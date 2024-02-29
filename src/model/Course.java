package model;

public class Course {
    private static long idCounter = 100000;
    private long c_ID;
    private String title;
    private int creditPoints;
    private Professor professor;

    public Course(String title, int creditPoints, Professor professor) {
        setC_ID();
        setTitle(title);
        setCreditPoints(creditPoints);
        setProfessor(professor);
    }
    public Course() {
        setC_ID();
        this.title = "Title Required";
        this.creditPoints = 1;
        this.professor = new Professor();
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

    public void setC_ID() {
        idCounter++;
        this.c_ID = idCounter;
    }

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
        if (creditPoints < 0 || creditPoints > 20) return;
        this.creditPoints = creditPoints;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor != null)
            this.professor = professor;
        else
            this.professor = new Professor();
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
