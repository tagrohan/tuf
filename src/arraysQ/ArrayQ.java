package arraysQ;

public class ArrayQ {

    public static void main(String[] args) {
        for (int i : leftRotateByDPlace(new int[]{1, 2, 3, 4, 5, 6}, 3)) {
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
    private static int[] leftRotateByDPlace(int[] arr, int D) {
//        leftRotateByDPlace(new int[]{1, 2, 3, 4, 5, 6}, 3);
        int len = D % 10;
        int[] temp = new int[D];
// here I am storing those which need to be at back side 123
        for (int i = 0; i < len; i++) {
            temp[i] = arr[i];
            //[1,2,3]
        }// here I am displacing rest to initial position
//         and at the same time displaced placed will be filled by 123
        for (int i = 0, j = D; j < arr.length; i++, j++) {
            arr[i] = arr[j];
            arr[j] = temp[i];
        }

        return arr;
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

}
