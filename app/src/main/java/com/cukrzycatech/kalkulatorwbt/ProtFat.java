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

public class ProtFat extends AppCompatActivity {

    Button buttonCalc, BackButton1;
    TextView Wynik;
    EditText Fats, Prots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prot_fat);

        buttonCalc = (Button) findViewById(R.id.buttonCalc);
        BackButton1 = (Button) findViewById(R.id.buttonCPback);

        Wynik = (TextView) findViewById(R.id.Wynik);
        Fats = (EditText) findViewById(R.id.editFat);
        Prots = (EditText) findViewById(R.id.editProt);

        Fats.addTextChangedListener(valuesTextWatcher);
        Prots.addTextChangedListener(valuesTextWatcher);

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float v1 = Float.parseFloat (Fats.getText() + "");
                float v2 = Float.parseFloat (Prots.getText() + "");

                float vv = ((4*v1)+(9*v2))/100;
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

        BackButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProtFat.this,MainActivity.class);
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
            String fatsInput = Fats.getText().toString();
            String protsInput = Prots.getText().toString();

            buttonCalc.setEnabled(!fatsInput.isEmpty() && !protsInput.isEmpty() );
            Wynik.setText("");
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
