package ch.bfh.ti.noso_sensorik.event;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.bfh.ti.noso_sensorik.model.Scrubbottle;

@RestController
public class ScrubbottleController {
    protected static final String TAG = "ScrubbottleController";

	private final ScrubbottleRepository repository;

	ScrubbottleController(ScrubbottleRepository repository) {
		this.repository = repository;
	}
	
	// Aggregate root
	@GetMapping("/scrubbottles")
	List<Scrubbottle> all() {
		return repository.findAll();
	}
	
	@PostMapping("/scrubbottles")
	Scrubbottle newScrubbottles(@RequestBody Scrubbottle newScrubbottle) {
		System.out.println("processing new scrubbottle posting...");
		Scrubbottle tmpScrubbottle = repository.save(newScrubbottle);
		System.out.println("successfully processed new scrubbottle posting!");
		return tmpScrubbottle;
	}
	
	// Single item
	@GetMapping("/scrubbottles/{id}")
	Scrubbottle one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
	}

	@PutMapping("/scrubbottles/{id}")
	Scrubbottle replaceScrubbottle(@RequestBody Scrubbottle newScrubbottle, @PathVariable Long id) {
		return repository.findById(id)
			.map(scrubbottle -> {
				scrubbottle.setStation(newScrubbottle.getStation());
				scrubbottle.setJob(newScrubbottle.getJob());
				return repository.save(scrubbottle);
			})
			.orElseGet(() -> {
				newScrubbottle.setId(id);
				return repository.save(newScrubbottle);
			});
	}

	@DeleteMapping("/scrubbottles/{id}")
	void deleteEvent(@PathVariable Long id) {
		repository.deleteById(id);
	}
}