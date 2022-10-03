import java.util.*;
class minKnightMoves
{
    public static void main(String[] swami){
        int[] kn={6,1}; // this is the current position of the knight on the chess
        int[] dest={2,4}; // we need to find the minimum number of steps that are required to reach the destination position
        int n=7; // n is the size of the chess board
        System.out.println(minStepToReachTarget(kn,dest,n));
    }
    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
        // Code here
        // we have to find the minimum steps that a knight will take to reach the target position
        // we will use the n*n matrix and then we will find the minimum steps to go to the target position from the starting position
        int[][] distance=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        int[] xind={1,-1,2,-2,1,-1,2,-2};
        int[] yind={2,2,1,1,-2,-2,-1,-1};
        // this will be the indexes which can be added to the current index to determine the next index
        Queue<chessCell> que=new LinkedList<>();
        int k1=KnightPos[0];
        int k2=KnightPos[1];
        que.add(new chessCell(k1,k2));
        distance[k1][k2]=0;
        while(!que.isEmpty()){
            chessCell cell=que.remove();
            int h1=cell.x;
            int h2=cell.y;
            for(int i=0;i<8;i++){
                int t1=h1+xind[i];
                int t2=h2+yind[i];
                if(isbounded(t1,t2,n) && distance[t1][t2]>distance[h1][h2]+1){
                    distance[t1][t2]=distance[h1][h2]+1;
                    que.add(new chessCell(t1,t2));
                }
            }
        }
        int t1=TargetPos[0];
        int t2=TargetPos[1];
        if(distance[t1][t2]==Integer.MAX_VALUE){
            return -1;
        }
        return distance[t1][t2];
    }

    public static boolean isbounded(int i,int j,int n){
        if(i>=0 && i<n && j<n && j>=0){
            return true;
        }
        return false;
    }
}

class chessCell{
    int x;
    int y;
    chessCell(int x,int y){
        this.x=x;
        this.y=y;
    }
}
