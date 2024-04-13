package arraysQ;

public class ArrayQ {

    public static void main(String[] args) {
        System.out.println(secondLargestInArray(new int[]{1, 2, 2, 3, 3, 4, 5, 5}));
    }

    // we are keeping a flag to hold 2nd largest
    private static int secondLargestInArray(int[] arr) {
//        System.out.println(secondLargestInArray(new int[]{1, 2, 2, 3, 3, 4, 5, 5}));
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
        }
        return secondMax;
    }


}
