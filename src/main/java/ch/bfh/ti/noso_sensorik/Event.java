package ch.bfh.ti.noso_sensorik;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Event {
	private @Id @GeneratedValue Long id;
	private String station;
	private String job;
	private String trigger;
	
	public Event(String station, String job, String trigger) {
		this.station = station;
		this.job = job;
		this.trigger = trigger;
	}
}
