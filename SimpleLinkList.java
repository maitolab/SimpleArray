
public class SimpleLinkList {
	private class Node {
		Node prev = null;

		Node next = null;

		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node endNode;

	private Node root;

	public SimpleLinkList() {
		root = new Node(0);
		endNode = null;
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (endNode == null) {
			root.next = newNode;
			newNode.prev = root;
		}
		else {
			endNode.next = newNode;
			newNode.prev = endNode;
		}
		endNode = newNode;
	}

	public void removeTail() {
		if (endNode == null) {
			return;
		}
		endNode = endNode.prev;
		// not the last node
		if (endNode != null) {
			endNode.next = null;
		}
	}

	public void removeAllGreater(int max) {
		Node currentNode = root.next;
		while (currentNode != null) {
			if (currentNode.data > max) {
				Node prevNode = currentNode.prev;
				Node nextNode = currentNode.next;
				if (nextNode != null) {
					nextNode.prev = prevNode;
				}
				prevNode.next = nextNode;
				currentNode = nextNode;
			}
			else {
				currentNode = currentNode.next;
			}
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Node currentNode = root.next;
		while (currentNode != null) {
			sb.append(" " + currentNode.data);
			currentNode = currentNode.next;
		}
		return sb.toString();
	}

}
