package ua.aval.cmd.conference.service;

import ua.aval.cmd.conference.domain.Talk;

import java.util.List;

public interface TalkService {

	Talk addTalkToConference(Long conferenceId, Talk talk);

	List<Talk> findTalksByConferenceId(Long conferenceId);

}
