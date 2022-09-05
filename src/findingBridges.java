import java.util.*;
public class findingBridges {
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

        System.out.println("The bridges in the graph are as follows :");
        printBridges(a,5);


    }
    static void printBridges(ArrayList<ArrayList<Integer>> arr,int v){
        int[] time=new int[v];
        int[] lowtime=new int[v];
        boolean[] visited=new boolean[v];
        int timer=0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(arr,i,-1,time,lowtime,visited,timer);
            }
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> arr,int i,int parent , int[] time,int[] lowtime,boolean[] visited,int timer){
        if(!visited[i]){
            visited[i]=true;
            timer++;
           // System.out.println("check");
            time[i]=timer ;
            lowtime[i]=timer;
            for(int ed : arr.get(i)){
                if(ed==parent){
                    continue;
                }
                if(!visited[ed]){
                    dfs(arr,ed,i,time,lowtime,visited,timer);
                    lowtime[i]=Math.min(lowtime[i],lowtime[ed]);
                    if(lowtime[ed] > time[i]){
                        System.out.println(i+"->"+ed);
                    }
                }
                else{
                    lowtime[i]=Math.min(lowtime[i],time[ed]);
                }
            }

        }
    }
}
