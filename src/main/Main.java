package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import structures.Color;
import structures.Graph;
import structures.Vertex;

public class Main {
	
	private static int tiempo;
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		
		Graph<String> myGraph = new Graph<>();
		
		/*//Prueba 1 de Strongly connected
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
		myGraph.addEdge("v","u");*/
		
		/*//Prueba 2 de Not strongly connected
		myGraph.addVertex("u");
		myGraph.addVertex("v");
		myGraph.addVertex("w");
		myGraph.addVertex("x");
		myGraph.addVertex("y");
		myGraph.addVertex("z");
		myGraph.addEdge("u","v");
		myGraph.addEdge("u","x");
		myGraph.addEdge("x","v");
		myGraph.addEdge("y","x");
		myGraph.addEdge("v","y");
		myGraph.addEdge("w","y");
		myGraph.addEdge("w","z");
		myGraph.addEdge("z","z");
		
		myGraph.print();*/
		
		//BFS(myGraph);
		//DFS(myGraph);
		
		init();
		
	}
	public static void init() {
		
		Graph<String> myGraph = new Graph<>();
		System.out.println("BFS-DFS");
		
		System.out.println("\nEnter the number of vertices to be entered in the graph: ");
		int numVertex=sc.nextInt();
		
		sc.nextLine();
		for(int i=0;i<numVertex;i++) {
			System.out.print("Vertex "+(i+1)+" -> ");
			String vertex=sc.nextLine();
			myGraph.addVertex(vertex);
		}
		
		System.out.println("\nEnter the number of edges to be entered in the graph: ");
		int numEdges=sc.nextInt();
		
		sc.nextLine();
		for(int i=0;i<numEdges;i++) {
			System.out.println("Edge "+(i+1)+": ");
			System.out.print("First vertex -> ");
			String edge1=sc.nextLine();
			System.out.print("Second vertex -> ");
			String edge2=sc.nextLine();
			myGraph.addEdge(edge1,edge2);
		}
		
		System.out.println("\nBFS: ");
		BFS(myGraph);	
		System.out.println("\nDFS: ");
		DFS(myGraph);
		
		//myGraph.print();
	}
	
	public static void DFS(Graph<String> graph) {
		for(Vertex<String> u : graph.getElements()) {
			u.setColor(Color.WHITE);
			u.setDad(null);
		}
		tiempo=0;
		int contadorArbolesProfundidad=0;
		
		for(Vertex<String> u : graph.getElements()) {
			if(u.getColor().equals(Color.WHITE)) {
				//System.out.println("se selecciono: "+u.getValue());
				DFSVisit(graph,u);
				contadorArbolesProfundidad+=1;
			}
		}
		
		boolean stronglyConnected = true;
		
		if(contadorArbolesProfundidad>1) {
			stronglyConnected=false;
		}
		
		if(stronglyConnected) {
			System.out.println("Strongly connected");
		} else {
			System.out.println("Not strongly connected");
		}
	}
	
	public static void DFSVisit(Graph<String> graph, Vertex<String> u) {
		tiempo+=1;
		
		u.setD(tiempo);
		u.setColor(Color.GRAY);
		for(Vertex<String> v : u.getAdjacencyList()) {
			if (v.getColor().equals(Color.WHITE)) {
				v.setDad(u);
				DFSVisit(graph,v);
			}
		}
		u.setColor(Color.BLACK);
		tiempo+=1;
		u.setF(tiempo);
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
