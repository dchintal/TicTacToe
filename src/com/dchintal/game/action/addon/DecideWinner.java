package com.dchintal.game.action.addon;

import java.util.ArrayList;

public class DecideWinner{
    DisplayGameInfo displayGameInfo;
    private char[][] gameValues;
    private ArrayList<String> toVisitPairs;
    String userName;
    public DecideWinner(char[][] gameValues, ArrayList<String> toVisitPairs, DisplayGameInfo displayGameInfo, String userName){
        this.gameValues = gameValues;
        this.toVisitPairs = toVisitPairs;
        this.userName = userName;
        this.displayGameInfo = displayGameInfo;
    }
    public boolean isGameComplete(){
        int isGetNextStepVal = isGetNextStepVal();
        if(isGetNextStepVal == 0){
            return true;
        }else if(isGetNextStepVal == -1) {
            return false;
        }
        if (toVisitPairs.isEmpty()){
            displayGameInfo.declareDrawGame();
            return true;
        }
        return false;
    }

    private int isGetNextStepVal() {
        int checkRowVal = isRowWinnerExists();
        if(checkRowVal == 0) return  0;
        int checkColVal = isColumnWinnerExists();
        if(checkColVal == 0) return  0;
        int checkDiagnoalVal = isDiagnoalWinnerExists();
        if(checkDiagnoalVal == 0) return  0;
        if(checkRowVal == -1) return -1;
        return  -2;
    }

    private int isRowWinnerExists(){
        int k,returnVal = -2;
        for(int i=0; i < gameValues.length; i++){
            k=0;
            for(int j=1; j<gameValues[0].length; j++) {
                if(gameValues[i][j] == ' '){
                    returnVal= -1;
                }
                if(gameValues[i][0] != ' ' && gameValues[i][0] == gameValues[i][j])
                    k++;
            }
            if(k == gameValues.length-1){
                displayGameInfo.displayWinner(gameValues[i][0],userName);
                return 0;
            }
        }
        return returnVal;
    }

    private int isColumnWinnerExists(){
        int k,returnVal = -2;
        for(int i=0; i < gameValues.length; i++){
            k=0;
            for(int j=1; j<gameValues[0].length; j++) {
                if(gameValues[i][j] == ' '){
                    returnVal= -1;;
                }
                if(gameValues[0][i] != ' ' && gameValues[0][i] == gameValues[j][i])
                    k++;
            }
            if(k == gameValues.length-1){
                displayGameInfo.displayWinner(gameValues[0][i],userName);
                return 0;
            }
        }
        return returnVal;
    }

    private int isDiagnoalWinnerExists(){
        int k=0;
        //Checking for left diagonal winner
        for(int i=0; i < gameValues.length; i++){
            if(gameValues[0][0] != ' ' && gameValues[0][0] == gameValues[i][i]) k++;
        }
        if(k == gameValues.length){
            displayGameInfo.displayWinner(gameValues[0][0],userName);
            return 0;
        }
        int i=0;k=0;
        //Checking for right diagonal winner
        for(int j=gameValues.length-1; j >= 0; j--){
            if(gameValues[0][gameValues.length-1] != ' ' && gameValues[0][gameValues.length-1] == gameValues[i][j]) k++;
            i++;
        }
        if(k == gameValues.length){
            displayGameInfo.displayWinner(gameValues[0][gameValues.length-1],userName);
            return 0;
        }
        return -2;
    }
}
