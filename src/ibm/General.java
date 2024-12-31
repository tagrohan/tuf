package ibm;

public class General {
    public static void main(String[] args) {
        System.out.println(reverseANumber(1234));
    }

    private static int reverseANumber(int num) {
        int reverseNum = 0; // 1234

        while (num > 0) {
            int temp = num % 10; // temp = 4
            num = num / 10;
            reverseNum = reverseNum * 10 + temp; // if we change 10 to some other place it can affect the output
        }
        return reverseNum;
    }
}
