package structures;

import java.util.ArrayList;

public class Graph<T extends Comparable<T>> {
	
	private ArrayList<Vertex<T>> graph;
	
	public Graph(){
		graph = new ArrayList<>();
	}
	
	public void addVertex(T value) {
		Vertex<T> addingVertex = new Vertex<>(value);
		if(this.search(addingVertex.getValue())==null) {
			graph.add(addingVertex);
		}
	}
	
	public void addEdge(T source, T destination) {
		Vertex<T> sourceVertex = this.search(source);
		Vertex<T> destinationVertex = this.search(destination);
		
		if(!sourceVertex.getAdjacencyList().contains(destinationVertex)) {
			sourceVertex.getAdjacencyList().add(destinationVertex);
		}
		
	}
	
	public void print() {
		for(Vertex<T> v : graph) {
			System.out.println(v.getValue()+": "+v.getAdjacency());
		}
	}
	
	public Vertex<T> search(T value){
		boolean founded = false;
		Vertex<T> vertex = null;
		for(Vertex<T> v : graph) {
			if(v.getValue().compareTo(value)==0) {
				founded = true;
				vertex = v;
			}
		}
		if(founded) {
			return vertex;
		} else {
			return null;
		}
	}
	

}
