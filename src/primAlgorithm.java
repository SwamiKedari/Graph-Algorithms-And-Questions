import java.util.*;
public class primAlgorithm {
    public static void main(String[] swami){

        // the implementation of the graph will be similar to the dijkstras algorithm
    }
    public void primAlgo(ArrayList<ArrayList<graphNode>> a, int n){
        int[] key=new int[n];
        int[] parent=new int[n];
        boolean[] mst =new boolean[n];
        PriorityQueue<graphNode> que=new PriorityQueue<>(n,new graphNode());
        Arrays.fill(parent,-1);
        Arrays.fill(key,Integer.MAX_VALUE);

        key[0]=0;

        que.add(new graphNode(0,key[0]));
        for(int i=0;i<n-1;i++){
            graphNode node=que.remove();
            mst[node.vertice]=true;

            for(graphNode v : a.get(node.vertice)){
                if(mst[v.vertice]==false && v.weight<key[v.vertice]){
                    parent[v.vertice]=node.vertice;
                    key[v.vertice]=v.weight;
                    que.add(v);
                }
            }

        }

        System.out.println(Arrays.toString(parent)); 
    }
}
