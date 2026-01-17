public class ComparePerformance {

    static void compare() {
        int count = 100000;

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

    public static void main(String[] args) {
        compare();
    }
}
