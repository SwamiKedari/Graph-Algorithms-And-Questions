import java.util.*;
public class numberOfDistinctIslands {
    // in this question, we are asked to find the number of islands that are distinct from each other, that is the islands are not of same shape
    // I did this using the bfs traversal, storing the relative coordinates of the adjacent elements in each island and then storing it in an hashset so that we find the unique entries inside it
    // then we just need to return the hashset size at the end
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        // we will solve this problem using the hashset which will contain the shape of the matrix in the form relative coordinates that we get from the traversal
        // this can be achieved if we create the hashset of the arraylist of two numbers
        HashSet<ArrayList<ArrayList<Integer>>> set=new HashSet<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ArrayList<ArrayList<Integer>> arr=bfs(grid,i,j,n,m);
                    set.add(arr);
                }
            }
        }
        return set.size();
    }

    boolean isbounded(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }
        return false;
    }

    ArrayList<ArrayList<Integer>> bfs(int[][] grid,int i,int j,int n,int m){
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        grid[i][j]=-1;
        Queue<node> que=new LinkedList<>();
        que.add(new node(i,j));

        while(!que.isEmpty()){
            node k=que.remove();
            int x=k.x;
            int y=k.y;
            ArrayList<Integer> ar1=new ArrayList<>();
            ar1.add(x-i);
            ar1.add(y-j);
            arr.add(ar1);
            int[] xind={-1,1,0,0};
            int[] yind={0,0,1,-1};
            for(int g=0;g<4;g++){
                int x1=x+xind[g];
                int y1=y+yind[g];
                if(isbounded(x1,y1,n,m) && grid[x1][y1]==1){
                    que.add(new node(x1,y1));
                    grid[x1][y1]=-1;
                }
            }
        }
        return arr;
    }



}
