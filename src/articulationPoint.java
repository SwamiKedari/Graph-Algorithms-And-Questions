import java.util.*;

public class articulationPoint {
    public static void main(String[] swami){

        // the graph we use will be a dummy graph and it will be used to get the answer
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        for(int i=0;i<5;i++){
            a.add(new ArrayList<>());
        }

        a.get(0).add(1);
        a.get(1).add(0);

        a.get(1).add(2);
        a.get(2).add(1);

        a.get(0).add(2);
        a.get(2).add(0);

        a.get(3).add(2);
        a.get(2).add(3);

        a.get(3).add(4);
        a.get(4).add(3);

        int[] artPoints=new int[5];

        getArticulationPoints(a,5,artPoints);

        System.out.println(Arrays.toString(artPoints));

    }
    public static void getArticulationPoints(ArrayList<ArrayList<Integer>> arr,int v,int[] artPoints){
        int[] time=new int[v];
        int[] lowtime=new int[v];
        boolean[] visited=new boolean[v];

        int timer=0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(arr,i,-1,time,lowtime,visited,timer,artPoints);
            }
        }
    }


    public static void dfs(ArrayList<ArrayList<Integer>> arr,int i,int parent,int[] time,int[] lowtime,boolean[] visited,int timer ,int[] artPoints){
        if(!visited[i]){
            visited[i]=true;
            timer++;
            time[i]=timer;
            lowtime[i]=timer;
            int childnum=0;

            for(int k : arr.get(i)){
                if(!visited[k]){
                    dfs(arr,k,i,time,lowtime,visited,timer,artPoints);
                    lowtime[i]=Math.min(lowtime[i],lowtime[k]);
                    childnum++;
                    if(lowtime[k] >=time[i] && parent!=-1){
                        artPoints[i]=1;
                    }
                }
                else{
                    lowtime[i]=Math.min(lowtime[i],time[k]);
                }
            }
            if(childnum>1 && parent!=-1 ){
                artPoints[i]=1;
            }
        }
    }


}
