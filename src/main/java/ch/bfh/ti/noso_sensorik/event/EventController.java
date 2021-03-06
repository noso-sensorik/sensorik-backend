package ch.bfh.ti.noso_sensorik.event;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jdk.internal.jline.internal.Log;

@RestController
public class EventController {
    protected static final String TAG = "EventController";

	private final EventRepository repository;

	EventController(EventRepository repository) {
		this.repository = repository;
	}
	
	// Aggregate root
	@GetMapping("/events")
	List<Event> all() {
		return repository.findAll();
	}
	
	@PostMapping("/events")
	Event newEvent(@RequestBody Event newEvent) {
		System.out.println("processing new event posting...");
		Event tmpEvent = repository.save(newEvent);
		System.out.println("successfully processed new event posting!");
		return tmpEvent;
	}
	
	// Single item
	@GetMapping("/events/{id}")
	Event one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
	}

	@PutMapping("/events/{id}")
	Event replaceEvent(@RequestBody Event newEvent, @PathVariable Long id) {
		return repository.findById(id)
			.map(event -> {
				event.setStation(newEvent.getStation());
				event.setJob(newEvent.getJob());
				event.setTrigger(newEvent.getTrigger());
				return repository.save(event);
			})
			.orElseGet(() -> {
				newEvent.setId(id);
				return repository.save(newEvent);
			});
	}

	@DeleteMapping("/events/{id}")
	void deleteEvent(@PathVariable Long id) {
		repository.deleteById(id);
	}
}