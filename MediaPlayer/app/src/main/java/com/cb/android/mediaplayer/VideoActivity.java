package com.cb.android.mediaplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = (VideoView) findViewById(R.id.videoView);
        mp = new MediaPlayer();

        videoView.setVideoURI(Uri.parse("android.resource://com.cb.android.mediaplayer/raw/video"));
        MediaController mController  = new MediaController(this);
        videoView.start();
        videoView.setMediaController(mController);




    }
}
