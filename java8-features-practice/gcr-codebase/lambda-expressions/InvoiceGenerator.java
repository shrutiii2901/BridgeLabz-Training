import java.util.List;
import java.util.stream.Collectors;

class Invoice {
    String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    public String toString() {
        return "Invoice for Transaction ID: " + transactionId;
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {

        List<String> transactionIds = List.of("TXN101", "TXN102", "TXN103");

        List<Invoice> invoices = transactionIds.stream()
                                                .map(Invoice::new)
                                                .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
