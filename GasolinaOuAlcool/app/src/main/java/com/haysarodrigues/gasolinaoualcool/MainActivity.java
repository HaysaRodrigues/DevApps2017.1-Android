package com.haysarodrigues.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //expressão ternária java


    public void convertButton(View view){

        EditText gasolina = (EditText) findViewById(R.id.editTextGasolina);

        EditText alcool = (EditText) findViewById(R.id.editTextAlcool);



        Double amountAsADoubleGasolina = Double.parseDouble(gasolina.getText().toString());

        Double amountAsADoubleAlcool = Double.parseDouble(alcool.getText().toString());


        if(amountAsADoubleAlcool <= (amountAsADoubleGasolina * 0.7)){
            Toast.makeText(MainActivity.this, "Melhor alcool", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(MainActivity.this, "Melhor gasolina", Toast.LENGTH_LONG).show();

        }


    }



}
