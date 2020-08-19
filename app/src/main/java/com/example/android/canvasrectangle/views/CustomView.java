package com.example.android.canvasrectangle.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {

    private static final int RECTANGLE_SIZE = 1000;

    private static Rect mRect;
    private static Paint mPaint;

    private static boolean move = true;
    private static boolean left = true;
    private static boolean top = true;
    private static boolean right = true;
    private static boolean bottom = true;

    private static float X = 600;
    private static float Y = 600;

    private static float dxLeft = 130;
    private static float dxRight = 130;
    private static float dyTop = 130;
    private static float dyBottom = 130;

    private static float changeLeft = 250;
    private static float changeRight = 250;
    private static float changeTop = 250;
    private static float changeBottom = 250;


    public CustomView(Context context) {
        super(context);

        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        mRect = new Rect();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    public void onDraw(Canvas canvas) {

        mRect.left = (int) (X - changeLeft);
        mRect.top = (int) (Y - changeTop);
        mRect.right = (int) (X + changeRight);
        mRect.bottom = (int) (Y + changeBottom);

        mPaint.setColor(Color.GRAY);
        canvas.drawRect(mRect.left, mRect.top, mRect.right, mRect.bottom, mPaint);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {

                return true;
            }

            case MotionEvent.ACTION_MOVE: {
                float x = event.getX();
                float y = event.getY();

                if (x > X - changeLeft + 30f && y > Y - changeTop + 30f &&
                        x < X + changeRight - 30f && y < Y + changeBottom - 30f) {
                    //Touched
                    X = x;
                    Y = y;

                    Log.v("CustomView", "Touched " + x + " " + y);

                    invalidate();
                    return true;
                }

                if (x > X - changeLeft - 30f && x < X - changeLeft + 30f && y > Y - changeTop - 30f && y < Y - changeTop + 30f) {
                    changeLeft = x;
                    changeTop = y;

                    Log.v("CustomView", "Top Left Touched " + x + " " + y);

                    invalidate();
                    return true;
                }
                return value;
            }
        }
        return value;
    }
}
