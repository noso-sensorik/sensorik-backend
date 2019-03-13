package ch.bfh.ti.noso_sensorik;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(EventRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Event("Station 00 1212", "Pflege", "Handhygiene-Disp")));
			log.info("Preloading " + repository.save(new Event("Station 00 1212", "Arzt", "Handhygiene-Disp")));
		};
	}
}