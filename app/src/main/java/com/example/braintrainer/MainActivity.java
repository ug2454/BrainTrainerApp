package com.example.braintrainer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    int number1;
    int number2;
    int number3;
    int number4;
    TextView sum;
    int correctSum = 0;
    TextView score;
    int correctAnswerCounter = 0;
    int totalAnswerCounter = 0;
    Button button;
    Button optionButton;
    ConstraintLayout constraintLayout;

    public void startGame(View view) {
        button = findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
        constraintLayout = findViewById(R.id.gridConstraintLayout);
        constraintLayout.setVisibility(View.VISIBLE);
        number1 = random.nextInt(10) + 1;
        number2 = random.nextInt(10) + 1;
        number3 = random.nextInt(20) + 10;
        number4 = random.nextInt(30) + 21;
        System.out.println(number1 + "" + number2);
        sum = findViewById(R.id.textView2);
        sum.setText(number1 + " + " + number2);

        score = findViewById(R.id.textView3);
        score.setText(correctAnswerCounter + " / " + totalAnswerCounter);
        correctSum = number1 + number2;
        optionButton = (Button) view;

        for(int i=0;i<3;i++){
            optionButton.getTag(i)
        }
        optionButton.setText(Integer.toString(number3));

        optionButton.setText(Integer.toString(number4));

        optionButton.setText(Integer.toString(correctSum));

        optionButton.setText(Integer.toString(number1));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void selectOption(View view) {
        optionButton = (Button) view;


        TextView correctWrong = findViewById(R.id.textView4);
        String correctSumString = Integer.toString(correctSum);

        if (optionButton.getText().equals(correctSumString)) {
            correctWrong.setText("Correct :)");
            correctAnswerCounter++;
        } else {
            correctWrong.setText("Wrong :(");

        }
        totalAnswerCounter++;

        Log.i("option", optionButton.getTag().toString());


    }
}