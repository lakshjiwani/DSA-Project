package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        //Student Management System using Doubly Linked List.
        System.out.println("Welcome to the Student Management System!\n");

        MainMenu menu = new MainMenu();

        boolean quit = false;
        while(!quit) {
            menu.run();
            System.out.println("Do you want to quit?(true/false): ");
            Scanner scan = new Scanner(System.in);
            quit = scan.nextBoolean();
        }

        System.out.println("Thank you for using Student Management System. Good bye.\n");


    }
}
