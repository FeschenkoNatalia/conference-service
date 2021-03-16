package ua.aval.cmd.conference.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.aval.cmd.conference.adaptors.persistence.ConferenceDao;
import ua.aval.cmd.conference.domain.Conference;
import ua.aval.cmd.conference.exception.ConferenceNotFoundException;
import ua.aval.cmd.conference.service.validate.ValidationService;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {

	private final ConferenceDao conferenceDao;
	private final ValidationService validationService;

	@Override
	public Conference saveConference(Conference conference) {
		validationService.checkIfValidConference(conference);
		return conferenceDao.save(conference);
	}

	@Override
	public List<Conference> findAllConference() {
		return conferenceDao.findAll();
	}

	@Override
	public void updateConference(Long id, Conference conference) {
		validationService.checkIfValidConference(conference);
		Optional<Conference> conf = conferenceDao.findConferenceById(id);
		conf.ifPresentOrElse(
				c -> {
					conference.setId(id);
					conferenceDao.save(conference);
				},
				() -> {
					throw new ConferenceNotFoundException(id);
				});
	}
}
