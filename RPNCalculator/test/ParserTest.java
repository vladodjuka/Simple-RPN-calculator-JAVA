import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {

	// CASES

	@Test
	public void firstCase() {
		Parser parser = new Parser();
		String s = parser.listToString(parser.generatePostfixNotation(parser.parse("1+99")));
		assertEquals("1.0 99.0 +", s);
	}

	@Test
	public void secondCase() {
		Parser parser = new Parser();
		String s = parser.listToString(parser.generatePostfixNotation(parser.parse("4")));
		assertEquals("4.0", s);
	}

	@Test
	public void thirdCase() {
		Parser parser = new Parser();
		String s = parser.listToString(parser.generatePostfixNotation(parser.parse("7 + (5) * (6 - 3)")));
		assertEquals("7.0 5.0 6.0 3.0 - * +", s);
	}

	@Test
	public void fourthCase() {
		Parser parser = new Parser();
		String s = parser.listToString(parser.generatePostfixNotation(parser.parse("(3 + 4) ^ 3 + 4 ^ 2")));
		assertEquals("3.0 4.0 + 3.0 ^ 4.0 2.0 ^ +", s);
	}

}
