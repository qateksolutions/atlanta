package practice;

public class Encapsulate {
    private String geekName;
    private int geekRoll;
    private int geekAge;

    public int getAge() {
        return geekAge;
    }

    public String getName() {
        return geekName;
    }

    public int getRoll() {
        return geekRoll;
    }

    public void setAge(int age) {
        geekAge = age;
    }

    public void setName(String name) {
        geekName = name;
    }

    public void setRoll(int roll) {
        geekRoll = roll;
    }
}
