package structures;

import java.util.ArrayList;

public class Node<T> {
	public T value;
	public ArrayList<Node<T>> children;
	
	public Node(T value) {
		this.value = value;
		children = new ArrayList<>();
	}

}
