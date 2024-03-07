package model;

public class Student extends Person{
    private static long idCounter = 100000;
    private long st_ID;


    public Student(String name, String surname) {
        super(name, surname);
        setSt_ID();
    }
    public Student() {
        super();
        setSt_ID();
    }

    public long getSt_ID() {
        return st_ID;
    }

    public void setSt_ID() {
        idCounter++;
        this.st_ID = idCounter;
    }

    @Override
    public String toString() {
        return "Student{" +
                "st_ID=" + st_ID +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                '}';
    }
}
