package Graph;

import java.util.Stack;

public class DFS {
    public void dfs(int s, ListHamjavariGraph graph) {
        boolean[] visited = new boolean[graph.getV()];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                for (int v : graph.getAdj()[u]) {
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }

    public void recursive(ListHamjavariGraph graph) {
        boolean[] visited = new boolean[graph.getV()];
        for (int v = 0; v < graph.getV(); v++) {
            if (!visited[v]) {
                dfs(v, visited, graph);
            }
        }
    }



    public void dfs(int v, boolean[] visited, ListHamjavariGraph graph) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int w : graph.getAdj()[v]) {
            if (!visited[w]) {
                dfs(w, visited, graph);
            }
        }

    }
}
