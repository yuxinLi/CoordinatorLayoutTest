package com.example.coordinatorlayouttest;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/8/22
 */

public class MyBehavior extends CoordinatorLayout.Behavior<View> {

    static String TAG = "MyBehavior";
    public MyBehavior() {
    }

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return false;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        child.setX(dependency.getX());
        child.setY(dependency.getY() + 100);

        return true;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        Log.d(TAG , " === onStartNestedScroll === ");
        return child instanceof ImageView && nestedScrollAxes == View.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        Log.d(TAG , " === onStartNestedScroll === dx = "+ dx + " , dy = "+ dy);
        ViewCompat.offsetTopAndBottom(child , dy);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.d(TAG , " === onStartNestedScroll === ");
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        Log.d(TAG , " === onStartNestedScroll === ");

        if (velocityY > 0){
            child.animate().scaleX(2f).scaleY(2f).setDuration(1000).start();
        }else {
            child.animate().scaleX(1f).scaleY(1f).setDuration(1000).start();
        }

        return false;
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        Log.d(TAG , " === onStartNestedScroll === ");
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }


}
