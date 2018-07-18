package com.example.alex.calculator;



public class Compute
{
    Compute()
    {

    }

    public double computation(double valueOne, double valueTwo, int action)
    {
        double result = 0;

        switch (action)
        {
            case 0:
                result = valueOne + valueTwo;
                break;
            case 1:
                result = valueOne - valueTwo;
                break;
            case 2:
                result = valueOne * valueTwo;
                break;
            case 3:
                result = valueOne / valueTwo;
                break;
        }

        return result;
    }
}
