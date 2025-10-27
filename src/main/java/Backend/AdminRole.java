/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.*;
import java.util.*;

/**
 *
 * @author engom
 */
public class AdminRole {
    private ArrayList<Student> students = new ArrayList<>();
    private String filename;

    public AdminRole(String filename) {
        this.filename = filename;
    }
    public Student createStudentFromString(String line){
       String[] parts=line.split(",");
       int ID=Integer.parseInt(parts[0]);
       int age=Integer.parseInt(parts[2]);
       double gpa=Double.parseDouble(parts[5]);
      return new Student(ID,parts[1],age,parts[3],parts[4],gpa);
    }
    public void readFromFile() throws FileNotFoundException {
        students.clear();
        Scanner input = new Scanner(new File(filename));

        while (input.hasNextLine()) {
            String line = input.nextLine();
            Student st = createStudentFromString(line);
            students.add(st);
        }

        input.close();
    }
    public void saveToFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        for (Student st : students) {
            writer.println(st.lineRepresentation());
        }
        writer.close();
    }
    public ArrayList<Student> returnAllStudents(){
        return students;
    }
    public Student[] viewStudents() throws FileNotFoundException{
        readFromFile();
        ArrayList<Student> students = returnAllStudents();
        Student[] sts=new Student[students.size()];
        for(int i=0;i<students.size();i++){
          sts[i] = (Student) students.get(i);  
        }
       return sts; 
    }
    public void addStudent(int ID, String name, int age, String gender, String department, double GPA) throws FileNotFoundException {
    readFromFile();
    if (contains(ID)) {
        System.out.println("Error: Student with ID " + ID + " already exists.");
        return;
    }

    Student s = new Student(ID, name, age, gender, department, GPA);
    students.add(s);

    saveToFile();
    System.out.println("Student added successfully!");
}

    public boolean contains(int key) {
        for (Student s : students) {
            if (s.getStudentID()== key) {
                return true;
            }
        }
        return false;
    }
    public void deleteStudent(int ID) throws FileNotFoundException {
    if (!contains(ID)) {
        System.out.println("ID not found!");
        return;
    }

    Scanner s = new Scanner(System.in);
    System.out.println("Are you sure you want to delete? Enter yes or no");
    String input = s.nextLine();

    if (input.equals("yes")) {
        if (removeStudent(ID)) {
            saveToFile();  // Save the updated list after removal
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Failed to delete student.");
        }
    } else {
        System.out.println("Deletion canceled.");
    }
}

  

    public boolean removeStudent(int key) {
        Iterator<Student> iter = students.iterator();
        while (iter.hasNext()) {
            Student s = iter.next();
            if (s.getStudentID()==key) {
                iter.remove();
                return true;
            }
        }
        return false;
    }
    public void updateStudent(int ID, String newName, int newAge, String newGender, String newDepartment, double newGPA) throws FileNotFoundException {
    readFromFile();
    for (Student s : students) {
        if (s.getStudentID() == ID) {
            s.setStudentName(newName);
            s.setAge(newAge);
            s.setDepartment(newDepartment);
            s.setGPA(newGPA);
            saveToFile();
            System.out.println("Student updated successfully!");
            return;
        }
    }
    System.out.println("Student with ID " + ID + " not found.");
}
    public void searchStudent(String query) throws FileNotFoundException {
    readFromFile();
    ArrayList<Student> results = new ArrayList<>();

    if (query.matches("\\d+")) {
        int searchID = Integer.parseInt(query);
        for (Student s : students) {
            if (s.getStudentID() == searchID) {
                results.add(s);
            }
        }
    } else {
        for (Student s : students) {
            if (s.getStudentName().toLowerCase().contains(query.toLowerCase())) {
                results.add(s);
            }
        }
    }

    if (results.isEmpty()) {
        System.out.println("No students found.");
    } else {
        System.out.println("Search Results:");
        for (Student s : results) {
            System.out.println(s.lineRepresentation());
        }
    }
}
 
}
