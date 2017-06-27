package com.example.sabita_sant.niwaas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectPriority1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_priority_1);
    }
    public void openPiority2(View view) {
        Intent intent = new Intent(SelectPriority1.this,SelectPriority2.class);
        startActivity(intent);

    }
}
