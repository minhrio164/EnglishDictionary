package sample.commandline ;
import java.util.Map;
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement {

    public void showAllWords() {
        int i = 1;
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            System.out.println(i + "\t" + entry.getKey() + "\t" + entry.getValue());
            i++;
        }
    }

    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        insertFromFile();
        showAllWords();
        dictionaryLookup();
        add();
        dictionaryExportToFile();
    }

    public void dictionarySeacher() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word: ");
        String keyWord = sc.nextLine();
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            if (entry.getKey().contains(keyWord)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
