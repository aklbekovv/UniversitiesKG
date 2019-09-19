package com.flaterlab.uskg.screens.splash;

import android.content.Intent;
import android.os.Bundle;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.screens.main.MainActivity;
import com.flaterlab.uskg.util.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startMainActivity();
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
