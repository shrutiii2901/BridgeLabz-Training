class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    public void setCGPA(double c) {
        cgpa = c;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class PostgraduateStudent extends Student {
    void display() {
        System.out.println(rollNumber + " " + name);
    }
}
