import java.util.List;

public class PatientIDPrint {
    public static void main(String[] args) {

        List<Integer> patientIds = List.of(101, 102, 103, 104);

        patientIds.forEach(System.out::println);
    }
}
