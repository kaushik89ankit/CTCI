import java.io.*;
import java.util.*;


public class Graph {

	int V;
	ArrayList<LinkedList<Integer>> adj;

	Graph(int v) {
		V = v;
		adj = new ArrayList<LinkedList<Integer>>(V);

		for (int i = 0 ; i < V; i++) {
			adj.add(i , new LinkedList<Integer>());
		}

	}


	void addEdge(int i , int w) {
		adj.get(i).add(w);
	}


	void BFS(int s) {

		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);


		while (queue.size() != 0) {
			int current = queue.poll();
			System.out.println("Now visiting : " + current);
			LinkedList<Integer> list = adj.get(current);

			for (int i : list) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}

	}


	void DFS(int s) {

		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();

		visited[s] = true;
		stack.push(s);

		while(!stack.isEmpty()){

			int current = stack.pop();
			System.out.println("Now visiting : " + current);
			LinkedList<Integer> list = adj.get(current);

			for(int adjacent : list){
				if(!visited[adjacent]){
					stack.push(adjacent);
					visited[adjacent] = true;
				}
			}

		}

	}


	void DFSRecursive(int current , boolean[] visited){

		visited[current] = true;
		System.out.println("Now visiting : " + current);

		LinkedList<Integer> list = adj.get(current);


		for(int next : list){
			if(!visited[next]){
				DFSRecursive(next , visited);
			}
		}
	}

	public static void main(String[] args) {

		Graph g = new Graph(8);

		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(0, 2);
		g.addEdge(1, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 6);
		g.addEdge(6, 4);
		g.addEdge(3, 2);
		g.addEdge(3, 5);
		g.addEdge(5, 3);
		g.addEdge(5, 7);
		g.addEdge(7, 5);

		// System.out.println("Following is Breadth First Traversal " +
		//                    "(starting from vertex 2)");

		System.out.println("Following is BFS from vertex 2");
		g.BFS(2);

		System.out.println("\nFollowing is DFS from vertex 2");
		g.DFS(2);

		System.out.println("\nFollowing is DFS Recursive from vertex 2");
		g.DFSRecursive(2 , new boolean[g.V]);
	}
}

