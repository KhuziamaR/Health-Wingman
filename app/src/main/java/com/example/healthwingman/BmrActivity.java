package com.example.healthwingman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BmrActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    EditText weight, height, age;
    TextView resulttext;
    String calculation, BMRresult, gender;
    RadioGroup genderRadio;
//    RadioButton maleRadio, femaleRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        resulttext = findViewById(R.id.result);
        genderRadio = (RadioGroup) findViewById(R.id.genderRadio);

        genderRadio.setOnCheckedChangeListener(this);

    }

    public void backToMenu(View view) {
        finish();
    }

    public void calculateBMR(View view) {
        String S1 = weight.getText().toString();
        String S2 = height.getText().toString();
        String S3 = age.getText().toString();



        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2);
        float ageValue = Float.parseFloat(S3);

        double bmr = 0;
        if (gender == "male"){
            bmr = (double) (66 + (6.2 * weightValue) + (12.7 * heightValue) - (6.76 * ageValue));
        }
        if (gender == "female"){
            bmr = (double) (655 + (4.35 * weightValue) + (4.7 * heightValue) - (4.7 * ageValue));
        }



        ((MyApplication) this.getApplication()).setSomeVariable(bmr);
        calculation = "Your BMR:  " + bmr + " Calories" ;

        resulttext.setText(calculation);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.maleRadio:
                gender = "female";
                break;
            case R.id.femaleRadio:
                gender = "male";
                break;
        }
    }
}