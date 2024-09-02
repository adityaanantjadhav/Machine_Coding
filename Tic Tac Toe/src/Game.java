public class Game {
    private static Game obj=null;

    private Game(){

    }

    public static Game startGame(){
        if(obj==null)
            obj=new Game();
        return obj;
    }

    public static GameBoard getTheBoard(){
        GameBoard obj=new GameBoard();
        return obj;
    }
}
