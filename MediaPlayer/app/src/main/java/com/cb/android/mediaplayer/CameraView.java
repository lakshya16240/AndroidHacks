package com.cb.android.mediaplayer;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by GhanshamBansal on 20/07/17.
 */

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
    Camera c;

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            c.setPreviewDisplay(holder);
            c.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        c.stopPreview();
        try {
            c.setPreviewDisplay(holder);
            c.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        c.release();

    }

    public CameraView(Context context, Camera camera) {
        super(context);
        this.c = camera;
        getHolder().addCallback(this);
    }
}
