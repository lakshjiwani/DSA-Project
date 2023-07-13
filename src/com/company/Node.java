package com.company;

import java.io.Serializable;

public class Node implements Serializable {

    private final Student student;
    public Node next;
    public Node previous;

    public Node(Student value){
        this.student = value;
    }

    public Student getStudent() {
        return student;
    }





    @Override
    public String toString() {
        return getStudent().getStudentName();
    }


    public void display(){
        getStudent().display();
    }
}
