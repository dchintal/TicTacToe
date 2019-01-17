package com.dchintal.game.action.addon;


import java.util.*;

public class PrepareGamePlay {

    DisplayGameInfo displayGameInfo;
    public boolean isUserTurn =false;
    public boolean deatiledLogVal=false;
    public String username;
    Scanner scanner;
    public PrepareGamePlay(DisplayGameInfo displayGameInfo, Scanner scanner){
        this.displayGameInfo = displayGameInfo;
        this.scanner=scanner;
    }

    public void init(){
        displayGameInfo.printGameCurrentStatus(-1);
        System.out.println("Enter Players Name:");
        username = scanner.next();
        System.out.println("Do you want to check detailed game log (true/false)");
        deatiledLogVal = scanner.nextBoolean();
        playToss();
    }

    public void playToss(){
        Random random = new Random();
        List<String> tossOptions = new ArrayList<>();
        tossOptions.add("heads");
        tossOptions.add("tails");
        Collections.shuffle(tossOptions);
        System.out.println("---------------------------------------------------------");
        System.out.println("Match Starting between "+ username + " vs Computer");
        System.out.println("Enter your choice for toss (heads/tails)");
        String userChoice = scanner.next();
        System.out.println("---------------------------------------------------------");
        String getRandomValue = tossOptions.get(random.nextInt(tossOptions.size()));
        System.out.println("Toss Has been conducted and results as " + getRandomValue);
        if((getRandomValue.equals("heads") && getRandomValue.startsWith(userChoice.toLowerCase())) ||
                (getRandomValue.equals("tails") && getRandomValue.startsWith(userChoice.toLowerCase())) ){
            isUserTurn = true;
            System.out.println( username + " have won the toss, so you will make the first move.");
        } else {
            isUserTurn = false;
            System.out.println("Computer won the toss, so it will make the first move.");
        }
    }
}
