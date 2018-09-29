package com.example.wushu.broken.particleSys;

import android.graphics.PointF;

public class Particle {
    public PointF pos;
    public PointF vp;
    public float r;
    public int color;

    public Particle(PointF pos, PointF vp,float r,int color) {
        this.pos = pos;
        this.vp = vp;
        this.r = r;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Particle{" +
                "pos=" + pos +
                ", vp=" + vp +
                ", r=" + r +
                ", color=" + color +
                '}';
    }
}
