package Practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class studentControl {
    String url = "jdbc:mysql://localhost:3306/studentClass";
    String use = "root";
    String pass = "";

    List<student> studentList = new ArrayList<>();

    public List<student> loadStudent() {
        try (
                Connection conn = DriverManager.getConnection(url, use, pass);
                Statement stmt = conn.createStatement();
        ) {
            String select = "Select * from student";
            ResultSet rSet = stmt.executeQuery(select);
            while (rSet.next()) {
                String id = rSet.getString("studentID");
                String name = rSet.getString("Name");
                String address = rSet.getString("Address");
                String phone = rSet.getString("Phone");

                student objStudent = new student(id, name, address, phone);
                studentList.add(objStudent);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    public void displayStudent() {

        try (
                Connection conn = DriverManager.getConnection(url, use, pass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "Select * from student";
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            ResultSetMetaData rsetMD = rSet.getMetaData();
            int numColums = rsetMD.getColumnCount();
            for (int i = 1; i <= numColums; i++) {
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            loadStudent();
            System.out.println();
            while (rSet.next()) {
                for (int i = 1; i <= numColums; i++) {
                    System.out.printf("%-30s", rSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void displayRecord() {
        Iterator<student> StudentsIterator = studentList.iterator();
        while (StudentsIterator.hasNext()) {
            student student1 = StudentsIterator.next();
            System.out.println(student1);
        }
    }

    public void addStudent() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter student ID:");
        String id = input.nextLine();

        System.out.println("Enter student name: ");
        String name = input.nextLine();

        System.out.println("Enter student address: ");
        String address = input.nextLine();

        System.out.println("Enter student phone number: ");
        String phone = input.next();

        student objStudent = new student(id, name, address, phone);
        studentList.add(new student(objStudent.getStudentID(), objStudent.getStudentName(), objStudent.getAddress(), objStudent.getPhone()));
    }

    public void insertStudent(student students) {
        try (
                Connection conn = DriverManager.getConnection(url, use, pass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlInsert = "Insert into student values (' "
                    + students.getStudentID() + "','"
                    + students.getStudentName() + "','"
                    + students.getAddress() + "','"
                    + students.getPhone() + "')";
            stmt.executeUpdate(sqlInsert);
            System.out.println("Inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveStudent(){
            Iterator<student> studentIterator = studentList.iterator();
            while (studentIterator.hasNext()) {
                student objStudent = studentIterator.next();
                insertStudent(objStudent);
            }
            displayRecord();
    }


}
