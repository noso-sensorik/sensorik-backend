package ch.bfh.ti.noso_sensorik;

import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;

import org.joda.time.LocalTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.bfh.ti.noso_sensorik.dcn.DataCollectionNode;
import ch.bfh.ti.noso_sensorik.device.Device;
import ch.bfh.ti.noso_sensorik.device.DeviceType;
import ch.bfh.ti.noso_sensorik.event.Event;
import ch.bfh.ti.noso_sensorik.event.EventRepository;
import ch.bfh.ti.noso_sensorik.event.EventTrigger;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(EventRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Event(LocalDate.now().toString(), LocalTime.now().toString(), "Station 00 1212", "Pflege", EventTrigger.USING_MOBILE_KITTELFLASCHE, new Device(DeviceType.MOBILE_KITTELFLASCHE, "Test-Bacon Kittel", "Card", "Radius Network", "Person XY", "xx:xx:xx"))));
			log.info("Preloading " + repository.save(new Event(LocalDate.now().toString(), LocalTime.now().toString(), "Station 00 1212", "Pflege", EventTrigger.APPROACHING_STATIONARY_BED, new Device(DeviceType.STATIONARY_BED, "Test-Bacon Bett", "E8", "Radius Network", "Über Bett 15", "xx:xx:xx") )));
			log.info("Preloading " + repository.save(new Event(LocalDate.now().toString(), LocalTime.now().toString(), "Station 00 1212", "Pflege", EventTrigger.APPROACHING_STATIONARY_DISPENSER, new Device(DeviceType.STATIONARY_DISPENSER, "Test-Bacon Disp", "E4", "Radius Network", "Unter Disp 03", "xx:xx:xx"))));
			log.info("Preloading " + repository.save(new Event(LocalDate.now().toString(), LocalTime.now().toString(), "Station 00 1212", "Arzt", EventTrigger.APPROACHING_STATIONARY_BED, new Device(DeviceType.STATIONARY_BED, "Test-Bacon Bett", "E8", "Radius Network", "Über Bett 15", "xx:xx:xx"))));
		};
	}
}