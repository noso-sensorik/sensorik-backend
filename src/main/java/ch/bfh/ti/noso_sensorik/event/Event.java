package ch.bfh.ti.noso_sensorik.event;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.bfh.ti.noso_sensorik.model.DataCollectionNode;
import ch.bfh.ti.noso_sensorik.model.Device;

@Data
@Entity
public class Event {
	private @Id @GeneratedValue Long id;
	private LocalDate date;
	private LocalTime time;
	private String station;
	private String job;
	private EventTrigger trigger;
	private int rssi;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Device eventSource;
	@ManyToOne(cascade = {CascadeType.ALL})
	private DataCollectionNode collectedFrom;
	
	public Event(String date, String time, String station, String job, EventTrigger trigger, int rssi, Device eventSource, DataCollectionNode collectedFrom) {
		this.date = LocalDate.parse(date);
		this.time = LocalTime.parse(time);
		this.station = station;
		this.job = job;
		this.trigger = trigger;
		this.rssi = rssi;
		this.eventSource = eventSource;
		this.collectedFrom = collectedFrom;
	}
}
