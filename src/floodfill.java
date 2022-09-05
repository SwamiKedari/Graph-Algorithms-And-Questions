import java.util.*;
public class floodfill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // we will perform the bfs technique to solve this problem
        // from the start we will move 4 directionlly to all the neighbouring cells
        // from this cells , we move to all the neighbouring cells of that cell
        // we mark this cells with the color
        int n=image.length;
        int m=image[0].length;
        boolean[][] visited=new boolean[n][m];
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int id=image[sr][sc];
        Queue<cell> que=new LinkedList<>();
        que.add(new cell(sr,sc));
        visited[sr][sc]=true;
        image[sr][sc]=color;
        int x=0 , y=0;
        while(!que.isEmpty()){
            cell a=que.remove();
            for(int i=0;i<4;i++){
                x=a.x+dx[i];
                y=a.y+dy[i];
                if( isbounded(x,y,n,m) && image[x][y]==id && !visited[x][y]){
                    que.add(new cell(x,y));
                    visited[x][y]=true;
                    image[x][y]=color;
                }
            }
        }

        return image;

    }

    public boolean isbounded(int x,int y,int n,int m){
        if(x<n && x>=0 && y<m && y>=0){
            return true;
        }
        return false;
    }


}

class cell{
    int x;
    int y;
    cell(int x,int y){
        this.x=x;
        this.y=y;
    }
}

