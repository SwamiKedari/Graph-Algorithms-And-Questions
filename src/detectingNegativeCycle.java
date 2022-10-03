import java.util.*;
public class detectingNegativeCycle {
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        //we are given with the weighted directed graph with the n nodes and m edges
        // we have to tell if the negative cycle exists or not
        // this will be achieved if in the bellman ford algorithm , it relaxes even after n loops
        int[] distance = new int[n];
        Arrays.fill(distance,1000000);
        int m=edges.length;
        distance[0]=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(distance[edges[j][0]]+edges[j][2]<distance[edges[j][1]]){
                    distance[edges[j][1]]=distance[edges[j][0]]+edges[j][2];
                }
            }
        }

        for(int j=0;j<m;j++){
            if(distance[edges[j][0]]+edges[j][2]<distance[edges[j][1]]){
                return 1;
            }
        }
        return 0;


    }
}
