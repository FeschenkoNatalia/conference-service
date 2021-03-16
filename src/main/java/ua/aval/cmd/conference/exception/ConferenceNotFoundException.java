package ua.aval.cmd.conference.exception;

import lombok.Getter;

@Getter
public class ConferenceNotFoundException extends RuntimeException {
	private Long conferenceId;

	public ConferenceNotFoundException(Long id) {
		super(String.format("ConferenceId [%s] not found", id));
		this.conferenceId = id;
	}
}
