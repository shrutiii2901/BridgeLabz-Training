import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrailUtil util = new TrailUtil();

        System.out.println("Enter the number of trails to be added");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter trail details");
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] arr = input.split(":");

            Trail t = new Trail(
                    arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4])
            );
            util.addTrailRecord(t);
        }

        // get by id
        System.out.println("Enter the Trail Id to check hike status");
        String id = sc.nextLine();
        Trail t = util.getTrailById(id);

        if (t != null) {
            System.out.println(t);
        } else {
            System.out.println("Trail Id " + id + " not found");
        }

        // most hiked
        System.out.println("Most hiked trails are");
        util.getMostHikedTrails().forEach(System.out::println);

        // region summary
        System.out.println("Region-wise hike counts");
        util.getHikeCountByRegion()
                .forEach((k, v) -> System.out.println(k + ": " + v + " hikes"));

        // group by difficulty
        System.out.println("Trails grouped by difficulty");
        util.groupTrailsByDifficulty().forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });

        // update
        System.out.println("Enter Trail Id to update hikes and additional hikes");
        String tid = sc.next();
        int add = sc.nextInt();
        sc.nextLine();

        if (util.updateHikeCount(tid, add)) {
            System.out.println("Updated " + tid + " by " + add + " hikes");
            System.out.println(util.getTrailById(tid));
        }

        // filter
        System.out.println("Filter trails by region and difficulty");
        String region = sc.next();
        String diff = sc.next();
        sc.nextLine();

        util.filterTrails(region, diff).forEach(System.out::println);

        // top n
        System.out.println("Top N trails per region");
        int top = Integer.parseInt(sc.nextLine());

        util.getTopTrailsByRegion(top).forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });

        
        System.out.println("Difficulty statistics");
        util.getDifficultyStats()
                .forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
