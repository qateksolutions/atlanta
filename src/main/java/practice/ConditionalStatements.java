package practice;

public class ConditionalStatements {
    public void ifStatement() {
        int x = 10;
        if(x < 20) {
            System.out.println("This is if Statement");
        }
    }

    public void ifElseStatement() {
        int x = 10;
        if(x > 20) {
            System.out.println("This is if Statement");
        }
        else {
            System.out.println("This is else Statement");
        }
    }

    public void nestedIfStatement() {
        int x = 10;
        int y = 15;
        if(x < 20) {
            if(y < 20) {
                System.out.println("Value is x " + x + " value of y " + y);
            }
        }
    }

    public void switchStatement(char grade) {
        switch (grade) {
            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
                System.out.println("Well Done");
                break;
            case 'C':
                System.out.println("You passed");
                break;
            case 'D':
                System.out.println("Better try again");
                break;
            default:
                System.out.println("Invalid Grade");
        }
    }

    public void conditionalOperator(int num) {
//        int a = (num == 5) ? 10:20;
//        System.out.println("value of a is: " + a);
        int a;
        if(num == 5) {
            a = 10;
        } else {
            a = 20;
        }
        System.out.println("value of a is: " + a);
    }
}
