
public class HangmanGallows {
    public static final int FINAL_COMPLETION_STAGE = 14;

    private int gallowsCompletionStage;
    
    public HangmanGallows() {
        gallowsCompletionStage = 0;
    }
    
    public boolean isComplete() {
        return gallowsCompletionStage == FINAL_COMPLETION_STAGE;
    }
    
    public void buildGallows() {
        if (isComplete()) {
            return;
        }

        gallowsCompletionStage++;
    }
    
    public String getPrettyPrintGallows() {
        String gallows = "";
        
        switch(gallowsCompletionStage) {
            case 0:
                gallows = " _______  \n" + 
                          " |     |  \n";
                break;
            case 1:
                gallows = " __|____  \n" + 
                          " |     |  \n";
                break;
            case 2:
                gallows = "   |      \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 3:
                gallows = "   |      \n" + 
                          "   |      \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 4:
                gallows = "   |      \n" + 
                          "   |      \n" + 
                          "   |      \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 5:
                gallows = "   |      \n" + 
                          "   |      \n" + 
                          "   |      \n" + 
                          "   |      \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 6:
                gallows = "  ------- \n" + 
                          "   |      \n" + 
                          "   |      \n" + 
                          "   |      \n" + 
                          "   |      \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 7:
                gallows = "  ------- \n" + 
                          "   |   |  \n" + 
                          "   |      \n" + 
                          "   |      \n" + 
                          "   |      \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 8:
                gallows = "  ------- \n" + 
                          "   |   |  \n" + 
                          "   |   O  \n" + 
                          "   |      \n" + 
                          "   |      \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 9:
                gallows = "  ------- \n" + 
                          "   |   |  \n" + 
                          "   |   O  \n" + 
                          "   |   |  \n" + 
                          "   |      \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 10:
                gallows = "  ------- \n" + 
                          "   |   |  \n" + 
                          "   |   O  \n" + 
                          "   |  /|  \n" + 
                          "   |      \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 11:
                gallows = "  ------- \n" + 
                          "   |   |  \n" + 
                          "   |   O  \n" + 
                          "   |  /|\\\n" + 
                          "   |      \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 12:
                gallows = "  ------- \n" + 
                          "   |   |  \n" + 
                          "   |   O  \n" + 
                          "   |  /|\\\n" + 
                          "   |  /   \n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
            case 13:
                gallows = "  ------- \n" + 
                          "   |   |  \n" + 
                          "   |   O  \n" + 
                          "   |  /|\\\n" + 
                          "   |  / \\\n" + 
                          " __|____  \n" + 
                          " |     |  \n";
                break;
        }
        
        return gallows;
    }
}
