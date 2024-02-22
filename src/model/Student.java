package model;

public class Student {
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

    public Student(long st_ID, String name, String surname) {
        this.st_ID = st_ID;
        this.name = name;
        this.surname = surname;
    }
    public Student() {
        this.st_ID = 0;
        this.name = "Name Required";
        this.surname = "Surname Required";
    }

    public long getSt_ID() {
        return st_ID;
    }

//    public void setSt_ID(long st_ID) {
//        this.st_ID = st_ID;
//    }

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
