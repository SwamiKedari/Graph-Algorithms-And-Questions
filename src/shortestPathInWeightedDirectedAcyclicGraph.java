import java.util.*;
public class shortestPathInWeightedDirectedAcyclicGraph {

    // since the graph that we are going to use , is a weighted graph , so we will store the elements in the pairs other than integers
    // we will use the topological sort technique to solve this problem
    // in the topological sort , we store the values in the stack after the dfs call for that node is over , this will give us the nodes will the u->v nodes arranged in u first and then v order everywhere
    // after doing the topological sort , we will use the stack that we get and we will use it to do a traversal and store the distances , this traversal is similar to the bfs traversal



    public static int[] getDistanceArray(ArrayList<ArrayList<pair>> arr){
        int n=arr.size();
        boolean[] visited=new boolean[n+1];
        Stack<Integer> st=new Stack<>();
        for(int i=1;i<=n;i++){
            if(visited[i]==false) {
                getStack(arr, i, n, visited, st);
            }

        }

        // after the stack of elements is ready , we will use it to get the distance array
        int[] distance=new int[n+1];
        distance[1]=0;
        Arrays.fill(distance,Integer.MAX_VALUE);

        while(!st.isEmpty()){
            int k=st.pop();
            if(distance[k]!=Integer.MAX_VALUE){
                for(pair h : arr.get(k)){
                    if(distance[k]+h.weight < distance[h.node]){
                        distance[h.node]=distance[k]+h.weight;

                    }
                }
            }
        }

        System.out.println(Arrays.toString(distance));

        return distance;

    }

    public static void getStack(ArrayList<ArrayList<pair>> arr,int i,int n,boolean[] visited,Stack<Integer> st){
        if(!visited[i]){
            visited[i]=true;
            for(pair adj : arr.get(i)){
                getStack(arr,adj.node,n,visited,st);
            }
            st.push(i);
        }
    }


}

class pair{
    int node;
    int weight;
    pair(int node , int weight){
        this.node=node;
        this.weight=weight;
    }
}

// we use the topogical sort in the case of the directed graph as it dont makes sense to traverse first to the node which is far and then node which come between the path

