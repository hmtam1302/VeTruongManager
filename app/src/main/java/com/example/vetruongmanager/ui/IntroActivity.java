package com.example.vetruongmanager.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.vetruongmanager.MainActivity;
import com.example.vetruongmanager.R;

public class IntroActivity extends AppCompatActivity {

    //Constant time delay
    private final int DELAY = 2500;

    //Fields (Widgets)
    private ImageView logoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        getWindow().setBackgroundDrawable(null);

        //Methods to call
        initializeView();
        animatedLogo();
        goToMainActivity();
    }

    private void initializeView() {
        logoView = findViewById(R.id.intro_logo);
    }

    private void animatedLogo() {
        //This method will animate logo
        Animation fadingAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadingAnimation.setDuration(DELAY);

        logoView.startAnimation(fadingAnimation);
    }

    private void goToMainActivity() {
        //This method will tkae the user to main actitvity when the animation is finished
        new Handler().postDelayed(() -> {
            startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            finish();
        }, DELAY);

    }
}