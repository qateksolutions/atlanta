package practice;

public class LearnEnum {
    enum LEVEL {
        LOW,
        MEDIUM,
        HIGH
    }

    public void printLevel(String level) {
        if (level.equals(LEVEL.LOW.toString())) {
            System.out.println("The level is LOW");
        } else if (level.equals(LEVEL.MEDIUM.toString())) {
            System.out.println("The level is MEDIUM");
        } else if (level.equals(LEVEL.HIGH.toString())) {
            System.out.println("The level is HIGH");
        } else {
            System.out.println("Default level is: " + level);
        }
    }
}
