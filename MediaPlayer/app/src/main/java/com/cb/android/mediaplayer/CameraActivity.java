package com.cb.android.mediaplayer;

import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.List;

public class CameraActivity extends AppCompatActivity {

    Camera c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        c= Camera.open();
        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        c.setDisplayOrientation(90);
        CameraView cv = new CameraView(this,c);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        container.addView(cv);

        ((Button) findViewById(R.id.bv_click)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePic(v);
            }
        });


    }
    public void takePic(View view){

        c.takePicture(null, null, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                c.stopPreview();
                c.startPreview();
            }
        });
    }
}
