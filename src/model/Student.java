package model;

public class Student {
    private static long idCounter = 100000;
    private long st_ID;
    private String name;
    private String surname;
    public boolean checkForSpecChar(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public Student(String name, String surname) {
        setSt_ID();
        setName(name);
        setSurname(surname);
    }
    public Student() {
        setSt_ID();
        this.name = "Name Required";
        this.surname = "Surname Required";
    }

    public long getSt_ID() {
        return st_ID;
    }

    public void setSt_ID() {
        idCounter++;
        this.st_ID = idCounter;
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

    @Override
    public String toString() {
        return "Student{" +
                "st_ID=" + st_ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
