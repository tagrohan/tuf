package basics;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(sumOfNNumbers(10));
    }

    // i did this on my own, I have used 2 pointer to keep the hold on prev and current state and using that for my code
    public static void fibonacciNumber(int prev, int curr, int place) {// 0 1 1 2 3 5 8 13
//        fibonacciNumber(0, 1, 5);

        if (place <= 0) {
            System.out.println(prev);
            return;
        }
        int temp = curr;
        curr = curr + prev;
        prev = temp;
        fibonacciNumber(prev, curr, place - 1);

    }
    // here we can write the same code in a single parameter
    // so to find this we need f(n) = f(n - 1) + f(n - 2)

    public static int fibViaMultiRec(int num) { // System.out.println(fibViaMultiRec(7));
        if (num <= 1) return num;
        return fibViaMultiRec(num - 1) + fibViaMultiRec(num - 2); // O(2^n as its a exponetial call as its creating a tree of 2 then 4 then 8 and so on)
    }

    public static int sumOfNNumbers(int num) {
//        System.out.println(sumOfNNumbers(10));
        if (num <= 1) {
            return num;
        }
        return sumOfNNumbers(num - 1) + num;
    }
}
