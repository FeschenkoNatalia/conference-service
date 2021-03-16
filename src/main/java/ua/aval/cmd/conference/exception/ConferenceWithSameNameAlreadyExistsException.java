package ua.aval.cmd.conference.exception;

import lombok.Getter;

@Getter
public class ConferenceWithSameNameAlreadyExistsException extends RuntimeException {
	private String name;

	public ConferenceWithSameNameAlreadyExistsException(String name) {
		super(String.format("Conference with name [%s] already exisis", name));
		this.name = name;
	}
}
