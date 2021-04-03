package com.example.task2_7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText Login;
    EditText Password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Login=(EditText) findViewById(R.id.editLogin);
        Password=(EditText)findViewById(R.id.editPassword);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Login.getText().toString().equals("") && !Password.getText().toString().equals("")) {
                    Intent i = new Intent();
                    i.putExtra("log", Login.getText().toString());
                    i.putExtra("pas", Password.getText().toString());
                    setResult(RESULT_OK, i);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Вы ничего не ввели", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}