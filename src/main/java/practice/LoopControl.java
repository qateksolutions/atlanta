package practice;

public class LoopControl {
    // Print value 1 to 99
    // Print value 10 to 15
    public void whileLoop() {
        int x = 15;
        while (x < 15) {
            System.out.println("Value is X is: " + x);
            x++;
        }
    }

    public void forLoop() {
        for (int x = 10; x <= 15; x++) {
            System.out.println("Value of x is: " + x);
        }
    }

    public void doWhileLoop() {
        int x = 15;
        do {
            System.out.println("Value of x is: " + x);
            x++;
        }while (x < 15);
    }
}
