package com.company;

import java.util.Scanner;

public class InputHelper {

    private final Scanner read;

    public InputHelper() {
        read = new Scanner(System.in);
    }


    public String readString(String prompt) {
        String inputText;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            inputText = read.nextLine();
            String[] a = inputText.split(inputText);
            for (String c: a) {
                if (c.isBlank()) {
                    inputError = true;
                    System.out.println("Invalid entry. Try again. ");
                }
            }
        } while ( inputError );
        return inputText;
    }


    public String readDate(String prompt) {
        String inputText;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            inputText = read.nextLine();
            String[] a = inputText.split(inputText);
            for (String c: a) {
                if (c.isBlank() && c.isEmpty()) {
                    inputError = true;
                    System.out.println("Invalid entry. Try again. ");
                }
            }
            for (char c: inputText.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    inputError = true;
                    System.out.println("Contains alphabets. Try Again. ");
                }
            }
        } while ( inputError );
        return inputText;
    }


    public int readInt(String prompt) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(read.nextLine());
            } catch(NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number. Try again. ");
            }
        } while ( inputError );
        return inputNumber;
    }

    public float readFloat(String prompt) {
        float inputNumber = 0.0f;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Float.parseFloat(read.nextLine());
            } catch(NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number. Try again. ");
            }
        } while ( inputError );
        return inputNumber;
    }

}
