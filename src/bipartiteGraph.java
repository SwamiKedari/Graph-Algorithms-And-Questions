import java.util.*;
public class bipartiteGraph {
    // bipartite graph is a graph that can be colored in to exactly 2 colors such that no 2 adjacent nodes have the same color with each other

    // through observation , it is clear that the graph with the odd cycle size are not bipartite and the graphs with the even cycle or the no cycle are the bipartite graphs
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        // we will use the bfs traversal to see whether the graph is bipartite or not
        // instead of the visited array , we will use the color array which will store the color of the arrays
        // if the node is already visited during the traversal , then we will check its adjacent colors
        // if the adjacent colors are opposite , then the graph is a bipartite graph else it is not a bipartite graph
        int[] color=new int[v];
        for(int i=0;i<v;i++){ // for the non connected components of the graph
            if(color[i]==0){
                color[i]=1; // first we will initialize the value of the color using 1
                Queue<Integer> a=new LinkedList<>();
                a.add(i);

                while(!a.isEmpty()){
                    int k=a.remove();
                    int col=color[k]; // we will check if the adjacent elements of the current elements have the different color, if it dont have different color and already has been marked with the same color as the current node color, then we can say that the graph is not a bipartite graph
                    for(int j: adj.get(k)){
                        if(color[j]==0){
                            color[j]=Math.abs(3-col);
                            a.add(j);
                        }
                        else if(color[j]==col){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
    // the algorithm is simple and just involves the traversing using bfs , marking the nodes as different adjacent colors during the traversal and then checking if any node was previously traversed and still has the color equal to same color as the given node , then the graph is not a bipartited graph , else it is

}
