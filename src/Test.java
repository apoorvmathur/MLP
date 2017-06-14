import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		// InputLayer containing 2 nodes.
		InputLayer inputLayer = new InputLayer(2);

		// InputLayer containing 1 node.
		OutputLayer outputLayer = new OutputLayer(1);

		// NodeLayer1 containing 3 nodes.
		NodeLayer nodeLayer1 = new NodeLayer(3);

		// NodeLayer2 containing 3 nodes.
		NodeLayer nodeLayer2 = new NodeLayer(3);

		// Let's connect them up
		inputLayer.connect(nodeLayer1);
		nodeLayer1.connect(nodeLayer2);
		nodeLayer2.connect(outputLayer);

		// We need two inputs of double, so creating an ArrayList
		ArrayList<Double> inputs = new ArrayList<Double>();

		// Adding inputs
		inputs.add(1.0);
		inputs.add(0.5);

		// Applying input to inputLayer
		inputLayer.applyInput(inputs);

		// Updating the layers
		inputLayer.updateLayer();

		// Storing the output
		ArrayList<Double> output = outputLayer.getOutput();

		// Printing the output
		for (Double x : output) {
			System.out.println(x);
		}
		
		//Training under construction :P
	}
}
