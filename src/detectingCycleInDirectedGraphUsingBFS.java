import java.util.*;
public class detectingCycleInDirectedGraphUsingBFS {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // we will use the kahn's algorithm to solve this problem
        // the topological sort was possible only if the graph is an directed acyclic graph
        // since the topological sort is not possible in the case of the directed cyclic graph , we will use it
        // when we use the kahn's algorithm in the case of the cyclic directed graph , we dont get all the nodes in the queue and the queue becomes empty in less than v iterations , we will use this fact to solve the problem
        int[] inVertices=new int[v];
        for(int i=0;i<v;i++){
            for(int j : adj.get(i)){
                inVertices[j]++;
            }
        }

        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inVertices[i]==0){
                que.add(i);
            }
        }

        int size=0;
        while(!que.isEmpty()){
            int k=que.remove();
            size++;
            for(int g : adj.get(k)){
                inVertices[g]--;
                if(inVertices[g]==0){
                    que.add(g);
                }
            }

        }

        if(size==v){
            return false;
        }
        else{
            return true;
        }
    }
}
