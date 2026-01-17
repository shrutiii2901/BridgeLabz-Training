import java.io.*;

public class CompareAll {

    static void compareBuilders() {
        int count = 1000000;

        long start1 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count;i++) sb.append("hello");
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for(int i=0;i<count;i++) sbf.append("hello");
        long end2 = System.nanoTime();

        System.out.println("StringBuilder Time: " + (end1-start1));
        System.out.println("StringBuffer Time: " + (end2-start2));
    }

    static void countWords(String filename) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int words = 0;
        String line;

        while((line = br.readLine()) != null) {
            words += line.split("\\s+").length;
        }

        br.close();
        System.out.println("Total Words: " + words);
    }

    public static void main(String[] args) throws Exception {
        compareBuilders();
        countWords("input.txt");
    }
}
