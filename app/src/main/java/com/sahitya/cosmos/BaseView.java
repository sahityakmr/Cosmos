package com.sahitya.cosmos;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import java.util.ArrayList;

public class BaseView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "BaseView";
    public static int paneWidth = 1280;
    public static int paneHeight = 720;
    public static int moveSpeed = -4;
    private ArrayList<ViewDispatcher> dispatchers;

    public BaseView(Context context) {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        dispatchers = new ArrayList<>();
    }

    public static int getMoveSpeed() {
        return moveSpeed;
    }

    public static int getPaneWidth() {
        return paneWidth;
    }

    public static int getPaneHeight() {
        return paneHeight;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Background background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.forest));
        dispatchers.add(background);
        BaseThread baseThread = new BaseThread(getHolder(), this);
        baseThread.setRunning(true);
        baseThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void update() {
        Log.d(TAG, "update: ");
        for(ViewDispatcher dispatcher : dispatchers)
            dispatcher.update();
    }

    @Override
    public void draw(Canvas canvas) {
        Log.d(TAG, "draw: ");
        super.draw(canvas);
        for(ViewDispatcher dispatcher : dispatchers)
            dispatcher.draw(canvas);
    }
}
