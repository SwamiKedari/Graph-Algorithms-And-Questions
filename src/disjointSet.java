public class disjointSet {
    // we will implement the disjoint set data structure over here
    // we will use the rank array and the parent array for storing the parent and the rank of a particular node
    int[] parent = new int[10000]; // we can check whether 2 nodes belong to the same component or the different components , as the parent of the each node in the single component will always be the same
    int[] rank=new int[10000];
    void makeSet(){
        for(int i=0;i<10000;i++){
            parent[i]=i;
        }
    }
    int findParent(int i){
        if(i==parent[i]){
            return i;
        }
        else{
            parent[i]= findParent(parent[i]); // we are using this line to compress the path and directly connect the child nodes to the parent
            return parent[i];
        }
    }

    void union(int u,int v){
        u=parent[u];
        v=parent[v];
        if(rank[u] < rank[v]){
            parent[u]=v;
        }
        else if(rank[u] > rank[v]){
            parent[v]=u;
        }
        else{
            parent[u]=v;
            rank[u]++;
        }
    }
}
