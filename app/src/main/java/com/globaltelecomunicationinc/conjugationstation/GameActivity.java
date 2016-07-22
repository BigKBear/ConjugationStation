package com.globaltelecomunicationinc.conjugationstation;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
//import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

//import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences prefs = null;
    User theUser;// stores the current user info
    Level[] levelData;//array to store each level info
    Question[] questionData;//array to store the questions for each level
    int leveldone = 0;//keeps track of the level state
    RelativeLayout relativeLayout;//created to allow fo the change in back ground of a question

    TextView tvLevelName, tvQuestion, tvScore, tvResult, tvScoreLabel, tvVerb;
    TextView tvWrong1, tvWrong2, tvWrong3, tvWrong4, tvWrong5, tvWrong6, tvWrong7, tvWrong8, tvWrong9, tvWrong10;
    ScrollView svAns;
    Button btnQuit, btnPause, btnAns1, btnAns2, btnAns3;
    int level1Score, level2Score, level3Score, levelScore;

    public void initViews() {
        tvLevelName = (TextView) findViewById(R.id.tvLevelName);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvScore = (TextView) findViewById(R.id.tvScore);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
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
        String[] LevelQuestions = new String[50];
        LevelQuestions[0] = "Jean _____ le bus pour aller à l'école ";
        LevelQuestions[1] = "Level 1 Question 2";
        LevelQuestions[2] = "Level 1 Question 3";
        LevelQuestions[3] = "Level 1 Question 4";
        LevelQuestions[4] = "Level 1 Question 5";
        LevelQuestions[5] = "Level 1 Question 6";
        LevelQuestions[6] = "Level 1 Question 7";
        LevelQuestions[7] = "Level 1 Question 8";
        LevelQuestions[8] = "Level 1 Question 9";
        LevelQuestions[9] = "Level 1 Question 10";

        LevelQuestions[10] = "Sara ___ ses devoir mewtenant elle ___ regarder le television.";
        LevelQuestions[11] = "Sara ___ ses devoir mewtenant elle ___ regarder le television.";
        LevelQuestions[12] = "Level 2 Question 2";
        LevelQuestions[13] = "Level 2 Question 2.1";
        LevelQuestions[14] = "Level 2 Question 3";
        LevelQuestions[15] = "Level 2 Question 3.1";
        LevelQuestions[16] = "Level 2 Question 4";
        LevelQuestions[17] = "Level 2 Question 4.1";
        LevelQuestions[18] = "Level 2 Question 5";
        LevelQuestions[19] = "Level 2 Question 5.1";
        LevelQuestions[20] = "Level 2 Question 6";
        LevelQuestions[21] = "Level 2 Question 6.1";
        LevelQuestions[22] = "Level 2 Question 7";
        LevelQuestions[23] = "Level 2 Question 7.1";
        LevelQuestions[24] = "Level 2 Question 8";
        LevelQuestions[25] = "Level 2 Question 8.1";
        LevelQuestions[26] = "Level 2 Question 9";
        LevelQuestions[27] = "Level 2 Question 9.1";
        LevelQuestions[28] = "Level 2 Question 10";
        LevelQuestions[29] = "Level 2 Question 10.1";

        LevelQuestions[30] = "Level 3 Question 1";
        LevelQuestions[31] = "Level 3 Question 1.1";
        LevelQuestions[32] = "Level 3 Question 2";
        LevelQuestions[33] = "Level 3 Question 2.1";
        LevelQuestions[34] = "Level 3 Question 3";
        LevelQuestions[35] = "Level 3 Question 3.1";
        LevelQuestions[36] = "Level 3 Question 4";
        LevelQuestions[37] = "Level 3 Question 4.1";
        LevelQuestions[38] = "Level 3 Question 5";
        LevelQuestions[39] = "Level 3 Question 5.1";
        LevelQuestions[40] = "Level 3 Question 6";
        LevelQuestions[41] = "Level 3 Question 6.1";
        LevelQuestions[42] = "Level 3 Question 7";
        LevelQuestions[43] = "Level 3 Question 7.1";
        LevelQuestions[44] = "Level 3 Question 8";
        LevelQuestions[45] = "Level 3 Question 8.1";
        LevelQuestions[46] = "Level 3 Question 9";
        LevelQuestions[47] = "Level 3 Question 9.1";
        LevelQuestions[48] = "Level 3 Question 10";
        LevelQuestions[49] = "Level 3 Question 10.1";

        String[] correctAnswers = new String[50];
        correctAnswers[0] = "attend";
        correctAnswers[1] = "Lv1Q2A2";
        correctAnswers[2] = "Lv1Q3A3";
        correctAnswers[3] = "Lv1Q4A1";
        correctAnswers[4] = "Lv1Q5A2";
        correctAnswers[5] = "Lv1Q6A3";
        correctAnswers[6] = "Lv1Q7A1";
        correctAnswers[7] = "Lv1Q8A2";
        correctAnswers[8] = "Lv1Q9A3";
        correctAnswers[9] = "Lv1Q10A1";

        correctAnswers[10] = "a fini";
        correctAnswers[11] = "peut";
        correctAnswers[12] = "Lv2Q2A2";
        correctAnswers[13] = "Lv2Q2A2.1";
        correctAnswers[14] = "Lv2Q3A3";
        correctAnswers[15] = "Lv2Q3A3.1";
        correctAnswers[16] = "Lv2Q4A1";
        correctAnswers[17] = "Lv2Q4A1.1";
        correctAnswers[18] = "Lv2Q5A2";
        correctAnswers[19] = "Lv2Q5A2.1";
        correctAnswers[20] = "Lv2Q6A2";
        correctAnswers[21] = "Lv2Q6A2.1";
        correctAnswers[22] = "Lv2Q7A2";
        correctAnswers[23] = "Lv2Q7A2.1";
        correctAnswers[24] = "Lv2Q8A2";
        correctAnswers[25] = "Lv2Q8A2.1";
        correctAnswers[26] = "Lv2Q9A2";
        correctAnswers[27] = "Lv2Q9A2.1";
        correctAnswers[28] = "Lv2Q10A2";
        correctAnswers[29] = "Lv2Q10A2.1";

        correctAnswers[30] = "Lv3Q1A1";
        correctAnswers[31] = "Lv3Q1A1.1";
        correctAnswers[32] = "Lv3Q2A2";
        correctAnswers[33] = "Lv3Q2A2.1";
        correctAnswers[34] = "Lv3Q3A3";
        correctAnswers[35] = "Lv3Q3A3.1";
        correctAnswers[36] = "Lv3Q4A1";
        correctAnswers[37] = "Lv3Q4A1.1";
        correctAnswers[38] = "Lv3Q5A2";
        correctAnswers[39] = "Lv3Q5A2.1";
        correctAnswers[40] = "Lv3Q6A3";
        correctAnswers[41] = "Lv3Q6A3.1";
        correctAnswers[42] = "Lv3Q7A1";
        correctAnswers[43] = "Lv3Q7A1.1";
        correctAnswers[44] = "Lv3Q8A2";
        correctAnswers[45] = "Lv3Q8A2.1";
        correctAnswers[46] = "Lv3Q9A3";
        correctAnswers[47] = "Lv3Q9A3.1";
        correctAnswers[48] = "Lv3Q10A1";
        correctAnswers[49] = "Lv3Q10A1.1";

        String[] shownAnswer = new String[50];
        shownAnswer[0] = "Jean attend le bus pour aller à l'école.";
        shownAnswer[1] = "Lv1Q2A2";
        shownAnswer[2] = "Lv1Q3A3";
        shownAnswer[3] = "Lv1Q4A1";
        shownAnswer[4] = "Lv1Q5A2";
        shownAnswer[5] = "Lv1Q6A3";
        shownAnswer[6] = "Lv1Q7A1";
        shownAnswer[7] = "Lv1Q8A2";
        shownAnswer[8] = "Lv1Q9A3";
        shownAnswer[9] = "Lv1Q10A1";

        shownAnswer[10] = "Sara a fini ses devoir mewtenant elle ____ regarder le television.";
        shownAnswer[11] = "Sara a fini ses devoir mewtenant elle peut regarder le television.";
        shownAnswer[12] = "Lv2Q2A2";
        shownAnswer[13] = "Lv2Q2A2.1";
        shownAnswer[14] = "Lv2Q3A3";
        shownAnswer[15] = "Lv2Q3A3.1";
        shownAnswer[16] = "Lv2Q4A1";
        shownAnswer[17] = "Lv2Q4A1.1";
        shownAnswer[18] = "Lv2Q5A2";
        shownAnswer[19] = "Lv2Q5A2.1";
        shownAnswer[20] = "Lv2Q6A3";
        shownAnswer[21] = "Lv2Q6A3.1";
        shownAnswer[22] = "Lv2Q7A1";
        shownAnswer[23] = "Lv2Q7A1.1";
        shownAnswer[24] = "Lv2Q8A2";
        shownAnswer[25] = "Lv2Q8A2.1";
        shownAnswer[26] = "Lv2Q9A3";
        shownAnswer[27] = "Lv2Q9A3.1";
        shownAnswer[28] = "Lv2Q10A1";
        shownAnswer[29] = "Lv2Q10A1.1";

        shownAnswer[30] = "Lv3Q1A1";
        shownAnswer[31] = "Lv3Q1A1.1";
        shownAnswer[32] = "Lv3Q2A2";
        shownAnswer[33] = "Lv3Q2A2.1";
        shownAnswer[34] = "Lv3Q3A3";
        shownAnswer[35] = "Lv3Q3A3.1";
        shownAnswer[36] = "Lv3Q4A1";
        shownAnswer[37] = "Lv3Q4A1.1";
        shownAnswer[38] = "Lv3Q5A2";
        shownAnswer[39] = "Lv3Q5A2.1";
        shownAnswer[40] = "Lv3Q6A3";
        shownAnswer[41] = "Lv3Q6A3.1";
        shownAnswer[42] = "Lv3Q7A1";
        shownAnswer[43] = "Lv3Q7A1.1";
        shownAnswer[44] = "Lv3Q8A2";
        shownAnswer[45] = "Lv3Q8A2.1";
        shownAnswer[46] = "Lv3Q9A3";
        shownAnswer[47] = "Lv3Q9A3.1";
        shownAnswer[48] = "Lv3Q10A1";
        shownAnswer[49] = "Lv3Q10A1.1";

        String[] verb = new String[50];
        verb[0] = "Assister ";
        verb[1] = "Lv1Q2VERB";
        verb[2] = "Lv1Q3VERB";
        verb[3] = "Lv1Q4VERB";
        verb[4] = "Lv1Q5VERB";
        verb[5] = "Lv1Q6VERB";
        verb[6] = "Lv1Q7VERB";
        verb[7] = "Lv1Q8VERB";
        verb[8] = "Lv1Q9VERB";
        verb[9] = "Lv1Q10VERB";

        verb[10] = "finir";
        verb[11] = "pouvoir";
        verb[12] = "Lv2Q2VERB";
        verb[13] = "Lv2Q2.1VERB";
        verb[14] = "Lv2Q3VERB";
        verb[15] = "Lv2Q3.1VERB";
        verb[16] = "Lv2Q4VERB";
        verb[17] = "Lv2Q4.1VERB";
        verb[18] = "Lv2Q5VERB";
        verb[19] = "Lv2Q5.1VERB";
        verb[20] = "Lv2Q6VERB";
        verb[21] = "Lv2Q6.1VERB";
        verb[22] = "Lv2Q7VERB";
        verb[23] = "Lv2Q7.1VERB";
        verb[24] = "Lv2Q8VERB";
        verb[25] = "Lv2Q8.1VERB";
        verb[26] = "Lv2Q9VERB";
        verb[27] = "Lv2Q9.1VERB";
        verb[28] = "Lv2Q10VERB";
        verb[29] = "Lv2Q10.1VERB";

        verb[30] = "Lv3Q1VERB";
        verb[31] = "Lv3Q1.1VERB";
        verb[32] = "Lv3Q2VERB";
        verb[33] = "Lv3Q2.1VERB";
        verb[34] = "Lv3Q3VERB";
        verb[35] = "Lv3Q3.1VERB";
        verb[36] = "Lv3Q4VERB";
        verb[37] = "Lv3Q4.1VERB";
        verb[38] = "Lv3Q5VERB";
        verb[39] = "Lv3Q5.1VERB";
        verb[40] = "Lv3Q6VERB";
        verb[41] = "Lv3Q6.1VERB";
        verb[42] = "Lv3Q7VERB";
        verb[43] = "Lv3Q7.1VERB";
        verb[44] = "Lv3Q8VERB";
        verb[45] = "Lv3Q8.1VERB";
        verb[46] = "Lv3Q9VERB";
        verb[47] = "Lv3Q9.1VERB";
        verb[48] = "Lv3Q10VERB";
        verb[49] = "Lv3Q10.1VERB";

        /*String[] image = new String[50];
        image[0] = "Assister ";
        image[1] = "Lv1Q2Image";
        image[2] = "Lv1Q3Image";
        image[3] = "Lv1Q4Image";
        image[4] = "Lv1Q5Image";
        image[4] = "Lv1Q6Image";
        image[4] = "Lv1Q7Image";
        image[4] = "Lv1Q8Image";
        image[4] = "Lv1Q9Image";
        image[4] = "Lv1Q10Image";

        image[5] = "Lv2Q1Image";
        image[5] = "Lv2Q1Image.1";
        image[6] = "Lv2Q2Image";
        image[6] = "Lv2Q2Image.1";
        image[7] = "Lv2Q3Image";
        image[7] = "Lv2Q3Image.1";
        image[8] = "Lv2Q4Image";
        image[8] = "Lv2Q4Image.1";
        image[9] = "Lv2Q5Image";
        image[9] = "Lv2Q5Image.1";
        image[9] = "Lv2Q6Image";
        image[9] = "Lv2Q6Image.1";
        image[9] = "Lv2Q7Image";
        image[9] = "Lv2Q7Image.1";
        image[9] = "Lv2Q8Image";
        image[9] = "Lv2Q8Image.1";
        image[9] = "Lv2Q9Image";
        image[9] = "Lv2Q9Image.1";
        image[9] = "Lv2Q10Image";
        image[9] = "Lv2Q10Image.1";

        image[10] = "Lv3Q1Image";
        image[11] = "Lv3Q2Image";
        image[12] = "Lv3Q3Image";
        image[13] = "Lv3Q4Image";
        image[14] = "Lv3Q5Image";
        image[14] = "Lv3Q6Image";
        image[14] = "Lv3Q7Image";
        image[14] = "Lv3Q8Image";
        image[14] = "Lv3Q9Image";
        image[14] = "Lv3Q10Image";
        image[14] = "Lv3Q1Image.1";
        image[14] = "Lv3Q2Image.1";
        image[14] = "Lv3Q3Image.1";
        image[14] = "Lv3Q4Image.1";
        image[14] = "Lv3Q5Image.1";
        image[14] = "Lv3Q6Image.1";
        image[14] = "Lv3Q8Image.1";
        image[14] = "Lv3Q9Image.1";
        image[14] = "Lv3Q10Image.1";
        */

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

        questionAnswers[5][0] = "Lv1Q6A1";
        questionAnswers[5][1] = "Lv1Q6A2";
        questionAnswers[5][2] = "Lv1Q6A3";
        // questionAnswers[5][3] = "Lv2Q1A4";
        questionAnswers[6][0] = "Lv1Q7A1";
        questionAnswers[6][1] = "Lv1Q7A2";
        questionAnswers[6][2] = "Lv1Q7A3";
        //questionAnswers[6][3] = "Lv2Q2A4";
        questionAnswers[7][0] = "Lv1Q8A1";
        questionAnswers[7][1] = "Lv1Q8A2";
        questionAnswers[7][2] = "Lv1Q8A3";
        // questionAnswers[7][3] = "Lv2Q3A4";
        questionAnswers[8][0] = "Lv1Q9A1";
        questionAnswers[8][1] = "Lv1Q9A2";
        questionAnswers[8][2] = "Lv1Q9A3";
        //questionAnswers[8][3] = "Lv2Q4A4";
        questionAnswers[9][0] = "Lv1Q10A1";
        questionAnswers[9][1] = "Lv1Q10A2";
        questionAnswers[9][2] = "Lv1Q10A3";
        // questionAnswers[9][3] = "Lv2Q5A4";

        questionAnswers[10][0] = "a fini";
        questionAnswers[10][1] = "Lv2Q1A2";
        questionAnswers[10][2] = "Lv2Q1A3";
        questionAnswers[11][0] = "peut";
        questionAnswers[11][1] = "Lv2Q1.1A2";
        questionAnswers[11][2] = "Lv2Q1.1A3";

        questionAnswers[12][0] = "Lv2Q2A1";
        questionAnswers[12][1] = "Lv2Q2A2";
        questionAnswers[12][2] = "Lv2Q2A3";
        questionAnswers[13][0] = "Lv2Q2.1A1";
        questionAnswers[13][1] = "Lv2Q2.1A2";
        questionAnswers[13][2] = "Lv2Q2.1A3";

        questionAnswers[14][0] = "Lv2Q3A1";
        questionAnswers[14][1] = "Lv2Q3A2";
        questionAnswers[14][2] = "Lv2Q3A3";
        questionAnswers[15][0] = "Lv2Q3.1A1";
        questionAnswers[15][1] = "Lv2Q3.1A2";
        questionAnswers[15][2] = "Lv2Q3.1A3";

        questionAnswers[16][0] = "Lv2Q4A1";
        questionAnswers[16][1] = "Lv2Q4A2";
        questionAnswers[16][2] = "Lv2Q4A3";
        questionAnswers[17][0] = "Lv2Q4.1A1";
        questionAnswers[17][1] = "Lv2Q4.1A2";
        questionAnswers[17][2] = "Lv2Q4.1A3";

        questionAnswers[18][0] = "Lv2Q5A1";
        questionAnswers[18][1] = "Lv2Q5A2";
        questionAnswers[18][2] = "Lv2Q5A3";
        questionAnswers[19][0] = "Lv2Q5.1A1";
        questionAnswers[19][1] = "Lv2Q5.1A2";
        questionAnswers[19][2] = "Lv2Q5.1A3";

        questionAnswers[20][0] = "Lv2Q6A1";
        questionAnswers[20][1] = "Lv2Q6A2";
        questionAnswers[20][2] = "Lv2Q6A3";
        questionAnswers[21][0] = "Lv2Q6.1A1";
        questionAnswers[21][1] = "Lv2Q6.1A2";
        questionAnswers[21][2] = "Lv2Q6.1A3";

        questionAnswers[22][0] = "Lv2Q7A1";
        questionAnswers[22][1] = "Lv2Q7A2";
        questionAnswers[22][2] = "Lv2Q7A3";
        questionAnswers[23][0] = "Lv2Q7.1A1";
        questionAnswers[23][1] = "Lv2Q7.1A2";
        questionAnswers[23][2] = "Lv2Q7.1A3";

        questionAnswers[24][0] = "Lv2Q8A1";
        questionAnswers[24][1] = "Lv2Q8A2";
        questionAnswers[24][2] = "Lv2Q8A3";
        questionAnswers[25][0] = "Lv2Q8.1A1";
        questionAnswers[25][1] = "Lv2Q8.1A2";
        questionAnswers[25][2] = "Lv2Q8.1A3";

        questionAnswers[26][0] = "Lv2Q9A1";
        questionAnswers[26][1] = "Lv2Q9A2";
        questionAnswers[26][2] = "Lv2Q9A3";
        questionAnswers[27][0] = "Lv2Q9.1A1";
        questionAnswers[27][1] = "Lv2Q9.1A2";
        questionAnswers[27][2] = "Lv2Q9.1A3";

        questionAnswers[28][0] = "Lv2Q10A1";
        questionAnswers[28][1] = "Lv2Q10A2";
        questionAnswers[28][2] = "Lv2Q10A3";
        questionAnswers[29][0] = "Lv2Q10.1A1";
        questionAnswers[29][1] = "Lv2Q10.1A2";
        questionAnswers[29][2] = "Lv2Q10.1A3";

        questionAnswers[30][0] = "Lv3Q1A1";
        questionAnswers[30][1] = "Lv3Q1A2";
        questionAnswers[30][2] = "Lv3Q1A3";
        questionAnswers[31][0] = "Lv3Q1.1A1";
        questionAnswers[31][1] = "Lv3Q1.1A2";
        questionAnswers[31][2] = "Lv3Q1.1A3";

        questionAnswers[32][0] = "Lv3Q2A1";
        questionAnswers[32][1] = "Lv3Q2A2";
        questionAnswers[32][2] = "Lv3Q2A3";
        questionAnswers[33][0] = "Lv3Q2.1A1";
        questionAnswers[33][1] = "Lv3Q2.1A2";
        questionAnswers[33][2] = "Lv3Q2.1A3";

        questionAnswers[34][0] = "Lv3Q3A1";
        questionAnswers[34][1] = "Lv3Q3A2";
        questionAnswers[34][2] = "Lv3Q3A3";
        questionAnswers[35][0] = "Lv3Q3.1A1";
        questionAnswers[35][1] = "Lv3Q3.1A2";
        questionAnswers[35][2] = "Lv3Q3.1A3";

        questionAnswers[36][0] = "Lv3Q4A1";
        questionAnswers[36][1] = "Lv3Q4A2";
        questionAnswers[36][2] = "Lv3Q4A3";
        questionAnswers[37][0] = "Lv3Q4.1A1";
        questionAnswers[37][1] = "Lv3Q4.1A2";
        questionAnswers[37][2] = "Lv3Q4.1A3";

        questionAnswers[38][0] = "Lv3Q5A1";
        questionAnswers[38][1] = "Lv3Q5A2";
        questionAnswers[38][2] = "Lv3Q5A3";
        questionAnswers[39][0] = "Lv3Q5.1A1";
        questionAnswers[39][1] = "Lv3Q5.1A2";
        questionAnswers[39][2] = "Lv3Q5.1A3";

        questionAnswers[40][0] = "Lv3Q6A1";
        questionAnswers[40][1] = "Lv3Q6A2";
        questionAnswers[40][2] = "Lv3Q6A3";
        questionAnswers[41][0] = "Lv3Q6.1A1";
        questionAnswers[41][1] = "Lv3Q6.1A2";
        questionAnswers[41][2] = "Lv3Q6.1A3";

        questionAnswers[42][0] = "Lv3Q7A1";
        questionAnswers[42][1] = "Lv3Q7A2";
        questionAnswers[42][2] = "Lv3Q7A3";
        questionAnswers[43][0] = "Lv3Q7.1A1";
        questionAnswers[43][1] = "Lv3Q7.1A2";
        questionAnswers[43][2] = "Lv3Q7.1A3";

        questionAnswers[44][0] = "Lv3Q8A1";
        questionAnswers[44][1] = "Lv3Q8A2";
        questionAnswers[44][2] = "Lv3Q8A3";
        questionAnswers[45][0] = "Lv3Q8.1A1";
        questionAnswers[45][1] = "Lv3Q8.1A2";
        questionAnswers[45][2] = "Lv3Q8.1A3";

        questionAnswers[46][0] = "Lv3Q9A1";
        questionAnswers[46][1] = "Lv3Q9A2";
        questionAnswers[46][2] = "Lv3Q9A3";
        questionAnswers[47][0] = "Lv3Q9.1A1";
        questionAnswers[47][1] = "Lv3Q9.1A2";
        questionAnswers[47][2] = "Lv3Q9.1A3";

        questionAnswers[48][0] = "Lv3Q10A1";
        questionAnswers[48][1] = "Lv3Q10A2";
        questionAnswers[48][2] = "Lv3Q10A3";
        questionAnswers[49][0] = "Lv3Q10.1A1";
        questionAnswers[49][1] = "Lv3Q10.1A2";
        questionAnswers[49][2] = "Lv3Q10.1A3";

        questionData = new Question[50];
        for (int i = 0; i < 50; i++) {
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
                    levelData[i].six = questionData[5];
                    levelData[i].seven = questionData[6];
                    levelData[i].eight = questionData[7];
                    levelData[i].nine = questionData[8];
                    levelData[i].ten = questionData[9];
                    break;
                case 1:
                    levelData[i].one = questionData[10];
                    levelData[i].two = questionData[11];
                    levelData[i].three = questionData[12];
                    levelData[i].four = questionData[13];
                    levelData[i].five = questionData[14];
                    levelData[i].six = questionData[15];
                    levelData[i].seven = questionData[16];
                    levelData[i].eight = questionData[17];
                    levelData[i].nine = questionData[18];
                    levelData[i].ten = questionData[19];

                    levelData[i].one1 = questionData[20];
                    levelData[i].two1 = questionData[21];
                    levelData[i].three1 = questionData[22];
                    levelData[i].four1 = questionData[23];
                    levelData[i].five1 = questionData[24];
                    levelData[i].six1 = questionData[25];
                    levelData[i].seven1 = questionData[26];
                    levelData[i].eight1 = questionData[27];
                    levelData[i].nine1 = questionData[28];
                    levelData[i].ten1 = questionData[29];
                    break;
                case 2:
                    levelData[i].one = questionData[30];
                    levelData[i].two = questionData[31];
                    levelData[i].three = questionData[32];
                    levelData[i].four = questionData[33];
                    levelData[i].five = questionData[34];
                    levelData[i].six = questionData[35];
                    levelData[i].seven = questionData[36];
                    levelData[i].eight = questionData[37];
                    levelData[i].nine = questionData[38];
                    levelData[i].ten = questionData[39];

                    levelData[i].one1 = questionData[40];
                    levelData[i].two1 = questionData[41];
                    levelData[i].three1 = questionData[42];
                    levelData[i].four1 = questionData[43];
                    levelData[i].five1 = questionData[44];
                    levelData[i].six1 = questionData[45];
                    levelData[i].seven1 = questionData[46];
                    levelData[i].eight1 = questionData[47];
                    levelData[i].nine1 = questionData[48];
                    levelData[i].ten1 = questionData[49];
                    break;
                default:
                    levelData[i].one = questionData[0];
                    levelData[i].two = questionData[1];
                    levelData[i].three = questionData[2];
                    levelData[i].four = questionData[3];
                    levelData[i].five = questionData[4];
                    levelData[i].six = questionData[5];
                    levelData[i].seven = questionData[6];
                    levelData[i].eight = questionData[7];
                    levelData[i].nine = questionData[8];
                    levelData[i].ten = questionData[9];

                    levelData[i].one1 = questionData[10];
                    levelData[i].two1 = questionData[11];
                    levelData[i].three1 = questionData[12];
                    levelData[i].four1 = questionData[13];
                    levelData[i].five1 = questionData[14];
                    levelData[i].six1 = questionData[15];
                    levelData[i].seven1 = questionData[16];
                    levelData[i].eight1 = questionData[17];
                    levelData[i].nine1 = questionData[18];
                    levelData[i].ten1 = questionData[19];
                    break;
            }
        }
    }

    /*public void saveGame(int levelID, int questionID, int stage) {
        prefs.edit().putInt("level", levelData[level].ID).apply();
        //prefs.edit().putInt("question", questionData[questionID].ID).apply();
        //prefs.edit().putInt("stage", stage).apply();
    }*/

    public void QuestionOneSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].one.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].one.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].one.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].one.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].one.option3);
    }

    public void QuestionOneP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].one1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].one1.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].one1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].one1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].one1.option3);
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

    public void QuestionTwoP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].two1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].two1.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].two1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].two1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].two1.option3);
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

    public void QuestionThreeP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].three1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].three1.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].three1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].three1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].three1.option3);
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

    public void QuestionFourP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].four1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].four1.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].four1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].four1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].four1.option3);
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

    public void QuestionFiveP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].five1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].five1.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].five1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].five1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].five1.option3);
    }

    public void QuestionSixSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].six.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].six.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].six.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].six.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].six.option3);
    }

    public void QuestionSixP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].six1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].six1.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].six1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].six1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].six1.option3);
    }

    public void QuestionSevenSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].seven.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].seven.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].seven.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].seven.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].seven.option3);
    }

    public void QuestionSevenP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].seven1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].seven1.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].seven1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].seven1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].seven1.option3);
    }

    public void QuestionEightSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].eight.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].eight.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].eight.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].eight.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].eight.option3);
    }

    public void QuestionEightP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].eight1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].eight1.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].eight1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].eight1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].eight1.option3);
    }

    public void QuestionNineSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].nine.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].nine.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].nine.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].nine.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].nine.option3);
    }

    public void QuestionNineP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].nine1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].nine1.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].nine1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].nine1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].nine1.option3);
    }

    public void QuestionTenSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].ten.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].ten.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].ten.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].ten.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].ten.option3);
    }

    public void QuestionTenP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].ten1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].ten1.verb);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].ten1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].ten1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].ten1.option3);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game);
        prefs = this.getSharedPreferences("com.globaltelecomunicationinc.conjugationstation", MODE_PRIVATE);
        initViews();
        setListeners();
        relativeLayout.getBackground().setAlpha(120);
        theUser = new User();
        theUser.score = prefs.getInt("score", -1);

        setUpAllQuestions();
        setUpAllLevels();
        resetGame();

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
            //Start level 2
            if (prefs.getInt("level", -1) == 0) {
                Toast.makeText(getApplicationContext(), "Last time you scored \n" + prefs.getInt("levelOneOver", -1) + " on level one", Toast.LENGTH_SHORT).show();
            } else if (prefs.getInt("level", -1) == 1) {
                Toast.makeText(getApplicationContext(), "Last time you scored \n" + prefs.getInt("levelTwoOver", -1) + " on level two", Toast.LENGTH_SHORT).show();
            } else if (prefs.getInt("level", -1) == 2) {
                Toast.makeText(getApplicationContext(), "Last time you scored \n" + prefs.getInt("levelThreeOver", -1) + " on level two", Toast.LENGTH_SHORT).show();
            } else {
                //TODO: display
                Toast.makeText(getApplicationContext(), "ERROR the game does not have a level set for you.", Toast.LENGTH_SHORT).show();
            }
            prefs.getInt("level", -1);
            leveldone = level1Score = level2Score = level3Score = 0;
            QuestionOneSetup();
        }
    }

    public void resetGame() {
        level1Score = 0;
        level2Score = 0;
        level3Score = 0;
        prefs.edit().putInt("level", 0).apply();
        levelScore = 0;
    }

    public void updateGame(String userAnswer) {
        initViews();
        setListeners();

        Log.i("level ", prefs.getInt("level", -1) + " Level Done  " + String.valueOf(leveldone));
        //Log.i("scores: ", " level1 " + String.valueOf(level1Score) + " level2 " + String.valueOf(level2Score) + " level3 " + String.valueOf(level3Score));

        if ((level1Score == 10) && (level2Score == 10) && (level3Score == 10)) {
            gameOver("Game Finished", "You have read over the game!", "Play Again", "Exit");
        } else {
            Toast.makeText(getApplicationContext(), "Game not over", Toast.LENGTH_SHORT).show();
        }

        //LEVEL 1 start
        if ((prefs.getInt("level", -1) == 0) && (leveldone < 10) && ((level1Score < 10))) {
            tvScore.setText(String.valueOf(level1Score) + "/10");

            switch (leveldone) {
                //level 1 question 1 attempt 1
                case 0:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                //level 1 question 1 attempt 2
                case 1:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    } else {
                        Toast.makeText(getApplicationContext(), "Q1 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    }
                    break;

                //level 1 question 2 attempt 1
                case 2:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                //level 1 question 2 attempt 2
                case 3:
                    break;

                //level 1 question 3 attempt 1
                case 4:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                //level 1 question 3 attempt 2
                case 5:
                    break;

                //level 1 question 4 attempt 1
                case 6:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                //level 1 question 4 attempt 2
                case 7:
                    break;

                //level 1 question 5 attempt 1
                case 8:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                //level 1 question 5 attempt 2
                case 9:
                    break;

                //level 1 question 6 attempt 1
                case 10:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                //level 1 question 6 attempt 2
                case 11:
                    break;

                //level 1 question 7 attempt 1
                case 12:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                //level 1 question 7 attempt 2
                case 13:
                    break;

                //level 1 question 8 attempt 1
                case 14:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                //level 1 question 8 attempt 2
                case 15:
                    break;

                //level 1 question 9 attempt 1
                case 16:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        leveldone = 2;//to start Q2L1
                        QuestionTwoSetup();
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                //level 1 question 9 attempt 2
                case 17:
                    break;

                //level 1 question 10 attempt 1
                case 18:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                        new CountDownTimer(1500, 1000) {
                            public void onTick(long miliSecondsUntilDone) {
                                //Countdown is counting down (in this case every second)
                                Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                            }
                            public void onFinish() {
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                        level1Score++;
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                        if (level1Score == 10) {
                            //Start level 2
                            prefs.edit().putInt("levelOneOver", level1Score).apply();
                            prefs.edit().putInt("level", 1).apply();
                            leveldone = 0;
                            QuestionOneSetup();
                        } else {
                            //game over
                            prefs.edit().putInt("levelOneOver", level1Score).apply();
                            prefs.edit().putInt("level", 0).apply();
                            leveldone = 0;
                            gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level1Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                        leveldone++;
                    }
                    break;
                //level 1 question 10 attempt 2
                case 19:
                    if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                        //go to next question
                        Toast.makeText(getApplicationContext(), "Q5 Correct", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText("Q10p2 Correct");
                        level1Score++;
                        leveldone = 10;//to start Q2L1
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                        if (level1Score == 10) {
                            //Start level 2
                            prefs.edit().putInt("levelOneOver", level1Score).apply();
                            prefs.edit().putInt("level", 1).apply();
                            leveldone = 0;
                            QuestionOneSetup();
                        } else {
                            //game over
                            prefs.edit().putInt("levelOneOver", level1Score).apply();
                            prefs.edit().putInt("level", 0).apply();
                            leveldone = 0;
                            gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level1Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Q5 Wrong", Toast.LENGTH_SHORT).show();
                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                        tvWrong.setVisibility(View.VISIBLE);
                        tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                        tvWrong.setText(levelData[prefs.getInt("level", -1)].ten1.shownAnswer);
                        tvScore.setText(String.valueOf(level1Score) + "/10");
                        leveldone = 10;//to start Q2L1
                        prefs.edit().putInt("levelOneOver", level1Score).apply();
                        prefs.edit().putInt("level", 0).apply();
                        leveldone = 0;
                        gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level1Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                    }
                    break;
            }
        }

        //LEVEL 2 Begins
        if ((level2Score < 10) && (prefs.getInt("level", -1) == 1)) {
            tvScore.setText(String.valueOf(level2Score) + "/10");

            switch (leveldone) {
                //level 2 question 1 attempt 1
                case 0:
                    break;
                //level 2 question 1 attempt 2
                case 1:
                    break;
                //level 2 question 1.1 attempt 1
                case 2:
                    break;
                //level 2 question 1.1 attempt 2
                case 3:
                    break;

                //level 2 question 2 attempt 1
                case 4:
                    break;
                //level 2 question 2 attempt 2
                case 5:
                    break;
                //level 2 question 2.1 attempt 1
                case 6:
                    break;
                //level 2 question 2.1 attempt 2
                case 7:
                    break;

                //level 2 question 3 attempt 1
                case 8:
                    break;
                //level 2 question 3 attempt 2
                case 9:
                    break;
                //level 2 question 3.1 attempt 1
                case 10:
                    break;
                //level 2 question 3.1 attempt 2
                case 11:
                    break;

                //level 2 question 4 attempt 1
                case 12:
                    break;
                //level 2 question 4 attempt 2
                case 13:
                    break;
                //level 2 question 4.1 attempt 1
                case 14:
                    break;
                //level 2 question 4.1 attempt 2
                case 15:
                    break;

                //level 2 question 5 attempt 1
                case 16:
                    break;
                //level 2 question 5 attempt 2
                case 17:
                    break;
                //level 2 question 5.1 attempt 1
                case 18:
                    break;
                //level 2 question 5.1 attempt 2
                case 19:
                    break;

                //level 2 question 6 attempt 1
                case 20:
                    break;
                //level 2 question 6 attempt 2
                case 21:
                    break;
                //level 2 question 6.1 attempt 1
                case 22:
                    break;
                //level 2 question 6.1 attempt 2
                case 23:
                    break;

                //level 2 question 7 attempt 1
                case 24:
                    break;
                //level 2 question 7 attempt 2
                case 25:
                    break;
                //level 2 question 7.1 attempt 1
                case 26:
                    break;
                //level 2 question 7.1 attempt 2
                case 27:
                    break;

                //level 2 question 8 attempt 1
                case 28:
                    break;
                //level 2 question 8 attempt 2
                case 29:
                    break;
                //level 2 question 8.1 attempt 1
                case 30:
                    break;
                //level 2 question 8.1 attempt 2
                case 31:
                    break;

                //level 2 question 9 attempt 1
                case 32:
                    break;
                //level 2 question 9 attempt 2
                case 33:
                    break;
                //level 2 question 9.1 attempt 1
                case 34:
                    break;
                //level 2 question 9.1 attempt 2
                case 35:
                    break;

                //level 2 question 10 attempt 1
                case 36:
                    break;
                //level 2 question 10 attempt 2
                case 37:
                    break;
                //level 2 question 10.1 attempt 1
                case 38:
                    break;
                //level 2 question 10.1 attempt 2
                case 39:
                    break;
            }
        } else {
            //The user either has not reached level 2 or an error occured when trying to get to level 2
        }

        //LEVEL 3 begins
        if ((level3Score < 10) && (prefs.getInt("level", -1) == 2)) {
            tvScore.setText(String.valueOf(level3Score) + "/10");
            //level tries to keep track of when a level needst to be retried
            //check levelscores
            //runLevelOne(leveldone, userAnswer);
            switch (leveldone) {
                //level 3 question 1 attempt 1
                case 0:
                    break;
                //level 3 question 1 attempt 2
                case 1:
                    break;
                //level 3 question 1.1 attempt 1
                case 2:
                    break;
                //level 3 question 1.1 attempt 2
                case 3:
                    break;

                //level 3 question 2 attempt 1
                case 4:
                    break;
                //level 3 question 2 attempt 2
                case 5:
                    break;
                //level 3 question 2.1 attempt 1
                case 6:
                    break;
                //level 3 question 2.1 attempt 2
                case 7:
                    break;

                //level 3 question 3 attempt 1
                case 8:
                    break;
                //level 3 question 3 attempt 2
                case 9:
                    break;
                //level 3 question 3.1 attempt 1
                case 10:
                    break;
                //level 3 question 3.1 attempt 2
                case 11:
                    break;

                //level 3 question 4 attempt 1
                case 12:
                    break;
                //level 3 question 4 attempt 2
                case 13:
                    break;
                //level 3 question 4.1 attempt 1
                case 14:
                    break;
                //level 3 question 4.1 attempt 2
                case 15:
                    break;

                //level 3 question 5 attempt 1
                case 16:
                    break;
                //level 3 question 5 attempt 2
                case 17:
                    break;
                //level 3 question 5.1 attempt 1
                case 18:
                    break;
                //level 3 question 5.1 attempt 2
                case 19:
                    break;

                //level 3 question 6 attempt 1
                case 20:
                    break;
                //level 3 question 6 attempt 2
                case 21:
                    break;
                //level 3 question 6.1 attempt 1
                case 22:
                    break;
                //level 3 question 6.1 attempt 2
                case 23:
                    break;

                //level 3 question 7 attempt 1
                case 24:
                    break;
                //level 3 question 7 attempt 2
                case 25:
                    break;
                //level 3 question 7.1 attempt 1
                case 26:
                    break;
                //level 3 question 7.1 attempt 2
                case 27:
                    break;

                //level 3 question 8 attempt 1
                case 28:
                    break;
                //level 3 question 8 attempt 2
                case 29:
                    break;
                //level 3 question 8.1 attempt 1
                case 30:
                    break;
                //level 3 question 8.1 attempt 2
                case 31:
                    break;

                //level 3 question 9 attempt 1
                case 32:
                    break;
                //level 3 question 9 attempt 2
                case 33:
                    break;
                //level 3 question 9.1 attempt 1
                case 34:
                    break;
                //level 3 question 9.1 attempt 2
                case 35:
                    break;

                //level 3 question 10 attempt 1
                case 36:
                    break;
                //level 3 question 10 attempt 2
                case 37:
                    break;
                //level 3 question 10.1 attempt 1
                case 38:
                    break;
                //level 3 question 10.1 attempt 2
                case 39:
                    break;
            }
        } else {
            //The user either has not reached level 3 or an error occured when trying to get to read over the game
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