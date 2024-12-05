package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void bfs(int s, ListHamjavariGraph graph) {
        boolean[] visited = new boolean[graph.getV()];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : graph.getAdj()[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }
}
