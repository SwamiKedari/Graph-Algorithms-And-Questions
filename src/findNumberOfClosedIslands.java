import java.util.*;
public class findNumberOfClosedIslands {
    public int closedIslands(int[][] a,int n,int m)
    {
        // Code here
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==1){
                    boolean ist=isInside(a,i,j,n,m);
                    if(ist){
                        count++;
                    }
                }
            }
        }
        return count;

    }

    public boolean isInside(int i,int j,int n,int m){
        if(i==0 || j==0 || i==n-1 || j==m-1){
            return false;
        }
        return true;
    }

    public boolean isBounded(int i,int j,int n,int m){
        if(i<n && i>=0 && j<m && j>=0){
            return true;
        }
        return false;
    }

    public boolean isInside(int[][] a,int i,int j,int n,int m){
        Queue<node> b=new LinkedList<>();
        b.add(new node(i,j));
        boolean isNotEnd=true;
        a[i][j]=-1;
        if(!isInside(i,j,n,m)){
            isNotEnd=false;
        }
        while(!b.isEmpty()){
            node k=b.remove();
            int x=k.x;
            int y=k.y;
            int[] xind={-1,1,0,0};
            int[] yind={0,0,1,-1};
            for(int h=0;h<4;h++){
                int x1=x+xind[h];
                int y1=y+yind[h];
                if(isBounded(x1,y1,n,m) && a[x1][y1]==1){
                    b.add(new node(x1,y1));
                    if(!isInside(x1,y1,n,m)){
                        isNotEnd=false;
                    }
                    a[x1][y1]=-1;
                }
            }

        }
        return isNotEnd;
    }




}
