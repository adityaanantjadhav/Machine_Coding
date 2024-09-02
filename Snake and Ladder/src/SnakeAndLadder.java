import java.util.HashMap;
import java.util.Queue;

public class SnakeAndLadder {
    private HashMap<Player,Integer> playerPosition;
    private Board board;
    Queue<Player> nextPlayers;
    
    public SnakeAndLadder(Board board,Queue<Player>nextPlayers){
        playerPosition=new HashMap<>();
        this.board=board;
        this.nextPlayers=nextPlayers;
    }

    public void startTheGame(){
        Dice dice=Dice.getDice(2);
        while(nextPlayers.size()>=1){
            Player currPlayer=nextPlayers.poll();
            int diceValue=dice.rollDice();

            if(!playerPosition.containsKey(currPlayer))
                playerPosition.put(currPlayer, 0);

            int steps=diceValue+playerPosition.get(currPlayer);

            if(steps==board.boardSize){
                System.out.println(currPlayer.getName()+" has completed the game.");
                playerPosition.put(currPlayer,board.boardSize);
            }
            else if(steps>board.boardSize){
                System.out.println("You are close to win! Better luck next time.");
                nextPlayers.offer(currPlayer);
            }
            else{
                steps=board.checkSnakeOrLadder(steps);
                if(steps==board.boardSize){
                    System.out.println(currPlayer.getName()+" has completed the game.");
                }
                else{
                    nextPlayers.offer(currPlayer);
                    System.out.println(currPlayer.getName()+" you are at position:"+steps);
                }
                playerPosition.put(currPlayer,steps);
            }
        }
    }

    

}
