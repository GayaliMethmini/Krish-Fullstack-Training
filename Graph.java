import java.io.*; 
import java.util.*; 
 
class Graph { 
    private int vertices;   // No. of vertices 
    private LinkedList<Integer> adjacency_list[]; //Adjacency Lists 
   
     //Constructor to pass the number of vertices 
    Graph(int ver) { 
        vertices = ver; 
        adjacency_list = new LinkedList[ver]; 
        for (int i=0; i<ver; i++)         
            adjacency_list[i] = new LinkedList(); 
    } 
   
    // adding an edge 
    void addEdge(int v,int b) { 
        adjacency_list[v].add(b); 
    } 
   
    // BFS traversal from the starting vertex
    void BFS(int startVertex)   { 
    
        boolean visited[] = new boolean[vertices]; 
   
        //queue 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
   
        //add in to the queue if the current node is visited
        visited[startVertex]=true; 
        queue.add(startVertex); 
   
        while (queue.size() != 0)  { 
            //remove the element from the queue (FIFO)
            //.poll()--> remove/delete the element in the queue
            startVertex = queue.poll(); 
            System.out.print(startVertex+" "); 
   
            // get all adjacent nodes of current node
            Iterator<Integer> i = adjacency_list[startVertex].listIterator(); 
            while (i.hasNext()){ 
                int x = i.next(); 
                if (!visited[x]) { 
                    visited[x] = true; 
                    queue.add(x); 
                } 
            } 
        } 
    }
	public static void main(String args[]) 
    { 
        //create a graph with 7 vertices
        Graph g = new Graph(7); 
		
        //add edges
	g.addEdge(0, 1); 
	g.addEdge(0, 2); 
	g.addEdge(1, 3);
	g.addEdge(2, 4);
        g.addEdge(2, 6); 
        g.addEdge(4, 5); 
	g.addEdge(5, 6); 
		 
        System.out.println("BFS with 0 as starting vertex:"); 
        g.BFS(0); 
    } 
	
  }

    
  
     
 