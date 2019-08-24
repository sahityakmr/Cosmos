package com.sahitya.cosmos;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Cosmo extends GameObject implements ViewDispatcher {
    private Bitmap[] faces;
    private static final int faceWidth = 182;
    private static final int faceHeight = 168;
    private static final int faceCount = 14;

    public Cosmo(Bitmap bitmap) {
        x = 100;
        y = BaseView.getPaneHeight();
        setWidth(faceWidth);
        setHeight(faceHeight);
        initializeFaces(bitmap);
    }

    private void initializeFaces(Bitmap bitmap) {
        faces = new Bitmap[faceCount];
        for (int i = 0, j = -1; i < faces.length; i++) {
            if (i % 5 == 0)
                j++;
            faces[i] = Bitmap.createBitmap(bitmap, (i % 5) * width, j * height, width, height);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {

    }
}
