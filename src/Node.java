

import java.util.ArrayList;

public class Node {
	protected ArrayList<Edge> in, out;
	double activation, output, delta;
	public static final double learningFactor = 0.25;

	public Node() {
		in = new ArrayList<Edge>();
		out = new ArrayList<Edge>();
	}

	public void addNode(Node n, double w) {
		Edge edge = new Edge(this, n, w);
		out.add(edge);
		n.in.add(edge);
	}

	public void addInEdge(Edge e) {
		in.add(e);
	}

	public void addOutEdge(Edge e) {
		out.add(e);
	}

	public void update() {
		activation = 0;

		for (int i = 0; i < in.size(); i++) {
			activation += in.get(i).getVal() * in.get(i).getWeight();
		}

		output = 1 / (1 + Math.exp(-activation));

		for (int i = 0; i < out.size(); i++) {
			out.get(i).setVal(output);
		}
	}

	public void backPropagate() {
		double sum = 0, change;
		for (Edge e : out) {
			sum += e.getRight().delta * e.getWeight();
		}
		delta = learningFactor * derivedSigmoid(output) * sum;
		for (Edge e : out) {
			change = delta * e.getRight().output;
			e.setWeight(e.getWeight() + change);
		}
	}

	public static double derivedSigmoid(double val) {
		double result = Math.exp(val) / (Math.pow(1 + Math.exp(val), 2));
		return result;
	}
}
