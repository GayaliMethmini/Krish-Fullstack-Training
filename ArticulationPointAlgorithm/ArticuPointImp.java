import java.io.*;
import java.util.*;
import java.util.LinkedList;
 
class ArticuPointImp{

    private int vertices; // no. of vertices
 
    private LinkedList<Integer> adjacency_list[]; //array for adjacency List
    int time = 0;
    static final int NIL = -1;
 
    ArticuPointImp(int v){
        vertices = v;
        adjacency_list = new LinkedList[v];
        for (int i=0; i<v; i++){
            adjacency_list[i] = new LinkedList();
        }     
    }
 
    //adding edges 
    void addEdge(int v, int w){
        adjacency_list[v].add(w); // Add w to v's list
        adjacency_list[w].add(v); //Add v to w's list
    }
 
    //recursive function that find articulation points using DFS
    void ArticuPointUtil(int u, boolean visited[], int dis[], int low[], int parent[], boolean aPoints[]) {
    // u = the next vertex to be visited
    // visited[] = visited vertices 
    // dis[] = discovery times of visited vertices
    // low[] = vertex with minimum discovery time that can be reached
        // low[u] = min(dis[u], dis[w]) 
        // where w is the parent of u and there is a back edge from some child of u to w
    // parent[] = parent vertices in DFS tree
    // aPoints[] = articulation points
    
        int children = 0; 
        visited[u] = true; // set the current node as visited
        dis[u] = low[u] = ++time; // Initialize discovery time and low value

        Iterator<Integer> i = adjacency_list[u].iterator(); // Go through all vertices adjacent to this
        while (i.hasNext()) {
            int a = i.next();  // a is current adjacent of u

            // If a is not visited yet then make it a child of u in DFS tree and recur for it
            if (!visited[a]) {
                children++;
                parent[a] = u;
                ArticuPointUtil(a, visited, dis, low, parent, aPoints);

                // Check if the subtree rooted with "a" has a connection to one of the ancestors of u
                low[u]  = Math.min(low[u], low[a]);
 
                // u is an articulation point under the following conditions

                // 1. u is root of DFS tree and has atleast two chilren.
                // if (parent[u] == NIL && children > 1)
                //     ap[u] = true;
                if (parent[u] == NIL && children > 1)
                    aPoints[u] = true;
 
                // 2. If u is not root and low value of one of its child is more than discovery value of u.
                if (parent[u] != NIL && low[a] >= dis[u])
                    aPoints[u] = true;
            }
            // Update low value of u for parent method calls
            else if (a != parent[u])
                low[u]  = Math.min(low[u], dis[a]);
        }
    }
 
    // DFS traversal = uses recursive function ArticuPointUtil()
    void AP() {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[vertices];
        int dis[] = new int[vertices];
        int low[] = new int[vertices];
        int parent[] = new int[vertices];
        boolean aPoints[] = new boolean[vertices]; 
 
        // Initialize parent, visited and articulation point arrays
        for (int i = 0; i < vertices; i++) {
            parent[i] = NIL;
            visited[i] = false;
            aPoints[i] = false;
        }
 
        // Call the recursive method to find articulation points in DFS tree rooted with vertex 'i'
        for (int i = 0; i < vertices; i++)
            if (visited[i] == false)
                ArticuPointUtil(i, visited, dis, low, parent, aPoints);
 
        // print articulation points
        for (int i = 0; i < vertices; i++)
            if (aPoints[i] == true)
                System.out.print(i +" ");
    }

    public static void main(String args[]) {

        System.out.print("Articulation points: ");
        ArticuPointImp ap = new ArticuPointImp(11);
        ap.addEdge(0, 1);
        ap.addEdge(0, 3);
        ap.addEdge(1, 2);
        ap.addEdge(2, 3);
        ap.addEdge(2, 4);
        ap.addEdge(2, 5);
        ap.addEdge(4, 5);
        ap.addEdge(5, 6);
        ap.addEdge(6, 7);
        ap.addEdge(6, 8);
        ap.addEdge(7, 8);
        ap.AP();
    }
}