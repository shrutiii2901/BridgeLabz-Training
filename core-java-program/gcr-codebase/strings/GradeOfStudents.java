class GradeOfStudents {

    static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {
            scores[i][0] = 50 + (int) (Math.random() * 50);
            scores[i][1] = 50 + (int) (Math.random() * 50);
            scores[i][2] = 50 + (int) (Math.random() * 50);
        }
        return scores;
    }

    static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            stats[i][0] = total;
            stats[i][1] = Math.round(avg * 100) / 100.0;
            stats[i][2] = Math.round(percent * 100) / 100.0;
        }
        return stats;
    }

    static String getGrade(double percent) {
        if (percent >= 80) return "A";
        else if (percent >= 70) return "B";
        else if (percent >= 60) return "C";
        else if (percent >= 50) return "D";
        else if (percent >= 40) return "E";
        else return "R";
    }
}