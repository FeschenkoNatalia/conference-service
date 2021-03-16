package ua.aval.cmd.conference.service.validate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.aval.cmd.conference.adaptors.persistence.ConferenceDao;
import ua.aval.cmd.conference.adaptors.persistence.TalkDao;
import ua.aval.cmd.conference.domain.Conference;
import ua.aval.cmd.conference.domain.Talk;
import ua.aval.cmd.conference.exception.ConferenceWithSameDateAlreadyExistsException;
import ua.aval.cmd.conference.exception.ConferenceWithSameNameAlreadyExistsException;
import ua.aval.cmd.conference.exception.MoreThanTreeTalksForOneSpeakerException;
import ua.aval.cmd.conference.exception.TalkWithLateDateException;
import ua.aval.cmd.conference.exception.TalkWithSameNameAlreadyExistsException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

	private final ConferenceDao conferenceDao;
	private final TalkDao talkDao;

	@Override
	public void checkIfValidConference(Conference conference) {
		checkIfConferenceWithSameNameAlreadyExists(conference);
		checkIfConferenceWithSameDateAlreadyExists(conference);
		conference.getTalks().forEach(talk -> {
			checkIfTalkWithSameNameAlreadyExists(talk);
			checkIfMoreThanThreeTalksOfOneSpeakerAlreadyExists(talk);
			checkIfTalkHasAppropriateDateForConference(conference);
		});
	}

	@Override
	public void checkIfValidTalk(Conference conference, Talk talk) {
		checkIfTalkWithSameNameAlreadyExists(talk);
		checkIfMoreThanThreeTalksOfOneSpeakerAlreadyExists(talk);
		checkIfTalkHasAppropriateDateForConference(conference);
	}

	private void checkIfConferenceWithSameNameAlreadyExists(Conference conference) {
		Optional<Conference> conf = conferenceDao.findConferenceByName(conference.getName());
		conf.ifPresent(
				c -> {
					throw new ConferenceWithSameNameAlreadyExistsException(conference.getName());
				});
	}

	private void checkIfConferenceWithSameDateAlreadyExists(Conference conference) {
		conference.getDates().forEach(date -> {
			Optional<Conference> con = conferenceDao.findConferenceByDatesEquals(date);
			con.ifPresent(c -> {
				throw new ConferenceWithSameDateAlreadyExistsException(date);
			});
		});
	}

	private void checkIfTalkWithSameNameAlreadyExists(Talk talk) {
		Optional<Talk> talkFromDB = talkDao.findByName(talk.getName());
		talkFromDB.ifPresent(
				t -> {
					throw new TalkWithSameNameAlreadyExistsException(t.getName());
				});
	}

	private void checkIfMoreThanThreeTalksOfOneSpeakerAlreadyExists(Talk talk) {
		List<Talk> talks = talkDao.findAllBySpeaker(talk.getSpeaker());
		if (talks.size() >= 3) {
			throw new MoreThanTreeTalksForOneSpeakerException(talk.getSpeaker());
		}
	}

	private void checkIfTalkHasAppropriateDateForConference(Conference conference) {
		conference.getDates().forEach(date -> {
			if (date.isBefore(LocalDate.now().plusDays(30))) {
				throw new TalkWithLateDateException(date);
			}
		});
	}
}
