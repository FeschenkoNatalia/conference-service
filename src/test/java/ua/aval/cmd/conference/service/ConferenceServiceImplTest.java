package ua.aval.cmd.conference.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.aval.cmd.conference.domain.Conference;
import ua.aval.cmd.conference.domain.Talk;
import ua.aval.cmd.conference.domain.TalkType;
import ua.aval.cmd.conference.service.validate.ValidationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ua.aval.cmd.conference.domain.TalkType.WORKSHOP;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class ConferenceServiceImplTest {

	@Mock
	private ValidationService validationService;

	@InjectMocks
	private ConferenceServiceImpl sut;

	@Test
	void saveConference() {
//		Talk talk = new Talk();
//		talk.setName("Talk1");
//		talk.setDescription("Description");
//		talk.setSpeaker("Speaker1");
//		talk.setType(WORKSHOP);
//		List<Talk> talks = new ArrayList<>();
//		talks.add(talk);
//		Conference conference = new Conference();
//		conference.setName("Conference1");
//		conference.setParticipantsNumber(101);
//		conference.setDates(List.of(LocalDate.of(2021, 12,15)));
//		conference.setTalks(talks);
//		validationService.checkIfValidConference(conference);
//		when(conference.getId()).thenReturn(1L);
//		sut.saveConference(conference);
//		assertNotNull(conference.getId());
	}

	@Test
	void findAllConference() {
	}

	@Test
	void updateConference() {
	}
}