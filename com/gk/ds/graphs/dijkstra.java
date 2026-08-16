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
//4.priority queue to always pick up the shortest distance through and fill the distance array

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
