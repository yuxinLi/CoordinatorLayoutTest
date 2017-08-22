package com.example.coordinatorlayouttest;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button v = (Button) findViewById(R.id.btn);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            v.setNestedScrollingEnabled(true);
        }

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    v.startNestedScroll(View.SCROLL_AXIS_VERTICAL);
                }
            }
        });
    }
}
