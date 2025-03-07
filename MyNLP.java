import java.util.ArrayList;
import java.util.Scanner;
public class MyNLP {

  // TODO: Create 1-2 meaningful ArrayList 
  private ArrayList<String> words;    // The lines of the song
  private ArrayList<String> partsOfSpeech; 

  private ArrayList<String> wordList = new ArrayList<String>();
  
  // TODO: assigned initial values for your instance variables
  public MyNLP() {
    cleanDictionaryList();
  }
  /**
   * Student Developed Algorithm
   * @param ArrayList<String>
   * @return no return because it is void
   */
  /**
   * Starts the app and gets user input
   */
public void cleanDictionaryList() {
  words = new ArrayList<String>();
  partsOfSpeech = new ArrayList<String>();
    ArrayList<String> newArrayList = FileReader.toStringList("dictionary.txt");
  for (int i = 0; i< newArrayList.size(); i++){
    String current = newArrayList.get(i);
    int index = current.indexOf("|");
    String word = current.substring(0,index);
    String after = current.substring(index + 1);
    index = after.indexOf("|");
    String POS = after.substring(0, index);
    words.add(word);
    partsOfSpeech.add(POS);
  }
}  
  /**
   * @param parameter1 the first parameter
   * @return what is returned from this method
   */
  /**
   * Starts the app and gets user input
   */
  public void prompt() {
    Scanner input = new Scanner(System.in);

    System.out.println("Would you like to pick a number? If so, type 1.");
    String userInput = input.nextLine();
    
    System.out.println("Choose number 1-5.");
    System.out.println ("1");
    System.out.println ("2");
    System.out.println ("3");
    System.out.println ("4");
    System.out.println ("5");
    System.out.println ("Enter Choice: ");

    int choice = input.nextInt();
    String txt = "sent" + choice + ".txt";
    wordFinder(txt);
    printSummary();
    
    input.close();
  }

 /**
   * Student Developed Algorithm
   * @param String filename
   * @return the count
   */
  /**
 
    // TODO: add logic based on the user input   
        /*
          1.create a for loop that checks each word (create a string containing all characters until the next space or period, and if not the very first word, 
          the characters after the previous space or period)
        */
  public void wordFinder(String filename){
        ArrayList<String> newArrayList = FileReader.toStringList(filename);
        
        String fullText = newArrayList.get(0);
        String noPeriods = fullText.replace(".", "");
        String noCommas = noPeriods.replace(",", "");
        String[] splitCleanedText = noCommas.split(" ");
        for (String w : splitCleanedText) {
          wordList.add(w);
        }
        System.out.println(wordList);
  }

  public int getWordIndex(String targetWord) {
    for (int i = 0; i < words.size(); i++) {
      if (words.get(i).equals(targetWord)) {
        return i;
      }
    }
    System.out.println("Couldnt find: " + targetWord);
    return -1;
  }

 public void printSummary() {
   ArrayList<String> posList = new ArrayList<String>();
   ArrayList<Integer> countList = new ArrayList<Integer>();
   
   for (String word : wordList) {
     int potentialIndex = getWordIndex(word);
     if (potentialIndex != -1) {
       String pos = partsOfSpeech.get(potentialIndex);
       boolean flag = false;
       for (int i = 0; i < posList.size(); i++) {
         String currentPos = posList.get(i);
         if (currentPos.equals(pos)) {
           countList.set(i, countList.get(i) + 1);
           flag = true;
         }
       }
       if (!flag) {
         posList.add(pos);
         countList.add(1);
       }
     }
   }

   System.out.println(posList);
   System.out.println(countList);
 }
 

}