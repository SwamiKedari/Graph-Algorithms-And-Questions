public class covidSpread {
    public int helpaterp(int[][] h) {
        // code here
        // this question is similar to the rotten oranges problem , just the case has changed to covid
        int n=h.length;
        int m=h[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(h[i][j]==1){
                    h[i][j]=Integer.MAX_VALUE;
                }
                else if(h[i][j]==2){
                    h[i][j]=-1;
                }
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(h[i][j]==-1){
                    dfs(h,i,j,n,m,0);
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(h[i][j]>max){
                    max=h[i][j];
                }
            }
        }

        if(max==Integer.MAX_VALUE || max==-1){
            return -1;
        }
        return max;


    }
    public void dfs(int[][] h,int i,int j,int n,int m,int dis){
        if(isbound(i-1,j,n,m) && dis+1 < h[i-1][j] && h[i-1][j]>0){
            h[i-1][j]=dis+1;
            dfs(h,i-1,j,n,m,h[i-1][j]);
        }
        if(isbound(i,j-1,n,m) && dis+1 < h[i][j-1] && h[i][j-1]>0){
            h[i][j-1]=dis+1;
            dfs(h,i,j-1,n,m,h[i][j-1]);
        }
        if(isbound(i+1,j,n,m) && dis+1 < h[i+1][j] && h[i+1][j]>0){
            h[i+1][j]=dis+1;
            dfs(h,i+1,j,n,m,h[i+1][j]);
        }
        if(isbound(i,j+1,n,m) && dis+1 < h[i][j+1] && h[i][j+1]>0){
            h[i][j+1]=dis+1;
            dfs(h,i,j+1,n,m,h[i][j+1]);
        }
    }

    public boolean isbound(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }
        return false;
    }
}
