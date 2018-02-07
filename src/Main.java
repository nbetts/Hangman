import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Hangman hangman = new Hangman("Strength");
        
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
                           " |     |  \n\n" +
                           "This version allows words containing\n" + 
                           "numbers. Try to guess the hangman word:\n\n " +
                           hangman.getPrettyPrintHangmanWord() + "\n");
        
        Scanner in = new Scanner(System.in);
        
        while(!hangman.isSolved()) {
            String line = new String();
            
            while (line.length() == 0) {
                line = in.nextLine();
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
        
        in.close();
    }
}
