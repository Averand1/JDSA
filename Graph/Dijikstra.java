package Graph;

import java.util.*;

class DJGraph {
    int dist[];
    Set<Integer> visited;
    Queue<Node> pq;
    int V;
    List<List<Node>> adj_list;

    // class constructor
    public DJGraph(int V) {
        this.V = V;
        dist = new int[V];
        visited = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    // Dijikstra's algorithm
    public void dijikstra(List<List<Node>> adj_list, int src_vertex) {
        this.adj_list = adj_list;
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // Add source vertex to priority queue
        pq.add(new Node(src_vertex, 0));

        // Distance to src from iteself is 0
        dist[src_vertex] = 0;
        while (visited.size() != V) {
            // u is removed from PriorityQueue and has min dist
            int u = pq.remove().node;

            // add node to finalized list (visited)
            visited.add(u);
            graph_adjacentNodes(u);
        }
    }

    // this method processes all neighbours of the just visited node
    private void graph_adjacentNodes(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        // process all neighbouring nodes of u
        for (int i = 0; i < adj_list.get(u).size(); i++) {
            Node v = adj_list.get(u).get(i);

            // proceed only if current node is not in 'visited'
            if (!visited.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // compare distance
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current vertex to PriorityQueue with updated distance
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }

}

class Main {
    public static void main(String arg[]) {
        int V = 7;
        int source = 0;

        // adj list representation of graph
        List<List<Node>> adj_list = new ArrayList<List<Node>>();
        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj_list.add(item);
        }

        // Input graph edges
        adj_list.get(0).add(new Node(1, 2));
        adj_list.get(0).add(new Node(2, 6));
        adj_list.get(1).add(new Node(3, 5));
        adj_list.get(2).add(new Node(3, 8));
        adj_list.get(3).add(new Node(5, 15));
        adj_list.get(3).add(new Node(4, 10));
        adj_list.get(5).add(new Node(4, 6));
        adj_list.get(4).add(new Node(6, 2));
        adj_list.get(5).add(new Node(6, 6));
        // call Dijkstra's algo method
        DJGraph dpq = new DJGraph(V);
        dpq.dijikstra(adj_list, source);

        // Print the shortest path from source node to all the nodes
        System.out.println("The shorted path from source node to other nodes:");
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " \t\t " + i + " \t\t " + dpq.dist[i]);

    }
}

class Node implements Comparator<Node> {
    int node;
    int cost;

    public Node() {

    }

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        return 0;
    }

}