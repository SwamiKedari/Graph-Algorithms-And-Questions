import java.util.*;
public class dijkstrasAlgorithm {
    // this algorithm help us to find the shortest distance between the source and the destination nodes
    // the previous algorithm for finding the shortest distance will not work in this case as the edge weights are not unit in this case and all have different edge weights
    // the algorithm is as follows :
    /*
    use a priority queue to store the nodes along with their distances from the source
    then use the array which has the all the values assigned equal to infinity and then update the distance from the source when u get a better minimum distance
    then store the distance along with the node in the priority queue
    the priority queue is used to get the shortest distance always from the priority queue and not any other distance from the same node which has the larger value

     */

    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=5;
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<graphNode> que=new PriorityQueue<>(n,new graphNode());
        ArrayList<ArrayList<graphNode>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<graphNode>());
        }

        adj.get(0).add(new graphNode(1,2));
        adj.get(1).add(new graphNode(0,2));

        adj.get(2).add(new graphNode(2,4));
        adj.get(1).add(new graphNode(1,4));

        adj.get(0).add(new graphNode(3,1));
        adj.get(3).add(new graphNode(0,1));

        adj.get(3).add(new graphNode(2,3));
        adj.get(2).add(new graphNode(3,3));


        adj.get(1).add(new graphNode(4,5));
        adj.get(4).add(new graphNode(1,5));

        que.add(new graphNode(0,0));
        dist[0]=0;

        while(que.size() > 0){
            graphNode a=que.remove();
            for(graphNode it : adj.get(a.vertice)){
                if(dist[a.vertice]+it.weight < dist[it.vertice]){
                    dist[it.vertice]=dist[a.vertice]+it.weight;
                    que.add(new graphNode(it.vertice,dist[it.vertice]));
                }
            }
        }


        System.out.println(Arrays.toString(dist));


    }



}


class graphNode implements Comparator<graphNode>{
    int weight;
    int vertice;

    graphNode(int vertice , int weight){
        this.weight=weight;
        this.vertice=vertice;
    }

    graphNode(){

    }
    public int compare(graphNode n1, graphNode n2){
        if(n1.weight < n2.weight){
            return -1;
        }
        else if(n1.weight > n2.weight){
            return 1;
        }
        return 0;
    }


}
