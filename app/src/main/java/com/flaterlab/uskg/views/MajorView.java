package com.flaterlab.uskg.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.flaterlab.uskg.R;

public class MajorView extends FrameLayout {

    private TextView tvName, tvFee;

    public MajorView(Context context) {
        super(context);
        init();
    }

    public MajorView(Context context, AttributeSet attr) {
        super(context, attr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.view_major, this);
        tvName = findViewById(R.id.tv_major_name);
        tvFee = findViewById(R.id.tv_major_fee);
    }

    public void setName(String name) {
        tvName.setText(name);
    }

    public void setFee(String fee) {
        tvFee.setText(fee);
    }
}
