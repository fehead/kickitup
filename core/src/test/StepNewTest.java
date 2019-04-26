package test;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fehead.im.StepNew;

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

}
