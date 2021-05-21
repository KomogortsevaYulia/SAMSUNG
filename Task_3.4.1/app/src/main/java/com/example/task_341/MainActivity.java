package com.example.task_341;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Bitmap bitmap;
    Button button;
    ImageView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        v=(ImageView) findViewById(R.id.imageView2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, " Запуск потока", Toast.LENGTH_SHORT).show();
                new LoadImage().execute();
            }
        });
    }
    // объект потока
    private class LoadImage extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        protected Void doInBackground(Void... args) {
            try {
                URL url = new URL("https://images.wallpaperscraft.ru/image/more_priboj_voda_pena_119619_540x960.jpg");
                InputStream input =(InputStream) (url.getContent());

                bitmap=BitmapFactory.decodeStream(input);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Void image) {
            v.setImageBitmap(bitmap);
            Toast.makeText(MainActivity.this, "Закрытие потока", Toast.LENGTH_SHORT).show();

        }

    }
}
