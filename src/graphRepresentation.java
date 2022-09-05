import java.util.ArrayList;
import java.util.*;

public class graphRepresentation {
    // the graph will be represented in the form of number of edges and vertices
    // in the case of a weighted graph , they will also give the weights
    // we can either store the graph in the matrix or in the adjacency list
    // for the higher memory usage , adjacency matrix is of no use as it will give memory limit exceed error
    // in the adjacency list , we use a arraylist of arraylist and store the elements in it
    // the every element at a particular index has the values of the elements connected to it in the arraylist which is also stored in a arraylist
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        for(int i=0;i<=n;i++){
            a.add(new ArrayList<>());
        }
        // add the elements in the following way
        a.get(0).add(2);
        a.get(1).add(3);
        // this means the vertex 0 is connected to the vertex 2 and the vertex 1 is connected to vertex 3
        // in the case of undirected graph , we write the add statements for both the vertices

        // in the case of the weighted graph , we store the pair inside the arraylists instead of the integers
        // the pairs will have the second vertex and the weights also


    }
}
