class ShortLongWord {

    static int[] findShortestLongest(String[][] table) {
        int min = Integer.parseInt(table[0][1]);
        int max = min;
        int minIndex = 0, maxIndex = 0;

        for (int i = 1; i < table.length; i++) {
            int len = Integer.parseInt(table[i][1]);
            if (len < min) {
                min = len;
                minIndex = i;
            }
            if (len > max) {
                max = len;
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }
}