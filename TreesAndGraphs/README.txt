Tree/Grap Graph topics

Algorithms : 

Traversal : 

1. BFS ( Iterative / Recursive)
2. DFS (Iterative / Recursive )
3. Create BST/binary tree from an Array

Shortest Path :

1. Djisktra Algorithm ( Greedy Algorithm ) - Find the shortest path from source to all other nodes , unable to work wth -ve
   weight edges
2. Bellman Ford Algorithm - ( DP approach) - Find shortest path from source to all other nodes , works with -ve weight edges
3. Floyd Warshall Algorithm - ( ) - Shortest path between all pairs of vertices 


Linear ordering :

1. Topological Sort - For every directed edge UV , vertex u comes before v in ordering. Only for DAG graph



Connected components :	

1. Articulation Points
2. Union-Find - Path compression , Union By rank - (Also see if there are cycles in graph)
3. Coloring problem - given value of m if graph can be coloure or number f permutations or find minimum m , also if graph is
   bipartite ( for every edge E , u is in one set and v is another set)


Min MST tree : Given an undirected and connected graph , a spanning tree of the graph  is a tree that spans  (that is, it includes every vertex of ) and is a subgraph of  (every edge in the tree belongs to ) and has minimum cost

1. Kruskal's Algorithm ( Greedy Algorithm) - Find min MST
2. Prim's Algorithm	( Greedy Algorithm ) - Find min MST



Miscellaeous : 

1.Ford-Fulkerson ALgorithm - (Maximum Flow problem) - Source to sink mximum flow
2.Hamiltonian Cycle / Graph - Find a hamiltonian path in a graph is possible
3.Euler Cycle - Find if a path where each edge is traversed only once

