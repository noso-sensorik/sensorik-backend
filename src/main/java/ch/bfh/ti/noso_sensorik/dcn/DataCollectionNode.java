package ch.bfh.ti.noso_sensorik.dcn;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
/**
 * Represents a data collection node (DCN), which collects events triggered by either:
 * - approximation of either 
 *   - a patient (EventTrigger.APPROACHING_STATIONARY_BED)
 *   - a stationary dispenser (EventTrigger.APPROACHING_STATIONARY_DISPENSER)
 * - using a kittelflasche (EventTrigger.USING_MOBILE_KITTELFLASCHE)
 * 
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
	

}
