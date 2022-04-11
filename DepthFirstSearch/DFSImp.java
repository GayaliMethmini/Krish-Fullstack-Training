import java.util.LinkedList;
import java.util.Stack;

class DFSImp {
	
	private int vertices;   // No. of vertices 
    private LinkedList<Integer> adjacency_list[]; //Adjacency Lists 

	DFSImp(int ver) {
		vertices = ver;
		adjacency_list = new LinkedList[ver];
		for (int i = 0; i < ver ; i++) {
			adjacency_list[i] = new LinkedList();
		}
	}

	//adding edges
	void addEdge(int v, int b){
		adjacency_list[v].add(b);
	}

	//DFS implementation
	void DFS(int startVertex){
		
		boolean visited[] = new boolean[vertices];
		
		Stack<Integer> s = new Stack<Integer>();

		int x = 0;
		int e =0;
	
		visited[startVertex] =true;
		s.push(startVertex);

		while (s.isEmpty()==false){
			//.pop() --> get the last element from the stack
			e = s.pop(); 
			System.out.print(e + " ");  

			for(int i = 0; i < adjacency_list[e].size();i++){
		
				// get the correspondent index value 
				x = adjacency_list[e].get(i); 
				
				if (!visited[x]){

					visited[x] = true;
					s.push(x); //add the element to the stack
				}
			}		

		}

	}
 
	public static void main(String[] args) {
		
		//create an object and pass the no of vertices
		DFSImp d = new DFSImp(8);
		
		d.addEdge(0, 3);
		d.addEdge(3, 5);
		d.addEdge(5, 6);
		d.addEdge(6, 2);
		d.addEdge(2, 1);
		d.addEdge(3, 7);
		d.addEdge(7, 4);
		
		System.out.print("DFS : ");
		d.DFS(0);
	}
}
