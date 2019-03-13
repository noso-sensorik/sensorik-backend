package ch.bfh.ti.noso_sensorik;


public class EventNotFoundException extends RuntimeException {

	public EventNotFoundException(Long id) {
		super("Could not find event " + id);
	}
}