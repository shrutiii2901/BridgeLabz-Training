import java.util.*;

public class VolumeOfCylinder{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int radius = sc.nextInt();
        int height = sc.nextInt();
        // calculate Volume
        System.out.println(3.14*radius*radius*height);
    }
}