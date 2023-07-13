package com.company;


import java.util.Scanner;

public class MainMenu {

    private final StudentList studentList;


    public MainMenu() {
        this.studentList = new StudentList();

    }

    public void run(){
        studentList.readFromFile();
        boolean finished = false;
        do{
            int choice = displayStudentListMenu();
            switch (choice){
                case 1:
                    displayStudentDetails();
                    break;
                case 2:
                    addStudentToList();
                    break;
                case 3:
                    addStudentAtPos();
                    break;
                case 4:
                    int searchBy = displaySearchMenu();
                    switch (searchBy){
                        case 1:
                            searchStudentFromList("ID");
                            break;
                        case 2:
                            searchStudentFromList("Name");
                            break;
                        default:
                            run();
                            break;
                    }
                    break;
                case 5:
                    int deleteBy = displayDeleteMenu();
                    switch (deleteBy){
                        case 1:
                            deleteStudentFromList("ID");
                            break;
                        case 2:
                            deleteStudentFromList("Name");
                            break;
                        default:
                            run();
                            break;
                    }
                    break;
                case 6:
                    updateDetail();
                    break;
                case 7:
                    studentList.bubbleSort();
                    break;
                case 8:
                    try{
                        studentList.writeToFile();
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    finished = true;
            }
        } while (!finished);
    }

    private int displayStudentListMenu(){
        InputHelper inputHelper = new InputHelper();
        System.out.println(" 1 - Display Details \n 2 - Add a new Student\n 3 - Insert a Student\n " +
                "4 - Search a Student\n 5 - Delete a Student\n 6 - Update Details\n 7 - Exit\n");
        return  inputHelper.readInt("\nEnter choice");
    }

    private int displaySearchMenu(){
        InputHelper inputHelper = new InputHelper();
        System.out.println("\n 1 - Search by Student ID\n 2 - Search by Student Name\n 3 - Exit");
        return  inputHelper.readInt("Enter choice.");
    }

    private int displayDeleteMenu(){
        InputHelper inputHelper = new InputHelper();
        System.out.println("\n 1 - Delete by Student ID\n 2 - Delete by Student Name\n 3 - Exit");
        return  inputHelper.readInt("Enter choice.");
    }



    private void displayStudentDetails(){
        if(this.studentList.getLength() == 0){
            System.out.println("\nNew List is empty\n");
        }
        this.studentList.display();
        this.studentList.bubbleSort();
    }

    private void addStudentToList(){
        InputHelper inputHelper = new InputHelper();
        int ID = inputHelper.readInt("Enter Student ID: eg.: 1001");
        String name = inputHelper.readString("Enter Student Name");
        float GPA = inputHelper.readFloat("Enter GPA");
        String department = inputHelper.readString("Enter Department");
        String enrolmentDate = inputHelper.readDate("Enter the date of enrolment.(Format: DD/MM/YYYY)");

        Student studentToAdd = new Student(ID,name,GPA,department,enrolmentDate);
        studentList.insertLast(studentToAdd);
        System.out.println("\nStudent " + ID + " added.\n");
    }

    private void addStudentAtPos(){
        InputHelper inputHelper = new InputHelper();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position: ");
        int position = sc.nextInt();
        if(studentList.getLength() < position) {
            System.out.println("Invalid position.");
        }
        else{
            int ID = inputHelper.readInt("Enter Student ID: eg.: 1001");
            String name = inputHelper.readString("Enter Student Name");
            float GPA = inputHelper.readFloat("Enter GPA");
            String department = inputHelper.readString("Enter Department");
            String enrolmentDate = inputHelper.readDate("Enter the date of enrolment.(Format: DD/MM/YYYY)");
            Student studentToAdd = new Student(ID,name,GPA,department,enrolmentDate);
            studentList.insertAt(studentToAdd, position);
        }
    }


    private void searchStudentFromList(String type){
        InputHelper inputHelper = new InputHelper();
        try{
            if(type.equals("ID")){
                int ID = inputHelper.readInt("Enter valid Student ID. eg.: 1001");
                this.studentList.searchNodebyID(ID).getStudent().display();
            }
            else {
                String name = inputHelper.readString("Enter Student Name");
                this.studentList.searchNodebyName(name).getStudent().display();
            }
        } catch (Exception e){
            System.out.println("\nInvalid Search (Name or ID is incorrect.)\n");
        }
    }


    private void updateDetail(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID: ");
        int ID = sc.nextInt();
        studentList.updateNode(ID);
    }

    private void deleteStudentFromList(String type){
        InputHelper inputHelper = new InputHelper();
        if(type.equals("ID")){
            int ID = inputHelper.readInt("Enter valid Student ID eg.: 1001");
            this.studentList.deleteByID(ID);
        }
        else {
            String name = inputHelper.readString("Enter valid Student Name");
            this.studentList.deleteByName(name);
        }
    }



}
