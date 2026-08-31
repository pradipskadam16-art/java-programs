import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String course;
    double marks;

    Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }

    void displayStudent() {
        System.out.println("--------------------------------");
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Course     : " + course);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + getGrade());
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check duplicate ID
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks! Enter marks between 0 and 100.");
            return;
        }

        Student student = new Student(id, name, age, course, marks);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    // View Students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== ALL STUDENTS =====");

        for (Student s : students) {
            s.displayStudent();
        }
    }

    // Search Student
    static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {
                System.out.println("\nStudent Found!");
                s.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update Student
    static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {

            if (s.id == id) {

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                System.out.print("Enter New Marks: ");
                double marks = sc.nextDouble();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks!");
                    return;
                }

                s.marks = marks;

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete Student
    static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Main Menu
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
