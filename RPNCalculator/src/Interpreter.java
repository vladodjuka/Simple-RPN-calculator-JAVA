import java.util.EmptyStackException;
import java.util.Stack;

public class Interpreter {
	
	// Input: Input line in String format with whitespace in between characters
	// Output: Result (double) of the RPN calculation
	// Description: Calculates input in postfix notation and generates 
	//result of the computation
	public double calcRPN(String input) throws ArithmeticException, EmptyStackException {
		Stack<Double> st = new Stack<Double>();
		String inputToken[] = input.split("\\s+");
		double finalResult = 0;
		for (String token : inputToken) {
			double result;
			switch (token) {
			case "+":
				finalResult = st.pop() + st.pop();
				st.push(finalResult);
				break;
			case "-":
				finalResult = -st.pop() + st.pop();
				st.push(finalResult);
				break;
			case "*":
				finalResult = st.pop() * st.pop();
				st.push(finalResult);
				break;
			case "/":
				double divisor = st.pop();
				finalResult = st.pop() / divisor;
				st.push(finalResult);
				break;
			case "^":
				double exponent = st.pop();
				finalResult = Math.pow(st.pop(), exponent);
				st.push(finalResult);
				break;
			case "SUM":
				result = sum(st);
				st.removeAllElements();
				st.push(result);
				finalResult = result;
				;
				break;
			case "MIN":
				result = min(st);
				st.removeAllElements();
				st.push(result);
				finalResult = result;
				;
				break;
			case "MAX":
				result = max(st);
				st.removeAllElements();
				st.push(result);
				finalResult = result;
				;
				break;
			case "AVG":
				result = avg(st);
				st.removeAllElements();
				st.push(result);
				finalResult = result;
				;
				break;
			case ".":
				finalResult = st.pop();
				System.out.println("STACK TOP ELEMENT: " + finalResult);
				;
				break;
			default:
				st.push(Double.parseDouble(token));
				break;
			}

		}

		return finalResult;
	}

	public double sum(Stack<Double> stack) {
		double result = 0;
		for (double value : stack) {
			result += value;
		}
		return result;
	}

	public double max(Stack<Double> stack) {
		double result = stack.get(0);
		for (double value : stack) {
			if (value > result) {
				result = value;
			}
		}
		return result;
	}

	public double min(Stack<Double> stack) {
		double result = stack.get(0);
		for (double value : stack) {
			if (value < result) {
				result = value;
			}
		}
		return result;
	}

	public double avg(Stack<Double> stack) {
		double result = 0;
		for (double value : stack) {
			result += value;
		}
		return result / stack.size();
	}

}
