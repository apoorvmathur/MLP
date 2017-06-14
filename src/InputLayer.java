

import java.util.ArrayList;

public class InputLayer extends NodeLayer {

	ArrayList<Double> input;
	ArrayList<Edge> inputEdges;

	public InputLayer(int num) {
		super(num);

		list.clear();

		for (int i = 0; i < num; i++) {
			InputNode n = new InputNode();
			list.add(n);
		}

		inputEdges = new ArrayList<Edge>();

		for (int i = 0; i < num; i++) {
			Edge edge = new Edge(null, list.get(i), 1);
			list.get(i).addInEdge(edge);
			inputEdges.add(edge);
		}
	}

	public void applyInput(ArrayList<Double> input) {
		this.input = input;

		for (int i = 0; i < inputEdges.size(); i++) {
			inputEdges.get(i).setVal(input.get(i));
		}
	}

}
