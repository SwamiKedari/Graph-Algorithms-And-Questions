public class isPathPossible {
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        // we will use the dfs type of algorithm to solve this problem
        // we will start from the node with the value equal to 1 and then do the dfs traversal to 2
        // we will keep a boolean matrix which will have the values of the visited nodes
        // since in one dfs , all the adjacent nodes with value 3 will be covered , we have no reoson to travel the same part again using some other node
        int sx=-1 , sy=-1 ;
        int dx=-1 , dy=-1;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    sx=i;
                    sy=j;
                }
                else if(grid[i][j]==2){
                    dx=i;
                    dy=j;
                }
            }
        }



        boolean[][] visited=new boolean[n][m];

        boolean[] value=new boolean[1];

        dfs(grid,visited,sx,sy,n,m,dx,dy,value);

        return value[0];



        //return ans;
    }

    public void dfs(int[][] grid,boolean[][] visited,int i,int j,int n,int m,int d1,int d2,boolean[] val){
        if(!visited[i][j] && isbounded(i,j,n,m)){
            visited[i][j]=true;
            if((i-1==d1 && j==d2) || (i+1==d1 && j==d2) || (i==d1 && j-1==d2) || (i==d1 && j+1==d2)){
                val[0]=true;
            }
            if(isbounded(i-1,j,n,m) && grid[i-1][j]==3){
                dfs(grid,visited,i-1,j,n,m,d1,d2,val);
                if(val[0]){

                    return;
                }
            }
            if(isbounded(i+1,j,n,m) && grid[i+1][j]==3){
                dfs(grid,visited,i+1,j,n,m,d1,d2,val);
                if(val[0]){

                    return;
                }
            }
            if(isbounded(i,j-1,n,m) && grid[i][j-1]==3){
                dfs(grid,visited,i,j-1,n,m,d1,d2,val);
                if(val[0]){

                    return;
                }
            }
            if(isbounded(i,j+1,n,m) && grid[i][j+1]==3){
                dfs(grid,visited,i,j+1,n,m,d1,d2,val);
                if(val[0]){

                    return;
                }
            }


        }

    }

    public boolean isbounded(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }
        return false;
    }
}
