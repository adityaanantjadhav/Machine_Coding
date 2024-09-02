public class Dice {
    private int numberOfDice;
    private static Dice objDice=null;

    private Dice(){

    }
    public static Dice getDice(int numberOfDice){
        if(objDice==null)
            objDice=new Dice();
        objDice.numberOfDice=numberOfDice;
        return objDice;
    }
    public int rollDice(){
        return (int)(Math.random()*(6*numberOfDice-1*numberOfDice))+1;
    }
}
