package test;

import java.util.Optional;

import org.junit.Test;

import lombok.extern.java.Log;

@Log
public class OptionalTest {
	@Test
	public void test1() {
		// Double a = null;
		Double a = 10.09;
		log.info(Optional.ofNullable(a)
			.map(String::valueOf)
			.orElse("a"));
	}

}
