public class BinaryOperatorNode implements Node {
    private String op;
    private Node node_1;
    private Node node_2;

    public BinaryOperatorNode(String op, Node node_1, Node node_2) {
        this.op = op;
        this.node_1 = node_1;
        this.node_2 = node_2;
    }

    public double evaluate() {
        if (this.op.equals("+")) {
            return this.node_1.evaluate() + this.node_2.evaluate();
        }
        else if (this.op.equals("-")) {
            return this.node_2.evaluate() - this.node_1.evaluate();
        }
        else if (this.op.equals("*")) {
            return this.node_1.evaluate() * this.node_2.evaluate();
        }
        return 0;
    }

    public String toString() {
        return "" + "( " + this.node_2 + " " + this.op + " " + this.node_1 + " )";
    }

    public String toPostfixString() {
        return "" + this.node_2.toPostfixString() + " " + this.node_1.toPostfixString() + " " + this.op;
    }
}