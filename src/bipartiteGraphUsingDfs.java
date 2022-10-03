import java.util.*;

public class bipartiteGraphUsingDfs {
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        // the procedure to check whether the graph is bipartite or not using the dfs is same as with the bfs code
        // we will keep an color array instead of the visited array and go on marking the color of the next nodes as the opposite of the previous nodes
        // when we find that the next element is already visited , we will check whether the next element has opposite color to the curr element , if it has the same color then the graph can not be the bipartite graph else the gralph will be the bipartite graph
        int[] color=new int[v];
        for(int i=0;i<v;i++){
            if(color[i]==0){
                if(!dfs(adj,i,2,color)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int i,int col,int[] color){
        if(color[i]==0){
            color[i]=Math.abs(3-col); // we are using the color of the previous element to determine the color of the current element which will be opposite of the previous color and then we are checking if the next element already has the color equal to same as the current element

            for(int k : adj.get(i)){
                if(color[k]==0){
                    if(!dfs(adj,k,color[i],color)){
                        return false;
                    }
                }
                else if(color[k]==color[i]){
                    return false;
                }
            }

            return true;
        }

        return false;
    }
    // the algorithm is similar to the bfs algorithm just the difference is of the traversal ,
    // here also we have to traverse and mark the nodes as the different adjacent colors during the same and check if the adjacent node has the same color as the given node , if such a condition arrives then we can say that the graph is not a bipartite graph
    // else it is the bipartite graph

}
