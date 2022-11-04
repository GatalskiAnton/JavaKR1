import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyReader {
    public static ArrayList<Student> readStudentFromFile(File file)
    {
        ArrayList<Student> students = new ArrayList<>();
        try(Scanner sc = new Scanner(file)) {
            while(sc.hasNextLine())
            {
                Student newStudent = new Student(sc.next(), sc.nextInt(), sc.nextDouble());
                students.add(newStudent);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static ArrayList<Double> readDoublesFromFile(File file)
    {
        ArrayList<Double> doubles = new ArrayList<>();
        try(Scanner sc = new Scanner(file)) {
            while(sc.hasNextLine())
            {
                doubles.add(sc.nextDouble());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return doubles;
    }
}
