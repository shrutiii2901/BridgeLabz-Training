public class NumberCheckerAdvanced {

    public static int sumDigits(int[] d) {
        int s = 0;
        for (int x : d) s += x;
        return s;
    }

    public static double sumSquares(int[] d) {
        double s = 0;
        for (int x : d) s += Math.pow(x, 2);
        return s;
    }

    public static boolean isHarshad(int n) {
        return n % sumDigits(NumberChecker.getDigits(n)) == 0;
    }

    public static int[][] digitFrequency(int[] d) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int x : d) freq[x][1]++;
        return freq;
    }
}
