package Backend;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        AdminRole admin = new AdminRole("Students.txt");

        boolean running = true;

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: {
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();

                    try {
                        admin.addStudent(id, name, age, gender, department, gpa);
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter Student ID to Update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Gender: ");
                    String newGender = scanner.nextLine();
                    System.out.print("Enter New Department: ");
                    String newDepartment = scanner.nextLine();
                    System.out.print("Enter New GPA: ");
                    double newGPA = scanner.nextDouble();

                    try {
                        admin.updateStudent(id, newName, newAge, newGender, newDepartment, newGPA);
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter Student ID to Delete: ");
                    int id = scanner.nextInt();

                    admin.deleteStudent(id);
                    break;
                }
                case 4: {
                    System.out.print("Enter Name or ID to Search: ");
                    String query = scanner.nextLine();

                    try {
                        admin.searchStudent(query);
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case 5: {
                    try {
                        Student[] students = admin.viewStudents();
                        if (students.length == 0) {
                            System.out.println("No students found.");
                        } else {
                            System.out.println("All Students:");
                            for (Student student : students) {
                                System.out.println(student.lineRepresentation());
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case 6: {
                    running = false;
                    System.out.println("Exiting...");
                    break;
                }
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}
