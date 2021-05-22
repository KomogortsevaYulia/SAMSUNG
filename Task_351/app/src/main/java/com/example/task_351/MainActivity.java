package com.example.task_351;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager; //менеджер сенсоров
    private TextView res;
    //private float n;
    private  Sensor sensor;
    MediaPlayer mPlayer;
    AudioManager audioManager;

    public MainActivity() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        res = (TextView) findViewById(R.id.resextView);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mPlayer=MediaPlayer.create(this, R.raw.sound);
        mPlayer.start();
        mPlayer.setLooping(true);

        //n=0;
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        final int type = event.sensor.getType(); //определяем тип датчика
        if (type == Sensor.TYPE_LIGHT) { //если акселерометр
            res.setText(String.valueOf( event.values[0]));
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            String s= String.valueOf(event.values[0]);
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, Integer.parseInt(s.substring(0,s.indexOf(".")))/50, 0);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_UI );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            mPlayer.stop();
            try {
                mPlayer.prepare();
                mPlayer.seekTo(0);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        mPlayer.stop();
        if (mPlayer.isPlaying()) {
            try {
                mPlayer.prepare();
                mPlayer.seekTo(0);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}