package ua.aval.cmd.conference.exception;

import lombok.Getter;

@Getter
public class TalkWithSameNameAlreadyExistsException extends RuntimeException {
	private String name;

	public TalkWithSameNameAlreadyExistsException(String name) {
		super(String.format("Talk with name [%s] already exisis", name));
		this.name = name;
	}
}