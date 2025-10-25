/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author engom
 */
public class Student {
    private int studentID;
    private String studentName;
    private int age;
    private String gender;
    private String department;
    private double GPA;

    public Student(int studentID, String studentName, int age, String gender, String department, double GPA) {
        this.studentID = studentID;
        setStudentName(studentName);
        setAge(age);
        setGender(gender);
        setDepartment(department);
        setGPA(GPA);
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0 || age>150){
            throw new IllegalArgumentException("Age must be between 0 and 150.");
        }
        this.age = age;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        if(GPA<0 || GPA>4){
            throw new IllegalArgumentException("GPA must be between 0 and 4 inclusive.");
        }
        this.GPA=GPA;
            
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setStudentName(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be empty.");
    }
        this.studentName = studentName;
    }
    public String lineRepresentation(){
        return studentID + "," + studentName +"," + age + "," + gender + "," + department + "," + GPA;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty.");
        }
        this.department = department;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Gender cannot be empty.");
        }
        this.gender = gender;
    }
    
    
}
