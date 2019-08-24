package com.sahitya.cosmos;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class BaseThread extends Thread {
    private boolean isRunning;
    private SurfaceHolder surfaceHolder;
    private BaseView baseView;
    private Canvas canvas;
    private long frameRate;

    public BaseThread(SurfaceHolder surfaceHolder, BaseView baseView) {
        this.surfaceHolder = surfaceHolder;
        this.baseView = baseView;
        frameRate = 30;
    }

    @Override
    public void run() {
        long startTime;
        long timeElapsedInCanvasUpdate;
        long timeToHoldFrame = 1000 / frameRate;
        while (isRunning) {
            startTime = System.currentTimeMillis();
            canvas = surfaceHolder.lockCanvas();
            baseView.update();
            baseView.draw(canvas);
            surfaceHolder.unlockCanvasAndPost(canvas);
            timeElapsedInCanvasUpdate = (System.currentTimeMillis() - startTime) / 1000;
            try {
                Thread.sleep(timeToHoldFrame - timeElapsedInCanvasUpdate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
