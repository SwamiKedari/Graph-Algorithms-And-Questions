import java.util.*;
public class spideySense {
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        // Your code goes here
        // we have to find the distance of the impact for the bomb
        int[][] distance=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]=='B'){
                    bfs(mat,i,j,m,n,distance);
                }
                else if(mat[i][j]=='W'){
                    distance[i][j]=-1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(distance[i][j]==Integer.MAX_VALUE){
                    distance[i][j]=-1;
                }
            }
        }
        return distance;


    }
    public static void bfs(char[][] mat,int i,int j,int m,int n,int[][] distance){
        Queue<node> que=new LinkedList<>();
        distance[i][j]=0;
        que.add(new node(i,j));
        while(!que.isEmpty()){
            node k=que.remove();
            int x=k.x;
            int y=k.y;
            int[] xind={-1,1,0,0};
            int[] yind={0,0,-1,1};
            for(int ind=0;ind<4;ind++){
                int x1=x+xind[ind];
                int y1=y+yind[ind];
                if(isbounded(x1,y1,m,n) && mat[x1][y1]=='O' && distance[x1][y1]>distance[x][y]+Math.abs(x1-x)+Math.abs(y1-y)){
                    distance[x1][y1]=distance[x][y]+Math.abs(x1-x)+Math.abs(y1-y);
                    que.add(new node(x1,y1));
                }
            }
        }
    }

    public static boolean isbounded(int i,int j,int m,int n){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }



}
