package ua.aval.cmd.conference.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.aval.cmd.conference.adaptors.persistence.ConferenceDao;
import ua.aval.cmd.conference.adaptors.persistence.TalkDao;
import ua.aval.cmd.conference.domain.Conference;
import ua.aval.cmd.conference.domain.Talk;
import ua.aval.cmd.conference.exception.ConferenceNotFoundException;
import ua.aval.cmd.conference.service.validate.ValidationService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TalkServiceImpl implements TalkService {

	private final TalkDao talkDao;
	private final ConferenceDao conferenceDao;
	private final ValidationService validationService;

	@Override
	public Talk addTalkToConference(Long id, Talk talk) {
		Optional<Conference> conference = conferenceDao.findById(id);
		conference.ifPresentOrElse(
				c -> {
					validationService.checkIfValidTalk(c, talk);
					talk.setConference(c);
					talkDao.save(talk);
				},
				() -> {
					throw new ConferenceNotFoundException(id);
				});
		return talk;
	}

	@Override
	public List<Talk> findTalksByConferenceId(Long conferenceId) {
		return talkDao.findAllByConferenceId(conferenceId);
	}
}
