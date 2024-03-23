import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static void BFS(ArrayList<ArrayList<Integer>> adj,int V, int s,boolean[] visited){
//        boolean[] visited=new boolean[V+1];
        Queue<Integer> q=new LinkedList<Integer>();
        visited[s]=true;
        q.add(s);
        while (!q.isEmpty()){
            int u=q.poll();
//            System.out.print(u+" ");
            for (int v:adj.get(u)){
                if (!visited[v]){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
    }
    static void BFSDis(ArrayList<ArrayList<Integer>> adj,int V){
        boolean[] visited=new boolean[V+1];
        for (int i=0;i<V;i++){
            if (!visited[i]){
                BFS(adj,V,i,visited);
            }
        }
    }

    static int BFSDisIsland(ArrayList<ArrayList<Integer>> adj,int V){
        boolean[] visited=new boolean[V+1];
        int count=0;
        for (int i=0;i<V;i++){
            if (!visited[i]){
                BFS(adj,V,i,visited);
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);
        adj.get(2).add(5);
        adj.get(6).add(6);

        System.out.println("BFS Traversal:");
//        BFSDis(adj, V); // Start BFS traversal from all vertices
        System.out.println();
        System.out.println("The number of islands here is: "+BFSDisIsland(adj,V));
    }
}
