public class SpecialNumbers {

    public static int sumProperDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++)
            if (n % i == 0) sum += i;
        return sum;
    }

    public static boolean isPerfect(int n) {
        return sumProperDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        return sumProperDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        return sumProperDivisors(n) < n;
    }

    public static boolean isStrong(int n) {
        int sum = 0, temp = n;
        while (temp > 0) {
            int d = temp % 10;
            sum += factorial(d);
            temp /= 10;
        }
        return sum == n;
    }

    private static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }
}
