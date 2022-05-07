package main;

import structures.Graph;

public class Main {

	public static void main(String[] args) {
		
		Graph<Integer> myGraph = new Graph<>();
		
		myGraph.addVertex(1);
		myGraph.addVertex(2,1,true);
		myGraph.addVertex(2,1,true);
		
		BFS(myGraph);	
	}
	
	public static void BFS(Graph<Integer> graph) {
		graph.print();
	}

}
