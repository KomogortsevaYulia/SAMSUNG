package com.example.task_2_5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText Login;
    EditText Password;
    Button Input;
    final String log="Yulia";
    final String key="123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView) findViewById(R.id.textView);
        Login=(EditText) findViewById(R.id.editTextLogin);
        Password=(EditText)findViewById(R.id.editTextPassword);
        Input=(Button)findViewById(R.id.buttonInput);
        text.setText("");
        Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(Login.getText()).equals(log) & String.valueOf(Password.getText()).equals(key) ){
                    text.setText(R.string.True);
                    text.setTextColor(Color.GREEN);
                }else {
                    text.setText(R.string.False);
                    text.setTextColor(Color.RED);
                    Login.setText("");
                    Password.setText("");
                }
            }
        });
    }
}