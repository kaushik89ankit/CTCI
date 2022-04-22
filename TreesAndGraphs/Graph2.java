import java.io.*;
import java.util.*;


public class Graph2 {

	int V;
	int[][] adg;


	Graph2(int v) {
		V = v;
		adg = new int[V][V];
	}


	void addEdge(int i , int w) {
		adg[i][w] = 1;
	}

	LinkedList<Integer> getNeighbors(int s) {

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0 ; i < adg[0].length ; i++) {
			if (adg[s][i] == 1) {
				list.add(i);
			}
		}

		return list;
	}


	void DFS(int s) {

	}


	void DFSRecursive(int s) {

	}

	void BFS(int s) {

		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();

		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {

			int current = queue.poll();
			System.out.println("Now visiting : " + s);
			LinkedList<Integer> neighbors = getNeighbors(s);

			for (int next : neighbors) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
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

		System.out.println("Following is BFS via adjacency matrix from vertex 2");
		g.BFS(2);

		// System.out.println("\nFollowing is DFS via adjacency matrix from vertex 2");
		// g.DFS(2);

		// System.out.println("\nFollowing is DFS Recursive via adjacency matrix from vertex 2");
		// g.DFSRecursive(2 , new boolean[g.V]);
	}

}