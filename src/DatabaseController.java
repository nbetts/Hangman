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

    }
    
    public String getRandomWord(Word.DIFFICULTY difficulty) {
        Random randNumber = new Random();
        String word = "";

        switch (difficulty) {
            case EASY:
                if (easyWords.size() > 0) {
                    word = easyWords.get(randNumber.nextInt(easyWords.size())).word;
                }
                break;
            case MEDIUM:
                if (mediumWords.size() > 0) {
                    word = mediumWords.get(randNumber.nextInt(mediumWords.size())).word;
                }
                break;
            case HARD:
                if (hardWords.size() > 0) {
                    word = hardWords.get(randNumber.nextInt(hardWords.size())).word;
                }
                break;
        }
        
        return word;
    }

    public void loadWords() {
        easyWords = new ArrayList<>();
        mediumWords = new ArrayList<>();
        hardWords = new ArrayList<>();
        
        String wordListFile = "src/words.txt";
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(wordListFile));
            String line = reader.readLine();
            
            while (line != null) {
               line = line.replaceAll("[^a-zA-Z]", "");
               
               if (!line.isEmpty()) {
                   Word word = new Word(line);
                   
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
