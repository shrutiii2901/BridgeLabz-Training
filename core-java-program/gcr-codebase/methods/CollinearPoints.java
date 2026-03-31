public class CollinearPoints {

    public static boolean slopeMethod(int x1,int y1,int x2,int y2,int x3,int y3) {
        return (y2 - y1)*(x3 - x2) == (y3 - y2)*(x2 - x1);
    }

    public static boolean areaMethod(int x1,int y1,int x2,int y2,int x3,int y3) {
        return 0.5 * (x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)) == 0;
    }
}
