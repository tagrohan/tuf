package basics;

public class Recursion {

    public static void main(String[] args) {
        boolean palidrome = isPalidrome("LAkaakAL", 0);
        System.out.println(palidrome);
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

    // factorial of 3 is 3x2x1 -> 6
    // factorial is same as sum check above code
    public static int factorialOfNNumbers(int num) {
//        System.out.println(factorialOfNNumbers(4));
        if (num <= 1) {
            return num;
        }
        return factorialOfNNumbers(num - 1) * num;
    }


    // this is to reverse an array using recursion
    // todo : tomm will do with two ponters approach
    public static int[] reverseAnArray(int[] arr, int i) {
//        int[] ints = reverseAnArray(new int[]{1, 2, 3, 4}, 0);
        if (i > arr.length) {
            return new int[arr.length];
        }

        int[] ints = reverseAnArray(arr, i + 1); // 0,1,2,3
        if (i != 0) {
            ints[arr.length - i] = arr[i - 1];
        }

        return ints;
    }


    // here we can replace both 1st and last element together so, its a some kind of two pointer approach
    public static int[] reverseAnArrayUsingTwoPointer(int[] arr, int i) {
//        int[] ints = reverseAnArrayUsingTwoPointer(new int[]{1, 2, 3, 4}, 0);
        if (i >= arr.length / 2) { // as we have 2 pointer wee should go half of array
            return arr;
        }

        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;

        return reverseAnArrayUsingTwoPointer(arr, i + 1);
    }

    // checking if its pelindrome, situation looks similar to two pointer approach in above question
    public static boolean isPalidrome(String str, int i) {
//        boolean palidrome = isPalidrome("LAkaakAL", 0);
        if (str.length() / 2 <= i) return true;

        if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
            return false;
        }

        return isPalidrome(str, i + 1);
    }


}
