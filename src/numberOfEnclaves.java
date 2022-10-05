import java.util.*;
public class numberOfEnclaves {
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        // we have to count the number of lands that are enclosed completely inside the water using the bfs traversal
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int[] size=new int[1];

                    boolean istrue=isEnclave(grid,i,j,n,m,size);

                    if(istrue){
                        count+=size[0];

                    }
                }
            }
        }
        return count;
    }

    public boolean isEnclave(int[][] grid,int i,int j,int n,int m,int[] size){
        Queue<node> que=new LinkedList<>();
        boolean isNotEnd=true;
        grid[i][j]=-1;
        if(isNotInside(i,j,n,m)){
            isNotEnd=false;
        }
        que.add(new node(i,j));
        size[0]++;
        while(!que.isEmpty()){
            node k =que.remove();
            int x=k.x;
            int y=k.y;
            int[] xind={-1,1,0,0};
            int[] yind={0,0,-1,1};
            for(int i1=0;i1<4;i1++){
                int x1=x+xind[i1];
                int y1=y+yind[i1];
                if(isBounded(x1,y1,n,m) && grid[x1][y1]==1){
                    grid[x1][y1]=-1;
                    if(isNotInside(x1,y1,n,m)){
                        isNotEnd=false;
                    }
                    que.add(new node(x1,y1));
                    size[0]++;
                }
            }
        }
        return isNotEnd;
    }
    public boolean isNotInside(int i,int j,int n,int m){
        if(i==0 || i==n-1 || j==0 || j==m-1){
            return true;
        }
        return false;
    }
    public boolean isBounded(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }
        return false;
    }




}
