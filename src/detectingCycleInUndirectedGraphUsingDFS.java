
import java.util.*;
public class detectingCycleInUndirectedGraphUsingDFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // the logic to solve this problem is same as the detecting the cycle using the bfs
        // in this case , we pass the index of the current element and the previous element to the funtion so that if the adjacent element is visited and it is also not the parent , then the cycle will be visited
        boolean[] vis=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                if(dfs(adj,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int i,int par){
        if(vis[i]==false){
            vis[i]=true;
            for(int j:adj.get(i)){
                if(!vis[j]){
                    if(dfs(adj,vis,j,i)){
                        return true;
                    }
                }
                else if(vis[j] && par!=j){
                    return true;
                }

            }
            return false;
        }

        return false;

    }
}
