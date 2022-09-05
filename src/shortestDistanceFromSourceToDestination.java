import java.util.*;     

public class shortestDistanceFromSourceToDestination {
    int shortestDistance(int n,int m,int[][] a,int x,int y) {
        // code here
        // we will use the bfs algorithm to solve this problem , we will keep on updating the distance of all the other nodes from the (0,0) and then we will reach the final node 
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        if(a[0][0]==0){
            return -1;
        }
        Queue<cell> que=new LinkedList<>();
        cell ori=new cell(0,0);
        dist[ori.x][ori.y]=0;
        que.add(ori);
        int x1=0 , y1=0;
        while(!que.isEmpty()){
            cell a1=que.remove();
            x1=a1.x;
            y1=a1.y;
            for(int i=0;i<4;i++){

                if(isbounded(x1+dx[i],y1+dy[i],n,m) && a[x1+dx[i]][y1+dy[i]]==1 && dist[x1+dx[i]][y1+dy[i]]> (dist[a1.x][a1.y]+1) ){
                    cell b=new cell(x1+dx[i],y1+dy[i]);
                    dist[b.x][b.y]=dist[a1.x][a1.y]+1;

                    que.add(b);
                }
            }
        }



        int k= dist[x][y];
        if(dist[x][y]==Integer.MAX_VALUE){
            return -1;
        }
        return k;

    }


    boolean isbounded(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }
        return false;
    }
};


