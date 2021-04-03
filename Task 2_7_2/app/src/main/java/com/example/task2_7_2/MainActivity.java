package com.example.task2_7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText Login;
    EditText Password;
    Button Input;
    List<String[]> list=new ArrayList<>();
    boolean r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(new String[]{"Yulia", "123"});
        list.add(new String[]{"123", "123"});
        text=(TextView) findViewById(R.id.textView);
        Login=(EditText) findViewById(R.id.editTextLogin);
        Password=(EditText)findViewById(R.id.editTextPassword);
        Input=(Button)findViewById(R.id.buttonInput);
        text.setText("");
        Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Login.getText().toString().equals("") && !Password.getText().toString().equals("")) {
                    for (String[] a:list) {
                        if (String.valueOf(Login.getText()).equals(a[0]) & String.valueOf(Password.getText()).equals(a[1]) ){
                            text.setText(R.string.True);
                            text.setTextColor(Color.GREEN);
                            r=true;
                            return;
                        }else {
                            r=false;
                        }
                    }
                    if (!r){
                        Context context=MainActivity.this;
                        Class anyActivity=MainActivity2.class;
                        Intent anyActiviy=new Intent(context,anyActivity);
                        startActivityForResult(anyActiviy,1);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Вы ничего не ввели", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle arguments = getIntent().getExtras();
        switch (resultCode) {
            case RESULT_OK:
                Login.setText(data.getStringExtra("log"));
                String log = data.getStringExtra("log");
                String pas = data.getStringExtra("pas");
                list.add(new String[]{log, pas});
        }
    }
}