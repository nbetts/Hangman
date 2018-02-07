
public class Word {
    public enum DIFFICULTY {
        EASY,
        MEDIUM,
        HARD;
    }

    public final String word;
    public final DIFFICULTY difficulty;
    
    public Word(String word) {
        this.word = word;
        int wordLength = word.length();
        
        if (wordLength <= 5) {
            this.difficulty = DIFFICULTY.HARD;
        } else if (wordLength <= 7) {
            this.difficulty = DIFFICULTY.MEDIUM;
        } else {
            this.difficulty = DIFFICULTY.EASY;
        }
    }
    
    /**
     * The equals() and hashCode() methods have been overwritten to ensure
     * duplicate words cannot be added into a Word list. Adapted from here:
     * https://stackoverflow.com/a/27751540
     */

    @Override
    public boolean equals(Object object) {
        return object instanceof Word && ((Word) object).word.equals(word);
    }
    
    @Override
    public int hashCode() {
        return word.hashCode(); 
    }
}
