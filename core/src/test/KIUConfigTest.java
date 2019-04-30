package test;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fehead.im.KIUConfig;
import fehead.im.KickItUpGame;
import lombok.extern.java.Log;

@Log
public class KIUConfigTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void cfgLogdingTest() {
		final String configPath = "kiu.cfg";
		File configFile = new File(configPath);
		KIUConfig kcfg = KIUConfig.of(configFile);
		log.info(kcfg.toString());

		kcfg.writeToFile(configFile);

	}

	@Test
	public void rootDirTest() {
		log.info("KickItUpGame root:" + KickItUpGame.class.getResource("/").toString());
		log.info("default Path:" + new File(".").getAbsolutePath());
		log.info("File root Path:" + new File("/").getAbsolutePath());
		log.info("assert Path:" + new File("assets").getAbsolutePath());
	}
}
