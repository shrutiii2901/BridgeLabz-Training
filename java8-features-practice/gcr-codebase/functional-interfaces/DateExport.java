interface Exporter {
    void exportCSV();
    void exportPDF();

    default void exportJSON() {
        System.out.println("Exported to JSON");
    }
}

class Report implements Exporter {
    public void exportCSV() {
        System.out.println("CSV Export");
    }
    public void exportPDF() {
        System.out.println("PDF Export");
    }
}

public class DateExport {
    public static void main(String[] args) {
        Exporter e = new Report();
        e.exportCSV();
        e.exportPDF();
        e.exportJSON();
    }
}
