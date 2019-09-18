package test;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.extern.java.Log;

@Log
public class StremTest {
	@Test
	public void test() {
		log.info("joinning : " + Arrays.asList(1, 2, 3,4, 5,6).stream()
		.map(String::valueOf)
		.collect(Collectors.joining(",")) );
	}
}
