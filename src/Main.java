import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HangmanController hController = new HangmanController();
        hController.loadDatabase();
        hController.displayWelcomeMessage();
        
        while (hController.isRunningHangman()) {
            hController.initialiseGame(scanner);
            hController.runGame(scanner);
            hController.runPlayAgainSelector(scanner);
        }
        
        scanner.close();
    }
}
