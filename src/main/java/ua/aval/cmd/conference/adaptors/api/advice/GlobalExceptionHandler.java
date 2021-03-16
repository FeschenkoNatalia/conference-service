package ua.aval.cmd.conference.adaptors.api.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.aval.cmd.conference.adaptors.api.dto.ErrorResponse;
import ua.aval.cmd.conference.exception.ConferenceNotFoundException;
import ua.aval.cmd.conference.exception.ConferenceWithSameDateAlreadyExistsException;
import ua.aval.cmd.conference.exception.ConferenceWithSameNameAlreadyExistsException;
import ua.aval.cmd.conference.exception.MoreThanTreeTalksForOneSpeakerException;
import ua.aval.cmd.conference.exception.TalkWithLateDateException;
import ua.aval.cmd.conference.exception.TalkWithSameNameAlreadyExistsException;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(ConferenceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	ErrorResponse exceptionHandler(ConferenceNotFoundException ex) {
		log.error("Conference not found exception", ex);
		return new ErrorResponse(String.format("ConferenceId [%s] not found", ex.getConferenceId()));
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ErrorResponse exceptionHandler(ConstraintViolationException ex) {
		log.error("Constraint violation exception", ex);
		var validationErrors = ex.getConstraintViolations().stream()
				.map(error -> String.format("%s:%s", error.getPropertyPath(), error.getMessage()))
				.collect(Collectors.joining(","));
		return new ErrorResponse("Validation request failed: " + validationErrors);
	}

	@ExceptionHandler(ConferenceWithSameNameAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	ErrorResponse exceptionHandler(ConferenceWithSameNameAlreadyExistsException ex) {
		log.error("Conference with same name already exists exception", ex);
		return new ErrorResponse(String.format("Conference with name [%s] already exists", ex.getName()));
	}

	@ExceptionHandler(ConferenceWithSameDateAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ErrorResponse exceptionHandler(ConferenceWithSameDateAlreadyExistsException ex) {
		log.error("Conference with same date already exists exception", ex);
		return new ErrorResponse(String.format("Conference with date [%s] already exists", ex.getDate()));
	}

	@ExceptionHandler(TalkWithSameNameAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	ErrorResponse exceptionHandler(TalkWithSameNameAlreadyExistsException ex) {
		log.error("Talk with same name already exists exception", ex);
		return new ErrorResponse(String.format("Talk with name [%s] already exists", ex.getName()));
	}

	@ExceptionHandler(MoreThanTreeTalksForOneSpeakerException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ErrorResponse exceptionHandler(MoreThanTreeTalksForOneSpeakerException ex) {
		log.error("More than tree talks for one speaker exception", ex);
		return new ErrorResponse(String.format("More than tree talks for the speaker [%s] ", ex.getSpeaker()));
	}

	@ExceptionHandler(TalkWithLateDateException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ErrorResponse exceptionHandler(TalkWithLateDateException ex) {
		log.error("Talk has too late date for the conference exception", ex);
		return new ErrorResponse(String.format("Talk has too late date [%s] for the conference", ex.getDate()));
	}
}
