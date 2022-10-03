import java.util.*;
public class bellManFord {
    static int[] bellman_ford(int v, ArrayList<ArrayList<Integer>> adj, int s)
    {
        // Write your code here
        int[] distance=new int[v];
        Arrays.fill(distance, 100000000);
        distance[s]=0;
        for(int i=0;i<v;i++){
            for(ArrayList<Integer> k : adj){
                int a0=k.get(0);
                int a1=k.get(1);
                int a2=k.get(2);
                if(distance[a0]+a2<distance[a1]){
                    distance[a1]=distance[a0]+a2;
                }
            }
        }
        return distance;
    }
}
