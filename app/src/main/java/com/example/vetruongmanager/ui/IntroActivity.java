package com.example.vetruongmanager.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.vetruongmanager.MainActivity;
import com.example.vetruongmanager.R;
import com.example.vetruongmanager.data.Ticket;
import com.example.vetruongmanager.data.TicketManager;

public class IntroActivity extends AppCompatActivity {

    //Constant time delay
    private final int DELAY = 2500;

    //Data for test
    public static TicketManager ticketManager;

    //Fields (Widgets)
    private ImageView logoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);

        getWindow().setBackgroundDrawable(null);

        //setUpData
        setUpData();

        //Methods to call
        initializeView();
        animatedLogo();
        goToMainActivity();
    }

    private void setUpData() {
        ticketManager = new TicketManager();
        ticketManager.addNewTicket(new Ticket(1, "Huỳnh Công Hải", "12/1", "0942239400", true));
        ticketManager.addNewTicket(new Ticket(20, "Hải", "12/1", "1", false));
        ticketManager.addNewTicket(new Ticket(300, "Hải", "12/1", "1", false));
        ticketManager.addNewTicket(new Ticket(4, "Hải", "12/1", "1", false));
        ticketManager.addNewTicket(new Ticket(5, "Hải", "12/1", "1", false));
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
        //This method will take the user to main actitvity when the animation is finished
        new Handler().postDelayed(() -> {
            startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            finish();
        }, DELAY);

    }
}