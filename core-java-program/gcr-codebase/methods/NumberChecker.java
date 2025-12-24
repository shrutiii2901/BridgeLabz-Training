public class NumberChecker {

    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int[] getDigits(int n) {
        int count = countDigits(n);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }

    public static boolean isDuck(int[] digits) {
        for (int d : digits)
            if (d != 0) return true;
        return false;
    }

    public static boolean isArmstrong(int n) {
        int[] d = getDigits(n);
        int power = d.length, sum = 0;
        for (int x : d) sum += Math.pow(x, power);
        return sum == n;
    }

    public static int[] largestSecondLargest(int[] d) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int x : d) {
            if (x > max) { second = max; max = x; }
            else if (x > second && x != max) second = x;
        }
        return new int[]{max, second};
    }

    public static int[] smallestSecondSmallest(int[] d) {
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int x : d) {
            if (x < min) { second = min; min = x; }
            else if (x < second && x != min) second = x;
        }
        return new int[]{min, second};
    }
}

