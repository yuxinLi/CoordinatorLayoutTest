package com.example.coordinatorlayouttest.nested;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/8/24
 */

public class NestedParentLayout extends FrameLayout implements NestedScrollingParent {

    NestedScrollingParentHelper mNestedScrollingParentHelper;

    public NestedParentLayout(@NonNull Context context) {
        this(context , null);
    }

    public NestedParentLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public NestedParentLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    }


    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        mNestedScrollingParentHelper.onNestedScrollAccepted(child , target , axes);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);

        if (dx > 0){
            if (target.getRight() + dx > getWidth()){
                consumed[0] = target.getRight() + dx - getWidth();
                offsetLeftAndRight(consumed[0]);
            }
        }else {
            if (target.getLeft() + dx < 0){
                consumed[0] = target.getLeft() + dx;
                offsetLeftAndRight(consumed[0]);
            }
        }

        if (dy > 0){
            if (target.getBottom() + dy > getHeight()){
                consumed[1] = target.getBottom() + dy - getHeight();
                offsetTopAndBottom(consumed[1]);
            }
        }else {
            if (target.getTop() + dy < 0){
                consumed[1] += target.getTop() + dy;
                offsetTopAndBottom(consumed[1]);
            }
        }
    }



    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }


    @Override
    public void onStopNestedScroll(View child) {
        mNestedScrollingParentHelper.onStopNestedScroll(child);
    }

    @Override
    public int getNestedScrollAxes() {
        return mNestedScrollingParentHelper.getNestedScrollAxes();
    }
}
