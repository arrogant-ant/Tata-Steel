package com.example.sabita_sant.niwaas;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Final extends AppCompatActivity {
    private boolean isUserClickedBackButton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
    }

    @Override
    public void onBackPressed() {
        if(!isUserClickedBackButton)
        {
            Toast.makeText(this, "press back again to exit", Toast.LENGTH_LONG).show();
            isUserClickedBackButton = true;}
        else{
            super.onBackPressed();
        }
        new CountDownTimer(3000, 1000){

            @Override
            public void onTick(long millisUntilFinished){

            }

            @Override
        public void onFinish(){
                isUserClickedBackButton = false;
            }
        }.start();
    }


}
