package ch.bfh.ti.noso_sensorik.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.bfh.ti.noso_sensorik.model.Scrubbottle;

@Repository
public interface ScrubbottleRepository extends JpaRepository<Scrubbottle, Long> {
	
}
