package model;

public class Professor {
    private static long idCounter = 0;
    private long p_ID;
    private String name;
    private String surname;
    private Degree degree;
    public boolean checkForSpecChar(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public Professor(String name, String surname, Degree degree) {
        setP_ID();
        this.name = name;
        this.surname = surname;
        this.degree = degree;
    }
    public Professor() {
        setP_ID();
        this.name = "Name Required";
        this.surname = "Surname Required";
        this.degree = Degree.bsc;
    }

    public long getP_ID() {
        return p_ID;
    }

    public void setP_ID() {
        idCounter++;
        this.p_ID = idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (checkForSpecChar(name)) return;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (checkForSpecChar(surname)) return;
        this.surname = surname;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "p_ID=" + p_ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}
