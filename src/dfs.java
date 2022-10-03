import java.util.*;
public class dfs {
    // in the dfs traversal , we traverse the depth of the graph first and then we move on to the next adjacent node when the traversal of the first adjacent node is completed
    // the depth of the graph means all the nodes that are connected to each other in the graph adjacently are traversed first in line and then the traversal moves to the next adjcanet nodes

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // in the dfs traversal , we traverse the depth of the graph first and then we proceed to the next node
        // in this solution , we describe the recursive code for the dfs traversal
        // the visited array elements are marked true when the traversal enters the dfs function

        ArrayList<Integer> arr=new ArrayList<>();
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++){ // this for loop is for the non-connected components in the graph
            if(!visited[i]){

                dfs(i,adj,arr,visited);
            }
        }

        return arr;
    }

    public void dfs(int i,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> arr,boolean[] visited){ // do traversal to the next nodes from the given node and when one traversal for the adjacent node is complete, then move to the next component
        if(!visited[i]){
            visited[i]=true;
            arr.add(i);
            for(int k: adj.get(i)){
                dfs(k,adj,arr,visited);
            }
        }
    }
}
