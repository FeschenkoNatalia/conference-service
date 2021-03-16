package ua.aval.cmd.conference.adaptors.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.aval.cmd.conference.domain.Talk;

import java.util.List;
import java.util.Optional;

public interface TalkDao extends JpaRepository<Talk, Long> {

	List<Talk> findAllByConferenceId(Long conferenceId);

	List<Talk> findAllBySpeaker(String speaker);

	Optional<Talk> findByName(String name);

}
