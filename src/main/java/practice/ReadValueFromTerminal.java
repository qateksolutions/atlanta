package practice;

import java.util.Scanner;

public class ReadValueFromTerminal {
    public void getInputFromUser() {
        LearnHashMap objMap = new LearnHashMap();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Key name: ");
        objMap.printHashMapValue(scan.nextLine());

//        System.out.print("Enter your name: ");
//        String str = scan.nextLine();
//        System.out.println("You entered String: " + str);
//
//        System.out.print("Enter Your age: ");
//        int age = scan.nextInt();
//        System.out.println("You entered integer: " + age);
//
//        System.out.print("Enter Product price: ");
//        float price = scan.nextFloat();
//        System.out.println("You entered float: " + price);
    }
}
