package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Scanner scan = new Scanner(System.in);
        int userInput;
        //System.out.println("test");
        board.outputBoard();
        System.out.print("Which column would you like to place your X? ");
        userInput = scan.nextInt();
    }
}
