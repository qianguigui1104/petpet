package com.example.pamqian.sharkhack;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.Random;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void Random(View view) {
        Random rand = new Random();
        int n = rand.nextInt(4) +1;
        if (n==1)
            Dog(view);
        else if (n==2)
            Cat(view);
        else if (n==3)
            Turtle(view);
        else
            Shark(view);
   }

    public void Dog(View view) {
        Intent intent = new Intent(this, DOG.class);
        startActivity(intent);
    }

    public void Cat(View view) {
        Intent intent = new Intent(this, CAT.class);
        startActivity(intent);
    }

    public void Turtle(View view) {
        Intent intent = new Intent(this, TURTLE.class);
        startActivity(intent);
    }

    public void Shark(View view) {
        Intent intent = new Intent(this, SHARK.class);
        startActivity(intent);
    }

}
