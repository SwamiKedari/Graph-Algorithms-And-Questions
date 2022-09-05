import java.util.*;

public class kruskalsAlgorithm {
    public static void main(String[] swami){

    }

    void kruskal(ArrayList<gNode> adj, int n){
        Collections.sort(adj,new sortComparator()); // sorting the array based on the sortComparator code in sortComparator class
        disjointSet set =new disjointSet();
        set.makeSet();
        int costMst=0;
        ArrayList<gNode> a1=new ArrayList<>();
        for(gNode a : adj){
            if(set.parent[a.u]!=set.parent[a.v]){
                a1.add(a);
                costMst+=a.weight;
                set.union(a.u,a.v);
            }
        }

        System.out.println(a1);
        System.out.println(costMst);

    }


}

class gNode{
    int u;
    int v;
    int weight;
    gNode(int u,int v,int weight){
        this.u=u;
        this.v=v;
        this.weight=weight;
    }


}

class sortComparator implements Comparator<gNode>{
    public int compare(gNode n1,gNode n2){
        if(n1.weight < n2.weight){
            return -1;
        }
        else if(n1.weight > n2.weight){
            return 1;
        }
        else {
            return 0;
        }
    }
}
