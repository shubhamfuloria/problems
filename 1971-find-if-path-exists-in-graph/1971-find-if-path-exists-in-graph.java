class Solution {

    static class Edge {
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr] && hasPath(graph, edge.nbr, dest, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] array : edges) {
            int s = array[0];
            int d = array[1];

            graph[s].add(new Edge(s, d));
            graph[d].add(new Edge(d, s));
        }
        boolean[] visited = new boolean[n];

        return hasPath(graph, source, destination, visited);
    }
}
