package com.junit;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class MyFirstClassTest {
	@Test
	public void myFirstMethod() {
		ZonedDateTime timeInNewYork = ZonedDateTime.of(2019, 8, 10, 8, 0, 0, 0, ZoneId.of("America/New_York"));
		ZonedDateTime timeInBerlin = ZonedDateTime.of(2019, 8, 10, 14, 0, 0, 0, ZoneId.of("Europe/Berlin"));

//		assertThat(timeInNewYork.isAfter(timeInBerlin), is(false));
//		assertThat(timeInNewYork.isBefore(timeInBerlin), is(false));
//		assertThat(timeInNewYork.isEqual(timeInBerlin), is(true));
	
	}
}
