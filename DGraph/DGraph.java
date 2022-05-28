package DGraph;
import java.util.*;

public class DGraph {
    private LinkedList<Integer> adjlist[]; 
    private boolean visited[];

    DGraph(int vertices) {
        adjlist = new LinkedList[vertices];
        visited = new boolean[vertices];
        for(int i=0; i<vertices; ++i) {
            adjlist[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w) {
        adjlist[v].add(w);
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.println(vertex + " ");
        Iterator<Integer> i = adjlist[vertex].listIterator();
        while(i.hasNext()) {
            int adjlist = i.next();
            if(!visited[adjlist]) {
                DFS(adjlist);
            }
        }
    }

    public static void main(String args[]) {
        DGraph g = new DGraph(15);
        g.addEdge(1,2);
        g.addEdge(1,5);
        g.addEdge(1,7);
        g.addEdge(2,0);
        g.addEdge(2, 8);
        g.addEdge(8,6);
        g.addEdge(6,12);
        g.addEdge(6,4);

        System.out.print("Depth First Search: ");
        g.DFS(1);
    }

    
}
