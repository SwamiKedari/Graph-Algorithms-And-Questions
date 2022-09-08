import java.util.*;
public class topologicalSortingUsingDFS {
    // topological sort is the order of the nodes in which if the there is an edge between u -> v , then u appears first and then v appears
    // the topological sort is possible only in the case of the directed acyclic graph
    /* the graph must not be cyclic because of the example as shown below
    2->3
    \  |
     \ 4
     in this example , the topological sort is not possible if their is an directed edge from 3->4 and 4->2

     */

    //Function to return list containing vertices in Topological order.
    // this solution solved 55/72 test cases in gfg
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        // we will use the dfs traversal to solve this problem , in this problem , we will call the normal dfs and when the dfs call is over , we will use a stack to store that element
        // this will help us get the topological sort in the reverse order and hence we can pop it out to get the array
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(adj,visited,st,i);
            }
        }

        //System.out.println(st);
        int[] ans=new int[v];
        for(int i=0;i<v;i++){
            int h=st.pop();
            ans[i]=h;
        }
        return ans;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer> st,int i){
        if(!visited[i]){
            visited[i]=true;
            for(int h : adj.get(i)){

                dfs(adj,visited,st,h);

            }
            st.push(i);
        }
    }
    // the topological sort using the dfs algorithm is based on the fact that the node which has the less number of outvertices will be stored first and then the node which has the more number of vertices
    // the algorithm is simple and just involves the pushing into the stack after the traversal


}
