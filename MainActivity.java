package com.example.calc;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button plus;
    private Button sub;
    private Button multi;
    private Button div;
    private Button equal;
    private Button back;
    private Button clear;
    private Button dot;
    private TextView info;
    private TextView result;
    private final char ADDITION ='+';
    private final char SUBTRACTION ='-';
    private final char MULTIPLICATION ='*';
    private final char DIV ='/';
    private final char Equ = 0;
    private final char per = '%';
    private final double de = 0.01;
    private double val1 = Double.NaN;
    private double val2;
    private char act;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + ".");
            }

        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              compute();
              act = ADDITION;
              result.setText(String.valueOf(val1) + "+");
              info.setText(null);

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                act = SUBTRACTION;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);

            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                act = MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                act = DIV;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                act = per;
                result.setText(String.valueOf(val1) + "%");
                info.setText(null);

            }
        });



        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                act = Equ;
                result.setText(String.valueOf(val1));
                //5+6=11
                info.setText(null);
                //to clear info

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);

                }
            }


        });
    }

    private void setupView() {


        one = (Button)findViewById(R.id.b1);
        two = (Button)findViewById(R.id.b2);
        three = (Button)findViewById(R.id.b3);
        four = (Button)findViewById(R.id.b4);
        five = (Button)findViewById(R.id.b5);
        six = (Button)findViewById(R.id.b6);
        seven = (Button)findViewById(R.id.b7);
        eight = (Button)findViewById(R.id.b8);
        nine = (Button)findViewById(R.id.b9);
        zero = (Button)findViewById(R.id.b0);
        plus = (Button)findViewById(R.id.bplus);
        sub = (Button)findViewById(R.id.bsub);
        multi = (Button)findViewById(R.id.bmult);
        div = (Button)findViewById(R.id.bdiv);
        clear = (Button)findViewById(R.id.bclear);
        equal = (Button)findViewById(R.id.bequal);
        back = (Button) findViewById(R.id.bback);
        dot = (Button)findViewById(R.id.bdot);
        info = (TextView) findViewById(R.id.ET);
        result = (TextView) findViewById(R.id.ET1);
    }


    private void compute(){
        if(!Double.isNaN(val1)){
            val2 =Double.parseDouble(info.getText().toString());

            switch(act){
                case ADDITION:
                    val1= val1+val2;
                    break;
                case SUBTRACTION:
                    val1= val1-val2;
                    break;
                case MULTIPLICATION:
                    val1= val1*val2;
                    break;
                case DIV:
                    val1= val1/val2;
                    break;
                case per:
                    val1= val1*de;
                    break;
                case Equ:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(info.getText().toString());
        }
    }


    }

