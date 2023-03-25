package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encodingstrategies.Rot13Encoding;

class Rot13EncodingTest {
	Rot13Encoding strategy;
	@BeforeEach
	void setUp() throws Exception {
		strategy = new Rot13Encoding();
	}

	@Test
	void testEncode() {
		assertEquals(strategy.encode("Aristotelis"),"Nevfgbgryvf");
		
	}

}
