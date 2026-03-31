import java.util.*;
import java.util.stream.Collectors;
public class EnrollmentManager {
    
     private List<Enrollment> list = new ArrayList<>();

    public List<String> filterByCourse(String courseName) {
        return list.stream()
                .filter(e -> e.getcourseName().equalsIgnoreCase(courseName))
                .map(Enrollment::getName)
                .collect(Collectors.toList());
    }

    public List<String> filterByCategory(String courseCategory){
        return list.stream()
               .filter(e->e.getcourseCategory().equalsIgnoreCase(courseCategory))
               .map(Enrollment::getName)
               .collect(Collectors.toList());
    }

    public Map<String,List<Enrollment>> groupCourseName(String courseName){
        return list.stream()
               .collect(Collectors.groupingBy(Enrollment::getcourseName));      
    }
    public Map<String,Long> countBycategory(){
        return list.stream()
               .collect(Collectors.groupingBy(Enrollment::getcourseCategory,Collectors.counting()));
    }
    
}
