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
    Question six;
    Question seven;
    Question eight;
    Question nine;
    Question ten;

    Question one1;
    Question two1;
    Question three1;
    Question four1;
    Question five1;
    Question six1;
    Question seven1;
    Question eight1;
    Question nine1;
    Question ten1;

    int score;

    Level(){
        ID =0;
        score =0;
        name ="";
        one = new Question();
        two = new Question();
        three = new Question();
        four = new Question();
        five = new Question();
        six = new Question();
        seven = new Question();
        eight = new Question();
        nine = new Question();
        ten = new Question();

        one1 = new Question();
        two1 = new Question();
        three1 = new Question();
        four1 = new Question();
        five1 = new Question();
        six1 = new Question();
        seven1 = new Question();
        eight1 = new Question();
        nine1 = new Question();
        ten1 = new Question();
    }

    public boolean levelPassed(){
        if(score>=5){
            return true;
        }else {
            return false;
        }
    }
}
