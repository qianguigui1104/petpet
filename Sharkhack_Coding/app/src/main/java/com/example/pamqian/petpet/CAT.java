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

public class CAT extends AppCompatActivity {
    private Button pet_head;
    private Button pet_butt;
    private boolean catMood=false;
    private TextView messageCat;
    private boolean isPlaying=false;
    MediaPlayer sound_effect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        pet_head = (Button) findViewById(R.id.pethead);
        pet_butt = (Button) findViewById(R.id.petbutt);

        pet_head.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ServiceCast")
            @Override

            public void onClick(View view) {
                messageCat = (TextView) findViewById(R.id.messageCat);
                sound_effect = MediaPlayer.create(CAT.this, R.raw.cat_happy);

                if(!catMood) {
                    messageCat.setVisibility(TextView.VISIBLE);
                    ImageView img = (ImageView) findViewById(R.id.catneutral);
                    img.setImageResource(R.drawable.cathappy);
                    messageCat.setText("That feels NICE!");
                    sound_effect.setLooping(true);
                    sound_effect.start();
                    isPlaying = true;
                    catMood=true;
                }else{
                    catMood=false;
                    if (isPlaying) {
                        sound_effect.pause();
                        isPlaying = false;
                    }
                    ImageView img = (ImageView) findViewById(R.id.catneutral);
                    img.setImageResource(R.drawable.catneutral);
                    messageCat.setVisibility(TextView.INVISIBLE);
                }

            }
        });


        pet_butt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ServiceCast")
            @Override
            public void onClick(View view) {
                messageCat = (TextView) findViewById(R.id.messageCat);
                sound_effect = MediaPlayer.create(CAT.this, R.raw.cat_mad);
                if(!catMood) {
                    messageCat.setVisibility(TextView.VISIBLE);
                    ImageView img = (ImageView) findViewById(R.id.catneutral);
                    img.setImageResource(R.drawable.catmad);
                    messageCat.setText("DON't touch my tail!");
                    sound_effect.setLooping(true);
                    sound_effect.start();
                    isPlaying = true;
                    catMood=true;
                }else{
                    catMood=false;
                    if (isPlaying) {
                        sound_effect.pause();
                        isPlaying = false;
                    }
                    ImageView img = (ImageView) findViewById(R.id.catneutral);
                    img.setImageResource(R.drawable.catneutral);
                    messageCat.setVisibility(TextView.INVISIBLE);
                }

            }
        });

    }

    @Override
    protected void onPause() {
        sound_effect.pause();
        super.onPause();
    }
}
