import java.util.*;
// in this problem, we are given with the some tasks and we want to tell the order in which they must be executed
// this involves checking of the cycle in the graph and then displaying the topological sort for the same
// link : https://practice.geeksforgeeks.org/problems/course-schedule/1?page=3&difficulty[]=0&difficulty[]=1&category[]=Graph&sortBy=submissions
public class courseSchedule {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> a)
    {
        // add your code here
        // the question is tricky but imply that we have to get the topological sort on the graph
        // 2d arraylist is the prerequisites arraylist
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<Integer>());
        }
        for(ArrayList<Integer> b : a){
            arr.get(b.get(1)).add(b.get(0));
        }
        // now we just need to perform the topological sort and then get the answer
        int[] ined=new int[n];
        for(int i=0;i<n;i++){
            for(int k : arr.get(i)){
                ined[k]++;
            }
        }
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(ined[i]==0){
                que.add(i);
            }
        }

        int size=0;
        ArrayList<Integer> ans=new ArrayList<>();
        while(!que.isEmpty()){
            int h =que.remove();
            size++;
            ans.add(h);
            for(int k: arr.get(h)){
                ined[k]--;
                if(ined[k]==0){
                    que.add(k);
                }
            }
        }


        if(size!=n){
            return new int[0];
        }
        int[] ans1=new int[n];
        for(int i=0;i<size;i++){
            ans1[i]=ans.get(i);
        }
        return ans1;
    }
}
