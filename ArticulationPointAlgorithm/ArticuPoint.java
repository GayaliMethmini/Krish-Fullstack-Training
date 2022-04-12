import java.util.*;

public class ArticuPoint {

    static class Graph{
        int vertices;
        LinkedList<Integer> adjList [];

        public Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int d){
            
            adjList[s].addFirst(d);//forward
            
            adjList[d].addFirst(s);//backwa
        }
    }

   
    ArrayList<Integer> articulationResult = new ArrayList<>();

    public void findArticuPoints(Graph g){

        int vertices = g.vertices;

        //visited array
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i <vertices ; i++) {
            
        }

    

    }

    public void DFS(Graph g, int currentVertex, boolean[] visited){

        LinkedList<Integer> adjList [] = g.adjList;
	
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(5, 6);

        ArticuPoint ap = new ArticuPoint();
        ap.findArticuPoints(g);
    }
}