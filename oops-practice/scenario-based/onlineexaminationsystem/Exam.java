public class Exam implements EvaluationStrategy {

    @Override
    public int evaluate() {
        return 85;
    }

    public void submit(boolean timeLeft) throws ExamTimeExpiredException {
        if (!timeLeft)
            throw new ExamTimeExpiredException("Exam time expired");
        System.out.println("Exam submitted");
    }
}
