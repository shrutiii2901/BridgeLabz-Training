public class Enrollment {
    private String name;
    private String courseName;
    private String courseCategory;
    private String enrollmentDate;

    public Enrollment(String name, String courseName, String coursecategory, String enrollmentDate){
        this.name = name;
        this.courseName=courseName;
        this.courseCategory= coursecategory;
        this.enrollmentDate=enrollmentDate;
    }

    public String getName(){
        return name;
    }
    public String getcourseName(){
        return courseName;
    }
    public String getcourseCategory(){
        return courseCategory;
    }
    public String getenDate(){
        return enrollmentDate;
    }
    public String toString(){
        return name+ "|" + courseName + "|" + courseCategory + "|" + enrollmentDate + "|";
    }

    
}
