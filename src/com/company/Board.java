package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private ArrayList<ArrayList<Space>> allColumns = new ArrayList<>();
    private Random rand = new Random();

    public Board() {
        for (int i = 0; i < 7; i++) {

            ArrayList<Space> column = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                column.add(j, new Space());
            }
            //System.out.println(column.size());
            allColumns.add(i, column);
        }
    }

    public void outputBoard() { //j is vertical i is horizontal
        String output = "";
        // System.out.println(allColumns.size());
        for (int j = 0; j < allColumns.get(1).size(); j++) {
            for (int i = 0; i < allColumns.size(); i++) {
                output = output + allColumns.get(i).get(j).getSpace();
            }
            System.out.println(output);
            output = "";
        }
    }

    public boolean playerMove(int column) {
        if (allColumns.get(column).get(0).getTaken() == 0) {
            makeMove(column,1);
            return true;
        } else {
            return false;
        }
    }

    public void computerMove(){
        int computer;
        do{
            computer = rand.nextInt(7);
        } while(allColumns.get(computer).get(0).getTaken() != 0);
        makeMove(computer, 2);
    }

    public void makeMove(int column,int turn) {
        int j = 0;
        while(allColumns.get(column).get(j).getTaken()==0) {
            j++;
            if(j==7){
                break;
            }
        }
        allColumns.get(column).get(j-1).setMove(turn);
    }

    public boolean checkBoard(int turn){  //j is vertical i is horizontal
        String checking;
        if(turn == 1)
            checking = "XXXX";
        else
            checking = "OOOO";

        ArrayList<String> possibilities = new ArrayList<>();
        String line = "";
        for(int i=0;i<allColumns.size();i++){ //adding in all vertical lines
            for(int j=0; j<allColumns.get(i).size();j++){
                line = line + allColumns.get(i).get(j).getSpace();
            }
            possibilities.add(line);
            line = "";
        }

        line = "";
        for (int j = 0; j < allColumns.get(1).size(); j++) { //adding in all horizontal lines
            for (int i = 0; i < allColumns.size(); i++) {
                line = line + allColumns.get(i).get(j).getSpace();
            }
            possibilities.add(line);
            line = "";
        }
        //toRight
        possibilities.add(step(0,2,true));
        possibilities.add(step(0,1,true));
        possibilities.add(step(0,0,true));
        possibilities.add(step(1,0,true));
        possibilities.add(step(2,0,true));
        possibilities.add(step(3,0,true));

        //toLeft
        possibilities.add(step(2,6,false));
        possibilities.add(step(1,6,false));
        possibilities.add(step(0,6,false));
        possibilities.add(step(0,5,false));
        possibilities.add(step(0,4,false));
        possibilities.add(step(0,3,false));

        for(int i=0;i<possibilities.size();i++){ ///checking for 4 in a row
            if(possibilities.get(i).contains(checking))
                return true;
        }

        return false;
    }

    public String step(int j, int i, boolean toRight){
        String line = "";
        while(j<=6 && j>=0 && i<=6 && i>=0){
            line = line+grid(j,i);
            if(toRight){
                j++;
                i++;
            } else{
                j++;
                i--;
            }
        }

        return line;
    }

    public char grid(int j, int i) { //j is vertical i is horizontal
        return allColumns.get(i).get(j).getSpace();

    }
}
