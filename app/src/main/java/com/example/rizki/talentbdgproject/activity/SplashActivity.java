package com.example.rizki.talentbdgproject.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.rizki.talentbdgproject.R;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class SplashActivity extends LoginActivity {

    private static int SPLASH_TIMEOUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*boolean check = isSignedIn();

        if (check == true) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            intent.putExtra("splash","splash");
            startActivity(intent);
            finish();
        }
        else {*/
            ProgressBar spinner = findViewById(R.id.progbar);
            spinner.getIndeterminateDrawable().setColorFilter(R.color.colorPrimaryDark, android.graphics.PorterDuff.Mode.MULTIPLY);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_TIMEOUT);
//        }
    }
}
