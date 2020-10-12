package sample.commandline ;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DictionaryManagement extends Dictionary {
    static Dictionary dictionary = new Dictionary();
    File fileDictionary = new File("/Users/apple/Downloads/LB.txt");

    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        String value = sc.nextLine();
        dictionary.words.put(key, value);
    }

    public void insertFromFile() {
        if(!fileDictionary.exists()) {
            fileDictionary.mkdir();
        }
        try {
            Scanner sc = new Scanner(fileDictionary);
            String content = "";
            while (sc.hasNextLine()) {
                content = sc.nextLine();
                String[] w = content.split("\t",2);
                dictionary.words.put(w[0], w[1]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("error");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error");
        }
    }

    public void dictionaryLookup() {
        System.out.print("Enter the word you want to look up: ");
        Scanner sc = new Scanner(System.in);
        String keyWord = sc.nextLine();
        boolean test = true;
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            if (keyWord.equals(entry.getKey())) {
                System.out.println(entry.getValue());
                test = false;
            }
            if (keyWord.equals(entry.getValue())) {
                System.out.println(entry.getKey());
                test = false;
            }
        }
        if (test == true) {
            System.out.println("not found");
        }
    }

    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add word: ");
        String key = sc.nextLine();
        System.out.print("Means: ");
        String value = sc.nextLine();
        dictionary.words.put(key, value);
    }

    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Remove word: ");
        String key = sc.nextLine();
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            if (key.equals(entry.getValue())) {
                key = entry.getKey();
            }
        }
        dictionary.words.remove(key);
    }

    public void change() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the word you want to edit: ");
        String editWord = sc.nextLine();// xin chao
        System.out.print("Enter the correct word: ");
        String corretWord = sc.nextLine();// hi
        String str = editWord;
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            if (entry.getValue().equals(editWord)) {
                str = entry.getKey();
                String tg = editWord;
                editWord = corretWord;
                corretWord = tg;
            }
        }
        dictionary.words.remove(str);
        dictionary.words.put(editWord, corretWord);
    }

    public void dictionaryExportToFile() {
        try {
            File f = new File("/Users/apple/Downloads/LB.txt");
            FileWriter fw = new FileWriter(f);
            for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
                fw.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e);
        }
    }

}
