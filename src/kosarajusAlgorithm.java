import java.util.*;

public class kosarajusAlgorithm {
    // get the stack which will have the elements in the topologically sorted manner
    // transpose all the directed nodes in the graph
    // perform dfs and store the strongly connected components together while performing the dfs traversal

    public static void main(String[] swami){

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=5;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(4);

        // now call the kosarajus algorithm

        kosaraju(adj,n);


    }

    public static void kosaraju(ArrayList<ArrayList<Integer>> arr ,int n){
        boolean[] visited=new boolean[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(arr,i,visited,st);
            }
        }

        // now we get the elements in the topological order in the stack

        // use another adjacency list which will have the values transpose than the current list
        ArrayList<ArrayList<Integer>> trans=new ArrayList<>();
        for(int i=0;i<n;i++){
            trans.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int k: arr.get(i)){
                trans.get(k).add(i);
            }
        }

        boolean[] visited1=new boolean[n];

        while(!st.isEmpty()){
            int h=st.pop();
            if(!visited1[h]){
                ArrayList<Integer> a=new ArrayList<>();
                revDfs(trans,h,visited1,a);
                System.out.println(a);
            }
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> arr,int i,boolean[] visited,Stack<Integer> st){
        if(!visited[i]){
            visited[i]=true;
            for(int adj : arr.get(i)){

                dfs(arr,adj,visited,st);
            }
            st.push(i);
        }
    }

    public static void revDfs(ArrayList<ArrayList<Integer>> arr,int i,boolean[] visited, ArrayList<Integer> a){
        if(!visited[i]){
            visited[i]=true;
            a.add(i);
            for(int k: arr.get(i)){
                revDfs(arr,k,visited,a);
            }
        }
    }

}
