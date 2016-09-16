package ua.epam;

/**
 * Created by Viktoriia_Marynchak on 9/15/2016.
 */
public class View {
    public final String CONGRATULATIONS = "Congratulations!";
    public final String YOU_WON = "You won with ";
    public final String ATTEMPTS = " attempts";
    public final String SORRY = "Sorry.. It's a wrong number. Try again.";
    public final String PLEASE_FROM = "Please type a number in the range from ";
    public final String TO = " to ";
    public final String PREVIOUSLY = "You've entered this number previously.";
    public final String OUTSIDE_THE_RANGE = "You entered a number outside the range.";
    public final String INVALID_VALUE = "You entered an invalid value.";

    public void print(Object ... objects) {
        for ( Object i : objects ) {
            System.out.print(i);
        }

        System.out.println();
    }
}
