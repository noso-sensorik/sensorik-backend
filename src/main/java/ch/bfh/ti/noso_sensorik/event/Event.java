package ch.bfh.ti.noso_sensorik.event;


import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.bfh.ti.noso_sensorik.dcn.DataCollectionNode;
import ch.bfh.ti.noso_sensorik.device.Device;

@Data
@Entity
public class Event {
	private @Id @GeneratedValue Long id;
	private LocalDate date;
	private LocalTime time;
	private String station;
	private String job;
	private EventTrigger trigger;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Device eventSource;
//	private DataCollectionNode collectedFrom;
	
	public Event(String date, String time, String station, String job, EventTrigger trigger, Device eventSource) {
		this.date = LocalDate.parse(date);
		this.time = LocalTime.parse(time);
		this.station = station;
		this.job = job;
		this.trigger = trigger;
		this.eventSource = eventSource;
	}
}
