package ua.aval.cmd.conference.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.datasource")
@Validated
public class DataSourceSettings {

	@NotBlank
	private String name;
	@NotBlank
	private String url;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String driverClassName;
}
