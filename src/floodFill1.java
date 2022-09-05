public class floodFill1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here
        // make the visited array , then do the dfs traversal from the source and change all the connected nodes which have the same color
        int n=image.length;
        int m=image[0].length;
        boolean[][] visited=new boolean[n][m];
        dfs(image,sr,sc,visited,image[sr][sc],newColor,n,m);
        return image;
    }

    public void dfs(int[][] im,int i,int j,boolean[][] visited,int col, int newColor,int n,int m){
        if(!visited[i][j]){
            im[i][j]=newColor;
            visited[i][j]=true;
            if(isbounded(i-1,j,n,m) && im[i-1][j]==col){
                dfs(im,i-1,j,visited,col,newColor,n,m);
            }
            if(isbounded(i,j-1,n,m) && im[i][j-1]==col){
                dfs(im,i,j-1,visited,col,newColor,n,m);
            }
            if(isbounded(i+1,j,n,m) && im[i+1][j]==col){
                dfs(im,i+1,j,visited,col,newColor,n,m);
            }
            if(isbounded(i,j+1,n,m) && im[i][j+1]==col){
                dfs(im,i,j+1,visited,col,newColor,n,m);
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
