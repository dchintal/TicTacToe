package com.dchintal.game.action.addon;


public class DisplayGameInfo {

    char[][] gameValues;
    public DisplayGameInfo(char[][] gameValues){
        this.gameValues = gameValues;
    }

    public void displayWinner(char winnerValue, String userName){
        if(winnerValue == 'X'){
            System.out.println("The Game is won by " + userName + " using :- " + winnerValue);
        }else{
            System.out.println("The Game is won by Computer using :- " + winnerValue);
        }
        System.out.println("------------------------------");
        printGameCurrentStatus(1);
        System.out.println("------------------------------");
    }

    public void declareDrawGame(){
        System.out.println("The Game has been Draw");
        System.out.println("------------------------------");
        printGameCurrentStatus(1);
        System.out.println("------------------------------");
    }

    public void printGameCurrentStatus(int initLog) {
        if(initLog == -1) {
            System.out.println("you will be playing " + gameValues.length + " X " + gameValues[0].length + " Tic Tac Toe.");
            System.out.println("---------Game Sample Start-----------");
        }else if(initLog == 0){
            System.out.println("-----Current Game Status Start-----");
        }
        System.out.println("");
        for(int i=0; i < gameValues.length; i++){
            for(int j=0; j<gameValues[0].length; j++) {
                if(j<gameValues[0].length-1)
                    System.out.print("| " + gameValues[i][j]);
                else
                    System.out.print("| "+ gameValues[i][j] + "|");
            }
            System.out.println("");
            System.out.println("----------");
        }
        if(initLog == -1) {
            System.out.println("---------Game Sample End-----------");
        }else if(initLog == 0){
            System.out.println("-----Current Game Status End-----");
        }

    }


}
