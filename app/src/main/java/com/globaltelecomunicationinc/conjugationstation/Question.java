package com.globaltelecomunicationinc.conjugationstation;

import android.widget.ImageView;

/**
 * Created by Kyle St-Hill on 7/9/2016.
 */
public class Question {

    int ID;
    int attempts;
    String sentence;
    String correctAnswer;
    String option1;
    String option2;
    String option3;
    String verb;

    String shownAnswer;

    ImageView questionImage;

    public Question() {
        ID = 0;
        attempts = 0;
        sentence = "";
        option1 = "";
        option2 = "";
        option3 = "";
        correctAnswer = "";
        shownAnswer = "";
        verb = "";
    }

    public Question(int suppliedAttempts, String suppliedQuestion, String suppliedoption1, String suppliedoption2, String suppliedoption3, String suppliedCorrectAnswer, String suppliedShownAnswer, String suppliedVerb) {
        attempts = suppliedAttempts;
        sentence = suppliedQuestion;
        option1 = suppliedoption1;
        option2 = suppliedoption2;
        option3 = suppliedoption3;
        correctAnswer = suppliedCorrectAnswer;
        shownAnswer = suppliedShownAnswer;
        verb = suppliedVerb;
    }

}
