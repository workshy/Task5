package ua.epam;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Viktoriia_Marynchak on 9/15/2016.
 */
class FinalVariables {
    public static final int MIN = 0;
    public static final int MAX = 100;
}


public class Model {
    private int leftRange;
    private int rightRange;
    private int number;
    ArrayList<Integer> attempts;

    public Model(){
        leftRange = FinalVariables.MIN;
        rightRange = FinalVariables.MAX;
        number = rand(leftRange, rightRange);
        attempts = new ArrayList<Integer>();
    }

    public int getLeftRange() {return leftRange;}
    public int getRightRange(){return rightRange;}
    public int getNumber() {return number;}

    protected void setNumber(int value) {number = value;}

    protected int rand(int leftRange, int rightRange) {
        Random random = new Random();
        int number = random.nextInt(rightRange - leftRange) + leftRange;

        return number;
    }

    public boolean isWon(int insertNumber){
        if ( insertNumber == number ) {
            return  true;
        }

        return false;
    }

    public void changeRange(int insertNumber, int leftRange, int rightRange) {
        if (insertNumber > leftRange && insertNumber < rightRange) {
            if (insertNumber > this.number ) {
                this.rightRange = insertNumber;
            } else if (insertNumber < this.number) {
                this.leftRange = insertNumber;
            }
        }
    }
}
