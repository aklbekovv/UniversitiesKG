package com.flaterlab.uskg.util;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

abstract public class BaseActivity extends AppCompatActivity {

    protected void log(String msg) {
        String tag = "Mylog" + getClass().getSimpleName();
        Log.d(tag, msg);
    }
}
