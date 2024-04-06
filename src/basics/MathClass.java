package basics;

public class MathClass {

    // we are going to use mod and divide here
    //mod gave last digit always, while divide gave remaining ex, for 123 % 10 = 3, / = 12(as digit after dot(12.3) not considered in int variable)
    public static void main(String[] args) {
        hcf(24, 12);
    }

    //    1234 -> 4, 123 -> 3
    public static void countNumberOfDigits(int num) {
//        countNumberOfDigits(123);
        int count = 0;
        while (num > 0) {
            num /= 10; //time complexity Olog(n) as we are dividing here, specifically Olog10(N)
            count += 1;
        }
        System.out.println(count);
    }

    // here if we mod we are getting last digit which we can print in reverse
    // but as we what about 12300, for this are going to use some math tricks as if we multiply mod number with 10 and then mod number can place that
    // cvalue in 10th position then 100 th based on it
    // ex 123 % 10 = 3, now 10 * 0 + 3 = 30,
    // 12 % 10 = 2, now 10 * 3 + 2 = 32, and so on became 321
    public static void reverseANum(int num) {
//        reverseANum(12300);
        int revNumber = 0;

        while (num > 0) {
            int mod = num % 10;
            num /= 10;

            revNumber = revNumber * 10 + mod;
        }
        System.out.println(revNumber);
    }

    // number which looks same from both sides, ex 1221, 131,
    private static void isPalindrome(int num) {
//        isPalindrome(121);
        int revNumber = 0;
        int originalNum = num;

        while (num > 0) {
            int mod = num % 10;
            num /= 10;

            revNumber = revNumber * 10 + mod;
        }
        System.out.println(revNumber == originalNum);
    }

    // a armstrong number aesa number h kisi digit number ka har ek digit se power kre to whi number a jye
    //ex : 153 (nu. of digits : 3) so 1^3 + 5^3 + 3^3 = 153,
    //ex : 1634 (nu. of digits : 4) so 1^4 + 6^4 + 3^4 + 4^4 = 1634,
    private static void isArmstrong(int num) {
//        isArmstrong(1634);
        int originalNumeber = num;
        int pow = 0, sum = 0;
        while (num > 0) {
            num /= 10;
            pow++;
        }
        num = originalNumeber;
        while (originalNumeber > 0) {
            int last = originalNumeber % 10;
            sum = sum + (int) Math.pow(last, pow);
            originalNumeber /= 10;
        }

        System.out.println(num == sum);

    }

    // print the nummbers that divided a num, ex 36 : 1,2,3,4,6,9,12,18,36
    // we can just print number after mod it with i (not optimised approach)
    private static void allDivisorNumber(int num) {
//        allDivisorNumber(36);
//        for (int i = 1; i <= num; i++) {
//            if (num % i == 0) {
//                System.out.println(i);
//            }
        // jo bhi multiple h wo dono numbers honge for ex : 36-> 4 * 9 and 9 * 4, so agr ek number pta h mod se to dusra number/divide se a jyege,
        //36 -> 4, then 36/4 = 9, so 2 numbers are 4 and 9
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println(i);
                if (i != num / i) { // for cases like 6, which will duplicate we use this
                    System.out.println(num / i);
                }
            }

        }
    }

    // a number who has exactly 2 factors(1 and number itself)
    private static void checkIfPrime(int num) { // O(N/2)
//        checkIfPrime(38);
        boolean isPrime = true;
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime && num != 1) { // 1 is not a prime number
            System.out.println("its a prime number");
        } else {
            System.out.println("not a prime number");
        }

    }

    // as definition said 2 factors of a number makes it a prime number
    // and we know in sware root, we can find all the factors if there(line 79),
    //that means for each factor I found 2 actually ex : for 6 -> 3*2 and 2 *3 so factors for this iteration are 2,3
    private static void checkIfPrimeUsingSquare(int num) { // O(square root N)
//        checkIfPrimeUsingSquare(5);
        int factors = 0;
        for (int i = 2; i * i < num; i++) { // or condition (i * i <= num)

            if (num % i == 0) {
                factors += 2;
                break;
            }
        }
        if (factors > 1 || num == 1) {
            System.out.println("its not a prime");
        } else System.out.println("It's a prime");

    }

    // hcf is a common highest divison among 2 numbers
    //9 -> 1,3,9 and 12-> 1,2,3,4,6,12 :: highest common factor is 3
    private static void hcf(int a, int b) {
//        hcf(9,12);
        int range = b;
        int hcf = 1;
        if (a > b) {
            range = a;
        }
        for (int i = 2; i <= range; i++) {
            if (a % i == 0 && b % i == 0) {
                hcf = i;
            }
        }
        System.out.println(hcf);
    }
}

