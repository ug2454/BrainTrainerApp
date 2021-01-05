package com.example.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //TODO add a countdown timer for the game(done)
    // think of a way to randomize the correct answer choice(done)
    // add a done text and play again button after countdown ends(done)
    // make a + - * / game app


    Random random = new Random();
    int number1;
    int number2;
    int number3;
    int number4;
    TextView sum;
    TextView timer;
    int correctSum = 0;
    TextView score;
    int correctAnswerCounter = 0;
    int totalAnswerCounter = 0;
    Button optionButton;
    Button button;
    Button optionButton1;
    Button optionButton2;
    Button optionButton3;
    Button optionButton4;
    ConstraintLayout constraintLayout;
    CountDownTimer countDownTimer = null;
    TextView textView5;
    Button button2;
    ArrayList<Integer> integers = new ArrayList<Integer>();

    public void updateUI() {


        number1 = random.nextInt(30) + 1;
        number2 = random.nextInt(30) + 1;

        System.out.println(number1 + "" + number2);
        sum = findViewById(R.id.textView2);
        sum.setText(number1 + " + " + number2);

        score = findViewById(R.id.textView3);
        score.setText(correctAnswerCounter + " / " + totalAnswerCounter);
        correctSum = number1 + number2;
        optionButton1 = findViewById(R.id.optionButton1);
        optionButton2 = findViewById(R.id.optionButton2);
        optionButton3 = findViewById(R.id.optionButton3);
        optionButton4 = findViewById(R.id.optionButton4);
        optionButton1.setClickable(true);
        optionButton2.setClickable(true);
        optionButton3.setClickable(true);
        optionButton4.setClickable(true);

        int locationOfCorrectAnswer = random.nextInt(4);

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                integers.add(number1 + number2);
            } else {
                int wrongAnswer = random.nextInt(40);
                if (wrongAnswer == number1 + number2) {  //is wrong answer same as correct answer? assign a different random number
                    wrongAnswer = random.nextInt(40);
                }
                integers.add(wrongAnswer);


            }
        }

        optionButton4.setText(Integer.toString(integers.get(0)));
        optionButton3.setText(Integer.toString(integers.get(1)));
        optionButton2.setText(Integer.toString(integers.get(2)));
        optionButton1.setText(Integer.toString(integers.get(3)));
    }

    public void startGame(View view) {
        integers.clear();

        button = findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
        constraintLayout = findViewById(R.id.gridConstraintLayout);
        constraintLayout.setVisibility(View.VISIBLE);

        updateUI();
        textView5 = findViewById(R.id.textView4);
        playAgainUIUpdate();
        button2 = findViewById(R.id.button2);

        button2.setVisibility(View.INVISIBLE);
        timer = findViewById(R.id.textView);
        countDownTimer = new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText(Integer.toString((int) (l / 1000))+" s");
            }

            @Override
            public void onFinish() {
                textView5.setText("Done!");
                button2.setVisibility(View.VISIBLE);
                optionButton1.setClickable(false);
                optionButton2.setClickable(false);
                optionButton3.setClickable(false);
                optionButton4.setClickable(false);
            }
        }.start();

//        for(int i=0;i<3;i++){
//            optionButton.setText(Integer.toString(random.nextInt()));
//        }


    }

    public void playAgainUIUpdate() {
        textView5.setText("");
        correctAnswerCounter = 0;
        totalAnswerCounter = 0;
        score.setText(correctAnswerCounter + " / " + totalAnswerCounter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void selectOption(View view) {
        optionButton = (Button) view;
        integers.clear();

        TextView correctWrong = findViewById(R.id.textView4);
        String correctSumString = Integer.toString(correctSum);

        if (optionButton.getText().equals(correctSumString)) {
            correctWrong.setText("Correct :)");
            correctAnswerCounter++;
        } else {
            correctWrong.setText("Wrong :(");

        }
        totalAnswerCounter++;

        updateUI();

        Log.i("option", optionButton.getTag().toString());


    }
}