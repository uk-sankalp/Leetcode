import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize the adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add initial roads from city i to city i+1
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[]{i + 1, 1});
        }
        
        int[] answer = new int[queries.length];
        
        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            // Add the new road to the graph
            graph.get(u).add(new int[]{v, 1});
            
            // Compute shortest path from 0 to n-1
            answer[i] = dijkstra(graph, n);
        }
        
        return answer;
    }
    
    private int dijkstra(List<List<int[]>> graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];
            
            if (d > dist[node]) continue;
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                
                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        
        return dist[n-1];
    }
}