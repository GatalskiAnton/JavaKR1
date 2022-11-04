import java.io.File;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Hatalski", 2, 5.3);
        Student s2 = new Student("Allenikov", 2, 6.7);
        Student s3 = new Student("Videvich", 2, 6);
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Container<Student> container = new Container<>(students);
        Student min = container.min();
        Student max = container.max();


        ArrayList<Double> doubles  = MyReader.readDoublesFromFile(new File("inDouble.txt"));
        ArrayList<Student> students1 = MyReader.readStudentFromFile(new File("inStudent.txt"));

        GUI frame = new GUI("Info");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
