import java.util.HashSet;
import java.util.Set;

public class Hangman {
    private final String originalWord;
    private String hangmanWord;
    private Set<Character> guessedLetters;
    public HangmanGallows gallows;
    
    public Hangman(String originalWord) throws Exception {
        
        if (originalWord == null || originalWord.trim().isEmpty()) {
            throw new Exception("Error: Word is not set");
        }
        
        this.originalWord = originalWord.trim().toUpperCase();
        
        StringBuilder stringBuilder = new StringBuilder(originalWord.length());
        
        for (int i = 0; i < originalWord.length(); i++) {
            stringBuilder.append('_');
        }
        
        this.hangmanWord = stringBuilder.toString();
        this.guessedLetters = new HashSet<>();
        this.gallows = new HangmanGallows();
    }
    
    public String getOriginalWord() {
        return originalWord;
    }

    public String getHangmanWord() {
        return hangmanWord;
    }

    public boolean isSolved() {
        return !hangmanWord.contains("_");
    }
    
    public String getPrettyPrintHangmanWord() {
        StringBuilder stringBuilder = new StringBuilder(hangmanWord.length());
        
        for (int i = 0; i < hangmanWord.length(); i++) {
            stringBuilder.append(hangmanWord.charAt(i));
            stringBuilder.append(' ');
        }
        
        return stringBuilder.toString();
    }
    
    public boolean guessLetter(char guessingLetter) {
        char guessedLetter = Character.toUpperCase(guessingLetter);
        
        boolean isGuessedLetterInWord = false;
        
        for (int i = 0; i < originalWord.length(); i++) {
            if (guessedLetter == originalWord.charAt(i)) {
                isGuessedLetterInWord = true;
                
                updateHangmanWord(guessedLetter, i);
            }
            
            guessedLetters.add(new Character(guessedLetter));
        }
        
        return isGuessedLetterInWord;
    }
    
    public boolean isLetterAlreadyGuessed(char guessingLetter) {
        Character guessedLetter = new Character(Character.toUpperCase(guessingLetter));
        
        for (Character letter : guessedLetters) {
            if (letter.equals(guessedLetter)) {
                return true;
            }
        }
        
        return false;
    }
    
    public void updateHangmanWord(char letter, int index) {
        StringBuilder stringBuilder = new StringBuilder(originalWord.length());
        
        for (int i = 0; i < originalWord.length(); i++) {
            if (i == index) {
                stringBuilder.append(letter);
            } else {
                stringBuilder.append(hangmanWord.charAt(i));
            }
        }
        
        hangmanWord = stringBuilder.toString();
    }
    
    public String getPrettyPrintGuessedLetters() {
        StringBuilder stringBuilder = new StringBuilder(guessedLetters.size());
        
        for (Character letter : guessedLetters) {
            stringBuilder.append(letter);
        }
        
        return "[" + stringBuilder.toString() + "]";
    }
}
