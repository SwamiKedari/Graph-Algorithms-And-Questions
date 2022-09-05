import java.util.*;

public class bellmanFordAlgo {
    // the bellmanford algorithm works for the directed graph with both positive edges and negative edges
    // it only fails in the case of the negative cycles , ie the cycle which has the total weight sum equal to negative
    // In the undirected graph , the single edges are considered as the combination of the two edges
    // as the algorithm fails in the case of the negative cycle , it is used to detect the negative cycles in the graphs
    /*
    The algorithm for the bellman-ford is as follows :
    we relax the edges n-1 times where n is the total number of edges
    Doing this gives us the actual shortest distance from the node
    For knowing whether the graph contains a negative cycle or not , we perform this operation once more , if the distance still changes , it means that it contains a negative weight cycle and dont give the actual shortest distance in this case


    Relaxation over here means : if(dist[u] + weight < dist[v]) -> update dist[v] with the lhs
     */
    public static void main(String[] swami){

        ArrayList<gNode> arr=new ArrayList<>();
        arr.add(new gNode(0,1,5));
        arr.add(new gNode(1,2,-2));
        arr.add(new gNode(2,4,3));
        arr.add(new gNode(3,2,6));
        arr.add(new gNode(5,3,1));
        arr.add(new gNode(1,5,-3));
        arr.add(new gNode(3,4,-2));

        int[] distance=new int[6];
        Arrays.fill(distance,100000);

        distance[0]=0; // we can change the index to any other index which is the source

        for(int i=0;i<5;i++){
            for(gNode h : arr){
               // System.out.println(h.u+" "+h.v);
                if(distance[h.u]+h.weight<distance[h.v]){
                    distance[h.v]=distance[h.u]+h.weight;
                }
            }
        }

        System.out.println(Arrays.toString(distance));

        for(gNode h: arr){
            if(distance[h.u]+h.weight<distance[h.v]){
                System.out.println("Negative Cycle detected");
                break;
            }
        }


    }


}

