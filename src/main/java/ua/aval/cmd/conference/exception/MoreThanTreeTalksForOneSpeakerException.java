package ua.aval.cmd.conference.exception;

import lombok.Getter;

@Getter
public class MoreThanTreeTalksForOneSpeakerException extends RuntimeException {
	private String speaker;

	public MoreThanTreeTalksForOneSpeakerException(String speaker) {
		super(String.format("More than tree talks for the speaker [%s]", speaker));
		this.speaker = speaker;
	}
}
