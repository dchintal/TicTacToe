package com.dchintal.game.action.addon;

import java.util.ArrayList;
import java.util.Scanner;

public class RunGame{

    DisplayGameInfo displayGameInfo;
    ComputerPlay computerPlay;
    DecideWinner decideWinner;
    PrepareGamePlay prepareGamePlay;

    public char[][] gameValues;
    char userValue = 'X';
    public ArrayList<String> toVisitPairs = new ArrayList<String>();
    Scanner scanner;

    /**
     * Right now it is hard code to work for 3 * 3 Tic Tac Toe Game.
     * To Do customizable.
     */
    public RunGame(){
        gameValues = new char[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ',' ',' '}};
        generateToVisitValues();
        scanner = new Scanner(System.in);
    }


    public void init(){
        displayGameInfo = new DisplayGameInfo(gameValues);
        prepareGamePlay = new PrepareGamePlay(displayGameInfo, scanner);
        prepareGamePlay.init();
        computerPlay = new ComputerPlay(gameValues, toVisitPairs);
        decideWinner = new DecideWinner(gameValues, toVisitPairs, displayGameInfo, prepareGamePlay.username);
        playGame();
    }

    public void playGame(){
        int xValue,yValue;
        do{
            if(prepareGamePlay.isUserTurn) {
                do {
                    System.out.println("Now It's your Turn ");
                    System.out.println("Enter X co-ordinate Value: ");
                    xValue = scanner.nextInt();

                    System.out.println("Enter Y co-ordinate Value: ");
                    yValue = scanner.nextInt();
                }while(!updateMovies(xValue, yValue));
                prepareGamePlay.isUserTurn=false;
            }else{
                computerPlay.pickAndUpdateRandomSpot();
                prepareGamePlay.isUserTurn=true;
            }
            if(prepareGamePlay.deatiledLogVal){
                displayGameInfo.printGameCurrentStatus(0);
            }
        }while (!decideWinner.isGameComplete());
    }

    private boolean updateMovies(int xValue, int yValue){
        if(xValue < 0 || xValue > gameValues.length-1 || yValue < 0 || yValue > gameValues[0].length-1){
            System.out.println("Invalid co-ordinates, Enter X co-ordinate Vales from 0 to " + (gameValues.length-1) +
                    " and Y co-ordinate Vales from 0 to " + (gameValues[0].length-1));
            return false;
        }
        if(!toVisitPairs.contains(xValue+"-"+yValue)){
            System.out.println("Given [X,Y] co-ordinates are already visited");
            return false;
        }
        gameValues[xValue][yValue]=userValue;
        toVisitPairs.remove(xValue+"-"+yValue);
        return true;
    }

    private void generateToVisitValues(){
        for(int i=0; i < gameValues.length; i++){
            for(int j=0; j<gameValues[0].length; j++) {
                toVisitPairs.add(i+"-"+j);
            }
        }
    }

}
