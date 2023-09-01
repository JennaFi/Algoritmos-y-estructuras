package Exceptions;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[4];
        try {
            System.out.println("before exce[tion");
            nums[7] = 10;
            System.out.println("error");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("out of bounds");
        }
        System.out.println("after catch");
    }

}
