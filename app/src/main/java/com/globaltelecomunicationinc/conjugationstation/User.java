package com.globaltelecomunicationinc.conjugationstation;

/**
 * Created by Kyle St-Hill on 7/9/2016.
 */
public class User {

    int score;
    Level level;

    public boolean hasWon(){
        if(score>=15){
            return true;
        }else {
            return false;
        }
    }
}
