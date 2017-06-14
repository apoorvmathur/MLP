

import java.util.ArrayList;

public class OutputLayer extends NodeLayer {

	ArrayList<Double> output;
	ArrayList<Edge> outputEdges;

	public OutputLayer(int num) {
		super(num);

		outputEdges = new ArrayList<Edge>();

		for (int i = 0; i < num; i++) {
			Edge edge = new Edge(super.getList().get(i), null, 1);
			list.get(i).addOutEdge(edge);
			outputEdges.add(edge);
		}
	}

	public ArrayList<Double> getOutput() {
		output = new ArrayList<Double>();

		for (int i = 0; i < outputEdges.size(); i++) {
			output.add(outputEdges.get(i).getVal());
		}
		return output;
	}

	@Override
	public void updateNextLayer() {
		// No next layer.
	}

	public void applyOutput(ArrayList<Double> output) {
		double error;
		for (int i = 0; i < list.size(); i++) {
			error = output.get(i) - list.get(i).output;
			list.get(i).delta = error * Node.derivedSigmoid(list.get(i).output);
			System.out.println(error);
		}
	}
	
	public void backPropagate() {
		if(prevLayer!=null) {
			prevLayer.backPropagate();
		}
	}

}
