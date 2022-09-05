import java.util.*;
public class preRequisiteTasks {
    public boolean isPossible(int n, int[][] pr)
    {
        // we have to check whether the graph is the directed acyclic graph or not
        // we will use the kahn's algorithm and check if the number of iterations are less than v
        // if they are less than v, then the graph is a directed cyclic graph

        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        int[] inv=new int[n];
        for(int i=0;i<pr.length;i++){
            arr.get(pr[i][1]).add(pr[i][0]);
            inv[pr[i][0]]++;
        }
        //System.out.println(Arrays.toString(inv));

        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inv[i]==0){
                que.add(i);
            }
        }
        int it=0;
        while(!que.isEmpty()){
            int k=que.remove();
            it++;
            for(int i : arr.get(k)){
                inv[i]--;
                if(inv[i]==0){
                    que.add(i);
                }
            }
        }
        // System.out.println(it);
        if(it==n){
            return true;
        }
        return false;

    }
}
