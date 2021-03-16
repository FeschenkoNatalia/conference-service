package ua.aval.cmd.conference.exception;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TalkWithLateDateException extends RuntimeException {
	private LocalDate date;

	public TalkWithLateDateException(LocalDate date) {
		super(String.format("Talk has too late date [%s] for the conference", date));
		this.date = date;
	}
}
