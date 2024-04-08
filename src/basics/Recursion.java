package basics;

public class Recursion {

    public static void main(String[] args) {
        fibonacciNumber(0, 1, 3);
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
}
