package com.dchintal.game.action.addon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ComputerPlay {

    private char[][] gameValues;
    private ArrayList<String> toVisitPairs;

    public ComputerPlay(char[][] gameValues, ArrayList<String> toVisitPairs){
        this.gameValues = gameValues;
        this.toVisitPairs = toVisitPairs;
    }

    public void pickAndUpdateRandomSpot(){
        Random random = new Random();
        Collections.shuffle(toVisitPairs);
        String getRandomValue = toVisitPairs.get(random.nextInt(toVisitPairs.size()));
        char[] getRandomValueArray = getRandomValue.toCharArray();
        int xCoordinate = Character.getNumericValue(getRandomValueArray[0]);
        int yCoordinate = Character.getNumericValue(getRandomValueArray[2]);
        System.out.println( "Computer Choose [X,Y] co-ordinates as follows  ["+xCoordinate +","+ yCoordinate+ "]");
        gameValues[xCoordinate][yCoordinate]='O';
        toVisitPairs.remove(getRandomValue);
    }
}
