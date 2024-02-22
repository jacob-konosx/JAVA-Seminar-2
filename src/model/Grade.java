package model;

public class Grade {
    private long g_ID;
    private int value;
    private Student student;
    private Course course;

    public Grade(long g_ID, int value, Student student, Course course) {
        this.g_ID = g_ID;
        this.value = value;
        this.student = student;
        this.course = course;
    }

    public long getG_ID() {
        return g_ID;
    }

//    public void setG_ID(long g_ID) {
//        this.g_ID = g_ID;
//    }

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
