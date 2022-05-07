package structures;

import java.util.ArrayList;

public class Graph<T extends Comparable<T>> {
	
	private ArrayList<Vertex<T>> graph;
	
	public Graph(){
		graph = new ArrayList<>();
	}
	
	public void addVertex(T addingValue, T sourceValue, boolean a) {
		
		Vertex<T> addingVertex = new Vertex<>(addingValue);
		Vertex<T> sourceVertex = new Vertex<>(sourceValue);
		
		graph.add(addingVertex);
		if(a) {
			sourceVertex.addAdjacency(addingVertex);
		} else {
			addingVertex.addAdjacency(sourceVertex);
		}
	
	}
	
	
	public void addVertex(T value) {
		Vertex<T> addingVertex = new Vertex<>(value);
		
		if(graph.isEmpty()) {
			graph.add(addingVertex);
		}
	}
	
	public void print() {
		for(Vertex<T> v : graph) {
			System.out.println(v.getValue());
		}
	}
	

}
