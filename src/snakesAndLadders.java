import java.util.*;
public class snakesAndLadders {
    static int minThrow(int n, int arr[]){
        // code here
        // we have to find the minimum number of dice throws that will help us reach the end of the arr
        // this problem is an easy problem which can be solved with the help of bfs
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        adj.add(new ArrayList<>());
        for(int i=1;i<30;i++){
            ArrayList<Integer> ar=new ArrayList<>();
            int ind=i+1;
            while(ind<=i+6 && ind<=30 ){
                ar.add(ind);
                ind++;
            }
            adj.add(ar);
        }
        adj.add(new ArrayList<>());
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<2*n;i+=2){
            adj.get(arr[i]).add(arr[i+1]);
            mp.put(arr[i],arr[i+1]);
        }
        int[] distance=new int[30];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        Queue<Integer> que=new LinkedList<>();
        que.add(1);
        while(!que.isEmpty()){
            int h=que.remove();
            for(int k : adj.get(h)){
                if(mp.containsKey(h) && mp.get(h)==k){
                    if(distance[h-1]<distance[k-1]){

                        distance[k-1]=distance[h-1];
                        que.add(k);
                    }
                }
                else{
                    if(distance[h-1]+1<distance[k-1]){

                        distance[k-1]=distance[h-1]+1;
                        que.add(k);
                    }
                }
            }
        }


        return distance[29];
    }
}
