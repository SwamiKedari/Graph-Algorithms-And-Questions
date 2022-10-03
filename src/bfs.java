import java.util.*;
public class bfs {
    // bfs means traversing the adjacent nodes first while traversing
    // in this traversal , the adjacent nodes are traversed and then the adjacent nodes of the adjacent nodes are traversed and so on ...
    // this type of traversal looks like the lightning when we look clearly .

    /*
    the algorithm for the code is as follows :
    we will use the queue to store the adjacent elements , and when we visit the nodes , we mark the elements as visited and check each time whether the elements are visited or not .

     */
    public static void main(String[] swami){

        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        ArrayList<ArrayList<Integer>> a=new ArrayList<>(); // creating the graph
        for(int i=0;i<=n;i++){
            a.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            int b=s.nextInt();
            int c=s.nextInt();
            a.get(b).add(c);
            a.get(c).add(b);
        }

        // now we will do the bfs traversal and store it in a arrayList
        ArrayList<Integer> ar=new ArrayList<>();

        boolean[] visited=new boolean[n+1];

        for(int i=1;i<=n;i++){ // this for loop is for the non-connected components in the graph
            if(visited[i]==false){
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                visited[i]=true;
                while(!q.isEmpty()){
                    int k=q.remove();
                    ar.add(k);
                    for(int u : a.get(k)){ // traversing to all the adjacent elements from the given node and doing same for all the nodes
                        if(!visited[u]) {
                            visited[i] = true;
                            q.add(u);
                        }
                    }
                }
            }
        }

        System.out.println(ar);

    }
}
