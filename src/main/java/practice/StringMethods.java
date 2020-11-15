package practice;

public class StringMethods {
    public void methodIndexOf() {
        String str = "I live in MMiami";
        int foundIndex = str.indexOf("Miami");
        System.out.println("Index location is: " + foundIndex);

        int foundIndexLocation = str.indexOf("Miami", 5);
        System.out.println("Index location is: " + foundIndexLocation);
    }

    public void methodSubString() {
        String str = "My state name is Texas";
        int foundIndex = str.indexOf("name");
        System.out.println("Index location is: " + foundIndex);

        String partOfString = str.substring(foundIndex);
        System.out.println("Extracted Data is: " +partOfString);

        String nameString = str.substring(foundIndex, foundIndex + 2);
        System.out.println("Data is: " + nameString);
    }

    public void variousStringMethods() {
        String str = "I live in Miami";
        int strLength = str.length();
        System.out.println("String Length is: " + strLength);

        String wordBeforeLast = str.substring(strLength-3);
        System.out.println("Character before the last: " + wordBeforeLast);

        String newStr = str.replace('i', 'a');
        String newStr1 = str.replaceAll("Miami", "Brooklyn");
        System.out.println("New String is: " + newStr);
        System.out.println("New String is: " + newStr1);

        String extraSpace = "     I live in Miami         ";
        int strLength1 = extraSpace.length();
        System.out.println("String Length is: " + strLength1);

        String removeSpace = extraSpace.trim();
        int strLength2 = removeSpace.length();
        System.out.println("String Length is: " + strLength2);


        String newLine = "My name is John";
        boolean exist = newLine.toLowerCase().contains("john");
        System.out.println("Name validation: " + exist);
    }

}
