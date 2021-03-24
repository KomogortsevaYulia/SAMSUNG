package com.example.task_2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button result;
    EditText InputA;
    EditText InputB;
    EditText InputC;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.button);
        InputA = findViewById(R.id.A);
        InputB = findViewById(R.id.B);
        InputC = findViewById(R.id.C);
        res = findViewById(R.id.textView);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Equation();
            }
        });
    }

    /**
     * Вызывается при нажатии пользователем на кнопку Решить
     */
    public void Equation() {
        try {
            double a = Double.parseDouble(String.valueOf(InputA.getText()));
            double b = Double.parseDouble(String.valueOf(InputB.getText()));
            double c = Double.parseDouble(String.valueOf(InputC.getText()));
            double d = b * b - 4 * a * c;
            if (d > 0) {
                double x1 = (-b - Math.sqrt(d)) / (2 * a);
                double x2 = (-b + Math.sqrt(d)) / (2 * a);
                res.setText("x1 =" + x1 + ", x2 =" + x2);
            } else if (d == 0) {
                double x;
                x = -b / (2 * a);
                res.setText("x =" + x);
            } else {
                res.setText("Уравнение не имеет действительных корней");
            }
        } catch (NumberFormatException e) {
            res.setText("Ошибка.Можно вводить только числа!");
        }
    }
}