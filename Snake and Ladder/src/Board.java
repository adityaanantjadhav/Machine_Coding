import java.util.HashMap;


public class Board {
    int boardSize;
    HashMap<Integer,Integer> snakes;
    HashMap<Integer,Integer> ladders;

    public Board(int boardSize){
        this.boardSize=boardSize;
        snakes=new HashMap<>();
        ladders=new HashMap<>();
    }

    public void addSnake(int head,int tail){
        if(!validatePosition(head, tail)){
            System.out.println("Invalid position entered...");
            return;
        }
        if(snakes.containsKey(head) || ladders.containsKey(head)){
            System.out.println("This position already has a snake or ladder");
            return ;
        }
        snakes.put(head, tail);
        System.out.println("Snake successfully added at:"+head);
    }

    public void addLadder(int bottom,int top){
        if(!validatePosition(top, bottom)){
            System.out.println("Invalid position entered...");
            return;
        }
        if(snakes.containsKey(bottom) || ladders.containsKey(bottom)){
            System.out.println("This position already has a snake or ladder");
            return ;
        }
        ladders.put(bottom, top);
        System.out.println("Ladder successfully added at:"+bottom);
    }

    private boolean validatePosition(int top,int bottom){
        if(top>0 && bottom>0 && top<boardSize+1 && bottom<boardSize){
            if(top>bottom){
                return true;
            }
        }
        return false;
    }

    public int checkSnakeOrLadder(int position){
        boolean isLadder=true;
        while(isLadder){
            isLadder=false;
            if(snakes.containsKey(position)){
                System.out.println("Oh no! its a snake.");
                position=snakes.get(position);
            }
            if (ladders.containsKey(position)) {
                System.out.println("Oh yeh! its a ladder.");
                position=ladders.get(position);
                isLadder=true;
            }
        }
        return position;
    }

}