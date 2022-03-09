package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Scanner scan = new Scanner(System.in);
        int userInput=0;
        int turn = -1;
        int moves = 0;
        boolean noWinner = true;
        //System.out.println("test");


        while(noWinner && moves <50){
            turn=turn*-1;
            moves++;
            board.outputBoard();
            do{
                try{
                    System.out.print("Which column would you like to place your X? (1-7) ");
                    userInput = scan.nextInt();
                } catch (InputMismatchException ex){
                    System.out.println("That is not a valid integer! please try again correctly!!");
                    scan.nextLine();
                }
            } while(userInput<1 || userInput>7);




            userInput--;
            board.playerMove(userInput);
            noWinner = !board.checkBoard(1);
            if(!noWinner || moves == 50)
                break;

            turn=turn*-1;
            moves++;
            board.computerMove();
            noWinner = !board.checkBoard(2);

            System.out.println("\n"+"\n"+"\n");
            userInput=0;
        }

        board.outputBoard();
        if(moves == 50){
            System.out.println("Tie game, no winner.");
        }
        else if(turn==1){
            System.out.println("You won! Contrats!");
        }
        else {
            System.out.println("Sorry, the random computer won.");
        }




    }
}
