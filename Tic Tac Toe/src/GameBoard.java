public class GameBoard {
    protected char[][]board=new char[3][3];

    public GameBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]='0';
            }
        }
    }
    
    public boolean play(Player player,int i,int j){
        if(i>=3 || i<0 || j>=3 || j<0)
            throw new IllegalArgumentException();
            
        if(board[i][j]!='0')
            throw new IllegalArgumentException();

        else{
            board[i][j]=player.tickMark;

            boolean row=true,col=true,diag=true,diag2=true;

            for(int k=0;k<3;k++){
                if(board[i][k]!=player.tickMark)
                    row=false;
                if(board[k][j]!=player.tickMark)
                    col=false;
                if(board[k][k]!=player.tickMark)
                    diag=false;
                if(board[k][3-k-1]!=player.tickMark)
                    diag2=false;
            }
            boolean answer= row || col || diag ||diag2;
            return answer;
        }

    }

    public void showTheGame(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    
}