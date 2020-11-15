package practice;

public class Account {
    int a_number;
    int b_number;

    public void setData(int a, int b) {
        a_number = a;
        b_number = b;
    }

    public void showData() {
        System.out.println("Value of A = " + a_number);
        System.out.println("Value of B = " + b_number);
    }
}
