import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode<T extends Comparable<T>> {
	private T key;
	private String value;
	private BinaryTreeNode<T> leftChild;
	private BinaryTreeNode<T> rightChild;
	

	public BinaryTreeNode(T key, String value) {
		this.setKey(key);
		this.setValue(value);
		
	}

	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public static <T extends Comparable<T>> String get(BinaryTreeNode<T> x, T key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return get(x.leftChild, key);
		} else if (cmp > 0) {
			return get(x.rightChild, key);
		} else {
			return x.value;			
		}
	}

	public static <T extends Comparable<T>> BinaryTreeNode<T> put(BinaryTreeNode<T> x, T key, String value) {
		if (x == null) {
			return new BinaryTreeNode<T>(key, value);
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.leftChild = put(x.leftChild, key, value);
		} else if (cmp > 0) {
			x.rightChild = put(x.rightChild, key, value);
		} else {
			x.value = value;
		}
		
		return x;
	}

	public void printTree(int indentLevel) {
		for (int i = 0; i < indentLevel; i++) {
			System.out.print("  ");
		}
		System.out.println(this.key + " = " + this.value);

		for (int i = 0; i < indentLevel; i++) {
			System.out.print("  ");
		}
		System.out.println("left:" + (this.leftChild == null ? " null" : ""));
		if (this.leftChild != null) {
			this.leftChild.printTree(indentLevel + 1);
		}
	
		for (int i = 0; i < indentLevel; i++) {
			System.out.print("  ");
		}
		System.out.println("right:" + (this.rightChild == null ? " null" : ""));
		if (this.rightChild != null) {
			this.rightChild.printTree(indentLevel + 1);
		}
	}

	public void printInorder() {
		if (this.leftChild != null) {
			this.leftChild.printInorder();
		}
		System.out.println(this.key + " = " + this.value);
		if (this.rightChild != null) {
			this.rightChild.printInorder();
		}
	}


	public boolean heapOrdered(){
		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
	
		queue.offer(this);

		while (!queue.isEmpty()){
			if (queue.element().leftChild!=null)
			queue.offer(queue.element().leftChild);
			if (queue.element().rightChild!=null)
			queue.offer(queue.element().rightChild);
			if (queue.element().leftChild!=null){
				int cmp = queue.element().leftChild.key.compareTo(queue.element().key);
				if (cmp>0)
					return false;
				}
			if (queue.element().rightChild!=null){
				int cmp2 = queue.element().rightChild.key.compareTo(queue.element().key);
				if (cmp2>0)
					return false;
			}
			queue.remove();
		}
		return true;
	}

	public boolean balanced(){
		Deque<BinaryTreeNode<T>> stack = new LinkedList<BinaryTreeNode<T>>();

		stack.add(this);
		while (!stack.isEmpty()){
			BinaryTreeNode<T> l = stack.peekLast();
			if (l.leftChild!=null)
			stack.addLast(l.leftChild);
			if (l.rightChild!=null)
			stack.addLast(l.rightChild);
			if ((l.rightChild!=null && l.leftChild!=null) || (l.rightChild==null && l.leftChild==null))
			stack.remove(l);
			if (l.leftChild==null && l.rightChild!=null){
				if (l.rightChild.rightChild==null && l.rightChild.leftChild==null){
					stack.remove(l);
				} else return false;
			}
			if (l.leftChild!=null && l.rightChild==null){
				if (l.leftChild.rightChild==null && l.leftChild.leftChild==null){
					stack.remove(l);
				} else return false;
			}
		}
		return true;
	}
}