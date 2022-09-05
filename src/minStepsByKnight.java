import java.util.*;
public class minStepsByKnight {
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
        // Code here
        // we will do the bfs traversal to solve this problem
        // from the current knights position , we will check in all the 8 directions where the knight can go
        // if the position that we get on the bfs traversal is equal to the target value , we will print the distance of the target value from the knights position

        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

        boolean[][] visited=new boolean[n+1][n+1];

        Queue<cellwithdist> que=new LinkedList<>();
        que.add(new cellwithdist(KnightPos[0],KnightPos[1],0));
        visited[KnightPos[0]][KnightPos[1]]=true;
        int x=0;
        int y=0;
        int z=0;
        int w=0;
        int dist=0;
        while(!que.isEmpty()){
            cellwithdist a=que.remove();
            x=a.r;
            y=a.c;
            dist=a.distance;
            if(x==TargetPos[0] && y==TargetPos[1]){
                return a.distance;
            }
            for(int i=0;i<8;i++){
                z=x+dx[i];
                w=y+dy[i];

                if(isbounded(z,w,n) && !visited[z][w]){
                    visited[z][w]=true;

                    cellwithdist b=new cellwithdist(z,w,a.distance+1);

                    que.add(b);
                }
            }
        }

        return Integer.MAX_VALUE;
    }


    public boolean isbounded(int x, int y, int n){
        if(x>=1 && x<=n && y>=1 && y<=n){
            return true;
        }
        return false;
    }
}


class cellwithdist{
    int r;
    int c;
    int distance;
    cellwithdist(int r,int c,int dist){
        this.r=r;
        this.c=c;
        this.distance=dist;
    }
}
