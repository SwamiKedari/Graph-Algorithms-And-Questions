import java.util.*;
public class detectingCycleInUndirectedGraph {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // lets solve this problem using the bfs algorithm in this program
        // during the bfs traversal we will store the previously visited element and the boolean value in a structure and then we will check if the next element is already visited in the bfs traversal
        // the work of the prev[] array elements is that it should not detect the previously visited elements as the cycle but when the element is not the previous element and still it shows visited , then there will be a cycle for sure in the graph

        boolean[] visited=new boolean[v];
        int[] prev=new int[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                prev[i]=-1;
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                visited[i]=true;
                while(!q.isEmpty()){
                    int h=q.remove();

                    for(int j:adj.get(h)){
                        if(!visited[j]){
                            q.add(j);
                            visited[j]=true;
                            prev[j]=h;
                        }
                        else if(visited[j] && prev[h]!=j){
                            //System.out.println(j+" "+prev[j]);
                            return true;
                        }
                    }
                }



            }
        }
        return false;
    }
}
