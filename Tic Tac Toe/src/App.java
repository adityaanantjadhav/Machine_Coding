import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String continu="no";
        Scanner sc=new Scanner(System.in);

        do{
            GameBoard gameBoard=Game.getTheBoard();
            System.out.println("Enter Player 1 name::");
            String player1Name=sc.nextLine();
            System.out.println("Enter Player 1 tickmark (Note it should not be 0)::");
            char player1Tick=sc.nextLine().charAt(0);
            if(player1Tick=='0'){
                System.out.println("Wrong input XX");
                continue;
            }
            Player p1=new Player(player1Name, player1Tick);
            
            System.out.println("Enter Player 2 name::");
            String player2Name=sc.nextLine();
            System.out.println("Enter Player 2 tickmark (Note it should not be 0 || "+player1Tick+" )::");
            char player2Tick=sc.nextLine().charAt(0);
            if(player1Tick=='0' || player2Tick==player1Tick){
                System.out.println("Wrong input XX");
                continue;
            }
            Player p2=new Player(player2Name, player2Tick);

            boolean endOfGame=false;
            Player currentPlayer=p1;
            int moves=0;
            Scanner st=new Scanner(System.in);

            while(!endOfGame && moves<9){
                System.out.println("Enter you move::");
                System.out.print("row::");
                int i=st.nextInt();
                System.out.print("col::");
                int j=st.nextInt();
                try{
                    endOfGame=gameBoard.play(currentPlayer,i,j);
                }
                catch(Exception exception){
                    System.out.println(exception);
                    continue;
                }
                moves++;
                currentPlayer=currentPlayer==p1?p2:p1;
                gameBoard.showTheGame();
            }
            currentPlayer=currentPlayer==p1?p2:p1;
            if(endOfGame){
                System.out.println("Winner is:"+currentPlayer.playerName);
            }
            else{
                System.out.println("Its a draw");
            }
            System.out.println("Do you want to continue::");
            continu=sc.nextLine();
        }while(continu.charAt(0)=='y'||continu.charAt(0)=='Y');
    }
}
