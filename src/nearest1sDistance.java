import java.util.*;

public class nearest1sDistance {
    public int[][] nearest(int[][] grid)
    {
        // Code here
        // we have to do an bfs from the 1s in the graph and then we will have to keep updating the distance accordingly
        // we will use a queue to store the nodes inside the graph and then we will use this queue to find the better distances from the nodes
        int n=grid.length;
        int m=grid[0].length;
        int[][] distance=new int[n][m];

        Queue<node> a=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=100000000;
                if(grid[i][j]==1){
                    a.add(new node(i,j));
                    distance[i][j]=0;
                }
            }
        }

        while(!a.isEmpty()){
            node b=a.remove();
            int x=b.x;
            int y=b.y;
            int[] xind={-1,0,1,0,1,-1,1,-1};
            int[] yind={0,-1,0,1,1,-1,-1,1};
            for(int i1=0;i1<8;i1++){
                if(isbounded(x+xind[i1],y+yind[i1],n,m) && grid[x+xind[i1]][y+yind[i1]]==0 && distance[x+xind[i1]][y+yind[i1]]>distance[x][y]+Math.abs(xind[i1])+Math.abs(yind[i1])){
                    distance[x+xind[i1]][y+yind[i1]]=distance[x][y]+Math.abs(xind[i1])+Math.abs(yind[i1]);
                    int k=distance[x+xind[i1]][y+yind[i1]];
                    node c=new node(x+xind[i1],y+yind[i1]);
                    a.add(c);
                }
            }
        }



        return distance;
    }

    public boolean isbounded(int x,int y,int n,int m){
        if(x>=0 && x<n && y>=0 && y<m){
            return true;
        }
        return false;
    }
}

class node{
    int x;
    int y;

    public node(int x,int y){
        this.x=x;
        this.y=y;

    }
}
