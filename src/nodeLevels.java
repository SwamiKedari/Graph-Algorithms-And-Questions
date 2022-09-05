import java.util.*;
public class nodeLevels {
    //Function to find the level of node X.
    int nodeLevel(int v, ArrayList<ArrayList<Integer>> adj, int x)
    {
        // code here
        // the vertice will have level equal to the shortest distance from the source vertex
        int[] dist=new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        // we will apply the bfs algorithm to get the answer
        Queue<Integer> que=new LinkedList<>();
        dist[0]=0;
        que.add(0);
        while(!que.isEmpty()){
            int h=que.remove();
            for(int i: adj.get(h)){
                if(dist[i]> dist[h]+1){
                    dist[i]=dist[h]+1;
                    que.add(i);
                }
            }
        }

        if(x>=v || dist[x]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[x];
    }
}
