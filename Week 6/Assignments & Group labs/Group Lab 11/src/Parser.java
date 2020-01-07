import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Parser {
	public static Node parseInfixExpression(String expression) {
		return parseInfixExpression(Arrays.asList(expression.split(" ")));
	}

	public static Node parseInfixExpression(List<String> tokens) {
		// TODO
		// Hint: see page 588 of the textbook

		ArrayDeque<String> ops = new ArrayDeque<>();
		ArrayDeque<Node> stack = new ArrayDeque<>();
		for (String token : tokens) {
			if (token.equals("(")) ;
			else if (token.equals("+")) ops.push(token);
			else if (token.equals("-")) ops.push(token);
			else if (token.equals("*")) ops.push(token);
			else if (token.equals("sqrt")) ops.push(token);
			else if (token.equals(")")) {
				String op = ops.pop();
				if (op.equals("+") || op.equals("-") || op.equals("*")) {
					stack.push(new BinaryOperatorNode(op, stack.pop(), stack.pop()));
				}
				else if (op.equals("sqrt")) {
					stack.push(new FunctionNode(op,stack.pop()));
				}
			}
			else stack.push(new LiteralNode(Double.parseDouble(token)));
		}
		return stack.pop();
	}

	public static Node parsePostfixExpression(String expression) {
		return parsePostfixExpression(Arrays.asList(expression.split(" ")));
	}

	public static Node parsePostfixExpression(List<String> tokens) {
		ArrayDeque<Node> stack = new ArrayDeque<>();
		for (String token : tokens) {
			if (token.equals("sqrt")) {
				stack.push(new FunctionNode(token, stack.pop()));
			} else if (token.equals("+") || token.equals("-") || token.equals("*")) {
				stack.push(new BinaryOperatorNode(token, stack.pop(), stack.pop()));
			} else {
				stack.push(new LiteralNode(Double.parseDouble(token)));
			}
		}
		return stack.pop();
	}
}