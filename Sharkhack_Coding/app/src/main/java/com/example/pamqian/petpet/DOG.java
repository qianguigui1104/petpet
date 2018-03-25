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

public class DOG extends AppCompatActivity {
    private Button pet_head;
    private Button pet_butt;
    private boolean dogMood=false;
    private TextView messageDog;
    private boolean isPlaying=false;
    MediaPlayer sound_effect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        pet_head = (Button) findViewById(R.id.pethead);
        pet_butt = (Button) findViewById(R.id.petbutt);

        pet_head.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ServiceCast")
            @Override
            public void onClick(View view) {
                sound_effect = MediaPlayer.create(DOG.this, R.raw.dog_happy);
                messageDog = (TextView) findViewById(R.id.messageDog);

                if(!dogMood) {
                    messageDog.setVisibility(TextView.VISIBLE);
                    ImageView img = (ImageView) findViewById(R.id.dogneutral);
                    img.setImageResource(R.drawable.dog1happy);
                    messageDog.setText("I am HAPPY!");
                    sound_effect.setLooping(true);
                    sound_effect.start();
                    isPlaying = true;
                    dogMood=true;
                }else{
                    dogMood=false;
                    if (isPlaying) {
                        sound_effect.pause();
                        isPlaying = false;
                    }
                    ImageView img = (ImageView) findViewById(R.id.dogneutral);
                    img.setImageResource(R.drawable.dog1neutral);
                    messageDog.setVisibility(TextView.INVISIBLE);
                }

            }
        });



        pet_butt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ServiceCast")
            @Override
            public void onClick(View view) {
                sound_effect = MediaPlayer.create(DOG.this, R.raw.dog_mad);
                messageDog = (TextView) findViewById(R.id.messageDog);

                if(!dogMood) {
                    messageDog.setVisibility(TextView.VISIBLE);
                    ImageView img = (ImageView) findViewById(R.id.dogneutral);
                    img.setImageResource(R.drawable.dog1mad);
                    messageDog.setText("I am MAD!");
                    sound_effect.setLooping(true);
                    sound_effect.start();
                    isPlaying = true;
                    dogMood=true;
                }else{
                    dogMood=false;
                    if (isPlaying) {
                        sound_effect.pause();
                        isPlaying = false;
                    }
                    ImageView img = (ImageView) findViewById(R.id.dogneutral);
                    img.setImageResource(R.drawable.dog1neutral);
                    messageDog.setVisibility(TextView.INVISIBLE);
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
