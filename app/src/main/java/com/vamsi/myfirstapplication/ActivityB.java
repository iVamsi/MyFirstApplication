package com.vamsi.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    String valueFromActivityA;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        valueFromActivityA = getIntent().getStringExtra("int_value");

        textView = (TextView) findViewById(R.id.textView2);
        textView.setText(valueFromActivityA);
    }

    public void previousActivity(View v) {
        ActivityB.this.finish();
    }
}
