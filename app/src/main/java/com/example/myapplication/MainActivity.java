package com.example.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn , pg;
    int incorrectans;
    TextView tv , timer;
    TextView result , scr;
    ArrayList<Integer> correct = new ArrayList<Integer>();
    int correctpos;
    Button btn0 , btn1 , btn2 , btn3;
    int score , total;
    RelativeLayout rl;



    public  void playagain(View view)
    {
        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        //hello
//hello1
        score = 0;
        total = 0;
        scr.setText("0/0");
        result.setText("       ");

        pg.setVisibility(View.INVISIBLE);
        generateQuestion();
        new CountDownTimer(31000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished/1000) +"s" );

            }

            @Override
            public void onFinish() {
                result.setText("Your score : " + Integer.toString(score) + "/" + Integer.toString(total));
                timer.setText("Os");
                //gl.setEnabled(false);
                btn0.setEnabled(false);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);

                pg.setVisibility(View.VISIBLE);
            }
        }.start();


    }

    public void generateQuestion() {
      //  gl.setEnabled(true);
        String sign;
        Random rand = new Random();
        int a = rand.nextInt(20);
        int b = rand.nextInt(25);
        int c = rand.nextInt(2);
        correctpos = rand.nextInt(4);
        if (c == 1)
            sign = "+";
        else
            sign = "x";
        tv.setText(Integer.toString(a) + sign + Integer.toString(b));

        correct.clear();

        for (int i = 0; i < 4; i++) {
            if (correctpos == i) {
                if (c == 1)
                    correct.add(a + b);
                else
                    correct.add(a * b);
            } else {


                if (c == 1) {
                    incorrectans = rand.nextInt(50);
                    while (incorrectans == a + b) {
                        incorrectans = rand.nextInt(500);
                    }
                    correct.add(incorrectans);
                } else {
                    incorrectans = rand.nextInt(500);
                    while (incorrectans == a * b) {
                        incorrectans = rand.nextInt(500);
                    }
                    correct.add(incorrectans);

                }
            }


        }
        btn0.setText(Integer.toString(correct.get(0))) ;
        btn1.setText(Integer.toString(correct.get(1))) ;
        btn2.setText(Integer.toString(correct.get(2))) ;
        btn3.setText(Integer.toString(correct.get(3))) ;
    }


    public void chooseanswer(View view) {

        if(view.getTag().toString().equals(Integer.toString(correctpos)))
        {

            score++;
            result.setText("Correct !");
        }
         else
        {
            result.setText("Oops! Wrong");

        }
        total++;
         scr.setText(Integer.toString(score) + "/" + Integer.toString(total));
         generateQuestion();
    }

    public void start(View view) {

        btn.setVisibility(View.INVISIBLE);
        rl.setVisibility(View.VISIBLE);
        playagain(findViewById(R.id.playagain));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.start);
        btn0 = (Button)findViewById(R.id.button0);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        result = (TextView)findViewById(R.id.result);
        scr = (TextView)findViewById(R.id.score);
      tv = (TextView) findViewById(R.id.question);
      timer = (TextView)findViewById(R.id.timer);

      rl = (RelativeLayout)findViewById(R.id.rl);
      pg = (Button)findViewById(R.id.playagain);




    }
}