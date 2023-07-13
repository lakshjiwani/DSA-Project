package com.company;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {

    private Node head;
    private Node tail;
    private int length;
    private final File file = new File("Student.txt");

    public StudentList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void bubbleSort(){
        int swapped,i;
        Node ptr1;
        Node lptr = null;

        if(head == null){
            return;
        }
        System.out.println("\nBubble Sort:\n");
        do{
            swapped = 0;
            ptr1 = head;
            while(ptr1.next != lptr){
                if(ptr1.getStudent().getStudentID() > ptr1.next.getStudent().getStudentID()){
                    int t = ptr1.getStudent().getStudentID();
                    ptr1.getStudent().setStudentID(ptr1.next.getStudent().getStudentID());
                    ptr1.next.getStudent().setStudentID(t);
                    swapped = 1;
                }
                System.out.println(ptr1.getStudent().getStudentID());
                ptr1 = ptr1.next;

            }
            lptr = ptr1;
           // ptr1.getStudent().display();
        }
        while (swapped != 0);
        //System.out.println(ptr1.getStudent().getStudentID());
    }




    public void insertLast(Student student){
        Node node = new Node(student);
        if(isEmpty()){
            head =node;
            tail = node;
        }
        else {
            tail.next = node;
            node.previous = tail;
            tail = node;
            tail.next = null;
        }
        length++;
    }

    public void insertFirst(Student student){
        Node node = new Node(student);

        if(isEmpty()){
            tail = node;
        }
        else {
            head.previous = node;
            node.next = head;
            head = node;
        }
    }

    public void updateNode(int id){
        Node temp = head;
        while (temp != null && temp.getStudent().getStudentID() != id){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Not found\n");
        }
        else {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nWhat do you want to update? [N]ame,[G]PA,[D]epartment or [E]nrolment Date");
            char x = sc.next().charAt(0);
            switch (x){
                case 'N':
                case 'n':
                    System.out.println("Enter Name to update: ");
                    String name = sc.next();
                    temp.getStudent().setStudentName(name);
                    break;
                case 'G':
                case 'g':
                    System.out.println("Enter GPA to update: ");
                    float gpa = sc.nextFloat();
                    temp.getStudent().setGpa(gpa);
                    break;
                case 'D':
                case 'd':
                    System.out.println("Enter Department to update: ");
                    String department = sc.next();
                    temp.getStudent().setDepartment(department);
                    break;
                case 'E':
                case 'e':
                    System.out.println("Enter Enrolment Date: ");
                    String date = sc.next();
                    temp.getStudent().setEnrolmentDate(date);
                default:
                    System.out.println("\nEnter valid symbol");
                    break;
            }
        }

    }


    public void insertAt(Student student, int position){
        Node node = new Node(student);
        if(position < 0 || position < length){
            //if(head == null){
            System.out.println("Invalid position.");
            //throw new IllegalArgumentException();
        }
        else if(position == 0){
            insertFirst(student);
        }
        else {
            Node temp = head;
            for(int i = 0; i< position - 1; i++){
                if(temp != null){
                    temp = temp.next;
                }
            }
            if(temp != null){
                node.next = temp.next;
                node.previous = temp;
                temp.next = node;
                if(node.next != null){
                    node.next.previous = node;
                }
                else {
                    System.out.println("\nThe previous node is null.");
                }
            }
            length++;
        }
    }


    public Node searchNodebyID(int value){
        int counter =0;

        Node node = head;
        if(head == null){
            System.out.println("\nList is empty\n");
            return null;
        }
        while (node != null){
            if(node.getStudent().getStudentID() == value){
                return node;
            }
            node = node.next;
            counter++;
        }
        return null;
    }


    public Node searchNodebyName(String value){
        int counter = 0;

        Node node = head;
        if(head == null){
            System.out.println("\nList is empty.\n");
            return null;
        }
        while(node != null){
            if(node.getStudent().getStudentName().equals(value)){
                return node;
            }
            node = node.next;
            counter++;
        }
        return null;
    }


    public void deleteFirst(){
        if(head == null){
            throw new RuntimeException("\nList is empty.\n");
        }
        if(head.next == null){
            tail = null;
        }
        else {
            head.next.previous = null;
        }
        head = head.next;
        length--;
    }


    public void deleteLast(){
        if(tail == null){
            throw new RuntimeException("\nList is empty.\n");
        }
        if(head.next == null){
            head = null;
        }
        else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        length--;
    }


    public void deleteByID(int value){
        if(isEmpty()){
            System.out.println("\nList is empty. Cannot delete " + value + "\n");
            return;
        }
        else {
            Node node = head;
            while(node != null){
                if(node.getStudent().getStudentID() == value){
                    if(node == head){
                        deleteFirst();
                        System.out.println(value + " deleted.\n");
                        return;
                    }
                    else if(node == tail){
                        deleteLast();
                        System.out.println( value + " deleted.\n");
                        return;
                    }
                    else {
                        System.out.println(value + " deleted.\n");
                        node.next.previous = node.previous;
                        node.previous.next = node.next;
                        node = null;
                    }
                    length--;
                    return;
                }
                node = node.next;
            }
        }
        System.out.println("\nList does not contain Student ID: " + value + "\n");
    }

    public void deleteByName(String value){
        if(isEmpty()){
            System.out.println("List is empty. Cannot delete " + value + "\n");
            return;
        }
        else {
            Node node = head;
            while(node != null){
                if(node.getStudent().getStudentName().equals(value)){
                    if(node == head){
                        deleteFirst();
                        System.out.println(value + " deleted.\n");
                        return;
                    }
                    else if(node == tail){
                        deleteLast();
                        System.out.println(value + " deleted.\n");
                        return;
                    }
                    else {
                        System.out.println(value + " deleted.\n");
                        node.next.previous = node.previous;
                        node.previous.next = node.next;
                        node = null;
                    }
                    length--;
                    return;
                }
                node = node.next;
            }
        }
        System.out.println("\nList does not contain Student name : " + value + "\n");
    }


    public void display(){
        Node node = head;
        while (node != null){
            node.display();
            node = node.next;
        }
    }


    @Override
    public String toString(){
        String studentList = "Students: \n";
        Node node = this.head;
        while(node != null){
            studentList += node;
            if(node.next != null){
                studentList += " , ";
            }
            node = node.next;
        }
        return studentList;
    }


    public void writeToFile() throws IOException{
        FileOutputStream outFile = new FileOutputStream(file);
        ObjectOutputStream OOutput = new ObjectOutputStream(outFile);
        ArrayList<Node> list = new ArrayList<>();
        Node n = head;
        while(n != null){
            if(!list.contains(n))
                list.add(n);
            else
                System.out.println("Student already enrolled");
            n= n.next;
        }
        OOutput.writeObject(list);
        OOutput.close();
    }

    public boolean readFromFile(){
        try{
            FileInputStream inFile = new FileInputStream(file);
            ObjectInputStream OInput = new ObjectInputStream(inFile);
            ArrayList<Node> list;
            list = (ArrayList<Node>) OInput.readObject();
            if(list.size() > 0) {
                head = list.get(0);
                tail = list.get(0);
                if(list.size() > 1) {
                    for (int i = 1; i < list.size(); i++) {
                        Node node = list.get(i);
                        tail.next = node;
                        node.previous = tail;
                        tail = node;
                        tail.next = null;
                    }
                }
            }else
                System.out.println("List is Empty");

            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }

    }

}

