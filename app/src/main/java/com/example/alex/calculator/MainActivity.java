package com.example.alex.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
   private int ACTION;
   private double valueOne;
   private double valueTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getButtonValue (View view)
    {
        Button button = (Button) view;
        String result = button.getText().toString();
        TextView textView = findViewById(R.id.display);

        if(textView.getText().equals("0.0"))
        {
            textView.setText(result);
        }
        else
        {
            textView.setText(textView.getText().toString() + result);
        }
    }

    public void toggleNegative (View view)
    {
        TextView textView = findViewById(R.id.display);
        String currentText = textView.getText().toString();

        if (currentText.charAt(0) != '-')
        {
            textView.setText("-" + textView.getText());
        }
        else
        {
            textView.setText(textView.getText().subSequence(1, textView.getText().length()));
        }
    }

    public void getAction (View view)
    {
        Button button = (Button) view;
        String value = button.getText().toString();
        TextView textView = findViewById(R.id.display);

        getButtonValue(view);

        String result = textView.getText().toString();

        if (result.charAt(0) == '-')
        {
            result = result.substring(1);
            valueOne = Double.parseDouble(result.substring(0, (result.length()-1))) * -1;
        }
        else
        {
            valueOne = Double.parseDouble(result.substring(0, (result.length() - 1)));
        }

        switch (value)
        {
            case "+":
                ACTION = 0;
                break;
            case "-":
                ACTION = 1;
                break;
            case "*":
                ACTION = 2;
                break;
            case "/":
                ACTION = 3;
                break;
             default:
                 break;
        }

        textView.setText("0.0");
    }

    public void clear (View view)
    {
        TextView textView = findViewById(R.id.display);
        textView.setText("0.0");
    }

    public void calculateResult (View view)
    {
        TextView textView = findViewById(R.id.display);
        String result = textView.getText().toString();

        valueTwo = Double.parseDouble(result);

        Compute compute = new Compute();

        double compute_result = compute.computation(valueOne, valueTwo, ACTION);
        textView.setText(String.valueOf(compute_result));
    }
}