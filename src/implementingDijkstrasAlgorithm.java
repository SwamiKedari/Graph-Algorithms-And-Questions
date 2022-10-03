import java.util.*; 
public class implementingDijkstrasAlgorithm {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        // Write your code here
        // we want to implement the dijkstra's algorithm
        // we are given with the arraylist of arraylist of integers
        // it is the arraylist of the arraylist of elements which contain the 2 numbers first the adjacent nodes and next the weight of that adjacent node with respect to the current node
        // first we will convert all the 2d arraylist which contains the 2 elements to the graphNode1 and then we will perform the operation on it
        ArrayList<ArrayList<graphNode1>> arr=new ArrayList<>();

        for(int i=0;i<v;i++){
            arr.add(new ArrayList<graphNode1>());
        }



        for(int i=0;i<v;i++){
            ArrayList<ArrayList<Integer>> a=adj.get(i);
            for(ArrayList<Integer> b : a){
                int vertice=b.get(0);

                int weight=b.get(1);

                graphNode1 g=new graphNode1(weight,vertice);
                arr.get(i).add(g);
            }
        }
        PriorityQueue<graphNode1> que=new PriorityQueue<graphNode1>(v,new graphNode1());
        int[] distance=new int[v];
        Arrays.fill(distance,Integer.MAX_VALUE);
        que.add(new graphNode1(0,s));
        distance[s]=0;
        while(!que.isEmpty()){
            graphNode1 h=(graphNode1)que.remove();
            for(graphNode1 i : arr.get(h.vertice)){
                if(distance[h.vertice]+i.weight<distance[i.vertice]){
                    distance[i.vertice]=distance[h.vertice]+i.weight;
                    que.add(new graphNode1(distance[i.vertice],i.vertice));
                }
            }
        }

        return distance;
    }

}

class graphNode1 implements Comparator<graphNode1>{
    int weight;
    int vertice;
    graphNode1(int w,int v){
        weight=w;
        vertice=v;
    }
    graphNode1(){

    }
    public int compare(graphNode1 n1,graphNode1 n2){
        if(n1.weight < n2.weight){
            return -1;
        }
        else if(n1.weight>n2.weight){
            return 1;
        }
        return 0;
    }
}
