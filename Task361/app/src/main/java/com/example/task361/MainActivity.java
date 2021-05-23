package com.example.task361;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
    private double number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.textView3);
        final String[][] equation = new String[3][3];
        Button buttonClear = (Button) findViewById(R.id.buttonDelete);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
            }
        });
        Button buttonEqual =(Button) findViewById(R.id.buttonEqually);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!text.getText().toString().isEmpty()) {
                    equation[0] = text.getText().toString().split(" ");
                    if (text.getText().toString().charAt(
                            text.getText().toString().length() - 1) == '.') text.append("0");
                    try {
                        number1 = Double.parseDouble(equation[0][0]);
                        number2 = Double.parseDouble(equation[0][2]);
                        Toast.makeText(MainActivity.this, equation[0][1], Toast.LENGTH_SHORT).show();

                        switch (equation[0][1]) {
                            case "+":
                                text.append(" = " + (number1 + number2));
                                break;
                            case "-":
                                text.append(" = " + (number1 - number2));
                                break;
                            case "*":
                                text.append(" = " + (number1 * number2));
                                break;
                            case "/":
                                text.append(" = " + (number1 / number2));
                                break;
                        }
                    } catch (NumberFormatException ex) {
                        Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}