import java.util.*;
public class shortestDistanceInUndirectedGraph {
    // when the weights of the graph are not given , we consider the weights of the graph as 1 ie we consider unit weights for such an graph
    // we have to find the shortest distance from the source to the other nodes , here we have to find the shortest distance from zero to other nodes
    // we will use the bfs algorithm to solve this problem
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        int n=s.nextInt();
        boolean[] visited=new boolean[n+1]; // we have put the condition for checking the minimum distance from the source which will be used to avoid adding the previously visited nodes in the queue again

        int[] distance=new int[n+1];

        int m=s.nextInt();
        for(int i=0;i<m;i++){
            int sc=s.nextInt();
            int de=s.nextInt();
            arr.get(sc).add(de);
        }
        Arrays.fill(distance,Integer.MAX_VALUE);

        Queue<Integer> que=new LinkedList<>();
        que.add(1);
        distance[1]=0;
        while(!que.isEmpty()){
            int k=que.remove();
            for(int i : arr.get(k)){
                if(distance[k]+1 < distance[i]){
                    que.add(i); // for updating the distances which are ahead from this index
                    distance[i]=distance[k]+1;
                }
            }
        }

        // the distance array will store the shortest distances from the source nodes for every node

        System.out.println(Arrays.toString(distance));



    }

}
