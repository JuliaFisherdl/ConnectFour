package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<ArrayList<Space>> allColumns = new ArrayList<>();

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
    public void makeMove(int column,int turn) {
        int j = 0;
        while(allColumns.get(column).get(j).getTaken()==0) {
            j++;
        }
        allColumns.get(column).get(j-1).setMove(turn);
    }
}
