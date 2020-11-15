package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearnList {
    List<String> states = new ArrayList<String>();

    private void addValueToTheList() {
        states.add("Alabama");
        states.add("California");
        states.add("Texas");
    }

    private void addMoreValueToTheList() {
        states.add("Tennessee");
        states.add("Vermont");
    }

    private void removeValueFromList() {
        states.remove("Alabama");
    }

    public void printList() {
        addValueToTheList();
        for (String state: states) {
            System.out.println("State name is: " + state);
        }
        addMoreValueToTheList();
        removeValueFromList();
        System.out.println("----------------------------------");
        for (int x = 0; x < states.size(); x++) {
            System.out.println("State name is: " + states.get(x));
        }
    }

    public void convertListToArray() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Apple");

        //convert list into array
        String[] fruitArray = fruits.toArray(new String[fruits.size()]);
        System.out.println("Printing Array: " + Arrays.toString(fruitArray));
    }

}
