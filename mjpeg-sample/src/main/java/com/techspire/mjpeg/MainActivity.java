package com.techspire.mjpeg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.techspire.mjpeglibrary.MjpegView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MjpegView webView = (MjpegView) findViewById(R.id.web_view);
        webView.setVerticalAlign(MjpegView.VerticalAlign.ALIGN_CENTER);
        webView.loadMjpeg("http://96.10.1.168/mjpg/1/video.mjpg");
    }
}
