package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.TalkingClock;
import com.example.demo.services.TalkingClockService;
import com.example.demo.services.TalkingClockServiceImpl;

@SpringBootTest
class TalkingClockServiceTests {

	@Mock
	private TalkingClock tt;

	@InjectMocks // auto inject
	private TalkingClockService service = new TalkingClockServiceImpl();

	static Integer hr = 1;
	static Integer min = 20;

//	 @BeforeEach
//	    void setMockOutput() {
//	        when(tt.getResponse()).thenReturn("Twenty past One");
//	    }

	@Test
	void contextLoads() {

		TalkingClock tv = service.getTime(hr, min);
		assertEquals("Twenty past One", tv.getResponse());

	}

}
