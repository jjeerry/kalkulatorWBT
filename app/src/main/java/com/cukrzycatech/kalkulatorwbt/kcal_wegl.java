package com.cukrzycatech.kalkulatorwbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class kcal_wegl extends AppCompatActivity {

    Button buttonCalc, BackButton2;
    TextView Wynik;
    EditText Kcals, Carbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kcal_wegl);
        buttonCalc = (Button) findViewById(R.id.buttonCalc);
        BackButton2 = (Button) findViewById(R.id.buttonKWback);

        Wynik = (TextView) findViewById(R.id.Wynik);
        Kcals = (EditText) findViewById(R.id.editKcal);
        Carbs = (EditText) findViewById(R.id.editCarbs);

        Kcals.addTextChangedListener(valuesTextWatcher);
        Carbs.addTextChangedListener(valuesTextWatcher);

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float v1 = Float.parseFloat (Kcals.getText() + "");
                float v2 = Float.parseFloat (Carbs.getText() + "");
                float vv = (v1-(4*v2))/100;
                if (vv>0) {
                    Wynik.setText(vv + " WBT");
                } else {
                    Wynik.setText("Błędne dane!");
                }

                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        });

        BackButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(kcal_wegl.this,MainActivity.class);
                startActivity(i);


            }
        });
    }

    public TextWatcher valuesTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String KcalsInput = Kcals.getText().toString();
            String CarbsInput = Carbs.getText().toString();

            buttonCalc.setEnabled(!KcalsInput.isEmpty() && !CarbsInput.isEmpty() );
            Wynik.setText("");
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
