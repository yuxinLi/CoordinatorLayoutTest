package com.example.coordinatorlayouttest.appbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.coordinatorlayouttest.R;


public class AppbarTestActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtnScroll,mBtnExit,mBtnSnap,mBtnEnter,mBtnEnterCollapsed,mBtnCollapsing,
            mBtnOffset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_test);

        mBtnScroll = (Button) findViewById(R.id.btn_scroll);
        mBtnScroll.setOnClickListener(this);
        mBtnExit = (Button) findViewById(R.id.btn_exit);
        mBtnExit.setOnClickListener(this);
        mBtnEnter = (Button) findViewById(R.id.btn_enter_always);
        mBtnEnter.setOnClickListener(this);
        mBtnEnterCollapsed = (Button) findViewById(R.id.btn_enter_collapsed);
        mBtnEnterCollapsed.setOnClickListener(this);
        mBtnSnap = (Button) findViewById(R.id.btn_snap);
        mBtnSnap.setOnClickListener(this);

        mBtnCollapsing = (Button) findViewById(R.id.btn_collapseing);
        mBtnCollapsing.setOnClickListener(this);
        mBtnOffset = (Button) findViewById(R.id.btn_offset);
        mBtnOffset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(AppbarTestActivity.this, AppbarLayoutActivity.class);

        switch (v.getId())
        {
            case R.id.btn_scroll:
                intent.putExtra("layout",R.layout.activity_appbar_layout_scroll);
                break;
            case R.id.btn_exit:
                intent.putExtra("layout",R.layout.activity_appbar_layout_exit);
                break;
            case R.id.btn_enter_always:
                intent.putExtra("layout",R.layout.activity_appbar_layout_scroll_enter);
                break;
            case R.id.btn_enter_collapsed:
                intent.putExtra("layout",R.layout.activity_appbar_layout_enter_collapsed);
                break;
            case R.id.btn_snap:
                intent.putExtra("layout",R.layout.activity_appbar_layout_snap);
                break;
            case R.id.btn_collapseing:
                intent.putExtra("layout",R.layout.activity_appbar_layout_collapsed_toolbar);
                break;
            case R.id.btn_offset:
                intent.putExtra("layout",R.layout.activity_appbar_layout_scroll_alpha);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
