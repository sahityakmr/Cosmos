package com.sahitya.cosmos;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Background extends GameObject implements ViewDispatcher{
    private Bitmap image;

    public Background(Bitmap image) {
        this.image = image;
        setdX(BaseView.getMoveSpeed());
    }

    @Override
    public void update() {
        x = (x + dX);
        if(x < -BaseView.getPaneWidth())
            x = 0;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
        if(x < 0)
            canvas.drawBitmap(image, x + BaseView.getPaneWidth(), y, null);
    }
}
