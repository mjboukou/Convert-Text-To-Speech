package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encodingstrategies.AtBashEncoding;


class AtBashEncodingTest {
	AtBashEncoding strategy;
	@BeforeEach
	void setUp() throws Exception {
		strategy = new AtBashEncoding();
	}

	@Test
	void testEncode() {
		assertEquals(strategy.encode("Aristotelis"),"Zirhglgvorh");
	}

}
