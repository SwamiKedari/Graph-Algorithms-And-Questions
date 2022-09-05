public class wordSearch {
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        // dfs algorithm should work to solve this problem
        // we will start the dfs from the point which has the first letter of the word
        int n=board.length;
        int m=board[0].length;
        boolean[][] visited=new boolean[n][m];
        int ind=0;
        boolean[] ans=new boolean[1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    matches(board,i,j,word,0,n,m,visited,ans);
                    if(ans[0]){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public void  matches(char[][] board,int i,int j,String word,int ind,int n,int m,boolean[][] visited,boolean[] ans){
        if(!visited[i][j]){
            visited[i][j]=true;
            if(ind+1==word.length()){
                ans[0]=true;
                return ;
            }

            if(isbounded(i-1,j,n,m) && board[i-1][j]==word.charAt(ind+1) && !visited[i-1][j]){
                matches(board,i-1,j,word,ind+1,n,m,visited,ans);
                if(ans[0]){
                    return;
                }
            }
            if(isbounded(i,j-1,n,m) && board[i][j-1]==word.charAt(ind+1) && !visited[i][j-1]){
                matches(board,i,j-1,word,ind+1,n,m,visited,ans);
                if(ans[0]){
                    return;
                }
            }
            if(isbounded(i+1,j,n,m) && board[i+1][j]==word.charAt(ind+1) && !visited[i+1][j]){
                matches(board,i+1,j,word,ind+1,n,m,visited,ans);
                if(ans[0]){
                    return;
                }
            }
            if(isbounded(i,j+1,n,m) && board[i][j+1]==word.charAt(ind+1) && !visited[i][j+1]){
                matches(board,i,j+1,word,ind+1,n,m,visited,ans);
                if(ans[0]){
                    return;
                }
            }
            visited[i][j]=false;


        }


    }


    public boolean isbounded(int i,int j,int n,int m){
        if(i<n && i>=0 && j<m && j>=0){
            return true;
        }
        return false;
    }
}
