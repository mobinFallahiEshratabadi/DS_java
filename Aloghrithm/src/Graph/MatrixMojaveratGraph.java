package Graph;

public class MatrixMojaveratGraph {
    private int V;
    private int E;
    int[][] adjMatrix;

    public MatrixMojaveratGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v) {
        this.adjMatrix[v][u] = 1;
        this.adjMatrix[u][v] = 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adjMatrix[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
