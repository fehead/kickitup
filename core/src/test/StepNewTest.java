package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fehead.im.song.StepNew;

public class StepNewTest {
	final static String songPath="assets/song";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StepNew	step = new StepNew();
		step.readKSF(new File(songPath, "Beethoven Virus/Easy_1.ksf"));
		System.out.println(step);
	}
	
	@Test
	public void doubleTest() {
		Double	a = 1.9998;
		System.out.println(" >>>> " + a.intValue());
		
		// assertThat(a.intValue() == 1).isTrue();
	}

}
