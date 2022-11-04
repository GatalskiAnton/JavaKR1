import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student implements Comparable<Student> {
  private   String surname;
  private   int course;
  private   double GPA;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public Student(String surname, int course, double GPA) {
        this.surname = surname;
        this.course = course;
        this.GPA = GPA;
    }


    @Override
    public int compareTo(Student o) {
        return (int)(this.getGPA() - ((Student)o).getGPA());
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", course=" + course +
                ", GPA=" + GPA +
                '}';
    }
}

