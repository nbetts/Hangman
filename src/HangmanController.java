import java.util.Scanner;

public class HangmanController {
    private DatabaseController dbController;
    private Word.DIFFICULTY selectedDifficulty;
    private boolean isRunningHangman;

    public Hangman hangman;

    public HangmanController() {
        this.dbController = new DatabaseController();
        this.selectedDifficulty = null;
        this.isRunningHangman = true;
        this.hangman = null;
    }
    
    public boolean isRunningHangman() {
        return this.isRunningHangman;
    }

    public void loadDatabase() {
        dbController.loadWords();
    }
    
    public void displayWelcomeMessage() {
        System.out.println("Welcome to the game of Hangman!\n" +
                           " _   _                                         \n" + 
                           "| | | |                                        \n" + 
                           "| |_| | __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" + 
                           "|  _  |/ _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" + 
                           "| | | | (_| | | | | (_| | | | | | | (_| | | | |\n" + 
                           "\\_| |_/\\____|_| |_|\\___ |_| |_| |_|\\____|_| |_|\n" + 
                           "  _______           __/ |                      \n" + 
                           "   |   |           |___/                       \n" +
                           "   |   O  \n" + 
                           "   |  /|\\\n" + 
                           "   |  / \\\n" + 
                           " __|____  \n" + 
                           " |     |  \n");
    }
    
    public void initialiseGame(Scanner scanner) {
        selectedDifficulty = null;
        String selectedWord = null;
        
        System.out.println("Please select a difficulty level:\n" +
                           " Easy = 1\n" +
                           " Medium = 2\n" +
                           " Hard = 3\n");
        
        while(selectedDifficulty == null) {
            String line = new String();
            
            while (line.length() == 0) {
                System.out.print("> ");
                line = scanner.nextLine().replaceAll("[^123]", "");
            }
            
            try {
                int difficulty = Integer.parseInt(line);
                
                switch (difficulty) {
                    case 1:
                        selectedDifficulty = Word.DIFFICULTY.EASY;
                        break;
                    case 2:
                        selectedDifficulty = Word.DIFFICULTY.MEDIUM;
                        break;
                    case 3:
                        selectedDifficulty = Word.DIFFICULTY.HARD;
                        break;
                    default:
                        continue;
                }
                
                selectedWord = dbController.getRandomWord(selectedDifficulty);
                
                if (selectedWord == null || selectedWord.isEmpty()) {
                    System.out.println("There aren't any words in this level.");
                    System.out.println("Please select another difficulty level.");
                } else {
                    hangman = new Hangman(selectedWord);
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
    
    public void runGame(Scanner scanner) {
        System.out.println("Try to guess the following word:");
        System.out.println(hangman.getPrettyPrintHangmanWord());
        
        while(!hangman.isSolved()) {
            String line = new String();
            
            while (line.length() == 0) {
                System.out.print("> ");
                line = scanner.nextLine().replaceAll("[^a-zA-Z]", "");
            }
            
            char guessedLetter = line.charAt(0);
            boolean isLetterWrong = false;
            System.out.println();
            
            if (hangman.isLetterAlreadyGuessed(guessedLetter)) {
                System.out.println("Oops! You've already guessed that letter.");
            } else {
                if (hangman.guessLetter(guessedLetter)) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Oops! Try again.");
                    isLetterWrong = true;
                }
            }
            
            System.out.println("Guessed letters: " + hangman.getPrettyPrintGuessedLetters());
            
            if (isLetterWrong) {
                hangman.gallows.buildGallows();
            }

            System.out.println("\n" + hangman.gallows.getPrettyPrintGallows());
            
            if (hangman.gallows.isComplete()) {
                break;
            }
            
            System.out.println(hangman.getPrettyPrintHangmanWord());
        }
        
        if (hangman.isSolved()) {
            System.out.println("\nWell done! Thanks for playing.");
        } else {
            System.out.println("Oh dear! You lost the game.");
            System.out.println("The word was \"" + hangman.getOriginalWord() + "\".");
        }
    }
    
    public void runPlayAgainSelector(Scanner scanner) {
        String line = "";
        
        System.out.println("Would you like to play again? y/n");
        
        while (!line.equals("y") && !line.equals("n")) {
            line = scanner.nextLine().toLowerCase().replaceAll("[^yn]", "");
        }
        
        if (line.equals("n")) {
            this.isRunningHangman = false;
            System.out.println("Goodbye.");
        } else {
            System.out.println();
        }
    }
}
