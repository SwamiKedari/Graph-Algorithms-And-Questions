import java.util.*;
public class replaceOsWithXs {
    // we have to replace the Os in the matrix with Xs if the Os are enclosed and are not outside
    // we do the bfs traversal and check if the value of O reaches the outside boundary of the matrix
    // if it reaches the outside boundary then we say that the region should not be replaced with Xs else it should be replaced
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        // we have to replace the o's with x if the o's are not at the border
        // one way to do this is to do the bfs first and then see if the answer of this bfs is true or not and if it gives true then we will replace this section with x else we will not
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='O'){
                    boolean in=isInside(a,i,j,n,m);
                    if(in){
                        bfs(a,i,j,'X',n,m);
                    }


                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='v'){
                    a[i][j]='O';
                }
            }
        }

        return a;
    }

    static boolean isInside(char[][] a,int i,int j,int n,int m){
        Queue<node> que=new LinkedList<>();
        que.add(new node(i,j));
        a[i][j]='v';
        boolean isNotEnd=true;
        if(isend(i,j,n,m)){
            isNotEnd=false;
        }
        while(!que.isEmpty()){
            node b=que.remove();
            int[] xind={-1,1,0,0};
            int[] yind={0,0,-1,1};
            int x=b.x;
            int y=b.y;
            for(int i1=0;i1<4;i1++){
                int x1=x+xind[i1];
                int y1=y+yind[i1];


                if(isbounded(x1,y1,n,m) && a[x1][y1]=='O'){
                    if(isend(x1,y1,n,m)){
                        isNotEnd=false;
                    }
                    a[x1][y1]='v';
                    que.add(new node(x1,y1));
                }
            }
        }
        return isNotEnd;
    }

    static boolean isbounded(int x,int y,int n,int m){
        if(x>=0 && x<n && y>=0 && y<m){
            return true;
        }
        return false;
    }
    static void bfs(char[][] a,int i,int j,char ch,int n,int m){
        Queue<node> que=new LinkedList<>();
        que.add(new node(i,j));
        a[i][j]=ch;

        while(!que.isEmpty()){
            node b=que.remove();
            int[] xind={-1,1,0,0};
            int[] yind={0,0,-1,1};
            int x=b.x;
            int y=b.y;
            for(int i1=0;i1<4;i1++){
                int x1=x+xind[i1];
                int y1=y+yind[i1];


                if(isbounded(x1,y1,n,m) && a[x1][y1]=='v'){
                    a[x1][y1]=ch;
                    que.add(new node(x1,y1));
                }
            }
        }

    }

    static boolean isend(int i,int j,int n,int m){
        if(i==0 || i==n-1 || j==0 || j==m-1){
            return true;
        }
        return false;
    }



}
