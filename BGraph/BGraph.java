package BGraph;
import java.util.*;

public class BGraph {
    private LinkedList adj[];
    private int V;

    BGraph(int v) {
        V = v;
        adj = new LinkedList[V];
        for(int i=0; i<V; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    @SuppressWarnings("unchecked")
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        BGraph g = new BGraph(15);
        g.addEdge(1,2);
        g.addEdge(1,5);
        g.addEdge(1,7);
        g.addEdge(2,0);
        g.addEdge(2, 8);
        g.addEdge(8,6);
        g.addEdge(6,12);
        g.addEdge(6,4);

        System.out.print("Breadth First Search: ");
        g.BFS(1);
    }
    
}
