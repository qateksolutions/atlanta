package practice;

public class Recursion {
    public int rangeOfSums(int num) {
        if(num > 0) {
            return num + rangeOfSums(num - 1);
        }
        return 0;
    }
}
