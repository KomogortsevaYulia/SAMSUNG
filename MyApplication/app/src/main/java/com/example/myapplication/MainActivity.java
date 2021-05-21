package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button) findViewById(R.id.button);
        OnClickListener oclBtnOk = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),R.string.text,Toast.LENGTH_SHORT).show();
            }
        };
        button.setOnClickListener(oclBtnOk);
    }
}