# Graphs

## A series of nodes connected via edges

Undirected - Edges do not have a direction
Directed - Edges have a direction (point to another node)
Acyclic - Do not contain any cycles (there is no way you can start from one node and come back to it)

# Trees

## Graph consisting of a root node and many leaf nodes, where each node has strictly one parent node

- contain no cycles
- contain n-1 edges and n nodes
- is undirected

# Recognizing Graphs In USACO Problems

1. A 2d grid can be represented by a graph, with adjacent squares in a grid being represented by adjacent nodes connecting by edges
2. In a game where a maximum of three points are awarded, and if any questions are answered incorrectly, the score is set to zero, graph representations can be used.
   0-1-2-3 If the first question is correct, node 0 goes to node 1, otherwise looping back to node 0. This happens for all other nodes, creating a finite state diagram.

# Graph Representations

## Edge List

The form that all USACO problems give graphs in, by stating each edge in the graph, and which nodes are connecting by it.

Example: There are four nodes, connected by three edges between (0, 1), (2, 3), (1, 4), and (0, 3)

Code: List of triplets containing the (start, end, length) for each edge in the graph.

## Adjacency Matrix

A n x n matrix (where n represents the number of nodes in a graph), where a 1 represents a connection between two nodes and a zero represents no connection

Example (adjacency matrix for four node graph):
0 1 2 3
0 0 0 1 0
1 0 0 1 0
2 1 1 0 1
3 0 0 1 0

Code: n x n 2d array with length between vertices.

- Useful to check whether to nodes are connected, or if you need to find the distance between two known vertices.
- not useful to find which nodes are adjacent to a given node, since the entire row of that node in the matrix has to be checked.

## Adjacency List

States the adjacent nodes for each node in the graph.

Example:
0: (2, 4)
1: (2, 6)
2: (0, 4), (1, 6), (3, 5)
3: (2, 5)

Code: A fixed length array containing variable length lists.

- By starting from one vertex, you immediately know its neighbors and the distance to them.
