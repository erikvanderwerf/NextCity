package curves;

import coordinate.Node;

public interface Curve {
	public Node t(double t);
	public Node point(int i);
	public void setNode(int i, Node node);
}
