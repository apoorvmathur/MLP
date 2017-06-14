

import java.util.ArrayList;

public class NodeLayer {

	ArrayList<Node> list;
	protected NodeLayer nextLayer, prevLayer;
	BiasNode biasNode;

	public NodeLayer(int num) {

		list = new ArrayList<Node>();
		
		biasNode = new BiasNode();

		for (int i = 0; i < num; i++) {
			Node n = new Node();
			n.addNode(biasNode, (Math.random() * 2) - 1);
			list.add(n);
		}
		nextLayer = null;
		setPrevLayer(null);
	}

	public void connect(NodeLayer layer) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < layer.list.size(); j++) {
				list.get(i).addNode(layer.list.get(j), (Math.random() * 2) - 1);
			}
		}
		nextLayer = layer;
		layer.setPrevLayer(this);
	}

	public void updateLayer() {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).update();
		}

		updateNextLayer();

	}

	public void updateNextLayer() {
		nextLayer.updateLayer();
	}

	public ArrayList<Node> getList() {
		return list;
	}

	public NodeLayer getPrevLayer() {
		return prevLayer;
	}

	public void setPrevLayer(NodeLayer prevLayer) {
		this.prevLayer = prevLayer;
	}
	
	public void backPropagate() {
		for(Node node : list) {
			node.backPropagate();
		}
		biasNode.backPropagate();
		if(prevLayer!=null) {
			prevLayer.backPropagate();
		}
	}
}
