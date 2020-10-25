package playground.swine;

import java.util.Comparator;
import java.util.function.Consumer;

public class RedBlackTree<V> {

	private enum Color {
		RED, BLACK
	}

	public enum Traversal {
		PRE_ORDER, IN_ORDER, POST_ORDER
	}

	public class Node {
		private final V value;
		private Color color;

		private Node parent;

		private Node left;
		private Node right;

		Node(V value) {
			this.value = value;
			this.color = Color.BLACK;

			this.parent = null;
		}
		Node(V value, Node parent) {
			this.value = value;
			this.color = Color.RED;

			this.parent = parent;
		}

		public V value() {
			return value;
		}
		public Node left() {
			return left;
		}
		public Node right() {
			return right;
		}
		public Node parent() {
			return parent;
		}

		public Node smallest() {
			Node node = this;

			while (node.left != null) {
				node = node.left;
			}

			return node;
		}
		public Node highest() {
			Node node = this;

			while (node.right != null) {
				node = node.right;
			}

			return node;
		}

		protected void traverse(Consumer<Node> callback, Traversal order) {
			if (order == Traversal.PRE_ORDER)
				callback.accept(this);

			if (left != null)
				left.traverse(callback, order);

			if (order == Traversal.IN_ORDER)
				callback.accept(this);

			if (right != null)
				right.traverse(callback, order);

			if (order == Traversal.POST_ORDER)
				callback.accept(this);
		}

		/*
			     P             P        | 	     P           P
			     |             |        |	     |           |
			     T             R        |	     T           L
			   /  \     ->    / \       |	   /  \   ->    / \
			  L    R         T   RR     |	  L    R       LL  T
                  / \       / \         |    / \              / \
                 RL RR     L  RL        |   LL  LR           LR  R
		 */
		private void rotateLeft() {
			Node P   = parent;
			Node T   = this;
			Node R   = right;
			Node RL  = right.left;

			T.parent = R;
			T.right  = RL;

			if (RL != null)
				RL.parent = T;

			R.parent = P;
			R.left   = T;

			if (P == null) {
				root = R;
			} else if (P.left == T) {
				P.left = R;
			} else {
				P.right = R;
			}
		}
		private void rotateRight() {
			Node P  = parent;
			Node T  = this;
			Node L  = left;
			Node LR = left.right;

			T.parent = L;
			T.left   = LR;

			if (LR != null)
				LR.parent = T;

			L.parent = P;
			L.right  = T;

			if (P == null) {
				root = L;
			}
			if (P.left == T) {
				P.left = L;
			} else {
				P.right = L;
			}
		}

		private Node sibling() {
			return parent.left == this ? parent.right : parent.left;
		}

		private boolean isLeftChild() {
			return parent.left == this;
		}
	}

	private final Comparator<V> comparator;

	private Node root = null;

	public RedBlackTree(Comparator<V> comparator) {
		this.comparator = comparator;
	}

	public Node root() {
		return root;
	}

	public Node insert(V value) {
		if (root == null) {
			return root = new Node(value);
		}

		// Find position in tree
		Node parent = root;
		int side;

		while(true) {
			side = comparator.compare(value, parent.value);

			if (side == 0) {
				return parent;
			} else {
				Node next = (side < 0) ? parent.left : parent.right;

				if (next == null)
					break;

				parent = next;
			}
		}

		// New node required, insert it
		Node node = new Node(value, parent);

		if (side < 0) {
			parent.left = node;
		} else {
			parent.right = node;
		}

		// Preserve red-black tree properties
		fixTree(node);

		return node;
	}

	private boolean isRed(Node node) {
		return node != null && node.color == Color.RED;
	}

	private void fixTree(Node node) {
		Node parent = node.parent;

		if (node.color == Color.RED && isRed(parent)) {
			// We are violating the red-black tree property!

			Node sibling = parent.sibling();

			if (isRed(sibling)) {
				// 2.1) Parent's sibling is also red - propagate red
				parent.color  = Color.BLACK;
				sibling.color = Color.BLACK;

				if (parent.parent.parent != null) {
					parent.parent.color = Color.RED;

					fixTree(parent.parent);
				}
			} else {
				// 2.2) Parent's sibling is black

				// 2.2.1) Make sure node and its parent is same sided children
				if (parent.isLeftChild()) {
					if (parent.left != node) {
						parent.rotateLeft();
						parent = node;
					}
				} else {
					if (parent.right != node) {
						parent.rotateRight();
						parent = node;
					}
				}

				// 2.2.2) When node and parent are same sided, recolor and rotate
				parent.color        = Color.BLACK;
				parent.parent.color = Color.RED;

				if (parent.isLeftChild()) {
					parent.parent.rotateRight();
				} else {
					parent.parent.rotateLeft();
				}
			}
		}
	}

	public void traverseNodes(Consumer<Node> callback, Traversal order) {
		if (root != null) {
			root.traverse(callback, order);
		}
	}

	public void traverseValues(Consumer<V> callback, Traversal order) {
		this.traverseNodes((Node node) -> callback.accept(node.value), order);
	}

}
