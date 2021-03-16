package ua.aval.cmd.conference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ua.aval.cmd.conference.config.DataSourceSettings;

@SpringBootApplication
@EnableConfigurationProperties({
		DataSourceSettings.class})
public class ConferenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceServiceApplication.class, args);
	}

}
