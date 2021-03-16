package ua.aval.cmd.conference.exception;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ConferenceWithSameDateAlreadyExistsException extends RuntimeException {
	private LocalDate date;

	public ConferenceWithSameDateAlreadyExistsException(LocalDate date) {
		super(String.format("Conference with date [%s] already exisis", date));
		this.date = date;
	}
}
