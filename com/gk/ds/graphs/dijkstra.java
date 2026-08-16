package com.gk.ds.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class dijkstra {
//used to find shortest path in a graph from source to all other nodes
//works on weighted graphs with non-negative weights
//1.create an adjacency list
//2.distance array to store the shortest distances 
//3.source distance will be 0
//4.priority queue(min heap) to always pick up the shortest distance through and fill the distance array

//why bfs fails here? because bfs is used to find the shortest path in unweighted graphs, it does not take into account the weights of the edges, so it may not find the shortest path in a weighted graph. Dijkstra's algorithm, on the other hand, takes into account the weights of the edges and finds the shortest path in a weighted graph.
//time complexity: O((V + E) log V) where V is the number of vertices and E is the number of edges
//space complexity: O(V + E) for the adjacency list and O(V) for the distance array and priority queue
//Dijkstra's algorithm is a greedy algorithm that finds the shortest path from a source node to all other nodes in a weighted graph with non-negative weights. It works by maintaining a priority queue of nodes to explore, always selecting the node with the smallest known distance from the source. The algorithm updates the distances to neighboring nodes and continues until all nodes have been processed.
//why negative weights are not allowed? because Dijkstra's algorithm assumes that once a node's shortest distance is found, it will not change. If there are negative weights, a shorter path to a node may be found after it has already been processed, which violates this assumption and can lead to incorrect results. For graphs with negative weights, the Bellman-Ford algorithm is used instead.
//relaxation: the process of updating the shortest distance to a node if a shorter path is found through another node. In Dijkstra's algorithm, this is done by checking if the new calculated distance to a neighbor is less than the currently recorded distance, and if so, updating it and adding the neighbor to the priority queue for further exploration.


//problems to solve:
//1.LeetCode 787 :cheapest flights within k stops (node is not enough to solve this problem, we need to use a modified version of Dijkstra's algorithm that takes into account the number of stops. We can use a priority queue to keep track of the current cost and the number of stops taken to reach each node. We will also maintain a distance array to store the minimum cost to reach each node(dist[nodes][k+2],where k+2 represents the number of stops). The algorithm will explore the graph while keeping track of the number of stops and updating the minimum cost accordingly.)
//2.LeetCode 743 :network delay time
//3.LeetCode 1631 :path with minimum effort
public static void main(String[] args) {
    int[] distances = shortestPaths(0, 5, new int[][]{
        {0, 1, 10},
        {0, 2, 3},
        {1, 2, 1},
        {1, 3, 2},
        {2, 1, 4},
        {2, 3, 8},
        {2, 4, 2},
        {3, 4, 7},
        {4, 3, 9}
    });
    System.out.println("Dijkstra's Algorithm");
    System.out.println("Shortest distances from source:");
    for (int i = 0; i < distances.length; i++) {
        System.out.println("To node " + i + ": " + distances[i]);
    }
}

public static int[] shortestPaths(int source, int nodes, int[][] edges) {
    // Implementation of Dijkstra's algorithm will go here
    List<List<int[]>> graph = new ArrayList<>();
    for(int i =0;i<nodes;i++){
        graph.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        int weight = edge[2];
        graph.get(u).add(new int[]{v, weight});
    }

    int[] distances = new int[nodes];
    // Initialize distances array with maximum values
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[source] = 0; // Distance to source is 0

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[]{source, 0});
    //O((V + E )log V) time complexity
    while (!pq.isEmpty()) {
        
        int[] current = pq.poll();
        int currentNode = current[0];
        int currentDistance = current[1];

        // If the distance is greater than the recorded distance, skip processing
        if (currentDistance > distances[currentNode]) {
            continue;
        }

        for (int[] neighbor : graph.get(currentNode)) {
            int neighborNode = neighbor[0];
            int edgeWeight = neighbor[1];
            int newDistance = currentDistance + edgeWeight;

            // If a shorter path to the neighbor is found
            if (newDistance < distances[neighborNode]) {
                distances[neighborNode] = newDistance;
                pq.offer(new int[]{neighborNode, newDistance});
            }
        }
    }
    return distances;
}

}
