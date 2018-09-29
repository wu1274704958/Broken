package com.example.wushu.broken.particleSys;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.NonNull;


import java.util.ArrayList;

public class ParticleSys implements Particleable{
    private double sin_n;
    private double MAX_SIN_N = Math.PI / 2.0;
    private double MIN_SIN_N = 0;
    private Paint paint;
    private float x,y;
    private double zl = 0.01;
    private ArrayList<Particle> myPs;

    public ParticleSys(@NonNull ArrayList<Particle> ps, float x, float y)
    {
        myPs = new ArrayList<>();
        for(Particle p : ps){
            myPs.add(new Particle(new PointF(p.pos.x,p.pos.y),new PointF(p.vp.x,p.vp.y),p.r,p.color));
        }

        this.x = x;
        this.y = y;
        sin_n = MIN_SIN_N;
        paint = new Paint();

        //paint.setAntiAlias(true);
    }
    @Override
    public boolean isOver() {
        return sin_n >= MAX_SIN_N;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(x,y);
        for(Particle p : myPs)
        {
            paint.setColor(p.color);
            canvas.drawCircle(p.pos.x,p.pos.y,p.r,paint);
        }
        canvas.restore();
    }

    @Override
    public void update(float delatiem) {
        for(Particle p : myPs)
        {
            p.pos.x += p.vp.x * delatiem * 0.01f;// *
            p.pos.y += p.vp.y * delatiem * 0.01f;// * Math.sin(sin_n);
            p.vp.y += Math.sin(sin_n) * 6;
            //p.r -= delatiem * 0.005f * Math.sin(sin_n);
        }
        sin_n += zl;
    }
}
