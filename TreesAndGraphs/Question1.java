/*

Problem : Route between Nodes - Given a directed graph , design an algorithm to find out whether there is
		  a route between nodes


*/
import java.util.*;

class Question1 {

	static boolean find(Graph g , int source , int destination) {

		if (source == destination) return true;
		boolean[] visited = new boolean[g.V];
		LinkedList<Integer> queue = new LinkedList<>();

		visited[source] = true;
		queue.add(source);


		while (!queue.isEmpty()) {

			int current = queue.pop();
			System.out.println("visited : " + current);
			LinkedList<Integer> list = g.adj.get(current);


			for (int i : list) {
				if (!visited[i]) {
					if (i == destination)return true;
					queue.add(i);
					visited[i] = true;

				}
			}
		}

		return false;
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

		System.out.println("Is route available ? " + find(g , 1, 5));

	}
}