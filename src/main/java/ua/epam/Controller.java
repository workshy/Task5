package ua.epam;

import java.util.Scanner;

/**
 * Created by Viktoriia_Marynchak on 9/15/2016.
 */
public class Controller {
    private boolean win;
    int insertNumber;
    Model model;
    View view;
    Scanner scanner;

    public Controller() {
        win = false;
        insertNumber = 0;
        model = new Model();
        view = new View();
        scanner = new Scanner(System.in);
    }

    public boolean getWin() {return  win;}

    private boolean checkNumber(int insertNumber) {
        if ( insertNumber < model.getLeftRange() || insertNumber >  model.getRightRange() ) {
            return false;
        }

        return true;
    }

    private int scanNumber(){
        if ( scanner.hasNextInt()) {
            insertNumber = scanner.nextInt();
            if (checkNumber(insertNumber)) {
                return insertNumber;
            } else {
                view.print(view.OUTSIDE_THE_RANGE);
                view.print(view.PLEASE_FROM, model.getLeftRange(), view.TO, model.getRightRange());
                scanNumber();
            }
        } else {
            view.print(view.INVALID_VALUE);
            view.print(view.PLEASE_FROM, model.getLeftRange(), view.TO, model.getRightRange());
            scanner.next();
            scanNumber();
        }

        return insertNumber;
    }

    private boolean checkInsert(int insertNumber){
        for (int i = 0; i < model.attempts.size(); i++) {
            if (insertNumber == model.attempts.get(i)) {
                view.print(view.PREVIOUSLY);
                //view.print(view.PLEASE_FROM, model.getLeftRange(), view.TO, model.getRightRange());
                return false;
            }
        }

        model.attempts.add(insertNumber);
        model.changeRange(insertNumber, model.getLeftRange(), model.getRightRange());

        return true;
    }

    public void play() {
        view.print(view.PLEASE_FROM, model.getLeftRange(), view.TO, model.getRightRange());

        insertNumber = scanNumber();

        if ( checkInsert(insertNumber) ){
            if (model.isWon(insertNumber)) {
                view.print(view.CONGRATULATIONS);
                view.print(view.YOU_WON, model.attempts.size(), view.ATTEMPTS);
                win = true;
                return;
            }
            view.print(view.SORRY);
        }
    }
}
