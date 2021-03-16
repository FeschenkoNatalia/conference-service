package ua.aval.cmd.conference.adaptors.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.aval.cmd.conference.domain.Talk;
import ua.aval.cmd.conference.service.TalkService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("conferences")
@RequiredArgsConstructor
@Validated
public class TalkRestController {

	private final TalkService talkService;

	@PostMapping(path = "/{conferenceId}/talks", produces = MediaType.APPLICATION_JSON_VALUE)
	public Talk addTalkToConference(@PathVariable Long conferenceId, @RequestBody Talk talk) {
		return talkService.addTalkToConference(conferenceId, talk);
	}

	@GetMapping(path = "/{conferenceId}/talks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Talk> getTalksByConferenceId(@PathVariable Long conferenceId) {
		return talkService.findTalksByConferenceId(conferenceId);
	}
}
