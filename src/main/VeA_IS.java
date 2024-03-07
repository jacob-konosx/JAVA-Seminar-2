package main;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class VeA_IS {
//    public static ArrayList<Professor> allProfessors = new
//            ArrayList<>();
//    public static ArrayList<Student> allStudents = new
//            ArrayList<>();
    public static ArrayList<Grade> allGrades = new
            ArrayList<>();
    public static ArrayList<Course> allCourses = new
            ArrayList<>();
    public static ArrayList<Person> allPeople = new
            ArrayList<>();

    public static float calcAvgGrade(Student stud) throws Exception{
        if (stud == null) throw new Exception("Invalid student input");
        float sum = 0;
        int howMany = 0;
        for (Grade tempGr: allGrades){
            if (tempGr.getStudent().equals(stud)){
                sum += tempGr.getValue();
                howMany++;
            }
        }
        if (howMany == 0) throw new Exception("Student has no grades");
        return sum/howMany;
    }
    public static float calcWeightedAvgGrade(Student stud) throws Exception{
        if (stud == null) throw new Exception("Invalid student input");
        float sum = 0;
        int howManyCP = 0;
        for (Grade tempGr: allGrades){
            if (tempGr.getStudent().equals(stud)){
                sum += tempGr.getValue() * tempGr.getCourse().getCreditPoints();
                howManyCP += tempGr.getCourse().getCreditPoints();
            }
        }
        if (howManyCP == 0) throw new Exception("Student has no grades");
        return sum/howManyCP;
    }
    public static float calcAvgCourseGrade(Course course) throws Exception{
        if (course == null) throw new Exception("Invalid student input");
        float sum = 0;
        int howMany = 0;

        for (Grade tempGr: allGrades){
            if (tempGr.getCourse().equals(course)){
                sum += tempGr.getValue();
                howMany++;
            }
        }

        if (howMany == 0) throw new Exception("Student has no grades");
        return sum/howMany;
    }
    public static int getProfCourseCount(Professor professor) throws Exception{
        if (professor == null) throw new Exception("Invalid professor input");
        int howMany = 0;

        for (Course course: allCourses){
            if (course.getProfessors().contains(professor)){
                howMany++;
            }
        }

        if (howMany == 0) throw new Exception("Profesor has no courses");
        return howMany;
    }

    public static ArrayList<Student> sortStudByAvgGrade() throws Exception{
        if (allPeople.isEmpty()) throw new Exception("No students in array");
        if (allGrades.isEmpty()) throw new Exception("No grades in array");
        ArrayList<Student> result = new ArrayList<Student>();
        for (Person st: allPeople){
            try {
                if (st instanceof Student){
                    calcAvgGrade((Student) st);
                    result.add((Student) st);
                }

            }catch (Exception e){
                System.out.println(e);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size() - 1; j++) {
                if (calcAvgGrade(result.get(j)) > calcAvgGrade(result.get(j+1))){
                    Student tempStudent = result.get(j);
                    result.set(j, result.get(j+1));
                    result.set(j+1, tempStudent);
                }
            }
        }
        return result;
    }

    public static void createStudent(String name, String surname)throws Exception{
        if (name == null || surname == null) throw new Exception("Invalid input/s");

        for (Person stud: allPeople){
            if (stud instanceof Student){
                if (stud.getName().equals(name) && stud.getSurname().equals(surname)){
                    throw new Exception("Student with this name and surname already exists");
                }
            }

        }
        Student newStudent = new Student(name, surname);
        allPeople.add(newStudent);
    }

    public static Student getStudentBySurname(String surname)throws Exception{
        if (surname == null) throw new Exception("Invalid surname input");
        for (Person student: allPeople){
            if (student.getSurname().equals(surname) && student instanceof Student) return (Student) student;
        }
        throw new Exception("No student with this surname");
    }
    public static void updateStudentByNameAndSurname(String name, String surname, String newSurname) throws Exception{
        if (name == null || surname == null || newSurname == null) throw new Exception("Invalid input/s");
        for (Person stud: allPeople){
            if (stud instanceof Student && stud.getName().equals(name) && stud.getSurname().equals(surname) && !stud.getSurname().equals(newSurname)){
                stud.setSurname(newSurname);
                break;
            }
        }
        throw new Exception("Student aint in system");
    }
    public static void deleteStudentByNameAndSurname(String name, String surname) throws Exception{
        if (name == null || surname == null) throw new Exception("Invalid input/s");
        for (Person stud: allPeople){
            if (stud instanceof Student && stud.getName().equals(name) && stud.getSurname().equals(surname)){
                allPeople.remove(stud);
                break;
            }
        }
        throw new Exception("Student aint in system");
    }
    public static void main(String[] args){
        Professor prof1 = new Professor("Jēkabs!", "Voltisz", Degree.phd);
        Professor prof2 = new Professor("Toms", "Balish", Degree.phd);
//        allProfessors.add(prof2);
//        allProfessors.add(prof1);

        Student stud1 = new Student("Endijs", "Bertāns");
        Student stud2 = new Student("Danjels", "Burkēvičs");
//        allStudents.add(stud2);
//        allStudents.add(stud1);
        allPeople.add(prof1);
        allPeople.add(prof2);
        allPeople.add(stud1);
        allPeople.add(stud2);

        Course course1 = new Course("Matene", 4, new ArrayList<Professor>(Arrays.asList(prof1)));
        Course course2 = new Course("Anglene", 2, new ArrayList<Professor>(Arrays.asList(prof2)));
        allCourses.add(course1);
        allCourses.add(course2);

        Grade grade1 = new Grade(4, stud1, course1);
        Grade grade2 = new Grade(10, stud2, course2);
        allGrades.add(grade1);
        allGrades.add(grade2);

        try{
            System.out.println(getProfCourseCount(prof1));
                for (Person person: allPeople){
                    if (person instanceof Student) System.out.println(person);
                }
            System.out.println();
//            System.out.println(calcAvgGrade(stud1));
//            System.out.println(getProfCourseCount(prof1));
            ArrayList<Student> sortedStudents = sortStudByAvgGrade();
            for (Student student: sortedStudents){
                System.out.println(student);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
