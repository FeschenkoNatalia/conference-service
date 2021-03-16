package ua.aval.cmd.conference.adaptors.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ErrorResponse {
	@JsonProperty("errorMessage")
	String message;
}