

public class BiasNode extends Node {
	
	public void update() {
		output = 1;
		
		for (int i = 0; i < out.size(); i++) {
			out.get(i).setVal(output);
		}
	}
}
