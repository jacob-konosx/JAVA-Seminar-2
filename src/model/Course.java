package model;

public class Course {
    private long c_ID;
    private String title;
    private int creditPoints;
    private Professor professor;

    public Course(long c_ID, String title, int creditPoints, Professor professor) {
        this.c_ID = c_ID;
        this.title = title;
        this.creditPoints = creditPoints;
        this.professor = professor;
    }

    public boolean checkForSpecChar(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public long getC_ID() {
        return c_ID;
    }

//    public void setC_ID(long c_ID) {
//        this.c_ID = c_ID;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (checkForSpecChar(title)) return;
        this.title = title;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        if (creditPoints < 0 || creditPoints > 10) return;
        this.creditPoints = creditPoints;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "c_ID=" + c_ID +
                ", title='" + title + '\'' +
                ", creditPoints=" + creditPoints +
                ", professor=" + professor +
                '}';
    }
}
