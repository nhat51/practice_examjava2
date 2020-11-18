package Practice;

import java.util.Scanner;

public class StudentView {
    public static void main(String[] args) {
        studentControl objControl = new studentControl();
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to student manager");

        do {
            System.out.println("==================");
            System.out.println("1.Add student record");
            System.out.println("2.Display student records");
            System.out.println("3.Save");
            System.out.println("4.Exit");
            System.out.println("Your choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    objControl.addStudent();
                case 2:
                    objControl.displayRecord();
                case 3:
                    objControl.saveStudent();
            }
        }while (choice != 4);
    }
}
