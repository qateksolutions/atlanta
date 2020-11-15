package practice;

public class Variables {
    int salary = 1000;

    public void intVariables() {
        System.out.println("My Salary is: " + salary);
    }

    public void adamSalary() {
        System.out.println("Adam Salary is: " + salary);
    }

    public void floatVariables() {
        float price = 45.5f;
        System.out.println("Product price is: " + price);
    }

    public void booleanVariables() {
        boolean red = true;
        boolean green = false;
        System.out.println("Red light is: " + red + " green light is: " + green);
    }

    public void characterVariables() {
        char grade = 'A';
        System.out.println("My grade is: " + grade);
    }

    public void stringVariables() {
        String name = "John";
        String city = "Texas";
        System.out.println("My name is: " + name + " I live in the state of: " + city);
    }

    public int printNumber(int a) {
        return a;
    }

}
