package com.example.wushu.broken.particleSys;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.NonNull;

import com.example.wushu.broken.particleSys.Particle;
import com.example.wushu.broken.particleSys.Particleable;

import java.util.ArrayList;

public class ParticleSys3 implements Particleable{
    private double sin_n;
    private double MAX_SIN_N = Math.PI / 2.0;
    private double MIN_SIN_N = 0;
    private Paint paint;
    private float x,y;
    private double zl = 0.01;
    private ArrayList<Particle> myPs;
    private ArrayList<Boolean> activate;
    private float activate_r;
    private float step_r;
    private float part_r;

    public ParticleSys3(@NonNull ArrayList<Particle> ps, float x, float y,float init_r,float step_r,float part_r)
    {
        activate = new ArrayList<>();
        activate_r = init_r;
        this.step_r = step_r;
        this.part_r = part_r;
        for(int i = 0;i < ps.size();i++)
        {
            activate.add(false);
        }
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
        for(int i = 0;i < activate.size() ;i++)
        {
            if(activate.get(i))
                continue;
            if(activate_r > Math.abs( myPs.get(i).pos.x + part_r) && activate_r > Math.abs(myPs.get(i).pos.y + part_r ))
            {
                activate.set(i,true);
            }
        }
        int i = 0;
        for(Particle p : myPs)
        {
            if(activate.get(i)) {
                p.pos.x += p.vp.x * delatiem * 0.01f;// *
                p.pos.y += p.vp.y * delatiem * 0.01f;// * Math.sin(sin_n);
                p.vp.y += Math.sin(sin_n) * 6;
                //p.r -= delatiem * 0.005f * Math.sin(sin_n);
            }
            i++;
        }
        activate_r += step_r;
        sin_n += zl;
    }
}
