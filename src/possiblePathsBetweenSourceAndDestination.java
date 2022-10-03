import java.util.*;
public class possiblePathsBetweenSourceAndDestination {
    // Function to count paths between two vertices in a directed graph.
    // in this question, we have assumed that the graph dont have the cycle and dont have multiple-edge
    // this algorithm will fail in the above two conditions

    public int countPaths(int v, ArrayList<ArrayList<Integer>> adj, int source,
                          int destination) {
    // Code here
    // do the dfs and keep a count of howmany times it reaches the value destination
        int[] count=new int[1];
        boolean[] visited=new boolean[v];
        dfs(adj,source,destination,visited,count);
        if(count[0]==0 && source== destination){
            return 1;
        }
        return count[0];
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int i,int d,boolean[] visited,int[] count){
        if(!visited[i]){
    // visited[i]=true;
            for(int k : adj.get(i)){
                if(k==d){
    // visited[i]=false;
                    count[0]++;
                    continue;
                }
                if(!visited[k]){
                    dfs(adj,k,d,visited,count);
                }
            }
        }
    }
}
