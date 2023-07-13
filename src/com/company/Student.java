package com.company;

import java.io.Serializable;

public class Student implements Serializable {

    private int studentID;
    private String studentName;
    private float gpa;
    private String department;
    private String enrolmentDate;

    public Student(int studentID, String studentName, float gpa, String department, String enrolmentDate) {
        setStudentID(studentID);
        setStudentName(studentName);
        setGpa(gpa);
        setDepartment(department);
        setEnrolmentDate(enrolmentDate);
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {

        if(gpa >= 1 && gpa <= 4) {
            this.gpa = gpa;
        }
        else {
            System.out.println("Invalid GPA.");
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(String enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }


    public void display(){
        System.out.println("Student ID: " + getStudentID() + "\t Name: " + getStudentName() + "\t\tGPA: " + getGpa() + "\tDepartment: " + getDepartment() +
                "\tEnrolment Date: " + getEnrolmentDate() + "\n");
    }

    @Override
    public String toString() {
        return this.studentName;
    }

}
