import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	Scanner sc = new Scanner(System.in);

	public void calculate() {
		String input = "";
		System.out.println("---CORRECT NOTATION INCLUDES WHITESPACES IN BETWEEN--- ** (I.E: 2 3 +) ");
		System.out.println("Enter value: ");
		Interpreter interpreter = new Interpreter();
		String inputLine = input;

		while (!input.equals("exit")) {

			if (input == null || input.isEmpty()) {
				System.out.print("> ");
				inputLine = sc.nextLine();
			} else {
				input = "";
			}
			switch (inputLine) {
			case "exit":

				System.out.println("Closing...");
				System.exit(0);
				break;
			case "back":
				initiate();
				return;
			default:

				try {
					double result = interpreter.calcRPN(inputLine);
					System.out.println("RESULT: " + result);

				} catch (Exception e) {
					System.out.println("Invalid expression !!");
				}
				break;
			}
		}

	}

	public void infixParser() {
		String input = "";
		System.out.println("Enter value: ");
		Parser parser = new Parser();
		String inputLine = input;

		while (!input.equals("exit")) {

			if (input == null || input.isEmpty()) {
				System.out.print("\n> ");
				inputLine = sc.nextLine();
			} else {
				input = "";
			}
			switch (inputLine) {
			case "exit":

				System.out.println("Closing...");
				System.exit(0);
				break;
			case "back":
				initiate();
				return;
			default:
				try {
					List<String> arrayList = parser.generatePostfixNotation(parser.parse(inputLine));
					System.out.print("Result: ");

					System.out.print(parser.listToString(arrayList));

				} catch (Exception e) {
					System.out.println("Invalid expression !!");
				}
				break;
			}
		}

	}

	public void infixCalc() {
		String input = "";
		System.out.println("Enter value: ");
		Parser parser = new Parser();
		Interpreter interpreter = new Interpreter();
		String inputLine = input;

		while (!input.equals("exit")) {

			if (input == null || input.isEmpty()) {
				System.out.print("\n> ");
				inputLine = sc.nextLine();
			} else {
				input = "";
			}
			switch (inputLine) {
			case "exit":

				System.out.println("Closing...");
				System.exit(0);
				break;
			case "back":
				initiate();
				return;
			default:
				try {
					List<String> arrayList = parser.generatePostfixNotation(parser.parse(inputLine));
					System.out.print("Result: ");
					String s = "";
					for (int i = 0; i < arrayList.size(); i++) {

						s += arrayList.get(i) + ((i == arrayList.size() - 1) ? "" : " ");
					}

					double result = interpreter.calcRPN(s);
					System.out.println(result);

				} catch (Exception e) {
					System.out.println("Invalid expression !!");
				}
				break;
			}
		}

	}

	public void initiate() {
		System.out.println("*****RPN CALCULATOR*****\n  Type \"exit\" to close. \n  Type \"back\" to change options.");
		System.out.println("Choose options: \n1. Calculate postfix notation \n2. Convert to postfix \n3. Infix calc");
		System.out.print("> ");
		String input = sc.nextLine();
		switch (input) {
		case "exit":
			System.out.println("Closing...");
			System.exit(0);
			break;
		case "1":
			calculate();
			break;
		case "2":
			infixParser();
			break;
		case "3":
			infixCalc();
			break;
		case "back":
			initiate();
			return;
		default:
			System.out.println("Invalid input. Try again.");
			;
			break;
		}
	}

}
