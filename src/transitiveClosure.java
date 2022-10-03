import java.util.*;
public class transitiveClosure {
    static ArrayList<ArrayList<Integer>> transitiveClosure(int n, int graph[][])
    {
// code here
// use the dfs or bfs traversal on the graph and then find the answer
        boolean[] visited=new boolean[n];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> b=new ArrayList<>();
            for(int j=0;j<n;j++){
                b.add(0);
            }
            ans.add(b);
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<n;i++){
                if(!visited[i] && graph[j][i]==1){
                    dfs(graph,ans,j,i,n,visited);
                }
            }
            visited=new boolean[n];
        }

        for(int i=0;i<n;i++){
            ans.get(i).set(i,1);
        }
        return ans;
    }

    static void dfs(int[][] graph,ArrayList<ArrayList<Integer>> ans,int j,int i,int n,boolean[] visited){
        if(!visited[i]){
            visited[i]=true;
            ans.get(j).set(i,1);
            for(int k=0;k<n;k++){
                if(!visited[k] && graph[i][k]==1){
                    //ans.get(i).set(k,1);
                    dfs(graph,ans,j,k,n,visited);
                }
            }
        }
    }
}
