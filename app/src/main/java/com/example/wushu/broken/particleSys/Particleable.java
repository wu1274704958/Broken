package com.example.wushu.broken.particleSys;

import android.graphics.Canvas;

public interface Particleable {
    public boolean isOver();
    public void draw(Canvas canvas);
    public void update(float delatiem);
}
