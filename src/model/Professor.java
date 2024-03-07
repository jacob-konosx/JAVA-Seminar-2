package model;

public class Professor extends Person{
    private static long idCounter = 0;
    private long p_ID;
    private Degree degree;

    public Professor(String name, String surname, Degree degree) {
        super(name, surname);
        setP_ID();
        setDegree(degree);
    }
    public Professor() {
        super();
        setP_ID();
        setDegree(Degree.bsc);
    }

    public long getP_ID() {
        return p_ID;
    }

    public void setP_ID() {
        idCounter++;
        this.p_ID = idCounter;
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
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}
