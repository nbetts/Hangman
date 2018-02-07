import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Hangman hangman = new Hangman("Strength");
        
        System.out.println("Welcome to the game of Hangman!\n" + 
                           "  _______\n" + 
                           "   |   |\n" + 
                           "   |   O\n" + 
                           "   |  /|\\\n" + 
                           "   |  / \\\n" + 
                           " __|____\n" + 
                           " |     |\n\n" +
                           "Try to guess the hangman word:\n\n " +
                           hangman.getPrettyPrintHangmanWord() + "\n");
        
        Scanner in = new Scanner(System.in);
        
        while(!hangman.isSolved()) {
            String line = new String();
            
            while (line.length() == 0) {
                line = in.nextLine();
            }
            
            char guessedLetter = line.charAt(0);
            System.out.println();
            
            if (hangman.isLetterAlreadyGuessed(guessedLetter)) {
                System.out.println("Oops! You've already guessed that letter.");
            } else {
                if (hangman.guessLetter(guessedLetter)) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Oops! Try again.");
                }
            }
            
            System.out.println("Guessed letters: " + hangman.getPrettyPrintGuessedLetters());
            System.out.println("\n" + hangman.getPrettyPrintHangmanWord());
        }
        
        System.out.println("\nWell done! Thanks for playing.");
        
        in.close();
    }

}
