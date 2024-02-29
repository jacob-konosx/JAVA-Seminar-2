package model;

public class Grade {
    private static long idCounter = 0;
    private long g_ID;
    private int value;
    private Student student;
    private Course course;

    public Grade(int value, Student student, Course course) {
        setG_ID();
        this.value = value;
        this.student = student;
        this.course = course;
    }
    public Grade() {
        setG_ID();
        this.value = 0;
        this.student = new Student();
        this.course = new Course();
    }

    public long getG_ID() {
        return g_ID;
    }

    public void setG_ID() {
        idCounter++;
        this.g_ID = idCounter;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value > 10 || value < 0) return;
        this.value = value;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "g_ID=" + g_ID +
                ", value=" + value +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
