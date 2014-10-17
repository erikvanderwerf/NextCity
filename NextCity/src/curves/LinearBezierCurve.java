package curves;

import coordinate.Node;

public class LinearBezierCurve implements Curve {
	Node[] nodes = new Node[2];
	
	public LinearBezierCurve() {
		this(new Node(), new Node());
	}
	
	public LinearBezierCurve(Node n1, Node n2) {
		nodes[0] = n1;
		nodes[1] = n2;
	}
	
	@Override
	public Node t(double t) {
		return Node.add(nodes[0], nodes[1].multiply(t));
	}

	@Override
	public Node point(int i) {
		try {
			return nodes[i];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public void setNode(int i, Node node) {
		try {
			nodes[i] = node;
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
	}
}
