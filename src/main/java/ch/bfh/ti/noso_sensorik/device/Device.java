package ch.bfh.ti.noso_sensorik.device;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ch.bfh.ti.noso_sensorik.event.Event;
import lombok.Data;


@Data
@Entity
/**
 * Represents a device, which can trigger an event
 * 
 * @author engeld
 *
 */
public class Device {
	private @Id @GeneratedValue Long id;
	private DeviceType type;
	private String label;
	private String model;
	private String manufacturer;
	private String location;
	private String macadress;
	
	@OneToMany
	private Collection<Event> eventList = new ArrayList<Event>();

	public Device(DeviceType type, String label, String model, String manufacturer, String loc, String mac ) {
		this.type = type;
		this.label = label;
		this.model = model;
		this.manufacturer = manufacturer;
		this.location = loc;
		this.macadress = mac;
		
	}
}
