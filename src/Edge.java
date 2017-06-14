

public class Edge {

	private Node left, right;
	private double val, weight;

	public Edge(Node left, Node right, double weight) {
		this.setLeft(left);
		this.setRight(right);
		this.setWeight(weight);
		this.setVal(0);
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}

	public void update() {
		System.out.println("Value is: " + val);
		if (right != null) {
			right.update();
		}
	}
}
