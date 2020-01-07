public class FunctionNode implements Node {
	private String op;
	private Node node;

	public FunctionNode(String functionName, Node operand) {
		// TODO
		this.op = functionName;
		this.node = operand;
	}

	public double evaluate() {
		if (this.op.equals("sqrt")) {
			return Math.sqrt(this.node.evaluate());
		}
		else return 0;
	}

	public String toPostfixString() {
		return "" + this.node.toPostfixString() + " " + this.op;
	}

	public String toString() {
		return this.op + " ( " + this.node + " )";
	}
}