package ch.bfh.ti.noso_sensorik;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.bfh.ti.noso_sensorik.event.Event;
import ch.bfh.ti.noso_sensorik.event.EventRepository;
import ch.bfh.ti.noso_sensorik.event.EventTrigger;
import ch.bfh.ti.noso_sensorik.event.ScrubbottleRepository;
import ch.bfh.ti.noso_sensorik.model.DataCollectionNode;
import ch.bfh.ti.noso_sensorik.model.Device;
import ch.bfh.ti.noso_sensorik.model.DeviceType;
import ch.bfh.ti.noso_sensorik.model.Scrubbottle;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initEventDatabase(EventRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(
					new Event(
							LocalDate.now().toString(), LocalTime.now().toString(), "Station 00 1212", "Pflege", EventTrigger.APPROACHING_PATIENT_ZONE, 666,
							new Device(DeviceType.STATIONARY_BED, "Test-Bacon am Bett", "XXX", "Radius Network", "Person XY", "xx:xx:xx"), 
							new DataCollectionNode("Preloaded testing DCN", "990000862471854", "Samsung dudu", "XYZ", "asdasd")
							)));
		};
	}
	
	@Bean
	CommandLineRunner initScrubbottleDatabase(ScrubbottleRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(
					new Scrubbottle(
							LocalDate.now(), LocalTime.now(), 12, 13, 20, -100, "Label", "Station XYASD", "Pflegende",
							new DataCollectionNode("Preloaded testing DCN", "990000862471854", "Samsung XYXY", "XYZ", "asdasd")
							)));
		};
	}
}