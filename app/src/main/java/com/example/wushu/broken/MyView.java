package com.example.wushu.broken;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.example.wushu.broken.particleSys.ParticleSys;
import com.example.wushu.broken.particleSys.Particleable;

import java.util.ArrayList;
import java.util.LinkedList;


public class MyView extends View {
    ParticleSys sys;
    LinkedList<Particleable> particlePlayer = new LinkedList<>();
    ArrayList<Particleable> rmlist = new ArrayList<>();

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    void init()
    {

    }
    public void addParticle(Particleable p)
    {
        particlePlayer.add(p);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rmlist.clear();
        for( Particleable p : particlePlayer)
        {
            if(p.isOver())
            {
                rmlist.add(p);
            }else {
                p.draw(canvas);
                p.update(8);
            }
        }
        for(Particleable p : rmlist)
        {
            particlePlayer.remove(p);
        }
       if(!particlePlayer.isEmpty())
       {
           postDelayed(new Runnable() {
               @Override
               public void run() {
                   MyView.this.invalidate();
               }
           },8);
       }
    }
}
