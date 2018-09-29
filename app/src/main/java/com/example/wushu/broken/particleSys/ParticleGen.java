package com.example.wushu.broken.particleSys;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ParticleGen {
    public static ArrayList<Particle> gen(Bitmap bitmap,int r)
    {
        ArrayList<Particle> res = new ArrayList<>();

        int R = r * 2;
        int w = bitmap.getWidth() / R;
        int h = bitmap.getHeight() / R;
        HashMap<Integer,Integer> m = new HashMap<>();

        int x0 = bitmap.getWidth() / 2;
        int y0 = bitmap.getHeight() / 2;

        for(int j = 0;j < h; ++j)
        {
            for(int i = 0;i < w; ++i)
            {
                m.clear();
                for(int y = 0;y < R;y++)
                {
                    for(int x = 0;x < R;x++)
                    {
                        int k = bitmap.getPixel((i * R) + x,(j * R) + y);
                        if( m.containsKey(k) )
                        {
                            int v = m.get(k);
                            m.put(k,v+1);
                        }else{
                            m.put(k,1);
                        }
                    }
                }
                int maxk = 0;
                int maxv = 0;
                for(Map.Entry<Integer,Integer> e : m.entrySet())
                {
                   // Log.e("WWS",e.toString());
                    if(e.getValue() > maxv)
                    {
                        maxv = e.getValue();
                        maxk = e.getKey();
                    }
                }
                int cx = (i * R) + r ;
                int cy = (j * R) + r ;
                PointF pos = new PointF(cx - x0 , cy - y0);
                res.add(new Particle(pos,new PointF(new Random().nextFloat() * 4.0f - 2.0f,new Random().nextFloat() * 16.0f - 9.0f),r,maxk));
            }
        }
        return res;
    }
}