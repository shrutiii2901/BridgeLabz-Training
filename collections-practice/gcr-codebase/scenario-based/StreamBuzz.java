import java.util.*;

class CreatorStats {
    public String creatorName;
    public double[] weeklyLikes;
    
    public static List<CreatorStats> engagementBoard = new ArrayList<>();
    
  
    public CreatorStats(String creatorName, double[] weeklyLikes) {
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }
}

public class StreamBuzz {

   
    public void registerCreator(CreatorStats record) {
        CreatorStats.engagementBoard.add(record);
        System.out.println("Creator registered successfully");
    }


    public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
        Map<String, Integer> result = new LinkedHashMap<>();
        
        for (CreatorStats creator : records) {
            int count = 0;
            for (double likes : creator.weeklyLikes) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(creator.creatorName, count);
            }
        }
        
        return result;
    }

    
    public double calculateAverageLikes() {
        double sum = 0;
        int totalWeeks = 0;
        
        for (CreatorStats creator : CreatorStats.engagementBoard) {
            for (double likes : creator.weeklyLikes) {
                sum += likes;
                totalWeeks++;
            }
        }
        
        if (totalWeeks == 0) return 0;
        return sum / totalWeeks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StreamBuzz app = new StreamBuzz();
        
        while (true) {
            System.out.println("\n1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Creator Name: ");
                    String name = sc.nextLine();
                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        likes[i] = sc.nextDouble();
                    }
                    sc.nextLine();
                    CreatorStats creator = new CreatorStats(name, likes);
                    app.registerCreator(creator);
                    break;
                    
                case 2:
                    System.out.print("Enter like threshold: ");
                    double threshold = sc.nextDouble();
                    sc.nextLine(); 
                    Map<String, Integer> topPosts = app.getTopPostCounts(CreatorStats.engagementBoard, threshold);
                    
                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;
                    
                case 3:
                    double avgLikes = app.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + (int)avgLikes);
                    break;
                    
                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    return; 
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
