public class rottingOranges {
    //Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid)
    {
        // Code here
        // we will use the bfs algorithm to solve this problem
        // we will keep a new matrix which will have the time of the rotting for each language
        // shift all the twos in the matrix to -1
        // this will help us to keep a track of the nodes
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    grid[i][j]=-1;
                }
                else if(grid[i][j]==1){
                    grid[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==-1){
                    dfs(grid,i,j,0,n,m);
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>max){
                    max=grid[i][j];
                }
            }
        }


        //System.out.println(Arrays.toString(grid[0]));
        if(max==Integer.MAX_VALUE){
            return -1;
        }


        return max;
    }



    public void dfs(int[][] grid,int i,int j,int d,int n,int m){
        if(isbounded(i-1,j,n,m) && grid[i-1][j]>0 && grid[i-1][j]>d+1){
            grid[i-1][j]=d+1;
            dfs(grid,i-1,j,d+1,n,m);
        }
        if(isbounded(i,j-1,n,m) && grid[i][j-1]>0 && grid[i][j-1]>d+1){
            grid[i][j-1]=d+1;
            dfs(grid,i,j-1,d+1,n,m);
        }
        if(isbounded(i+1,j,n,m) && grid[i+1][j]>0 && grid[i+1][j]>d+1){
            grid[i+1][j]=d+1;
            dfs(grid,i+1,j,d+1,n,m);
        }
        if(isbounded(i,j+1,n,m) && grid[i][j+1]>0 && grid[i][j+1]>d+1){
            grid[i][j+1]=d+1;
            dfs(grid,i,j+1,d+1,n,m);
        }
    }

    public boolean isbounded(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }

        return false;

    }
}
