package ua.epam;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();

        while (!controller.getWin()) {
            controller.play();
        }

    }
}
