package curves;

import coordinate.Node;

public class CubicBezierCurve implements Curve {
	
	private Node[] nodes = new Node[4];
	
	public CubicBezierCurve() {
		this(new Node(), new Node(), new Node(), new Node());
	}
	
	public CubicBezierCurve(Node n1, Node n2, Node n3, Node n4) {
		nodes[0] = n1;
		nodes[1] = n2;
		nodes[2] = n3;
		nodes[3] = n4;
	}
	
	@Override
	public void setNode(int i, Node node) {
		try{
			nodes[i] = node;
		} catch (IndexOutOfBoundsException e) {
			return;
		}
	}
	
	@Override
	public Node t(double t) {
		// (1-t)^3 P0 + 3(1-t)^2t P1 + 3(1-t)t^2 P2 + t^3 P3
		Node s0 = nodes[0].multiply(Math.pow(1-t, 3));
		Node s1 = nodes[1].multiply(Math.pow(1-t, 2)* 3 * t);
		Node s2 = nodes[2].multiply(Math.pow(t, 2)  * 3 * (1-t));
		Node s3 = nodes[3].multiply(Math.pow(t, 3));
		return Node.add(s0,s1,s2,s3);
	}

	@Override
	public Node point(int i) {
		try{
			return nodes[i];
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
