package ua.aval.cmd.conference.service;

import ua.aval.cmd.conference.domain.Conference;

import java.util.List;

public interface ConferenceService {

	Conference saveConference(Conference conference);

	List<Conference> findAllConference();

	void updateConference(Long conferenceId, Conference conference);

}
