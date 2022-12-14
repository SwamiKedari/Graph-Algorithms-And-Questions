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
            size++; // we check whether this while loop loops exactly v times as the number of total vertices are v
            // in the case of a cyclic directed graph, this while loop will not be able to reach for every node and it will stop before all the nodes are completed
            // this is because the topological sort order is not followed for the directed cyclic graph and is followed for the directed acyclic graph only ...
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
    // we use the kahn's algorithm to get the topological sort and we use the fact that the topological sort algorithm is only possible in the case of the directed acyclic graph and in the directed cyclic graph , the queue will not store all the nodes inside it and thus the size will not be equal to the value of v

}
