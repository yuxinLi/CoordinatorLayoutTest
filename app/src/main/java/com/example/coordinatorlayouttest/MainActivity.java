package com.example.coordinatorlayouttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.coordinatorlayouttest.appbar.AppbarTestActivity;
import com.example.coordinatorlayouttest.dependency.DependencyActivity;
import com.example.coordinatorlayouttest.nested.NestedActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_dependency).setOnClickListener(this);
        findViewById(R.id.btn_nestedscroll).setOnClickListener(this);
        findViewById(R.id.btn_appbar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.btn_dependency:
                i = new Intent(this , DependencyActivity.class);
                break;
            case R.id.btn_nestedscroll:
                i = new Intent(this , NestedActivity.class);
                break;
            case R.id.btn_appbar:
                i = new Intent(this , AppbarTestActivity.class);
                break;
            default:
                i = new Intent(this , DependencyActivity.class);
                break;
        }
        startActivity(i);
    }
}
