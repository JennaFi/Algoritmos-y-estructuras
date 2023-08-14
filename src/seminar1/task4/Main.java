package seminar1.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.close();

        System.out.println(fiboRecursion((n)));

    }

    /**
     * @apiNote Algorithms of Fibonacci by recursion
     * @param pos - position to find
     * @return value of the element
     */

    public static int fiboRecursion(int pos) {
        if (pos ==1 || pos == 2) {
            return 1;
        }
        return fiboRecursion((pos -1) + fiboRecursion(pos - 2));
    }
}
