package coordinate;

import java.util.Arrays;

public class Node {
	final double[] coordinates = new double[2];

	public Node() {
		coordinates[0] = 0;
		coordinates[1] = 0;
	}

	public Node(double x, double y) {
		coordinates[0] = x;
		coordinates[1] = y;
	}

	public Node(Node copy) {
		coordinates[0] = copy.coordinates[0];
		coordinates[1] = copy.coordinates[1];
	}

	public static Node add(Node... nodes) {
		double x = 0, y = 0;
		for (Node node : nodes) {
			x += node.coordinates[0];
			y += node.coordinates[1];
		}
		return new Node(x, y);
	}

	public Node subtract(Node other) {
		return new Node(coordinates[0] - other.coordinates[0], coordinates[1]
				- other.coordinates[1]);
	}

	public Node multiply(double factor) {
		return new Node(coordinates[0] * factor, coordinates[1] * factor);
	}

	public String toString() {
		return Arrays.toString(coordinates);
	}
}
