import static org.junit.Assert.*;

import org.junit.Test;

public class InterpreterTest {

	@Test
	public void firstCase() {
		Interpreter in = new Interpreter();
		String s = in.calcRPN("3 1 2 + * .")+"";
		assertEquals("9.0", s);
	}

	@Test
	public void secondCase() {
		Interpreter in = new Interpreter();
		String s = in.calcRPN("3 4 5 SUM 3 + .")+"";
		assertEquals("15.0", s);
	}

	@Test
	public void thirdCase() {
		Interpreter in = new Interpreter();
		String s = in.calcRPN("4 5 7 8 AVG 2 / .")+"";
		assertEquals("3.0", s);
	}

	@Test
	public void fourthCase() {
		Interpreter in = new Interpreter();
		String s = in.calcRPN("1 2 + 8 6 MIN 10 * .")+"";
		assertEquals("30.0", s);
	}
	
	@Test
	public void fifthCase() {
		Interpreter in = new Interpreter();
		String s = in.calcRPN("2 3 ^ 5 + .")+"";
		assertEquals("13.0", s);
	}

}
