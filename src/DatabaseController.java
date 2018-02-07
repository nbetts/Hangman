import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class DatabaseController {
    private ArrayList<Word> easyWords;
    private ArrayList<Word> mediumWords;
    private ArrayList<Word> hardWords;

    public DatabaseController() {
        loadWords();
    }
    
    public String getRandomWord(Word.DIFFICULTY difficulty) {
        Random randNumber = new Random();

        switch (difficulty) {
            case EASY:
                return easyWords.get(randNumber.nextInt(easyWords.size())).word;
            case MEDIUM:
                return mediumWords.get(randNumber.nextInt(mediumWords.size())).word;
            case HARD:
                return hardWords.get(randNumber.nextInt(hardWords.size())).word;
            default:
                return "";
        }
    }

    public void loadWords() {
        easyWords = new ArrayList<>();
        mediumWords = new ArrayList<>();
        hardWords = new ArrayList<>();
        
        String wordListFile = "src/words_test.txt";
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(wordListFile));
            System.out.format("Reading contents from %s:\n", wordListFile);
            String line = reader.readLine();
            
            while (line != null) {
               Word word = new Word(line.trim());
               
               switch (word.difficulty) {
                   case EASY:
                       easyWords.add(word);
                       break;
                   case MEDIUM:
                       mediumWords.add(word);
                       break;
                   case HARD:
                       hardWords.add(word);
                       break;
               }
               
               line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error: could not read " + wordListFile);
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error: could not close file reader");
                e.printStackTrace();
            }
        }
    }
}
