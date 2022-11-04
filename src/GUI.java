import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.Reader;

public class GUI extends JFrame {

    private Container<Student> students;
    private Container<Double> doubles;

    private JPanel studentInfoPanel;
    private JPanel doubleInfoPanel;


    JTextArea studentsTable;

    JTextArea doublesTable;

    JButton openButtonStudent;
    JButton maxButtonStudent;
    JButton minButtonStudent;

    JButton openButtonDouble;
    JButton maxButtonDouble;
    JButton minButtonDouble;


    public GUI(String title) throws HeadlessException {
        super(title);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(700, 700));

        addStudentPanel();
        addDoublePanel();
        addCentralPanel();
    }


    private void addCentralPanel()
    {
        JPanel centralPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centralPanel.add(studentInfoPanel);
        centralPanel.add(doubleInfoPanel);

        centralPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        add(centralPanel, BorderLayout.CENTER);
    }
    private void addStudentPanel() {
        studentInfoPanel = new JPanel(new BorderLayout());
        studentInfoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Student"));
        addButtonStudent();


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButtonStudent);
        buttonPanel.add(maxButtonStudent);
        buttonPanel.add(minButtonStudent);
        studentInfoPanel.add(buttonPanel, BorderLayout.NORTH);

        studentsTable = new JTextArea(" Info here", 10, 10);
        studentInfoPanel.add(studentsTable, BorderLayout.CENTER);
    }

    private void addDoublePanel() {
        doubleInfoPanel = new JPanel(new BorderLayout());
        doubleInfoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Double"));
        addButtonDouble();

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButtonDouble);
        buttonPanel.add(maxButtonDouble);
        buttonPanel.add(minButtonDouble);
        doubleInfoPanel.add(buttonPanel, BorderLayout.NORTH);

        doublesTable = new JTextArea(" Info here", 10, 10);
        doubleInfoPanel.add(doublesTable, BorderLayout.CENTER);
    }


    private void addButtonStudent() {
        openButtonStudent = new JButton("Open Students");
        openButtonStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int value = fileChooser.showDialog(null, "Select");
                if (value == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    students = new Container<>(MyReader.readStudentFromFile(selectedFile));
                    studentsTable.setText(students.toString());
                }
            }
        });
        maxButtonStudent = new JButton("Max");
        maxButtonStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Max " + students.max().toString());
                } catch (NullPointerException exception) {
                    JOptionPane.showMessageDialog(null, "File doesn`t open");
                }

            }
        });
        minButtonStudent = new JButton("Min");
        minButtonStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Min " + students.min().toString());
                } catch (NullPointerException exception) {
                    JOptionPane.showMessageDialog(null, "File doesn`t open");
                }
            }
        });
    }

    private void addButtonDouble() {
        openButtonDouble = new JButton("Open Doubles");
        openButtonDouble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int value = fileChooser.showDialog(null, "Select");
                if (value == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    doubles = new Container<>(MyReader.readDoublesFromFile(selectedFile));
                    doublesTable.setText(doubles.toString());
                }
            }
        });
        maxButtonDouble = new JButton("Max");
        maxButtonDouble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Max " + doubles.max().toString());
                } catch (NullPointerException exception) {
                    JOptionPane.showMessageDialog(null, "File doesn`t open");

                }
            }
        });
        minButtonDouble = new JButton("Min");
        minButtonDouble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Min " + doubles.min().toString());
                } catch (NullPointerException exception) {
                    JOptionPane.showMessageDialog(null, "File doesn`t open");
                }
            }
        });
    }

}
