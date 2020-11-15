package practice;

import java.util.ArrayList;
import java.util.List;

public class LearnArray {
    public void stringArray() {
        String[] states = {"Alabama", "California", "Florida", "Texas"};
//        for (int x = 0; x < states.length; x++) {
//            System.out.println("State name is: " + states[x]);
//        }

        for(String state: states) {
            System.out.println("State name is: " + state);
        }
    }

    public void splitArray() {
//        String names = "John,Matthew,Robert,Don";
//        String[] nameArray = names.split(",");
//        for(String name: nameArray) {
//            System.out.println("Name is: " + name);
//        }

        String sentence = "I live in NewYork";
        String[] words = sentence.split(" ");
//        for (String word: words) {
//            System.out.println("Word is: " + word);
//        }
        System.out.println("Array Length: " + words.length);
        String reverse = "";
        for(int x = words.length -1; x >= 0; x--) {
            reverse += " " + words[x];
        }

        System.out.println(reverse);
    }

    public void convertArrayToList() {
        String[] languages = {"Java", "PHP", "Python", "C++"};
        List<String> listOfLanguage = new ArrayList<>();
        for (String lang: languages) {
            listOfLanguage.add(lang);
        }
        listOfLanguage.add("C#");
        listOfLanguage.add("VB");
        listOfLanguage.add("Java");
        System.out.println(listOfLanguage);
    }

}
