package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import encodingstrategies.StrategiesFactory;
import model.Line;

class LineTest {

	Line line;
	StrategiesFactory strategy;
	private String sentence="Aris mixalis";
	@BeforeEach
	void setUp() throws Exception {
		line = new Line();
		line.addLine(sentence);
		strategy = new StrategiesFactory();
		line.tuneEncodingStrategy(strategy.createStrategy("Rot13"));
	}@Test
	void testaddLine() {
		line.addLine(sentence);
	}
	@Test
	void testPlayLine() {
		line.playLine();
	}
	@Test
	void testPlayReverseLine() {
		line.playReverseLine();
	}
	@Test
	void testPlayEncodedLine() {
		line.playEncodedLine();
	}
}
