package ua.aval.cmd.conference.adaptors.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.aval.cmd.conference.domain.Conference;

import java.time.LocalDate;
import java.util.Optional;

public interface ConferenceDao extends JpaRepository<Conference, Long> {

	Optional<Conference> findConferenceById(Long id);

	Optional<Conference> findConferenceByName(String name);

	Optional<Conference> findConferenceByDatesEquals(LocalDate date);

}
