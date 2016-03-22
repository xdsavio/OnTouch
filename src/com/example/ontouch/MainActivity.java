package com.example.ontouch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnTouchListener;


 public class MainActivity extends Activity implements SensorEventListener {

    private TextView myTouchEvent;
    
   
    private ImageView myImageView;
    
    
    private Bitmap bitmap;
    
    
    private Sensor sensor;
    
    
    private ImageView xImagem;
    
    
    private ImageView yImagem;
    
    
    private ImageView zImagem;
    
    
    private SensorManager SM;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myImageView = (ImageView) findViewById(R.id.imageView);
        

        myTouchEvent = (TextView) findViewById(R.id.textViewEvent);


        bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.android);
        
        
        myImageView.setImageBitmap(bitmap);


        myImageView.setOnTouchListener(onTouchListener);
        
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SM.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        

        xImagem = (ImageView) findViewById(R.drawable.android);
        
        
        yImagem = (ImageView) findViewById(R.drawable.android);
        
        
        zImagem = (ImageView) findViewById(R.drawable.android);

    }
    
    
        OnTouchListener onTouchListener = new OnTouchListener() {
 
        public boolean onTouch(View v, MotionEvent event) {


            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                
                case MotionEvent.ACTION_POINTER_DOWN:

                    myTouchEvent.setText("ACTION_POINTER_DOWN");
                    break;
                    
                    
                case MotionEvent.ACTION_MOVE:

                    myTouchEvent.setText("ACTION_MOVE");
                    break;
                    
                    
                case MotionEvent.ACTION_UP:

                    myTouchEvent.setText("ACTION_UP");
                    break;
                    
                    
                case MotionEvent.ACTION_DOWN:
                	  
                    myTouchEvent.setText("ACTION_DOWN");
                    break;
            }
            return true;
        }

    };


    public void onSensorChanged(SensorEvent event) {

        xImagem.setImageDrawable("X : " + event.values[0]);

        Log.i("Accelerometer", "onSensorChanged" + event.values[0]);

        yImagem.setImageDrawable("Y : " + event.values[1]);

        Log.i("Accelerometer", "onSensorChanged" + event.values[1]);

        zImagem.setImageDrawable("Z : " + event.values[2]);

        Log.i("Accelerometer", "onSensorChanged" + event.values[2]);
    }




    public void onAccuracyChanged(Sensor sensor, int accuracy) {


        Log.i("Accelerometer", "onSensorChanged");

    }
}