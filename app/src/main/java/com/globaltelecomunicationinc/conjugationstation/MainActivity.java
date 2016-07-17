package com.globaltelecomunicationinc.conjugationstation;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button btnStart, btnQuit;

    public void initViews() {
        btnStart = (Button) findViewById(R.id.btnStart);
        btnQuit = (Button) findViewById(R.id.btnQuit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
    }

    public void setListeners() {
        btnStart.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                showLoadingScreenAnimation(view);
                new CountDownTimer(1500,1000) {
                    public void onTick(long miliSecondsUntilDone) {
                        //Countdown is counting down (in this case every second)
                        Log.i("Seconds Left",String.valueOf(miliSecondsUntilDone / 1000));
                    }
                    public void onFinish() {
                        Intent i = new Intent(MainActivity.this, GameActivity.class);
                        startActivity(i);
                    }
                }.start();
                break;
            case R.id.btnQuit:
                finish();
                break;
        }
    }

    public void showLoadingScreenAnimation(View view){
        ImageView load = (ImageView) findViewById(R.id.ivLoadingGame);
        btnQuit.animate().alpha(0f).setDuration(500);
        btnStart.animate().alpha(0f).setDuration(500);
        load.animate().alpha(1f).setDuration(1000);
        load.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}