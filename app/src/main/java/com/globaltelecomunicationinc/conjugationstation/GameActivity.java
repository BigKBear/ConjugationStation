package com.globaltelecomunicationinc.conjugationstation;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
//import android.graphics.Color;
//import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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
        LevelQuestions[0] = "Jean _____ le bus pour aller à l'école.";
        LevelQuestions[1] = "Aie! J' ___ mal au vent!";
        LevelQuestions[2] = "Oh la la! Il ___ chaud!";
        LevelQuestions[3] = "Marie ___ de marcher. Ça fait du bien!";
        LevelQuestions[4] = "Voia ma jolie ___ !";
        LevelQuestions[5] = "Ces sont ses ___ préfèrés";
        LevelQuestions[6] = "Pendant l'été les personnes ___ beacoup des mangues.";
        LevelQuestions[7] = "Les plages de la Barbade ___ les plus belles";
        LevelQuestions[8] = "Quand il ___ il feut froid.";
        LevelQuestions[9] = "Ses ___ sont trôp sérré.";

        LevelQuestions[10] = "Ma soeur ___ est trois ans plus jeune que moi.";
        LevelQuestions[11] = "No part 2 click Lv2Q1A1.1";
        LevelQuestions[12] = "___ attention! le prof a dit aux eleves in attentives.";
        LevelQuestions[13] = "No part 2 click Lv2Q2A1.1";
        LevelQuestions[14] = "Il ___ aujourd 'hui, donc je ___ mon parapluie.";
        LevelQuestions[15] = "Il ___ aujourd 'hui, donc je ___ mon parapluie.";
        LevelQuestions[16] = "Les Mathematique sont si ___ les eleves endorment.";
        LevelQuestions[17] = "No part 2 click Lv2Q4A1.1";
        LevelQuestions[18] = "Chloe ___ sa jambe hier soir.";
        LevelQuestions[19] = "No part 2 click Lv2Q5A1.1";
        LevelQuestions[20] = "Claude est tres ___ une feis qui! commencera parler, il est impossible de L'arreter!";
        LevelQuestions[21] = "No part 2 click L2Q6A1.1";
        LevelQuestions[22] = "___ ! le pref a dit avant les.";
        LevelQuestions[23] = "No part 2 click Lv2Q7A1.1";
        LevelQuestions[24] = "Je ___ le repulsif parce que moustiques mardae beaucoup!";
        LevelQuestions[25] = "No part 2 click L2Q8A1.1";
        LevelQuestions[26] = "Sara ___ ses devoirs tot donc elle ___ regarder la television.";
        LevelQuestions[27] = "Sara ___ ses devoirs tot donc elle ___ regarder la television.";
        LevelQuestions[28] = "Nous ___ les jeux de viders pendant tout le3 soir!";
        LevelQuestions[29] = "No part 2 click Lv2Q10A1.1";

        LevelQuestions[30] = "Oh non! Le chien ___ le petit garçon!";
        LevelQuestions[31] = "No part 2 click Lv3Q1A1.1";
        LevelQuestions[32] = "Manon ___ Paris avec sa fanille l'année passe.";
        LevelQuestions[33] = "No part 2 click Lv3Q2A1.1";
        LevelQuestions[34] = "Le garçon méchant ___ les jeux de video au lieu de ___ ses devoirs.";
        LevelQuestions[35] = "Le garçon méchant ___ les jeux de video au lieu de ___ ses devoirs.";
        LevelQuestions[36] = "Marle ___ de ___ au Marco.";
        LevelQuestions[37] = "Marle ___ de ___ au Marco.";
        LevelQuestions[38] = "Cecile et ses amies ___ ent ville pour acheter les tenues nouvellrs pour CropOver.";
        LevelQuestions[39] = "No part 2 click Lv3Q5A1.1";
        LevelQuestions[40] = "La fille ___ et elle ___ son bras.";
        LevelQuestions[41] = "No part 2 click Lv3Q6A1.1";
        LevelQuestions[42] = "Elodie a pleuré beaucoup parce son chat ___.";
        LevelQuestions[43] = "No part 2 click Lv3Q7A1.1";
        LevelQuestions[44] = "Yanis ___ ses lunettes.";
        LevelQuestions[45] = "No part 2 click Lv3Q8A1.1";
        LevelQuestions[46] = "Le maman de Pierre lui accompagne partout parce qui'l ___ facilement.";
        LevelQuestions[47] = "No part 2 click Lv3Q9A1.1";
        LevelQuestions[48] = "Nous ___ à nons examens donc hes parent nous ___.";
        LevelQuestions[49] = "Nous ___ à nons examens donc hes parent nous ___.";

        String[] correctAnswers = new String[50];
        correctAnswers[0] = "attend";
        correctAnswers[1] = "ai";
        correctAnswers[2] = "fait";
        correctAnswers[3] = "aime";
        correctAnswers[4] = "robe";
        correctAnswers[5] = "chaussures";
        correctAnswers[6] = "mangent";
        correctAnswers[7] = "sont";
        correctAnswers[8] = "neige";
        correctAnswers[9] = "pantalons";

        correctAnswers[10] = "cadette";
        correctAnswers[11] = "Lv2Q1A1.1";
        correctAnswers[12] = "faites";
        correctAnswers[13] = "Lv2Q2A1.1";
        correctAnswers[14] = "pleut";
        correctAnswers[15] = "prendre";
        correctAnswers[16] = "ennuyeuses";
        correctAnswers[17] = "Lv2Q4A1.1";
        correctAnswers[18] = "a blesse";
        correctAnswers[19] = "Lv2Q5A1.1";
        correctAnswers[20] = "bavard";
        correctAnswers[21] = "Lv2Q6A1.1";
        correctAnswers[22] = "Felicitations";
        correctAnswers[23] = "Lv2Q7A1.1";
        correctAnswers[24] = "mets";
        correctAnswers[25] = "Lv2Q8A1.1";
        correctAnswers[26] = "a fini";
        correctAnswers[27] = "peut";
        correctAnswers[28] = "auront";
        correctAnswers[29] = "Lv2Q10A1.1";

        correctAnswers[30] = "a mordu";
        correctAnswers[31] = "Lv3Q1A1.1";
        correctAnswers[32] = "a visite";
        correctAnswers[33] = "Lv3Q2A1.1";
        correctAnswers[34] = "a joue";
        correctAnswers[35] = "faire";
        correctAnswers[36] = "-";
        correctAnswers[37] = "-";
        correctAnswers[38] = "-";
        correctAnswers[39] = "Lv3Q5A1.1";
        correctAnswers[40] = "-";
        correctAnswers[41] = "-";
        correctAnswers[42] = "-";
        correctAnswers[43] = "Lv3Q7A1.1";
        correctAnswers[44] = "-";
        correctAnswers[45] = "Lv3Q8A1.1";
        correctAnswers[46] = "-";
        correctAnswers[47] = "Lv3Q9A1.1";
        correctAnswers[48] = "-";
        correctAnswers[49] = "-";

        String[] shownAnswer = new String[50];
        shownAnswer[0] = "<b>Jean <u>attend</u> le bus pour aller à l'école.</b>";
        shownAnswer[1] = "<b>Aie! J' <u>ai</u> mal au vent!</b>";
        shownAnswer[2] = "<b>Oh la la! Il <u>fait</u> chaud!</b>";
        shownAnswer[3] = "<b>Marie <u>aime</u> de marcher. Ça fait du bien!</b>";
        shownAnswer[4] = "<b>Voia ma jolie <u>robe</u>!</b>";
        shownAnswer[5] = "<b>Ces sont ses <u>chaussures</u> préfèrés.</b>";
        shownAnswer[6] = "<b>Pendant l'été les personnes <u>managent</u> beacoup des mangues.</b>";
        shownAnswer[7] = "<b>Les plages de la Barbade <u>sont</u> les plus belles.</b>";
        shownAnswer[8] = "<b>Quand il <u>neige</u> il feut froid.</b>";
        shownAnswer[9] = "<b>Ses <u>pantalons</u> sont trôp sérré.</b>";

        shownAnswer[10] = "<b>Ma soeur <u>cadette</u> est trois ans plus jeune que moi.</b>";
        shownAnswer[11] = "<b>L2Q1A1.1";
        shownAnswer[12] = "<b><u>Faites</u> attention! le prof a dit aux élèves inattentives.</b>";
        shownAnswer[13] = "<b>L2Q2A1.1";
        shownAnswer[14] = "<b>Il <u>pleut</u> aujourd 'hui, donc je ___ mon parapluie.</b>";
        shownAnswer[15] = "<b>Il <u>pleut</u> aujourd 'hui, donc je <u>umon</u> parapluie.</b>";
        shownAnswer[16] = "<b>Les Mathematique sont si <u>ennuyeuses</u> les élèves endorment.</b>";
        shownAnswer[17] = "<b>L2Q4A1.1";
        shownAnswer[18] = "<b>Chloe <u>a blesse</u> sa jambe hier soir.</b>";
        shownAnswer[19] = "<b>L2Q5A1.1";
        shownAnswer[20] = "<b>Claude est très <u>bavard</u> une feis qui! commencerà parler, il est impossible de L'arrêter!</b>";
        shownAnswer[21] = "<b>L2Q6A1.1";
        shownAnswer[22] = "<b><u>Felicitations!</u> le pref a dit avant les.</b>";
        shownAnswer[23] = "<b>L2Q7A1.1";
        shownAnswer[24] = "<b>Je <u>mets</u> le répulsif parce que moustiques mardae beaucoup!</b>";
        shownAnswer[25] = "<b>L2Q8A1.1";
        shownAnswer[26] = "<b>Sara a <u>fini</u> ses devoir tôt donc elle ____ regarder le télévision.</b>";
        shownAnswer[27] = "<b>Sara a <u>fini</u> ses devoir tôt donc elle <u>peut</u> regarder le télévision.</b>";
        shownAnswer[28] = "<b>Les jeux olympique <u>auront</u> lieu été en Brésil.</b>";
        shownAnswer[29] = "<b>L2Q10A1.1";

        shownAnswer[30] = "<b>Oh non! Le chien <u>a mordu</u> le petit garçon!</b>";
        shownAnswer[31] = "<b>Lv3Q1A1.1</b>";
        shownAnswer[32] = "<b>Manon <u>a visite</u> Paris avec sa fanille l'année passe.</b>";
        shownAnswer[33] = "<b>Lv3Q2A2.1</b>";
        shownAnswer[34] = "<b>Le garçon méchant <u>a joue</u> les jeux de video au lieu de ___ ses devoirs.</b>";
        shownAnswer[35] = "<b>Le garçon méchant <u>a joue</u> les jeux de video au lieu de ___ ses devoirs.</b>";
        shownAnswer[36] = "<b>Marle <u>___</u> de <u>___</u> au Marco.</b>";
        shownAnswer[37] = "<b>Marle <u>___</u> de <u>___</u> au Marco.</b>";
        shownAnswer[38] = "<b>Cecile et ses amies <u>___</u> ent ville pour acheter les tenues nouvellrs pour CropOver.</b>";
        shownAnswer[39] = "<b>Lv3Q5A2.1</b>";
        shownAnswer[40] = "<b>La fille <u>___</u> et elle <u>___</u> son bras.</b>";
        shownAnswer[41] = "<b>La fille <u>___</u> et elle <u>___</u> son bras.</b>";
        shownAnswer[42] = "<b>Elodie a pleuré beaucoup parce son chat <u>___</u>.</b>";
        shownAnswer[43] = "<b>Lv3Q7A1.1</b>";
        shownAnswer[44] = "<b>Yanis <u>___</u> ses lunettes.</b>";
        shownAnswer[45] = "<b>Lv3Q8A2.1</b>";
        shownAnswer[46] = "<b>Le maman de Pierre lui accompagne partout parce qui'l <u>___</u> facilement.</b>";
        shownAnswer[47] = "<b>Lv3Q9A3.1</b>";
        shownAnswer[48] = "<b>Nous <u>___</u> à nons examens donc hes parent nous <u>___</u>.</b>";
        shownAnswer[49] = "<b>Nous <u>___</u> à nons examens donc hes parent nous <u>___</u>.</b>";

        String[] verb = new String[50];
        verb[0] = "ASSISTER";
        verb[1] = "AVOIR";
        verb[2] = "FAIRE";
        verb[3] = "AIMER";
        verb[4] = "";
        verb[5] = "";
        verb[6] = "MANGER";
        verb[7] = "ÊTRE";
        verb[8] = "NEIGER";
        verb[9] = "";

        verb[10] = "Lv2Q1VERB";
        verb[11] = "Lv2Q1.1VERB";
        verb[12] = "FAIRE";
        verb[13] = "Lv2Q2.1VERB";
        verb[14] = "PLEUVOIR";
        verb[15] = "PRENDRE";
        verb[16] = "Lv2Q4VERB";
        verb[17] = "Lv2Q4.1VERB";
        verb[18] = "BLESSER";
        verb[19] = "Lv2Q5.1VERB";
        verb[20] = "Lv2Q6VERB";
        verb[21] = "Lv2Q6.1VERB";
        verb[22] = "Lv2Q7VERB";
        verb[23] = "Lv2Q7.1VERB";
        verb[24] = "METTRE";
        verb[25] = "Lv2Q8.1VERB";
        verb[26] = "FINIR";
        verb[27] = "POUVOIR";
        verb[28] = "AVOIR";
        verb[29] = "Lv2Q10.1VERB";

        verb[30] = "MORDRER";
        verb[31] = "Lv3Q1.1VERB";
        verb[32] = "VISITER";
        verb[33] = "Lv3Q2.1VERB";
        verb[34] = "JOUER";
        verb[35] = "FAIRE";
        verb[36] = "REVER";
        verb[37] = "VOGAGER";
        verb[38] = "ALLER";
        verb[39] = "Lv3Q5.1VERB";
        verb[40] = "TOMBER";
        verb[41] = "CASSER";
        verb[42] = "Lv3Q7VERB";
        verb[43] = "Lv3Q7.1VERB";
        verb[44] = "PERDRE";
        verb[45] = "Lv3Q8.1VERB";
        verb[46] = "SE PERDRE";
        verb[47] = "Lv3Q9.1VERB";
        verb[48] = "REUSSIR";
        verb[49] = "ACHETTER";

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

        questionAnswers[1][0] = "avez";
        questionAnswers[1][1] = "ai";
        questionAnswers[1][2] = "ont";

        questionAnswers[2][0] = "fait";
        questionAnswers[2][1] = "font";
        questionAnswers[2][2] = "faites";

        questionAnswers[3][0] = "aimez";
        questionAnswers[3][1] = "aimons";
        questionAnswers[3][2] = "aime";

        questionAnswers[4][0] = "robe";
        questionAnswers[4][1] = "jupe";
        questionAnswers[4][2] = "ceinture";

        questionAnswers[5][0] = "manteau";
        questionAnswers[5][1] = "chaussures";
        questionAnswers[5][2] = "chausettes";

        questionAnswers[6][0] = "mangent";
        questionAnswers[6][1] = "manges";
        questionAnswers[6][2] = "mangeons";

        questionAnswers[7][0] = "sommes";
        questionAnswers[7][1] = "sont";
        questionAnswers[7][2] = "est";

        questionAnswers[8][0] = "neige";
        questionAnswers[8][1] = "neigera";
        questionAnswers[8][2] = "neige";

        questionAnswers[9][0] = "chemise";
        questionAnswers[9][1] = "pantalons";
        questionAnswers[9][2] = "short";

        questionAnswers[10][0] = "cadette";
        questionAnswers[10][1] = "aîné";
        questionAnswers[10][2] = "âgé";
        questionAnswers[11][0] = "Lv2Q1A1.1";
        questionAnswers[11][1] = "Lv2Q1A2.1";
        questionAnswers[11][2] = "Lv2Q1A3.1";

        questionAnswers[12][0] = "fais";
        questionAnswers[12][1] = "faites";
        questionAnswers[12][2] = "faisons";
        questionAnswers[13][0] = "Lv2Q2A1.1";
        questionAnswers[13][1] = "Lv2Q2A2.1";
        questionAnswers[13][2] = "Lv2Q2A3.1";

        questionAnswers[14][0] = "pleut";
        questionAnswers[14][1] = "pleuvent";
        questionAnswers[14][2] = "pleuvoir";
        questionAnswers[15][0] = "pris";
        questionAnswers[15][1] = "prends";
        questionAnswers[15][2] = "prendre";

        questionAnswers[16][0] = "ennuyeux";
        questionAnswers[16][1] = "ennuyeuses";
        questionAnswers[16][2] = "intéressant";
        questionAnswers[17][0] = "Lv2Q4A1.1";
        questionAnswers[17][1] = "Lv2Q4A2.1";
        questionAnswers[17][2] = "Lv2Q4A3.1";

        questionAnswers[18][0] = "a blesser";
        questionAnswers[18][1] = "a blesse";
        questionAnswers[18][2] = "est blessé";
        questionAnswers[19][0] = "Lv2Q5A1.1";
        questionAnswers[19][1] = "Lv2Q5A2.1";
        questionAnswers[19][2] = "Lv2Q5A3.1";

        questionAnswers[20][0] = "timide";
        questionAnswers[20][1] = "bavard";
        questionAnswers[20][2] = "sociable";
        questionAnswers[21][0] = "Lv2Q6A1.1";
        questionAnswers[21][1] = "Lv2Q6A2.1";
        questionAnswers[21][2] = "Lv2Q6A3.1";

        questionAnswers[22][0] = "Bon voyage";
        questionAnswers[22][1] = "Bonne dnance";
        questionAnswers[22][2] = "Felicitations";
        questionAnswers[23][0] = "Lv2Q7A1.1";
        questionAnswers[23][1] = "Lv2Q7A2.1";
        questionAnswers[23][2] = "Lv2Q7A3.1";

        questionAnswers[24][0] = "met";
        questionAnswers[24][1] = "mets";
        questionAnswers[24][2] = "mettent";
        questionAnswers[25][0] = "Lv2Q8A1.1";
        questionAnswers[25][1] = "Lv2Q8A2.1";
        questionAnswers[25][2] = "Lv2Q8A3.1";

        questionAnswers[26][0] = "a fini";
        questionAnswers[26][1] = "est fini ";
        questionAnswers[26][2] = "ont fini";
        questionAnswers[27][0] = "pouvons";
        questionAnswers[27][1] = "peuvent.";
        questionAnswers[27][2] = "peut";

        questionAnswers[28][0] = "aurai";
        questionAnswers[28][1] = "auriez";
        questionAnswers[28][2] = "auront";
        questionAnswers[29][0] = "Lv2Q10A1.1";
        questionAnswers[29][1] = "Lv2Q10A2.1";
        questionAnswers[29][2] = "Lv2Q10A3.1";

        questionAnswers[30][0] = "a mordu";
        questionAnswers[30][1] = "as mordu";
        questionAnswers[30][2] = "ont mordu";
        questionAnswers[31][0] = "Lv3Q1A1.1";
        questionAnswers[31][1] = "Lv3Q1A2.1";
        questionAnswers[31][2] = "Lv3Q1A3.1";

        questionAnswers[32][0] = "a visiter";
        questionAnswers[32][1] = "ont visité";
        questionAnswers[32][2] = "a visité";
        questionAnswers[33][0] = "Lv3Q2A1.1";
        questionAnswers[33][1] = "Lv3Q2A2.1";
        questionAnswers[33][2] = "Lv3Q2A3.1";

        questionAnswers[34][0] = "ont joue";
        questionAnswers[34][1] = "a joue";
        questionAnswers[34][2] = "avons joue";
        questionAnswers[35][0] = "fais";
        questionAnswers[35][1] = "faire";
        questionAnswers[35][2] = "faites";

        questionAnswers[36][0] = "-";
        questionAnswers[36][1] = "-";
        questionAnswers[36][2] = "-";
        questionAnswers[37][0] = "-";
        questionAnswers[37][1] = "-";
        questionAnswers[37][2] = "-";

        questionAnswers[38][0] = "est allé";
        questionAnswers[38][1] = "sommes allé";
        questionAnswers[38][2] = "sont allé";
        questionAnswers[39][0] = "Lv3Q5A1.1";
        questionAnswers[39][1] = "Lv3Q5A2.1";
        questionAnswers[39][2] = "Lv3Q5A3.1";

        questionAnswers[40][0] = "sont tombé";
        questionAnswers[40][1] = "est tombé";
        questionAnswers[40][2] = "es tombé";
        questionAnswers[41][0] = "a cassé";
        questionAnswers[41][1] = "est cassé";
        questionAnswers[41][2] = "sont cassé";

        questionAnswers[42][0] = "suis mort";
        questionAnswers[42][1] = "sont morts";
        questionAnswers[42][2] = "est mort";
        questionAnswers[43][0] = "Lv3Q7A1.1";
        questionAnswers[43][1] = "Lv3Q7A2.1";
        questionAnswers[43][2] = "Lv3Q7A3.1";

        questionAnswers[44][0] = "a perdei";
        questionAnswers[44][1] = "est perdu";
        questionAnswers[44][2] = "ont perdu";
        questionAnswers[45][0] = "Lv3Q8A1.1";
        questionAnswers[45][1] = "Lv3Q8A2.1";
        questionAnswers[45][2] = "Lv3Q8A3.1";

        questionAnswers[46][0] = "me perds";
        questionAnswers[46][1] = "se perd";
        questionAnswers[46][2] = "se perder";
        questionAnswers[47][0] = "Lv3Q9A1.1";
        questionAnswers[47][1] = "Lv3Q9A2.1";
        questionAnswers[47][2] = "Lv3Q9A3.1";

        questionAnswers[48][0] = "avons réussi";
        questionAnswers[48][1] = "son tries reussi";
        questionAnswers[48][2] = "avons réussi";
        questionAnswers[49][0] = "achèterai";
        questionAnswers[49][1] = "achètera";
        questionAnswers[49][2] = "achèteras";

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
                    levelData[i].one1 = questionData[11];

                    levelData[i].two = questionData[12];
                    levelData[i].two1 = questionData[13];

                    levelData[i].three = questionData[14];
                    levelData[i].three1 = questionData[15];

                    levelData[i].four = questionData[16];
                    levelData[i].four1 = questionData[17];

                    levelData[i].five = questionData[18];
                    levelData[i].five1 = questionData[19];

                    levelData[i].six = questionData[20];
                    levelData[i].six1 = questionData[21];

                    levelData[i].seven = questionData[22];
                    levelData[i].seven1 = questionData[23];

                    levelData[i].eight = questionData[24];
                    levelData[i].eight1 = questionData[25];

                    levelData[i].nine = questionData[26];
                    levelData[i].nine1 = questionData[27];

                    levelData[i].ten = questionData[28];
                    levelData[i].ten1 = questionData[29];
                    break;
                case 2:
                    levelData[i].one = questionData[30];
                    levelData[i].one1 = questionData[31];

                    levelData[i].two = questionData[32];
                    levelData[i].two1 = questionData[33];
                    levelData[i].three = questionData[34];
                    levelData[i].three1 = questionData[35];
                    levelData[i].four = questionData[36];
                    levelData[i].four1 = questionData[37];
                    levelData[i].five = questionData[38];
                    levelData[i].five1 = questionData[39];
                    levelData[i].six = questionData[40];
                    levelData[i].six1 = questionData[41];
                    levelData[i].seven = questionData[42];
                    levelData[i].seven1 = questionData[43];
                    levelData[i].eight = questionData[44];
                    levelData[i].eight1 = questionData[45];
                    levelData[i].nine = questionData[46];
                    levelData[i].nine1 = questionData[47];
                    levelData[i].ten = questionData[48];
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
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].one.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].one.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].one.option3);
    }

    public void QuestionOneP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].one1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].one1.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].one1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].one1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].one1.option3);
    }

    public void QuestionTwoSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].two.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].two.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].two.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].two.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].two.option3);
    }

    public void QuestionTwoP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].two1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].two1.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].two1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].two1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].two1.option3);
    }

    public void QuestionThreeSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].three.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].three.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].three.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].three.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].three.option3);
    }

    public void QuestionThreeP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].three1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].three1.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].three1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].three1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].three1.option3);
    }

    public void QuestionFourSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].four.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].four.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].four.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].four.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].four.option3);
    }

    public void QuestionFourP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].four1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].four1.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].four1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].four1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].four1.option3);
    }

    public void QuestionFiveSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].five.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].five.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].five.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].five.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].five.option3);
    }

    public void QuestionFiveP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].five1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].five1.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].five1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].five1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].five1.option3);
    }

    public void QuestionSixSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].six.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].six.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].six.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].six.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].six.option3);
    }

    public void QuestionSixP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].six1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].six1.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].six1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].six1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].six1.option3);
    }

    public void QuestionSevenSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].seven.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].seven.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].seven.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].seven.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].seven.option3);
    }

    public void QuestionSevenP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].seven1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].seven1.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].seven1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].seven1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].seven1.option3);
    }

    public void QuestionEightSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].eight.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].eight.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].eight.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].eight.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].eight.option3);
    }

    public void QuestionEightP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].eight1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].eight1.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].eight1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].eight1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].eight1.option3);
    }

    public void QuestionNineSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].nine.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].nine.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].nine.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].nine.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].nine.option3);
    }

    public void QuestionNineP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].nine1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].nine1.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].nine1.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].nine1.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].nine1.option3);
    }

    public void QuestionTenSetup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].ten.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].ten.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
        btnAns1.setText(levelData[prefs.getInt("level", -1)].ten.option1);
        btnAns2.setText(levelData[prefs.getInt("level", -1)].ten.option2);
        btnAns3.setText(levelData[prefs.getInt("level", -1)].ten.option3);
    }

    public void QuestionTenP2Setup() {
        tvLevelName.setText(levelData[prefs.getInt("level", -1)].name);
        tvScore.setText(String.valueOf(levelData[prefs.getInt("level", -1)].score));

        tvQuestion.setText(levelData[prefs.getInt("level", -1)].ten1.sentence);
        tvVerb.setText(levelData[prefs.getInt("level", -1)].ten1.verb);
        tvVerb.setBackgroundResource(R.drawable.brick2);
        tvVerb.getBackground().setAlpha(120);
        tvVerb.setVisibility(View.VISIBLE);
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
        int level1turns = 20;
        int level2turns = 40;
        int level3turns = 40;

        Log.i("level ", prefs.getInt("level", -1) + " Level Done  " + String.valueOf(leveldone));
        //Log.i("scores: ", " level1 " + String.valueOf(level1Score) + " level2 " + String.valueOf(level2Score) + " level3 " + String.valueOf(level3Score));

        if ((level1Score == 10) && (level2Score == 10) && (level3Score == 10)) {
            gameOver("Game Finished", "You have read over the game!", "Play Again", "Exit");
        } else /*{
            Toast.makeText(getApplicationContext(), "Game not over", Toast.LENGTH_SHORT).show();
        }*/

            //LEVEL 1 start
            if ((prefs.getInt("level", -1) == 0) && (leveldone < level1turns) && ((level1Score < 10))) {
                tvScore.setText(String.valueOf(level1Score) + "/10");

                switch (leveldone) {
                    //level 1 question 1 attempt 1
                    case 0:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].one.shownAnswer));
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
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].one.shownAnswer));
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
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].one.shownAnswer));
                            leveldone = 2;//to start Q2L1
                            QuestionTwoSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        }
                        break;

                    //level 1 question 2 attempt 1
                    case 2:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q2 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].two.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 4;//to start Q2L1
                            QuestionThreeSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        } else {
                            Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                            leveldone++;
                        }
                        break;
                    //level 1 question 2 attempt 2
                    case 3:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q2 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].two.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 4;//to start Q3L1
                            QuestionThreeSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        } else {
                            Toast.makeText(getApplicationContext(), "L1Q2 Wrong", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].two.shownAnswer));
                            leveldone = 4;//to start Q3L1
                            QuestionThreeSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        }
                        break;

                    //level 1 question 3 attempt 1
                    case 4:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q3 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].three.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 6;//to start Q4L1
                            QuestionFourSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        } else {
                            Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                            leveldone++;
                        }
                        break;
                    //level 1 question 3 attempt 2
                    case 5:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q3 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].three.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 6;//to start Q4L1
                            QuestionFourSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        } else {
                            Toast.makeText(getApplicationContext(), "L1Q2 Wrong", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].three.shownAnswer));
                            leveldone = 6;//to start Q4L1
                            QuestionFourSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        }
                        break;

                    //level 1 question 4 attempt 1
                    case 6:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q1 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].four.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 8;//to start Q2L1
                            QuestionFiveSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                            tvVerb.setVisibility(View.INVISIBLE);
                        } else {
                            Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                            leveldone++;
                        }
                        break;
                    //level 1 question 4 attempt 2
                    case 7:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q4 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].four.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 8;//to start Q4L1
                            QuestionFiveSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                            tvVerb.setVisibility(View.INVISIBLE);
                        } else {
                            Toast.makeText(getApplicationContext(), "L1Q2 Wrong", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].four.shownAnswer));
                            leveldone = 8;//to start Q4L1
                            QuestionFiveSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                            tvVerb.setVisibility(View.INVISIBLE);
                        }
                        break;

                    //level 1 question 5 attempt 1
                    case 8:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q5 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].five.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 10;//to start Q6L1
                            QuestionSixSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                            tvVerb.setVisibility(View.INVISIBLE);
                        } else {
                            Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                            leveldone++;
                        }
                        break;
                    //level 1 question 5 attempt 2
                    case 9:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q5 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].five.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 10;//to start Q6L1
                            QuestionSixSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                            tvVerb.setVisibility(View.INVISIBLE);
                        } else {
                            Toast.makeText(getApplicationContext(), "L1Q5 Wrong", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].five.shownAnswer));
                            leveldone = 10;//to start Q6L1
                            QuestionSixSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                            tvVerb.setVisibility(View.INVISIBLE);
                        }
                        break;

                    //level 1 question 6 attempt 1
                    case 10:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].six.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q6 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].six.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 12;//to start Q7L1
                            QuestionSevenSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        } else {
                            Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                            leveldone++;
                        }
                        break;
                    //level 1 question 6 attempt 2
                    case 11:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].six.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q6 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].six.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 12;//to start Q7L1
                            QuestionSevenSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        } else {
                            Toast.makeText(getApplicationContext(), "L1Q6 Wrong", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].six.shownAnswer));
                            leveldone = 12;//to start Q7L1
                            QuestionSevenSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        }
                        break;

                    //level 1 question 7 attempt 1
                    case 12:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].seven.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q7 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].seven.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 14;//to start Q2L1
                            QuestionEightSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        } else {
                            Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                            leveldone++;
                        }
                        break;
                    //level 1 question 7 attempt 2
                    case 13:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].seven.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q7 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].seven.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 14;//to start Q8L1
                            QuestionEightSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        } else {
                            Toast.makeText(getApplicationContext(), "L1Q7 Wrong", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].seven.shownAnswer));
                            leveldone = 14;//to start Q8L1
                            QuestionEightSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        }
                        break;

                    //level 1 question 8 attempt 1
                    case 14:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].eight.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q8 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].eight.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 16;//to start Q2L1
                            QuestionNineSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        } else {
                            Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                            leveldone++;
                        }
                        break;
                    //level 1 question 8 attempt 2
                    case 15:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].eight.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q8 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].eight.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 16;//to start Q9L1
                            QuestionNineSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        } else {
                            Toast.makeText(getApplicationContext(), "L1Q8 Wrong", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].eight.shownAnswer));
                            leveldone = 16;//to start Q9L1
                            QuestionNineSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                        }
                        break;

                    //level 1 question 9 attempt 1
                    case 16:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].nine.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q9 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].nine.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 18;//to start Q2L1
                            QuestionTenSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                            tvVerb.setVisibility(View.INVISIBLE);
                        } else {
                            Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                            leveldone++;
                        }
                        break;
                    //level 1 question 9 attempt 2
                    case 17:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].nine.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q9 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].nine.shownAnswer));
                            new CountDownTimer(1500, 1000) {
                                public void onTick(long miliSecondsUntilDone) {
                                    //Countdown is counting down (in this case every second)
                                    Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                }

                                public void onFinish() {
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                    tvWrong.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            level1Score++;
                            leveldone = 18;//to start Q10L1
                            QuestionTenSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                            tvVerb.setVisibility(View.INVISIBLE);
                        } else {
                            Toast.makeText(getApplicationContext(), "L1Q9 Wrong", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].nine.shownAnswer));
                            leveldone = 18;//to start Q10L1
                            QuestionTenSetup();
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                            tvVerb.setVisibility(View.INVISIBLE);
                        }
                        break;

                    //level 1 question 10 attempt 1
                    case 18:
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].ten.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "L1Q10 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].ten.shownAnswer));
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
                        if (userAnswer.matches(levelData[prefs.getInt("level", -1)].ten.correctAnswer)) {
                            //go to next question
                            Toast.makeText(getApplicationContext(), "Q10 Correct", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
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
                            Toast.makeText(getApplicationContext(), "Q10 Wrong", Toast.LENGTH_SHORT).show();
                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                            tvWrong.setVisibility(View.VISIBLE);
                            tvWrong.setBackgroundResource(R.drawable.brick2);
                            tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                            tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].ten.shownAnswer));
                            tvScore.setText(String.valueOf(level1Score) + "/10");
                            leveldone = 10;//to start Q2L1
                            prefs.edit().putInt("levelOneOver", level1Score).apply();
                            prefs.edit().putInt("level", 0).apply();
                            leveldone = 0;
                            gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level1Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                        }
                        break;
                }
            } else
                //LEVEL 2 Begins
                if ((leveldone < level2turns) && (prefs.getInt("level", -1) == 1) && (level2Score < 20)) {
                    tvScore.setText(String.valueOf(level2Score) + "/20");

                    switch (leveldone) {
                        //level 2 question 1 attempt 1
                        case 0:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
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
                                level2Score++;
                                leveldone = 2;//to start Q2L1
                                QuestionOneP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 1 attempt 2
                        case 1:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
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
                                level2Score++;
                                leveldone = 2;//to start Q2L1
                                QuestionOneP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q1 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                                leveldone = 2;//to start Q2L1
                                QuestionOneP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;
                        //level 2 question 1.1 attempt 1
                        case 2:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q1.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].one1.shownAnswer);
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
                                level2Score++;
                                leveldone = 4;//to start Q2L1
                                QuestionTwoSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 1.1 attempt 2
                        case 3:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q1.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].one1.shownAnswer);
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
                                level2Score++;
                                leveldone = 4;//to start Q2L1
                                QuestionTwoSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q1.1 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].one1.shownAnswer);
                                leveldone = 4;//to start Q2L1
                                QuestionTwoSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;

                        //level 2 question 2 attempt 1
                        case 4:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q2 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].two.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 6;//to start Q2L1
                                QuestionTwoP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 2 attempt 2
                        case 5:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q2 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].two.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 6;//to start Q3L1
                                QuestionTwoP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q2 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].two.shownAnswer);
                                leveldone = 6;//to start Q3L1
                                QuestionTwoP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;
                        //level 2 question 2.1 attempt 1
                        case 6:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q2.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].two1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 8;//to start Q2L1
                                QuestionThreeSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 2.1 attempt 2
                        case 7:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q2.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].two1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 8;//to start Q3L1
                                QuestionThreeSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q2.1 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].two1.shownAnswer);
                                leveldone = 8;//to start Q3L1
                                QuestionThreeSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;

                        //level 2 question 3 attempt 1
                        case 8:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q3 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].three.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 10;//to start Q4L1
                                QuestionThreeP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 3 attempt 2
                        case 9:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q3 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].three.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 10;//to start Q4L1
                                QuestionThreeP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q3 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].three.shownAnswer);
                                leveldone = 10;//to start Q4L1
                                QuestionThreeP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;
                        //level 2 question 3.1 attempt 1
                        case 10:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q3.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].three1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 12;//to start Q4L1
                                QuestionFourSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 3.1 attempt 2
                        case 11:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q3.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].three1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 12;//to start Q4L1
                                QuestionFourSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q3.1 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].three1.shownAnswer);
                                leveldone = 12;//to start Q4L1
                                QuestionFourSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;

                        //level 2 question 4 attempt 1
                        case 12:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q4 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 14;//to start Q2L1
                                QuestionFourP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 4 attempt 2
                        case 13:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q4 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 14;//to start Q4L1
                                QuestionFourP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q4 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                                leveldone = 14;//to start Q4L1
                                QuestionFourP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;
                        //level 2 question 4.1 attempt 1
                        case 14:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q4.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].four1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 16;//to start Q2L1
                                QuestionFiveSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 4.1 attempt 2
                        case 15:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q4.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].four1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 16;//to start Q4L1
                                QuestionFiveSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q4.1 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                                leveldone = 16;//to start Q4L1
                                QuestionFiveSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;

                        //level 2 question 5 attempt 1
                        case 16:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q5 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 18;//to start Q6L1
                                QuestionFiveP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 5 attempt 2
                        case 17:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q5 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 18;//to start Q6L1
                                QuestionFiveP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L1Q5 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                                leveldone = 18;//to start Q6L1
                                QuestionFiveP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;
                        //level 2 question 5.1 attempt 1
                        case 18:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q5 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].five1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 20;//to start Q6L1
                                QuestionSixSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 5.1 attempt 2
                        case 19:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q5 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].five1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 20;//to start Q6L1
                                QuestionSixSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L1Q5 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                                leveldone = 20;//to start Q6L1
                                QuestionSixSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;

                        //level 2 question 6 attempt 1
                        case 20:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].six.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q6 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].six.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 22;//to start Q7L1
                                QuestionSixP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 6 attempt 2
                        case 21:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].six.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q6 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].six.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 22;//to start Q7L1
                                QuestionSixP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L1Q6 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].six.shownAnswer);
                                leveldone = 22;//to start Q7L1
                                QuestionSixP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;
                        //level 2 question 6.1 attempt 1
                        case 22:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].six1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q6.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].six1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 24;//to start Q7L1
                                QuestionSevenSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 6.1 attempt 2
                        case 23:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].six1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q6.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].six1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 24;//to start Q7L1
                                QuestionSevenSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q6.1 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].six1.shownAnswer);
                                leveldone = 24;//to start Q7L1
                                QuestionSevenSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;

                        //level 2 question 7 attempt 1
                        case 24:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].seven.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q7 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].seven.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 26;//to start Q2L1
                                QuestionSevenP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 7 attempt 2
                        case 25:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].seven.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q7 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].seven.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 26;//to start Q8L1
                                QuestionSevenP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L1Q7 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].seven.shownAnswer);
                                leveldone = 26;//to start Q8L1
                                QuestionSevenP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;
                        //level 2 question 7.1 attempt 1
                        case 26:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].seven1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q7 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].seven1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 28;//to start Q2L1
                                QuestionEightSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 7.1 attempt 2
                        case 27:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].seven1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q7 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].seven1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 28;//to start Q8L1
                                QuestionEightSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L1Q7 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].seven.shownAnswer);
                                leveldone = 28;//to start Q8L1
                                QuestionEightSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;

                        //level 2 question 8 attempt 1
                        case 28:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].eight.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q8 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].eight.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 30;//to start Q2L1
                                QuestionEightP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 8 attempt 2
                        case 29:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].eight.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q8 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].eight.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 30;//to start Q9L1
                                QuestionEightP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L1Q8 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].eight.shownAnswer);
                                leveldone = 30;//to start Q9L1
                                QuestionEightP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;
                        //level 2 question 8.1 attempt 1
                        case 30:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].eight1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q8 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].eight1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 32;//to start Q2L1
                                QuestionNineSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 8.1 attempt 2
                        case 31:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].eight1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L1Q8 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].eight1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 32;//to start Q9L1
                                QuestionNineSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L1Q8 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].eight1.shownAnswer);
                                leveldone = 32;//to start Q9L1
                                QuestionNineSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;

                        //level 2 question 9 attempt 1
                        case 32:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].nine.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q9 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].nine.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 34;//to start Q2L1
                                QuestionNineP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 9 attempt 2
                        case 33:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].nine.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q9 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].nine.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 34;//to start Q10L1
                                QuestionNineP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q9 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].nine.shownAnswer);
                                leveldone = 34;//to start Q10L1
                                QuestionNineP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;
                        //level 2 question 9.1 attempt 1
                        case 34:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].nine1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q9.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].nine1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 36;//to start Q2L1
                                QuestionTenSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 9.1 attempt 2
                        case 35:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].nine1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q9.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].nine1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 36;//to start Q10L1
                                QuestionTenSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q9.1 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].nine.shownAnswer);
                                leveldone = 36;//to start Q10L1
                                QuestionTenSetup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;


                        //level 2 question 10 attempt 1
                        case 36:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].ten.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q10 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].ten.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 38;//to start Q2L1
                                QuestionTenP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 10 attempt 2
                        case 37:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].ten.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q10 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].ten.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                leveldone = 38;//to start Q10L1
                                QuestionTenP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q10 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].ten.shownAnswer);
                                leveldone = 36;//to start Q10L1
                                QuestionTenP2Setup();
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                            }
                            break;

                        //level 2 question 10.1 attempt 1
                        case 38:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].ten1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q10.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(levelData[prefs.getInt("level", -1)].ten1.shownAnswer);
                                new CountDownTimer(1500, 1000) {
                                    public void onTick(long miliSecondsUntilDone) {
                                        //Countdown is counting down (in this case every second)
                                        Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                    }

                                    public void onFinish() {
                                        TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                        tvWrong.setVisibility(View.INVISIBLE);
                                    }
                                }.start();
                                level2Score++;
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                                if (level2Score == 20) {
                                    //Start level 2
                                    prefs.edit().putInt("levelTwoOver", level2Score).apply();
                                    prefs.edit().putInt("level", 2).apply();
                                    leveldone = 0;
                                    QuestionOneSetup();
                                } else {
                                    //game over
                                    prefs.edit().putInt("levelTwoOver", level2Score).apply();
                                    prefs.edit().putInt("level", 1).apply();
                                    leveldone = 0;
                                    gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level2Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                leveldone++;
                            }
                            break;
                        //level 2 question 10.1 attempt 2
                        case 39:
                            if (userAnswer.matches(levelData[prefs.getInt("level", -1)].ten1.correctAnswer)) {
                                //go to next question
                                Toast.makeText(getApplicationContext(), "L2Q10.1 Correct", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText("L1Q10p2 Correct");
                                level1Score++;
                                leveldone = 40;//to start Q2L1
                                tvScore.setText(String.valueOf(level1Score) + "/20");
                                if (level1Score == 20) {
                                    //Start level 2
                                    prefs.edit().putInt("levelTwoOver", level2Score).apply();
                                    prefs.edit().putInt("level", 2).apply();
                                    leveldone = 0;
                                    QuestionOneSetup();
                                } else {
                                    //game over
                                    prefs.edit().putInt("levelTwoOver", level2Score).apply();
                                    prefs.edit().putInt("level", 0).apply();
                                    leveldone = 0;
                                    gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level2Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "L2Q10.1 Wrong", Toast.LENGTH_SHORT).show();
                                TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                tvWrong.setVisibility(View.VISIBLE);
                                tvWrong.setBackgroundResource(R.drawable.brick2);
                                tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                tvWrong.setText(Html.fromHtml(levelData[prefs.getInt("level", -1)].ten1.shownAnswer));
                                tvScore.setText(String.valueOf(level2Score) + "/20");
                                leveldone = 10;//to start Q2L1
                                prefs.edit().putInt("levelTwoOver", level2Score).apply();
                                prefs.edit().putInt("level", 1).apply();
                                leveldone = 0;
                                gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level2Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                            }
                            break;
                    }
                } else /*{
            //The user either has not reached level 2 or an error occured when trying to get to level 2
        }*/

                    //LEVEL 3 begins
                    if ((leveldone < level3turns) && (prefs.getInt("level", -1) == 2) && (level3Score < 20)) {
                        tvScore.setText(String.valueOf(level3Score) + "/20");

                        switch (leveldone) {
                            //level 3 question 1 attempt 1
                            case 0:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
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
                                    level3Score++;
                                    leveldone = 2;//to start Q2L1
                                    QuestionOneP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 1 attempt 2
                            case 1:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
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
                                    level3Score++;
                                    leveldone = 2;//to start Q2L1
                                    QuestionOneP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q1 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].one.shownAnswer);
                                    leveldone = 2;//to start Q2L1
                                    QuestionOneP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;
                            //level 3 question 1.1 attempt 1
                            case 2:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].one1.shownAnswer);
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
                                    level3Score++;
                                    leveldone = 4;//to start Q2L1
                                    QuestionTwoSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 1.1 attempt 2
                            case 3:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].one1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].one1.shownAnswer);
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
                                    level3Score++;
                                    leveldone = 4;//to start Q2L1
                                    QuestionTwoSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q1 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong1);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].one1.shownAnswer);
                                    leveldone = 4;//to start Q2L1
                                    QuestionTwoSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;

                            //level 3 question 2 attempt 1
                            case 4:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q2 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].two.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 6;//to start Q2L1
                                    QuestionTwoP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 2 attempt 2
                            case 5:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q2 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].two.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 6;//to start Q3L1
                                    QuestionTwoP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q2 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].two.shownAnswer);
                                    leveldone = 6;//to start Q3L1
                                    QuestionTwoP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;
                            //level 3 question 2.1 attempt 1
                            case 6:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q2.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].two1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 8;//to start Q2L1
                                    QuestionThreeSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 2.1 attempt 2
                            case 7:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].two1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q2.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].two1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 8;//to start Q3L1
                                    QuestionThreeSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q2.1 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong2);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].two1.shownAnswer);
                                    leveldone = 8;//to start Q3L1
                                    QuestionThreeSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;

                            //level 3 question 3 attempt 1
                            case 8:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q3 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].three.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 10;//to start Q4L1
                                    QuestionThreeP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 3 attempt 2
                            case 9:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q3 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].three.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 10;//to start Q4L1
                                    QuestionThreeP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q3 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].three.shownAnswer);
                                    leveldone = 10;//to start Q4L1
                                    QuestionThreeP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;
                            //level 3 question 3.1 attempt 1
                            case 10:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q3.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].three1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 12;//to start Q4L1
                                    QuestionFourSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 3.1 attempt 2
                            case 11:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].three1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q3.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].three1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 12;//to start Q4L1
                                    QuestionFourSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q3.1 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong3);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].three1.shownAnswer);
                                    leveldone = 12;//to start Q4L1
                                    QuestionFourSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;

                            //level 3 question 4 attempt 1
                            case 12:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q4 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 14;//to start Q2L1
                                    QuestionFourP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 4 attempt 2
                            case 13:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q4 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 14;//to start Q4L1
                                    QuestionFourP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q4 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                                    leveldone = 14;//to start Q4L1
                                    QuestionFourP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;
                            //level 3 question 4.1 attempt 1
                            case 14:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q4.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].four1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 16;//to start Q2L1
                                    QuestionFiveSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 4.1 attempt 2
                            case 15:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].four1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q4.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].four1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 16;//to start Q4L1
                                    QuestionFiveSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q4.1 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong4);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].four.shownAnswer);
                                    leveldone = 16;//to start Q4L1
                                    QuestionFiveSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;

                            //level 3 question 5 attempt 1
                            case 16:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q5 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 18;//to start Q6L1
                                    QuestionFiveP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 5 attempt 2
                            case 17:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q5 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 18;//to start Q6L1
                                    QuestionFiveP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q5 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                                    leveldone = 18;//to start Q6L1
                                    QuestionFiveP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;
                            //level 3 question 5.1 attempt 1
                            case 18:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q5 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].five1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 20;//to start Q6L1
                                    QuestionSixSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 5.1 attempt 2
                            case 19:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].five1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q5 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].five1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 20;//to start Q6L1
                                    QuestionSixSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q5 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong5);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].five.shownAnswer);
                                    leveldone = 20;//to start Q6L1
                                    QuestionSixSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;

                            //level 3 question 6 attempt 1
                            case 20:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].six.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q6 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].six.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 22;//to start Q7L1
                                    QuestionSixP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 6 attempt 2
                            case 21:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].six.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q6 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].six.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 22;//to start Q7L1
                                    QuestionSixP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q6 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].six.shownAnswer);
                                    leveldone = 22;//to start Q7L1
                                    QuestionSixP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;
                            //level 3 question 6.1 attempt 1
                            case 22:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].six1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q6.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].six1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 24;//to start Q7L1
                                    QuestionSevenSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 6.1 attempt 2
                            case 23:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].six1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q6.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].six1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 24;//to start Q7L1
                                    QuestionSevenSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q6.1 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong6);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].six1.shownAnswer);
                                    leveldone = 24;//to start Q7L1
                                    QuestionSevenSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;

                            //level 3 question 7 attempt 1
                            case 24:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].seven.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q7 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].seven.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 26;//to start Q2L1
                                    QuestionSevenP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 7 attempt 2
                            case 25:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].seven.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q7 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].seven.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 26;//to start Q8L1
                                    QuestionSevenP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q7 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].seven.shownAnswer);
                                    leveldone = 26;//to start Q8L1
                                    QuestionSevenP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;
                            //level 3 question 7.1 attempt 1
                            case 26:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].seven1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q7 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].seven1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 28;//to start Q2L1
                                    QuestionEightSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 7.1 attempt 2
                            case 27:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].seven1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q7 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].seven1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 28;//to start Q8L1
                                    QuestionEightSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q7 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong7);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].seven.shownAnswer);
                                    leveldone = 28;//to start Q8L1
                                    QuestionEightSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;

                            //level 3 question 8 attempt 1
                            case 28:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].eight.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q8 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].eight.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 30;//to start Q2L1
                                    QuestionEightP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 8 attempt 2
                            case 29:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].eight.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q8 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].eight.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 30;//to start Q9L1
                                    QuestionEightP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q8 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].eight.shownAnswer);
                                    leveldone = 30;//to start Q9L1
                                    QuestionEightP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;
                            //level 3 question 8.1 attempt 1
                            case 30:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].eight1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q8 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].eight1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 32;//to start Q2L1
                                    QuestionNineSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 8.1 attempt 2
                            case 31:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].eight1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q8 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].eight1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 32;//to start Q9L1
                                    QuestionNineSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q8 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].eight1.shownAnswer);
                                    leveldone = 32;//to start Q9L1
                                    QuestionNineSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;

                            //level 3 question 9 attempt 1
                            case 32:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].nine.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q9 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].nine.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 34;//to start Q2L1
                                    QuestionNineP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 9 attempt 2
                            case 33:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].nine.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q9 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].nine.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 34;//to start Q10L1
                                    QuestionNineP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q9 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].nine.shownAnswer);
                                    leveldone = 34;//to start Q10L1
                                    QuestionNineP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;
                            //level 3 question 9.1 attempt 1
                            case 34:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].nine1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q9.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].nine1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 36;//to start Q2L1
                                    QuestionTenSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 9.1 attempt 2
                            case 35:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].nine1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q9.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].nine1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 36;//to start Q10L1
                                    QuestionTenSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q9.1 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].nine.shownAnswer);
                                    leveldone = 36;//to start Q10L1
                                    QuestionTenSetup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;


                            //level 3 question 10 attempt 1
                            case 36:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].ten.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q9.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].ten.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 38;//to start Q2L1
                                    QuestionTenP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 10 attempt 2
                            case 37:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].ten.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q109 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].ten.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong8);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    leveldone = 36;//to start Q10L1
                                    QuestionTenP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                } else {
                                    Toast.makeText(getApplicationContext(), "L3Q10 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong9);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].ten.shownAnswer);
                                    leveldone = 36;//to start Q10L1
                                    QuestionTenP2Setup();
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                }
                                break;

                            //level 3 question 10.1 attempt 1
                            case 38:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].ten1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L2Q10.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].ten1.shownAnswer);
                                    new CountDownTimer(1500, 1000) {
                                        public void onTick(long miliSecondsUntilDone) {
                                            //Countdown is counting down (in this case every second)
                                            Log.i("Seconds Left", String.valueOf(miliSecondsUntilDone / 1000));
                                        }

                                        public void onFinish() {
                                            TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                            tvWrong.setVisibility(View.INVISIBLE);
                                        }
                                    }.start();
                                    level3Score++;
                                    tvScore.setText(String.valueOf(level3Score) + "/20");
                                    if (level3Score == 20) {
                                        //Start level 2
                                        prefs.edit().putInt("levelThreeOver", level3Score).apply();
                                        prefs.edit().putInt("level", 2).apply();
                                        leveldone = 0;
                                        QuestionOneSetup();
                                    } else {
                                        //game over
                                        prefs.edit().putInt("levelThreeOver", level3Score).apply();
                                        prefs.edit().putInt("level", 2).apply();
                                        leveldone = 0;
                                        gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level3Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Try again ", Toast.LENGTH_SHORT).show();
                                    leveldone++;
                                }
                                break;
                            //level 3 question 10.1 attempt 2
                            case 39:
                                if (userAnswer.matches(levelData[prefs.getInt("level", -1)].ten1.correctAnswer)) {
                                    //go to next question
                                    Toast.makeText(getApplicationContext(), "L3Q10.1 Correct", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText("L1Q10p2 Correct");
                                    level1Score++;
                                    leveldone = 40;//to start Q2L1
                                    tvScore.setText(String.valueOf(level1Score) + "/20");
                                    if (level1Score == 20) {
                                        //Start level 3
                                        prefs.edit().putInt("levelThreeOver", level3Score).apply();
                                        prefs.edit().putInt("level", 2).apply();
                                        leveldone = 0;
                                        gameOver("Game Finished", "You have read over the game!", "Restart", "Quit");
                                    } else {
                                        //game over
                                        prefs.edit().putInt("levelThreeOver", level3Score).apply();
                                        prefs.edit().putInt("level", 0).apply();
                                        leveldone = 0;
                                        gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level3Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "L1Q10.1 Wrong", Toast.LENGTH_SHORT).show();
                                    TextView tvWrong = (TextView) findViewById(R.id.tvWrong10);
                                    tvWrong.setVisibility(View.VISIBLE);
                                    tvWrong.setBackgroundResource(R.drawable.brick2);
                                    tvWrong.setGravity(Gravity.CENTER_VERTICAL);
                                    tvWrong.setText(levelData[prefs.getInt("level", -1)].ten1.shownAnswer);
                                    tvScore.setText(String.valueOf(level3Score) + "/10");
                                    leveldone = 40;//to start Q2L1
                                    prefs.edit().putInt("levelThreeOver", level3Score).apply();
                                    prefs.edit().putInt("level", 1).apply();
                                    leveldone = 0;
                                    gameOver(levelData[prefs.getInt("level", -1)].name + "\n " + level3Score + " correct", "Nice try but you must get all question correct to finish the game", "Retry", "Quit");

                                }
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