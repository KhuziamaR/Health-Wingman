package com.example.healthwingman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import static java.lang.Math.abs;

public class CalorieActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    EditText weight, goalWeight, weeks;
    TextView resulttext;
    String calculation, CalorieResult;
    double activity;
    RadioGroup activityRadio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        weight = findViewById(R.id.weight);
        goalWeight = findViewById(R.id.goalWeight);
        weeks = findViewById(R.id.weeks);
        resulttext = findViewById(R.id.result);
        activityRadio = (RadioGroup) findViewById(R.id.activityRadio);

        activityRadio.setOnCheckedChangeListener(this);
    }

    public void backToMenu(View view) {
        finish();
    }

    public void calculateCalories(View view) {
        String S1 = weight.getText().toString();
        String S2 = goalWeight.getText().toString();
        String S3 = weeks.getText().toString();


        float weightValue = Float.parseFloat(S1);
        float goalWeightValue = Float.parseFloat(S2);
        float weeksValue = Float.parseFloat(S3);
        float pounds = goalWeightValue - weightValue;
        float changeCaloriesPerDay = (pounds * 3500)/(weeksValue*7);
        double dailyCalories;
        if (((MyApplication) this.getApplication()).getSomeVariable() == null) {
            resulttext.setText("Please use the BMR calculator to calculate your BMR first!");
            return;
        } else{

            Double bmr = ((MyApplication) this.getApplication()).getSomeVariable();
            dailyCalories = (bmr * activity) + changeCaloriesPerDay; // + changeCaloriesPerDay;
            calculation = "Result: You need to consume " + dailyCalories  + " calories per day to reach your goal weight of "+S2 +"lbs in "+S3+" weeks\n";
            resulttext.setText(calculation);
        }




    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.A1Radio:
                activity = 1.2;
                break;
            case R.id.A2Radio:
                activity = 1.375;
                break;
            case R.id.A3Radio:
                activity = 1.55;
                break;
            case R.id.A4Radio:
                activity = 1.725;
                break;
            case R.id.A5Radio:
                activity = 1.9;
                break;
        }
    }
}