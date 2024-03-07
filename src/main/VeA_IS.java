package main;

import model.*;

import java.util.ArrayList;

public class VeA_IS {
    public static ArrayList<Professor> allProfessors = new
            ArrayList<>();
    public static ArrayList<Student> allStudents = new
            ArrayList<>();
    public static ArrayList<Grade> allGrades = new
            ArrayList<>();
    public static ArrayList<Course> allCourses = new
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
            if (course.getProfessor().equals(professor)){
                howMany++;
            }
        }

        if (howMany == 0) throw new Exception("Profesor has no courses");
        return howMany;
    }

    public static void main(String[] args){
        Professor prof1 = new Professor("Jēkabs!", "Voltisz", Degree.phd);
        Professor prof2 = new Professor("Toms", "Balish", Degree.phd);
        allProfessors.add(prof2);
        allProfessors.add(prof1);

        Student stud1 = new Student("Endijs", "Bertāns");
        Student stud2 = new Student("Danjels", "Burkēvičs");
        allStudents.add(stud2);
        allStudents.add(stud1);

        Course course1 = new Course("Matene", 4, prof1);
        Course course2 = new Course("Anglene", 2, prof2);
        allCourses.add(course1);
        allCourses.add(course2);

        Grade grade1 = new Grade(4, stud1, course1);
        Grade grade2 = new Grade(10, stud1, course2);
        allGrades.add(grade1);
        allGrades.add(grade2);

        try{
            System.out.println(calcAvgGrade(stud1));
            System.out.println(getProfCourseCount(prof1));

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
