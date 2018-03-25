package com.example.pamqian.sharkhack;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SHARK extends AppCompatActivity {
    private Button pet_head;
    private Button pet_butt;
    private boolean sharkMood=false;
    private TextView messageShark;
    MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shark);
        bgm = MediaPlayer.create(SHARK.this, R.raw.shark_bgm);
        bgm.setLooping(true);
        bgm.start();

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        pet_head = (Button) findViewById(R.id.pethead);
        pet_butt = (Button) findViewById(R.id.petbutt);


        pet_head.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ServiceCast")
            @Override
            public void onClick(View view) {
                messageShark = (TextView) findViewById(R.id.messageShark);
                if(!sharkMood) {
                    messageShark.setVisibility(TextView.VISIBLE);
                    ImageView img = (ImageView) findViewById(R.id.sharkneutral);
                    img.setImageResource(R.drawable.sharkhappy);
                    messageShark.setText("I like that!!");
                    sharkMood=true;
                }else{
                    sharkMood=false;
                    ImageView img = (ImageView) findViewById(R.id.sharkneutral);
                    img.setImageResource(R.drawable.sharkneutral);
                    messageShark.setVisibility(TextView.INVISIBLE);
                }

            }
        });


        pet_butt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ServiceCast")
            @Override
            public void onClick(View view) {
                messageShark = (TextView) findViewById(R.id.messageShark);
                if(!sharkMood) {
                    messageShark.setVisibility(TextView.VISIBLE);
                    ImageView img = (ImageView) findViewById(R.id.sharkneutral);
                    img.setImageResource(R.drawable.sharkmad);
                    messageShark.setText("Take your hands OFF!");
                    sharkMood=true;
                }else{
                    sharkMood=false;
                    ImageView img = (ImageView) findViewById(R.id.sharkneutral);
                    img.setImageResource(R.drawable.sharkneutral);
                    messageShark.setVisibility(TextView.INVISIBLE);
                }

            }
        });

    }

    @Override
    protected void onPause() {
        bgm.pause();
        bgm.release();
        super.onPause();
    }

}
