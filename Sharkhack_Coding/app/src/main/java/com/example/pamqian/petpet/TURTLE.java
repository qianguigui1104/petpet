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

public class TURTLE extends AppCompatActivity {
    private Button pet_head;
    private Button pet_butt;
    private boolean turtleMood=false;
    private TextView messageTurtle;
    MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turtle);
        bgm = MediaPlayer.create(TURTLE.this, R.raw.turtle_bgm);
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
                messageTurtle = (TextView) findViewById(R.id.messageTurtle);
                if(!turtleMood) {
                    messageTurtle.setVisibility(TextView.VISIBLE);
                    ImageView img = (ImageView) findViewById(R.id.turtleneutral);
                    img.setImageResource(R.drawable.turtlehappy);
                    messageTurtle.setText("You are my BEST friend!");
                    turtleMood=true;
                }else{
                    turtleMood=false;
                    ImageView img = (ImageView) findViewById(R.id.turtleneutral);
                    img.setImageResource(R.drawable.turtleneutral);
                    messageTurtle.setVisibility(TextView.INVISIBLE);
                }

            }
        });



        pet_butt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ServiceCast")
            @Override
            public void onClick(View view) {
                messageTurtle = (TextView) findViewById(R.id.messageTurtle);
                if(!turtleMood) {
                    messageTurtle.setVisibility(TextView.VISIBLE);
                    ImageView img = (ImageView) findViewById(R.id.turtleneutral);
                    img.setImageResource(R.drawable.turtlemad);
                    messageTurtle.setText("Hands OFF of my butt!");
                    turtleMood=true;
                }else{
                    turtleMood=false;
                    ImageView img = (ImageView) findViewById(R.id.turtleneutral);
                    img.setImageResource(R.drawable.turtleneutral);
                    messageTurtle.setVisibility(TextView.INVISIBLE);
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
