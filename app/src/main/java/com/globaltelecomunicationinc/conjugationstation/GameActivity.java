package com.globaltelecomunicationinc.conjugationstation;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
//import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

//import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences prefs = null;
    User theUser;// stores the current user info
    Level[] levelData;//array to store each level info
    Question[] questionData;//array to store the questions for each level
    //int level = 0;//this keeps track of what level the user is at this will be stored in future to shared preferences
    int attempts = 0;
    int leveldone = 0;

    //Question theQuestion;
    //Level theLevel;
    //private int levelPass = 0;
    //private int question = 0;
    //private int stage = 0;

    TextView tvLevelName, tvQuestion, tvWrong1, tvWrong2, tvWrong3, tvWrong4, tvWrong5, tvScore, tvResult, tvScoreLabel, tvVerb;
    ScrollView svAns;
    Button btnQuit, btnPause, btnAns1, btnAns2, btnAns3;
    int level1Score, level2Score, level3Score, levelScore;


    public void initViews() {
        tvLevelName = (TextView) findViewById(R.id.tvLevelName);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvScore = (TextView) findViewById(R.id.tvScore);
        tvWrong1 = (TextView) findViewById(R.id.tvWrong1);
        tvWrong2 = (TextView) findViewById(R.id.tvWrong2);
        tvWrong3 = (TextView) findViewById(R.id.tvWrong3);
        tvWrong4 = (TextView) findViewById(R.id.tvWrong4);
        tvWrong5 = (TextView) findViewById(R.id.tvWrong5);
        tvVerb = (TextView) findViewById(R.id.tvVerb);
        tvScoreLabel = (TextView) findViewById(R.id.tvScoreLabel);

        btnQuit = (Button) findViewById(R.id.btnQuit);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnAns1 = (Button) findViewById(R.id.btnAns1);
        btnAns2 = (Button) findViewById(R.id.btnAns2);
        btnAns3 = (Button) findViewById(R.id.btnAns3);

        svAns = (ScrollView) findViewById(R.id.svAns);
    }

    public void setListeners() {
        btnQuit.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnAns1.setOnClickListener(this);
        btnAns2.setOnClickListener(this);
        btnAns3.setOnClickListener(this);
    }

    public void setUpAllQuestions() {
        String[] LevelQuestions = new String[15];
        LevelQuestions[0] = "Jean _____ le bus pour aller à l'école ";
        LevelQuestions[1] = "Level 1 Question 2";
        LevelQuestions[2] = "Level 1 Question 3";
        LevelQuestions[3] = "Level 1 Question 4";
        LevelQuestions[4] = "Level 1 Question 5";

        LevelQuestions[5] = "Level 2 Question 1";
        LevelQuestions[6] = "Level 2 Question 2";
        LevelQuestions[7] = "Level 2 Question 3";
        LevelQuestions[8] = "Level 2 Question 4";
        LevelQuestions[9] = "Level 2 Question 5";

        LevelQuestions[10] = "Level 3 Question 1";
        LevelQuestions[11] = "Level 3 Question 2";
        LevelQuestions[12] = "Level 3 Question 3";
        LevelQuestions[13] = "Level 3 Question 4";
        LevelQuestions[14] = "Level 3 Question 5";

        String[] correctAnswers = new String[15];
        correctAnswers[0] = "attend";
        correctAnswers[1] = "Lv1Q2A2";
        correctAnswers[2] = "Lv1Q3A3";
        correctAnswers[3] = "Lv1Q4A1";
        correctAnswers[4] = "Lv1Q5A2";

        correctAnswers[5] = "Lv2Q1A1";
        correctAnswers[6] = "Lv2Q2A2";
        correctAnswers[7] = "Lv2Q3A3";
        correctAnswers[8] = "Lv2Q4A1";
        correctAnswers[9] = "Lv2Q5A2";

        correctAnswers[10] = "Lv3Q1A1";
        correctAnswers[11] = "Lv3Q2A2";
        correctAnswers[12] = "Lv3Q3A3";
        correctAnswers[13] = "Lv3Q4A1";
        correctAnswers[14] = "Lv3Q5A3";

        String[] shownAnswer = new String[15];
        shownAnswer[0] = "Jean attend le bus pour aller à l'école.";
        shownAnswer[1] = "Lv1Q2A2";
        shownAnswer[2] = "Lv1Q3A3";
        shownAnswer[3] = "Lv1Q4A1";
        shownAnswer[4] = "Lv1Q5A2";

        shownAnswer[5] = "Lv2Q1A1";
        shownAnswer[6] = "Lv2Q2A2";
        shownAnswer[7] = "Lv2Q3A3";
        shownAnswer[8] = "Lv2Q4A1";
        shownAnswer[9] = "Lv2Q5A2";

        shownAnswer[10] = "Lv3Q1A1";
        shownAnswer[11] = "Lv3Q2A2";
        shownAnswer[12] = "Lv3Q3A3";
        shownAnswer[13] = "Lv3Q4A1";
        shownAnswer[14] = "Lv3Q5A3";

        String[] verb = new String[15];
        verb[0] = "Assister ";
        verb[1] = "Lv1Q2VERB";
        verb[2] = "Lv1Q3VERB";
        verb[3] = "Lv1Q4VERB";
        verb[4] = "Lv1Q5VERB";

        verb[5] = "Lv2Q1VERB";
        verb[6] = "Lv2Q2VERB";
        verb[7] = "Lv2Q3VERB";
        verb[8] = "Lv2Q4VERB";
        verb[9] = "Lv2Q5VERB";

        verb[10] = "Lv3Q1VERB";
        verb[11] = "Lv3Q2VERB";
        verb[12] = "Lv3Q3VERB";
        verb[13] = "Lv3Q4VERB";
        verb[14] = "Lv3Q5VERB";

        /*String[] image = new String[15];
        image[0] = "Assister ";
        image[1] = "Lv1Q2Image";
        image[2] = "Lv1Q3Image";
        image[3] = "Lv1Q4Image";
        image[4] = "Lv1Q5Image";

        image[5] = "Lv2Q1Image";
        image[6] = "Lv2Q2Image";
        image[7] = "Lv2Q3Image";
        image[8] = "Lv2Q4Image";
        image[9] = "Lv2Q5Image";

        image[10] = "Lv3Q1Image";
        image[11] = "Lv3Q2Image";
        image[12] = "Lv3Q3Image";
        image[13] = "Lv3Q4Image";
        image[14] = "Lv3Q5Image";*/

        String[][] questionAnswers = new String[51][4];
        questionAnswers[0][0] = "attendiez";
        questionAnswers[0][1] = "attendent";
        questionAnswers[0][2] = "attend";
        //questionAnswers[0][3] = "attend";
        questionAnswers[1][0] = "Lv1Q2A1";
        questionAnswers[1][1] = "Lv1Q2A2";
        questionAnswers[1][2] = "Lv1Q2A3";
        // questionAnswers[1][3] = "Lv1Q2A4";
        questionAnswers[2][0] = "Lv1Q3A1";
        questionAnswers[2][1] = "Lv1Q3A2";
        questionAnswers[2][2] = "Lv1Q3A3";
        // questionAnswers[2][3] = "Lv1Q3A4";
        questionAnswers[3][0] = "Lv1Q4A1";
        questionAnswers[3][1] = "Lv1Q4A2";
        questionAnswers[3][2] = "Lv1Q4A3";
        // questionAnswers[3][3] = "Lv1Q4A4";
        questionAnswers[4][0] = "Lv1Q5A1";
        questionAnswers[4][1] = "Lv1Q5A2";
        questionAnswers[4][2] = "Lv1Q5A3";
        //questionAnswers[4][3] = "Lv1Q5A4";

        questionAnswers[5][0] = "Lv2Q1A1";
        questionAnswers[5][1] = "Lv2Q1A2";
        questionAnswers[5][2] = "Lv2Q1A3";
        // questionAnswers[5][3] = "Lv2Q1A4";
        questionAnswers[6][0] = "Lv2Q2A1";
        questionAnswers[6][1] = "Lv2Q2A2";
        questionAnswers[6][2] = "Lv2Q2A3";
        //questionAnswers[6][3] = "Lv2Q2A4";
        questionAnswers[7][0] = "Lv2Q3A1";
        questionAnswers[7][1] = "Lv2Q3A2";
        questionAnswers[7][2] = "Lv2Q3A3";
        // questionAnswers[7][3] = "Lv2Q3A4";
        questionAnswers[8][0] = "Lv2Q4A1";
        questionAnswers[8][1] = "Lv2Q4A2";
        questionAnswers[8][2] = "Lv2Q4A3";
        //questionAnswers[8][3] = "Lv2Q4A4";
        questionAnswers[9][0] = "Lv2Q5A1";
        questionAnswers[9][1] = "Lv2Q5A2";
        questionAnswers[9][2] = "Lv2Q5A3";
        // questionAnswers[9][3] = "Lv2Q5A4";

        questionAnswers[10][0] = "Lv3Q1A1";
        questionAnswers[10][1] = "Lv3Q1A2";
        questionAnswers[10][2] = "Lv3Q1A3";
        // questionAnswers[9][3] = "Lv2Q5A4";
        questionAnswers[11][0] = "Lv3Q2A1";
        questionAnswers[11][1] = "Lv3Q2A2";
        questionAnswers[11][2] = "Lv3Q2A3";
        // questionAnswers[9][3] = "Lv2Q5A4";
        questionAnswers[12][0] = "Lv3Q3A1";
        questionAnswers[12][1] = "Lv3Q3A2";
        questionAnswers[12][2] = "Lv3Q3A3";
        // questionAnswers[9][3] = "Lv2Q5A4";

        questionAnswers[13][0] = "Lv3Q4A1";
        questionAnswers[13][1] = "Lv3Q4A2";
        questionAnswers[13][2] = "Lv3Q4A3";
        // questionAnswers[9][3] = "Lv2Q5A4";

        questionAnswers[14][0] = "Lv3Q5A1";
        questionAnswers[14][1] = "Lv3Q5A2";
        questionAnswers[14][2] = "Lv3Q5A3";
        // questionAnswers[9][3] = "Lv2Q5A4";

        questionData = new Question[15];
        for (int i = 0; i < 15; i++) {
            questionData[i] = new Question();
            questionData[i].ID = i;
            questionData[i].attempts = 0;
            questionData[i].sentence = LevelQuestions[i];
            questionData[i].correctAnswer = correctAnswers[i];
            questionData[i].shownAnswer = shownAnswer[i];
            questionData[i].verb = verb[i];
            int z = 0;
            questionData[i].option1 = questionAnswers[i][z];
            questionData[i].option2 = questionAnswers[i][z + 1];
            questionData[i].option3 = questionAnswers[i][z + 2];
        }
    }

    public void setUpAllLevels() {
        String[] levelName = new String[3];
        levelName[0] = "Level One";
        levelName[1] = "Level Two";
        levelName[2] = "Level Three";

        levelData = new Level[3];
        for (int i = 0; i < 3; i++) {
            levelData[i] = new Level();
            levelData[i].ID = i;
            levelData[i].name = levelName[i];
            levelData[i].score = 0;
            switch (i) {
                case 0:
                    levelData[i].one = questionData[0];
                    levelData[i].two = questionData[1];
                    levelData[i].three = questionData[2];
                    levelData[i].four = questionData[3];
                    levelData[i].five = questionData[4];
                    break;
                case 1:
                    levelData[i].one = questionData[5];
                    levelData[i].two = questionData[6];
                    levelData[i].three = questionData[7];
                    levelData[i].four = questionData[8];
                    levelData[i].five = questionData[9];
                    break;
                case 2:
                    levelData[i].one = questionData[10];
                    levelData[i].two = questionData[11];
                    levelData[i].three = questionData[12];
                    levelData[i].four = questionData[13];
                    levelData[i].five = questionData[14];
                    break;
                default:
                    levelData[i].one = questionData[0];
                    levelData[i].two = questionData[1];
                    levelData[i].three = questionData[2];
                    levelData[i].four = questionData[3];
                    levelData[i].five = questionData[4];
            }
        }
    }

    public void QuestionOneSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].one.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].one.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].one.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].one.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].one.option3);
    }

    public void QuestionTwoSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].two.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].two.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].two.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].two.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].two.option3);
    }

    public void QuestionThreeSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].three.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].three.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].three.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].three.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].three.option3);
    }

    public void QuestionFourSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].four.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].four.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].four.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].four.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].four.option3);
    }

    public void QuestionFiveSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].five.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].five.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].five.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].five.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].five.option3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game);
        prefs = this.getSharedPreferences("com.globaltelecomunicationinc.conjugationstation", MODE_PRIVATE);
        initViews();
        setListeners();
        theUser = new User();
        theUser.score = prefs.getInt("score", -1);
        //theUser.level.ID = prefs.getInt("level",-1);

        setUpAllQuestions();
        setUpAllLevels();
        resetGame();
        //setupGame(prefs.getInt("level",-1), prefs.getInt("question",-1));
       /* levelScore=0;
        level = 0;
        question =0;*/
        //get latest game info
        /*level = prefs.getInt("level",-1);
        levelScore = prefs.getInt("level"+level+"score",-1);
        question = prefs.getInt("question",-1);*/
/*
        switch (theLevel.name) {
            case 0:
                setUpGame("Level One");
                break;
            case 1:
                setUpGame("Level Two");
                break;
            case 2:
                setUpGame("Level Three");
                break;
        }*/
        if (theUser.hasWon()) {
            gameOver("Game Finished", "You have read over the game!", "Restart", "Quit");
        }
    }

    public void gameOver(String title, String message, String positiveButton, String negativeButton) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        QuestionOneSetup();
                        Log.i("Level: ", String.valueOf(prefs.getInt("level", -1)));
                        Intent g = new Intent(GameActivity.this, GameActivity.class);
                        startActivity(g);
                    }
                })
                .setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //resetGame();
                        Intent g = new Intent(GameActivity.this, MainActivity.class);
                        startActivity(g);
                    }
                }).setCancelable(false)
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //check to see if this is the first ime the application is being run
        if (prefs.getBoolean("firstrun", true)) {
            //set up game info
            setUpAllQuestions();
            setUpAllLevels();
            resetGame();
            QuestionOneSetup();
            prefs.edit().putBoolean("firstrun", false).apply();
        } else {
            setUpAllQuestions();
            setUpAllLevels();
            QuestionOneSetup();
            //setupGame(prefs.getInt("level",-1), prefs.getInt("question",-1));
        }
    }

    public void resetGame() {
        level1Score = 0;
        level2Score = 0;
        level3Score = 0;
        prefs.edit().putInt("level", 0).apply();
        levelScore = 0;
        //prefs.edit().putInt("question", 0).apply();
        //prefs.edit().putInt("stage", 0).apply();
    }

    /*public void saveGame(int levelID, int questionID, int stage) {
        prefs.edit().putInt("level", levelData[level].ID).apply();
        //prefs.edit().putInt("question", questionData[questionID].ID).apply();
        //prefs.edit().putInt("stage", stage).apply();
    }*/

    public void updateGame(String userAnswer) {
        initViews();
        setListeners();
//        tvScore.setText(String.valueOf(level1Score) + "/5");
        Log.i("level ", prefs.getInt("level", -1) + " Level Done  " + String.valueOf(leveldone));
        //Log.i("scores: ", " level1 " + String.valueOf(level1Score) + " level2 " + String.valueOf(level2Score) + " level3 " + String.valueOf(level3Score));
        if ((level1Score == 5) && (level2Score == 5) && (level3Score == 5)) {
            gameOver("Game Finished", "You have read over the game!", "Play Again", "Exit");
        }else if ((prefs.getInt("level", -1) == 0) && (leveldone < 10) && ((level1Score < 5))) {
            tvScore.setText(String.valueOf(level1Score) + "/5");
            //level tries to keep track of when a level needst to be retried
            //check levelscores
            //runLevelOne(leveldone, userAnswer);
            switch(leveldone) {
                case 0:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q1 Correct");
                        level1Score++;
                        attempts = 0;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 1:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q1 Correct");
                        level1Score++;
                        attempts = 0;
                        leveldone = 2;//to start Q2L1
                        //tvScore.setText(String.valueOf(level1Score) + "/5");
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q1 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        attempts = 0;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    }
                    break;
                case 2:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q2 Correct");
                        level1Score++;
                        attempts = 0;
                        leveldone = 4;//to start Q2L1
                        QuestionThreeSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 3:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q2 Correct");
                        level1Score++;
                        leveldone = 4;//to start Q2L1
                        QuestionThreeSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q2 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].two.shownAnswer);
                        leveldone = 4;//to start Q2L1
                        QuestionThreeSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    }
                    break;
                case 4:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q3 Correct");
                        level1Score++;
                        leveldone = 6;//to start Q2L1
                        QuestionFourSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 5:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q3 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q3 Correct");
                        level1Score++;
                        leveldone = 6;//to start Q2L1
                        QuestionFourSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q3 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].three.shownAnswer);
                        leveldone = 6;//to start Q2L1
                        QuestionFourSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    }
                    break;
                case 6:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q4 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q4 Correct");
                        level1Score++;
                        leveldone = 8;//to start Q2L1
                        QuestionFiveSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    Log.i("Attempts ", String.valueOf(attempts) + " Level Done  " + String.valueOf(leveldone));
                    break;
                case 7:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q4 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q4 Correct");
                        level1Score++;
                        leveldone = 8;//to start Q2L1
                        QuestionFiveSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q4 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                        leveldone = 8;//to start Q2L1
                        QuestionFiveSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                    }
                    break;
                case 8:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q5 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q5 Correct");
                        level1Score++;
                        tvScore.setText(String.valueOf(level1Score) + "/5");

                        if(level1Score==5){
                            //Start level 2
                            prefs.edit().putInt("levelOneOver", level1Score).apply();
                            prefs.edit().putInt("level", 1).apply();
                            leveldone=0;
                            QuestionOneSetup();
                        }else{
                            //game over
                            prefs.edit().putInt("levelOneOver", level1Score).apply();
                            prefs.edit().putInt("level", 0).apply();
                            leveldone = 0;
                            gameOver(levelData[prefs.getInt("level", -1)].name +"\n " + level1Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 9:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q5 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q5 Correct");
                        level1Score++;
                        leveldone = 10;//to start Q2L1
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                        if(level1Score==5){
                            //Start level 2
                            prefs.edit().putInt("levelOneOver", level1Score).apply();
                            prefs.edit().putInt("level", 1).apply();
                            leveldone = 0;
                            QuestionOneSetup();
                        }else{
                            //game over
                            prefs.edit().putInt("levelOneOver", level1Score).apply();
                            prefs.edit().putInt("level", 0).apply();
                            leveldone = 0;
                            gameOver(levelData[prefs.getInt("level", -1)].name +"\n " + level1Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Q5 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                        tvScore.setText(String.valueOf(level1Score) + "/5");
                        leveldone = 10;//to start Q2L1
                        prefs.edit().putInt("levelOneOver", level1Score).apply();
                        prefs.edit().putInt("level", 0).apply();
                        leveldone = 0;
                        gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level1Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                    }
                    break;
                case 10:
                    if (level1Score == 5) {
                        //Start level 2
                        prefs.edit().putInt("levelOneOver", level1Score).apply();
                        prefs.edit().putInt("level", 1).apply();
                        QuestionOneSetup();
                    } else {
                        //game over
                        prefs.edit().putInt("levelOneOver", level1Score).apply();
                        prefs.edit().putInt("level", 0).apply();
                        leveldone = 0;
                        gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level1Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                    }
                    break;
            }
        }else if ((level2Score < 5) && (prefs.getInt("level", -1) == 1)){
            tvScore.setText(String.valueOf(level2Score) + "/5");
            //level tries to keep track of when a level needst to be retried
            //check levelscores
            //runLevelOne(leveldone, userAnswer);
            switch(leveldone) {
                case 0:
                    Toast.makeText(getApplicationContext(), "L2 Q1 Ans " + levelData[prefs.getInt("level", -1)].one.correctAnswer, Toast.LENGTH_SHORT).show();
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q1 Correct");
                        level2Score++;
                        attempts = 0;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "L2 Q1 Ans " + levelData[prefs.getInt("level", -1)].one.correctAnswer, Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 1:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q1 Correct");
                        level2Score++;
                        attempts = 0;
                        leveldone = 2;//to start Q2L1
                        //tvScore.setText(String.valueOf(level2Score) + "/5");
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q1 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        attempts = 0;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    }
                    break;
                case 2:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q2 Correct");
                        level2Score++;
                        attempts = 0;
                        leveldone = 4;//to start Q2L1
                        QuestionThreeSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 3:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q2 Correct");
                        level2Score++;
                        leveldone = 4;//to start Q2L1
                        QuestionThreeSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q2 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].two.shownAnswer);
                        leveldone = 4;//to start Q2L1
                        QuestionThreeSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    }
                    break;
                case 4:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q3 Correct");
                        level2Score++;
                        leveldone = 6;//to start Q2L1
                        QuestionFourSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 5:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q3 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q3 Correct");
                        level2Score++;
                        leveldone = 6;//to start Q2L1
                        QuestionFourSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q3 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].three.shownAnswer);
                        leveldone = 6;//to start Q2L1
                        QuestionFourSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    }
                    break;
                case 6:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q4 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q4 Correct");
                        level2Score++;
                        leveldone = 8;//to start Q2L1
                        QuestionFiveSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 7:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q4 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q4 Correct");
                        level2Score++;
                        leveldone = 8;//to start Q2L1
                        QuestionFiveSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q4 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                        leveldone = 8;//to start Q2L1
                        QuestionFiveSetup();
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                    }
                    break;
                case 8:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q5 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q5 Correct");
                        level2Score++;
                        tvScore.setText(String.valueOf(level2Score) + "/5");

                        if(level2Score==5){
                            //Start level 2
                            prefs.edit().putInt("levelTwoOver", level2Score).apply();
                            prefs.edit().putInt("level", 2).apply();
                            leveldone=0;
                            QuestionOneSetup();
                        }else{
                            //game over
                            prefs.edit().putInt("levelTwoOver", level2Score).apply();
                            prefs.edit().putInt("level", 1).apply();
                            leveldone = 0;
                            gameOver(levelData[prefs.getInt("level", -1)].name +"\n " + level2Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 9:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q5 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q5 Correct");
                        level2Score++;
                        leveldone = 10;//to start Q2L1
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                        if(level2Score==5){
                            //Start level 2
                            prefs.edit().putInt("levelTwoOver", level2Score).apply();
                            prefs.edit().putInt("level", 2).apply();
                            leveldone = 0;
                            QuestionOneSetup();
                        }else{
                            //game over
                            prefs.edit().putInt("levelTwoOver", level2Score).apply();
                            prefs.edit().putInt("level", 1).apply();
                            leveldone = 0;
                            gameOver(levelData[prefs.getInt("level", -1)].name +"\n " + level2Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Q5 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                        tvScore.setText(String.valueOf(level2Score) + "/5");
                        leveldone = 10;//to start Q2L1
                        prefs.edit().putInt("levelTwoOver", level2Score).apply();
                        prefs.edit().putInt("level", 1).apply();
                        leveldone = 0;
                        gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level2Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                    }
                    break;
                case 10:
                    if (level2Score == 5) {
                        //Start level 2
                        prefs.edit().putInt("levelTwoOver", level2Score).apply();
                        prefs.edit().putInt("level", 2).apply();
                        QuestionOneSetup();
                    } else {
                        //game over
                        prefs.edit().putInt("levelTwoOver", level2Score).apply();
                        prefs.edit().putInt("level", 1).apply();
                        leveldone = 0;
                        gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level2Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                    }
                    break;
            }
        }else if ((level3Score < 5) && (prefs.getInt("level", -1) == 2)) {
            tvScore.setText(String.valueOf(level3Score) + "/5");
            //level tries to keep track of when a level needst to be retried
            //check levelscores
            //runLevelOne(leveldone, userAnswer);
            switch(leveldone) {
                case 0:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q1 Correct");
                        level3Score++;
                        attempts = 0;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 1:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q1 Correct");
                        level3Score++;
                        attempts = 0;
                        leveldone = 2;//to start Q2L1
                        //tvScore.setText(String.valueOf(level3Score) + "/5");
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q1 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        attempts = 0;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    }
                    break;
                case 2:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q2 Correct");
                        level3Score++;
                        attempts = 0;
                        leveldone = 4;//to start Q2L1
                        QuestionThreeSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 3:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q2 Correct");
                        level3Score++;
                        leveldone = 4;//to start Q2L1
                        QuestionThreeSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q2 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].two.shownAnswer);
                        leveldone = 4;//to start Q2L1
                        QuestionThreeSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    }
                    break;
                case 4:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q3 Correct");
                        level3Score++;
                        leveldone = 6;//to start Q2L1
                        QuestionFourSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 5:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q3 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q3 Correct");
                        level3Score++;
                        leveldone = 6;//to start Q2L1
                        QuestionFourSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q3 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].three.shownAnswer);
                        leveldone = 6;//to start Q2L1
                        QuestionFourSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    }
                    break;
                case 6:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q4 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q4 Correct");
                        level3Score++;
                        leveldone = 8;//to start Q2L1
                        QuestionFiveSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 7:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q4 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q4 Correct");
                        level3Score++;
                        leveldone = 8;//to start Q2L1
                        QuestionFiveSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q4 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                        leveldone = 8;//to start Q2L1
                        QuestionFiveSetup();
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                    }
                    break;
                case 8:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q5 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q5 Correct");
                        level3Score++;
                        tvScore.setText(String.valueOf(level3Score) + "/5");

                        if(level3Score==5){
                            //Start level 2
                            prefs.edit().putInt("levelThreeOver", level3Score).apply();
                            prefs.edit().putInt("level", 2).apply();
                            leveldone=0;
                            QuestionOneSetup();
                        }else{
                            //game over
                            prefs.edit().putInt("levelThreeOver", level3Score).apply();
                            prefs.edit().putInt("level", 2).apply();
                            leveldone = 0;
                            gameOver(levelData[prefs.getInt("level", -1)].name +"\n " + level3Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                case 9:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q5 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q5 Correct");
                        level3Score++;
                        leveldone = 10;//to start Q2L1
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                        if(level3Score==5){
                            //Start level 2
                            prefs.edit().putInt("levelThreeOver", level3Score).apply();
                            prefs.edit().putInt("level", 2).apply();
                            leveldone = 0;
                            QuestionOneSetup();
                        }else{
                            //game over
                            prefs.edit().putInt("levelThreeOver", level3Score).apply();
                            prefs.edit().putInt("level", 2).apply();
                            leveldone = 0;
                            gameOver(levelData[prefs.getInt("level", -1)].name +"\n " + level3Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Q5 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                        tvScore.setText(String.valueOf(level3Score) + "/5");
                        leveldone = 10;//to start Q2L1
                        prefs.edit().putInt("levelThreeOver", level3Score).apply();
                        prefs.edit().putInt("level", 2).apply();
                        leveldone = 0;
                        gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level3Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                    }
                    break;
                case 10:
                    if (level3Score == 5) {
                        //Start level 3 Again
                        prefs.edit().putInt("levelThreeOver", level3Score).apply();
                        prefs.edit().putInt("level", 2).apply();
                        QuestionOneSetup();
                    } else {
                        //game over
                        prefs.edit().putInt("levelThreeOver", level3Score).apply();
                        prefs.edit().putInt("level", 2).apply();
                        leveldone = 0;
                        gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level3Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                    }
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAns1:
                updateGame(btnAns1.getText().toString());
                //Toast.makeText(getApplicationContext(), "Btn 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnAns2:
                updateGame(btnAns2.getText().toString());
                //Toast.makeText(getApplicationContext(), "Button 2 clicked text is "+ btnAns2.getText(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnAns3:
                updateGame(btnAns3.getText().toString());
                //Toast.makeText(getApplicationContext(), "Button 3 clicked text is "+ btnAns3.getText(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnPause:
                Toast.makeText(getApplicationContext(), "Pause Button clicked ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnQuit:
                finish();
                break;
        }
    }
}