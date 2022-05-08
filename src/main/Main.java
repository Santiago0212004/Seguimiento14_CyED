package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import structures.Color;
import structures.Graph;
import structures.Vertex;

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
		
		
		for(Vertex<String> v : graph.getElements()) {
			v.setColor(Color.WHITE);
		}
		
		Queue<Vertex<String>> queue = new LinkedList<>();
		
		
		Vertex<String> initialVertex = graph.getElement(0);
		initialVertex.setColor(Color.GRAY);
		queue.offer(initialVertex);
			
		while(!queue.isEmpty()) {
			queue.peek().setColor(Color.BLACK);
			for(Vertex<String> v : queue.peek().getAdjacencyList()) {
				if(v.getColor().equals(Color.WHITE)) {
					v.setColor(Color.GRAY);
					v.setDad(queue.peek());
					queue.offer(v);
				}	
			}
			queue.poll();
		}
		
		boolean stronglyConnected = true;
		
		for(Vertex<String> v : graph.getElements()) {
			if(!v.getColor().equals(Color.BLACK)) {
				stronglyConnected = false;
			}
		}
		
		if(stronglyConnected) {
			System.out.println("Strongly connected");
		} else {
			System.out.println("Not strongly connected");
		}
		
		
		
	}
	

}
