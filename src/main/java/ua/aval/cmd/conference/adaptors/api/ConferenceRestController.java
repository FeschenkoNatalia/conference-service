package ua.aval.cmd.conference.adaptors.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.aval.cmd.conference.domain.Conference;
import ua.aval.cmd.conference.service.ConferenceService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("conferences")
@RequiredArgsConstructor
@Validated
public class ConferenceRestController {

	private final ConferenceService conferenceService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Conference addConference(@RequestBody Conference conference) {
		return conferenceService.saveConference(conference);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Conference> getAllConferences() {
		return conferenceService.findAllConference();
	}

	@PutMapping(path = "/{conferenceId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateConference(@PathVariable Long conferenceId, @RequestBody Conference conference) {
		conferenceService.updateConference(conferenceId, conference);
	}
}
