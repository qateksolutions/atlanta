package practice;

import java.util.*;

public class LearnHashMap {
    HashMap<String,String> hmap = new HashMap<>();

    public void AddHashMapValue() {
        hmap.put("IE", "Internet Explorer");
        hmap.put("CHROME", "Chrome Browser");
        hmap.put("Firefox", "Mozilla Firefox");
        hmap.put("Safari", "Macbook Browser");
        hmap.put("Opera", "Linux browser");
    }

    public void printHashMapValue(String keyName) {
        AddHashMapValue();
        System.out.println("Browser Name: " + hmap.get(keyName));
    }
}
