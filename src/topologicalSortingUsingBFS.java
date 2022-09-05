import java.util.*;

public class topologicalSortingUsingBFS {
    // finding the topological sort using the bfs algorithm involves using the kahn's algorithm
    // the algorithm is as follows:
    /*
    find all the invertices;
    add the nodes which have value of invertex equal to zero to the queue
    do bfs using this nodes in the queue , during the bfs , reduce the counts of the invertices by 1
    add the node to the queue , which has the value equal to the zero
     */

    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        // the solution using the kahn's algorithm
        int[] invert=new int[v];
        boolean[] visited=new boolean[v];
        int size=0;
        int[] ans=new int[v];
        for(int i=0;i<v;i++){
            for(int j : adj.get(i)){
                invert[j]++;
            }
        }

        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(invert[i]==0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int k=que.remove();
            visited[k]=true;
            ans[size++]=k;
            for(int i : adj.get(k)){
                invert[i]--;
                if(!visited[i] && invert[i]==0){
                    que.add(i);
                }
            }
        }

        return ans;
    }
}
