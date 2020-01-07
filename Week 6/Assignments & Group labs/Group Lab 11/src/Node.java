/**
 * Represents an arithmetic expression
 */
public interface Node {
	/**
	 * @return value that results from evaluating the expression
	 */
	public double evaluate();

	/**
	 * @return expression in postfix notation
	 */
	public String toPostfixString();

	/**
	 * @return expression in infix notation
	 */
	public String toString();
}