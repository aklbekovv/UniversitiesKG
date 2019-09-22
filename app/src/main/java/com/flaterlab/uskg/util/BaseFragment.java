package com.flaterlab.uskg.util;

import android.util.Log;

import androidx.fragment.app.Fragment;

abstract public class BaseFragment extends Fragment {

    protected void log(String msg) {
        String tag = "Mylog" + getClass().getSimpleName();
        Log.d(tag, msg);
    }
}
