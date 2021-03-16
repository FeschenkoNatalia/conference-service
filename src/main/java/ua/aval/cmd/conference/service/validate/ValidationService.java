package ua.aval.cmd.conference.service.validate;

import ua.aval.cmd.conference.domain.Conference;
import ua.aval.cmd.conference.domain.Talk;

public interface ValidationService {

	void checkIfValidConference(Conference conference);

	void checkIfValidTalk(Conference conference, Talk talk);

}
