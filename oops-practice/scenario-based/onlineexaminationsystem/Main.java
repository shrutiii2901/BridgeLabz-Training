public class Main {
public static void main(String[] args) {
    Exam exam = new Exam();

    try {
        exam.submit(true);
        System.out.println("Score" + exam.evaluate());
    } catch (ExamTimeExpiredException e) {
        System.out.println(e.getMessage());
    }
}    
}
