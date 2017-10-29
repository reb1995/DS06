/**
	This class represents a Node structure in a Binary Tree. 
	The data element is the team id. Each node is augmented with subtree sizes.
	Each node also has a reference to the left and right subtrees.
	*/
public class Node {

	private int team;			// Data Field.
	private int size;			// Size of the entire Tree rooted at this node.
	private Node left;		// Reference to the left subtree.
	private Node right;		// Reference to the right subtree.

	// Constructors.
	public Node(int _team) {
		team = _team;
		size = 1;
		left = null;
		right = null;
	}
	public Node(int _team, Node _left, Node _right) {
		team = _team;
		left = _left;
		right = _right;
		size = (left == null ? 0 : left.getSize()) + (right == null ? 0 : right.getSize()) + 1;
	}

	// Accessors.
	public int getTeam() {
		return team;
	}
	public int getSize() {
		return size;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}

	// Mutators.
	public void setTeam(int _team) {
		team = _team;
	}
	public void setSize(int _size) {
		size = _size;
	}
	public void setLeft(Node _left) {
		left = _left;
	}
	public void setRight(Node _right) {
		right = _right;
	}

	/**
		This method increments the size.
	*/
	public void incSize() {
		size++;
	}

	/**
		This method updates the size of the node (tree). This is needed after
		we perform splits, or other updates that would change the structure
		of the trees.
	*/
	public void updateSize() {
		size = ((left == null) ? 0 : left.size) + ((right == null) ? 0 : right.size) + 1;
	}
}
