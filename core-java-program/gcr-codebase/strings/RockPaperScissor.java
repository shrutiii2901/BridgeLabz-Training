class RockPaperScissor {

    static String computerChoice() {
        int n = (int) (Math.random() * 3);
        return (n == 0) ? "rock" : (n == 1) ? "paper" : "scissors";
    }

    static String findWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if (user.equals("rock") && comp.equals("scissors") ||
            user.equals("paper") && comp.equals("rock") ||
            user.equals("scissors") && comp.equals("paper"))
            return "User";
        return "Computer";
    }
}