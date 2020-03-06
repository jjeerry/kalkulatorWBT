package com.cukrzycatech.kalkulatorwbt;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    Button buttonFatProt, buttonKcalCarbs, buttonExit;
    TextView textMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFatProt = (Button) findViewById(R.id.buttonFatProt);
        buttonKcalCarbs = (Button) findViewById(R.id.buttonKcalCarbs);
        buttonExit = (Button) findViewById(R.id.btnExit);

        textMain = (TextView) findViewById(R.id.textMain);
    }

    public void CalcCarbProteins(View v){
        Intent i = new Intent(this,ProtFat.class);
        startActivity(i);
    }

    public void CalcKcalCarbs(View v){
        Intent i = new Intent(this,kcal_wegl.class);
        startActivity(i);
    }

    public void Exit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
