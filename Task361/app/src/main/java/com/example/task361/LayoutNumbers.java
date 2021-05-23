package com.example.task361;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class LayoutNumbers extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layoutnumbers, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button buttonOne = getView().findViewById(R.id.button1);
        buttonOne.setOnClickListener(this);
        Button buttonTwo = getView().findViewById(R.id.button2);
        buttonTwo.setOnClickListener(this);
        Button buttonThree = getView().findViewById(R.id.button3);
        buttonThree.setOnClickListener(this);
        Button buttonFour = getView().findViewById(R.id.button4);
        buttonFour.setOnClickListener(this);
        Button buttonFive = getView().findViewById(R.id.button5);
        buttonFive.setOnClickListener(this);
        Button buttonSix = getView().findViewById(R.id.button6);
        buttonSix.setOnClickListener(this);
        Button buttonSeven = getView().findViewById(R.id.button7 );
        buttonSeven.setOnClickListener(this);
        Button buttonEight = getView().findViewById(R.id.button8);
        buttonEight.setOnClickListener(this);
        Button buttonNine = getView().findViewById(R.id.button9);
        buttonNine.setOnClickListener(this);
        Button buttonZero = getView().findViewById(R.id.button0);
        buttonZero.setOnClickListener(this);
        Button buttonAdd = getView().findViewById(R.id.buttonAddition);
        buttonAdd.setOnClickListener(this);
        Button buttonSub = getView().findViewById(R.id.buttonSubtraction);
        buttonSub.setOnClickListener(this);
        Button buttonDiv = getView().findViewById(R.id.buttonDivision);
        buttonDiv.setOnClickListener(this);
        Button buttonMult = getView().findViewById(R.id.buttonMultiplication);
        buttonMult.setOnClickListener(this);
        Button buttonPoint = getView().findViewById(R.id.buttonComma);
        buttonPoint.setOnClickListener(this);
        Button buttonSign = getView().findViewById(R.id.button);
        buttonSign.setOnClickListener(this);
        /*Button buttonRemove = getView().findViewById(R.id.remove);
        buttonRemove.setOnClickListener(this);*/
    }
    @Override
    public void onClick(View v) {
        TextView text = getView().findViewById(R.id.textView3);
        String[] equation;
        switch (v.getId()) {
            case R.id.button1:
                if (text.getText().toString().contains("="))
                    text.setText("1");
                else
                    text.append("1");
                break;
            case R.id.button2:
                if (text.getText().toString().contains("="))
                    text.setText("2");
                else
                    text.append("2");
                break;
            case R.id.button3:
                if (text.getText().toString().contains("="))
                    text.setText("3");
                else
                    text.append("3");
                break;
            case R.id.button4:
                if (text.getText().toString().contains("="))
                    text.setText("4");
                else
                    text.append("4");
                break;
            case R.id.button5:
                if (text.getText().toString().contains("="))
                    text.setText("5");
                else
                    text.append("5");
                break;
            case R.id.button6:
                if (text.getText().toString().contains("="))
                    text.setText("6");
                else
                    text.append("6");
                break;
            case R.id.button7:
                if (text.getText().toString().contains("="))
                    text.setText("7");
                else
                    text.append("7");
                break;
            case R.id.button8:
                if (text.getText().toString().contains("="))
                    text.setText("8");
                else
                    text.append("8");
                break;
            case R.id.button9:
                if (text.getText().toString().contains("="))
                    text.setText("9");
                else
                    text.append("9");
                break;
            case R.id.button0:
                equation = text.getText().toString().split(" ");
                if (!text.getText().toString().isEmpty() && !text.getText().toString().contains("=") && equation.length != 2) {
                    text.append("0");
                }
                break;
            case R.id.buttonComma:
                equation = text.getText().toString().split(" ");
                if (!text.getText().toString().isEmpty() && !text.getText().toString().contains("=")) {
                    if (equation.length == 1 && equation[0].length() > 0 && !equation[0].contains(".")) {
                        text.append(".");
                    } else if (equation.length == 3 && equation[2].length() > 0 && !equation[2].contains(".")) {
                        text.append(".");
                    }
                }
                break;
            case R.id.button:
                equation = text.getText().toString().split(" ");
                if (!text.getText().toString().isEmpty() && !text.getText().toString().contains("=")) {
                    if (equation.length == 1 && equation[0].length() > 0) {
                        if (!equation[0].contains("-")) {
                            text.setText("-" + text.getText());
                        } else {
                            text.setText(text.getText().subSequence(1, text.getText().length()));
                        }
                    } else if (equation.length == 3 && equation[2].length() > 0) {
                        if (!equation[2].contains("-")) {
                            text.setText(equation[0] + " " + equation[1] + " -" + equation[2]);
                        } else {
                            text.setText(equation[0] + " " + equation[1] + " " + equation[2].substring(1));
                        }
                    }
                }
                break;
            default:
                if (!text.getText().toString().isEmpty()) {
                    try {
                        if (text.getText().toString().charAt(
                                text.getText().toString().length() - 1) == '.') text.append("0");

                        Double.parseDouble(text.getText().toString());

                        switch (v.getId()) {
                            case R.id.buttonAddition:
                                text.append(" + ");
                                break;
                            case R.id.buttonSubtraction:
                                text.append(" - ");
                                break;
                            case R.id.buttonMultiplication:
                                text.append(" * ");
                                break;
                            case R.id.buttonDivision:
                                text.append(" / ");
                                break;
                        }
                    } catch (NumberFormatException ex) {
                        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }
}
