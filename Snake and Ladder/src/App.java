import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Player player1=new Player("Aditya", 1);
        Player player2=new Player("kunal",2);
        
        Queue<Player> nextPlayers=new LinkedList<>();
        nextPlayers.add(player1);
        nextPlayers.add(player2);

        Board board=new Board(100);

        board.addLadder(3, 93);
        board.addLadder(10, 50);
        board.addLadder(25, 70);
        board.addLadder(75, 100);

        board.addSnake(45, 2);
        board.addSnake(99, 2);
        board.addSnake(23, 2);
        board.addSnake(55, 45);

        SnakeAndLadder obj=new SnakeAndLadder(board, nextPlayers);
        obj.startTheGame();
    }
}
