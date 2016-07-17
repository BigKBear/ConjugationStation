package com.globaltelecomunicationinc.conjugationstation;

/**
 * Created by Kyle St-Hill on 7/9/2016.
 */
public class Level {
    int ID;
    String name;
    Question one;
    Question two;
    Question three;
    Question four;
    Question five;
    int score;
    String levelBackgroung;

    Level(){
        ID =0;
        score =0;
        name ="";
        one = new Question();
        two = new Question();
        three = new Question();
        four = new Question();
        five = new Question();
    }

    public boolean levelPassed(){
        if(score>=5){
            return true;
        }else {
            return false;
        }
    }
}
