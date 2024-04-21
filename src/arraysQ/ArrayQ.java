package arraysQ;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ArrayQ {

    public static void main(String[] args) {
        for (Object i : unionOfArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})) {
            System.out.print(i);
        }
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

    // 12345 -> 23451
    private static int[] leftRotateBy1Place(int[] arr) {
//        leftRotateBy1Place(new int[]{1, 2, 3, 4, 5, 6})
        int first = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = first;

        return arr;
    }

    // left rotate by N place
    // ex : 123456 : D = 3 -> 456123
    private static int[] leftRotateByDPlace(int[] arr, int D) { // O(N)
//        leftRotateByDPlace(new int[]{1, 2, 3, 4, 5, 6}, 3);
        int len = D % arr.length;
        int[] temp = new int[D];
// here I am storing those which need to be at back side 123
        for (int i = 0; i < len; i++) {
            temp[i] = arr[i];
            //[1,2,3]
        }// here I am displacing rest to initial position
        for (int j = D; j < arr.length; j++) {
            arr[j - D] = arr[j];
        }
        // her I am putting back the remaining from temp to arr
        for (int i = arr.length - len; i < arr.length; i++) {
            arr[i] = temp[i - len - D];
        }

        return arr;
    }

    // here if you see closely, 123456 : D = 3
    // if you reverve first D and last remaining -> 321,654,
    // now reverse whole -> 456123, you will get your answer
    private static int[] leftRotateByDPlaceV2(int[] arr, int D) {
//        leftRotateByDPlaceV2(new int[]{1, 2, 3, 4, 5}, 2)
        D = D % arr.length;
        rev(arr, 0, D - 1);
        rev(arr, D, arr.length - 1);
        rev(arr, 0, arr.length - 1);

        return arr;
    }

    private static void rev(int[] arr, int i, int j) { //O(2N)
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // 102040506 -> 124560000
    // using 2 pointeer approach
    private static int[] moveZeroToEnd(int[] arr) {
//        moveZeroToEnd(new int[]{1,0,2,0,4,0,5,0,6})
        int i = 0;
        int j = 1;
        while (i < arr.length && j < arr.length) {
            if (arr[i] == 0 && arr[j] != 0) {
                int temp = arr[i];
                arr[i] = j;
                arr[j] = temp;
            }
            if (arr[i] != 0) i++;
            if (arr[j] == 0) j++;
        }

        return arr;
    }

    // one way is to do it by set as set only contains unique elements
    private static Object[] unionOfArrays(int[] arr1, int[] arr2) {
//        unionOfArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        return set.toArray();
    }

}
