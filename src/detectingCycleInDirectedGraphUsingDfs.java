import java.util.ArrayList;

public class detectingCycleInDirectedGraphUsingDfs {
    // Function to detect cycle in a directed graph.
    // doubt
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // in this problem , as the graph is directed , we can not use the code for the undirected graph to solve this problem
        // along with the main visited array , we will also need to maintain a dfsvisited array which will contain the boolean values of the elements which were visited during that time and not during the previous time of the dfs
        // in the dfsvisited array , we will set the values of the elements to false after the recursion call was completed and returned back
        boolean[] visited=new boolean[v];
        boolean[] dfsvisited=new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(dfs(adj,i,visited,dfsvisited)){
                    return true;
                }
            }
        }

        return false;

    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int i,boolean[] visited,boolean[] dfsvisited){
        if(!visited[i]){
            visited[i]=true;
            dfsvisited[i]=true;
            for(int j: adj.get(i)){
                if(dfs(adj,j,visited,dfsvisited)){
                    return true;
                }
            }

            dfsvisited[i]=false;
            return false;
        }
        else if(visited[i] && dfsvisited[i]){
            return true;
        }
        else{
            return false;
        }
    }
    // the logic behind using the dfsvisited array is that in this case , we erase the values of the dfsvisited back to false after the dfs traversal and still if we get that the next visited node is visited and its dfsvisited value is also true , this means that the node was previously visited during the same traversal which is possible in the case of the cycle and not the normal graph
    /*
    consider the graph  1->2 and the edges are 2->3 and 3->1, then the graph is an directed cyclic graph, in this case, we start the dfs from one of the node and start traversal, during the dfs, we will observe that when it reaches again that node then its value is true for both dfsvisited and visited , so it must be visited in the current traversal only which is possible only when the graph is cyclic and directed .
                        | /
                         3
     */
}
