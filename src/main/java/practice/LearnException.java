package practice;

public class LearnException {
    public void readArray() {
        try{
            int[] nums = {1,2,3,4};
            System.out.println(nums[5]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addNumbers() {
        int sum = 5+5;
        System.out.println("Summation is: " + sum);
    }

    public void subtractNumbers() {
        int result = 10-5;
        System.out.println("Subtraction is: " + result);
    }
}
