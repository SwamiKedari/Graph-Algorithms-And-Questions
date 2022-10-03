import java.util.*;
public class numOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        // code here
        // we will do just the normal bfs traversal and then we will count the total number of provinces
        // here , they gave the adjacency matrix in the form of the arraylist of arraylist of integers
        // link : https://practice.geeksforgeeks.org/problems/number-of-provinces/1?page=2&difficulty[]=0&difficulty[]=1&category[]=Graph&sortBy=submissions
        boolean[] visited=new boolean[v];
        int count=0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                Queue<Integer> que=new LinkedList<>();
                count++;
                //System.out.println(i);
                que.add(i);
                visited[i]=true;
                while(!que.isEmpty()){
                    int h=que.remove();
                    //System.out.println(h+"//");
                    for(int k=0;k<v;k++){
                        if(adj.get(h).get(k)==1 && k!=h && !visited[k]){
                            que.add(k);
                            visited[k]=true;
                        }
                    }
                }
            }
        }
        return count;
    }
}
