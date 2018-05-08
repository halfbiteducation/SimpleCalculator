package com.example.prekshasingla.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double valueOne = Double.NaN;
    private double valueTwo;


    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonZero;

    Button buttonDot;
    Button buttonEqual;
    Button buttonDivide;
    Button buttonMultiply;
    Button buttonSubtract;
    Button buttonAdd;
    Button buttonClear;

    TextView infoTextView;
    EditText editText;

    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne=(Button)findViewById(R.id.buttonOne);
        buttonTwo=(Button)findViewById(R.id.buttonTwo);
        buttonThree=(Button)findViewById(R.id.buttonThree);
        buttonFour=(Button)findViewById(R.id.buttonFour);
        buttonFive=(Button)findViewById(R.id.buttonFive);
        buttonSix=(Button)findViewById(R.id.buttonSix);
        buttonSeven=(Button)findViewById(R.id.buttonSeven);
        buttonEight=(Button)findViewById(R.id.buttonEight);
        buttonNine=(Button)findViewById(R.id.buttonNine);
        buttonZero=(Button)findViewById(R.id.buttonZero);

        buttonDot=(Button)findViewById(R.id.buttonDot);
        buttonEqual=(Button)findViewById(R.id.buttonEqual);
        buttonDivide=(Button)findViewById(R.id.buttonDivide);
        buttonMultiply=(Button)findViewById(R.id.buttonMultiply);
        buttonSubtract=(Button)findViewById(R.id.buttonSubtract);
        buttonAdd=(Button)findViewById(R.id.buttonAdd);
        buttonClear=(Button)findViewById(R.id.buttonClear);

        infoTextView=(TextView)findViewById(R.id.infoTextView);
        editText=(EditText)findViewById(R.id.editText);




        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "1");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "2");
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "3");
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "4");
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "5");
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "6");
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "7");
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "8");
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "9");
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "0");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + ".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ACTION = '+';
                infoTextView.setText(valueOne + "+");
                editText.setText(null);
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ACTION = '-';
                infoTextView.setText(valueOne + "-");
                editText.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ACTION = '*';
                infoTextView.setText(valueOne + "*");
                editText.setText(null);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ACTION = '/';
                infoTextView.setText(valueOne + "/");
                editText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                infoTextView.setText(infoTextView.getText().toString() + valueTwo + " = " + valueOne);
                valueOne = Double.NaN;
                ACTION = '0';
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().length() > 0) {
                    CharSequence currentText = editText.getText();
                    editText.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    editText.setText("");
                    infoTextView.setText("");
                }
            }
        });


    }

    private void calculate() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(editText.getText().toString());
            editText.setText(null);

            if(ACTION == '+')
                valueOne = this.valueOne + valueTwo;
            else if(ACTION == '-')
                valueOne = this.valueOne - valueTwo;
            else if(ACTION == '*')
                valueOne = this.valueOne * valueTwo;
            else if(ACTION == '/')
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(editText.getText().toString());
            }
            catch (Exception e){}
        }
    }
}
