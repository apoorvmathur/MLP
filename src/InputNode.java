

public class InputNode extends Node {

	@Override
	public void update() {
		activation = 0;

		for (int i = 0; i < in.size(); i++) {
			activation += in.get(i).getVal() * in.get(i).getWeight();
		}

		output = activation;

		for (int i = 0; i < out.size(); i++) {
			out.get(i).setVal(output);
		}
	}
}
