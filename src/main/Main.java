package main;

import structures.Graph;

public class Main {

	public static void main(String[] args) {
		
		Graph<String> myGraph = new Graph<>();
		
		myGraph.addVertex("u");
		myGraph.addVertex("x");
		myGraph.addVertex("y");
		myGraph.addVertex("z");
		myGraph.addVertex("v");
		myGraph.addEdge("u","x");
		myGraph.addEdge("x","y");
		myGraph.addEdge("y","z");
		myGraph.addEdge("z","y");
		myGraph.addEdge("y","v");
		myGraph.addEdge("v","u");
		
		
		
		BFS(myGraph);	
	}
	
	public static void BFS(Graph<String> graph) {
		graph.print();
	}

}
