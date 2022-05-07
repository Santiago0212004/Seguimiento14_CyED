package structures;

import java.util.ArrayList;

public class Vertex<T> {
	T value;
	Color color;
	Vertex<T> dad;
	
	ArrayList<Vertex<T>> adjacencyList;
	
	public Vertex(T value) {
		this.value = value;
		this.dad = null;
		this.adjacencyList = new ArrayList<>();
	}
	
	public void addAdjacency(Vertex<T> vertex) {
		this.adjacencyList.add(vertex);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}


	public ArrayList<Vertex<T>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(ArrayList<Vertex<T>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
	
		
}
