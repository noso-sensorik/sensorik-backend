package ch.bfh.ti.noso_sensorik.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ch.bfh.ti.noso_sensorik.event.Event;

@Data
@Entity
/**
 * Represents a data collection node (DCN), which collects triggered events.
 * To put it clearly, a DCN in this use case is nothing other than a mobile device (handy)
 * which recognizes approximation/usage of ble bluetooth beacons and reports this to the API
 * 
 * @author engeld
 *
 */
public class DataCollectionNode {
	/** the id of the DCN */
	private @Id @GeneratedValue Long id;
	
	/** the label of the DCN, can be descriptive */
	private String label;
	private String IMEI;
	private String manufacturer;
	private String model;
	private String fingerprint;

	@OneToMany
	private Collection<Event> collectedEventList = new ArrayList<Event>();
	
	public DataCollectionNode(String label, String IMEI, String manufacturer, String model, String fingerprint) {
		this.label = label;
		this.IMEI = IMEI;
		this.manufacturer = manufacturer;
		this.model = model;
		this.fingerprint = fingerprint;
	}
}
