package com.example.wushu.broken;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wushu.broken.particleSys.ParticleGen;
import com.example.wushu.broken.particleSys.ParticleSys;
import com.example.wushu.broken.particleSys.ParticleSys2;
import com.example.wushu.broken.particleSys.ParticleSys3;
import com.example.wushu.broken.particleSys.ParticleSys4;


public class MainActivity extends AppCompatActivity {
    ImageView iv;
    MyView myView;
    Button tv;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.mv);
        tv = findViewById(R.id.tv);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        iv4 = findViewById(R.id.iv4);

        iv = findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( v.getDrawingCache() == null)
                    v.buildDrawingCache();
                myView.addParticle(new ParticleSys(ParticleGen.gen(v.getDrawingCache(),3),
                        v.getX() + (v.getWidth() / 2),v.getY() + (v.getHeight() / 2)
                ));
                v.setVisibility(View.INVISIBLE);
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getDrawingCache() == null)
                    v.buildDrawingCache();
                myView.addParticle(new ParticleSys(ParticleGen.gen(v.getDrawingCache(), 5),
                        v.getX() + (v.getWidth() / 2), v.getY() + (v.getHeight() / 2)
                ));
                v.setVisibility(View.INVISIBLE);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getDrawingCache() == null)
                    v.buildDrawingCache();
                myView.addParticle(new ParticleSys2(ParticleGen.gen(v.getDrawingCache(), 8),
                        v.getX() + (v.getWidth() / 2), v.getY() + (v.getHeight() / 2)
                ));
                v.setVisibility(View.INVISIBLE);
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getDrawingCache() == null)
                    v.buildDrawingCache();
                myView.addParticle(new ParticleSys3(ParticleGen.gen(v.getDrawingCache(), 3),
                        v.getX() + (v.getWidth() / 2), v.getY() + (v.getHeight() / 2),0.5f,0.5f,3
                ));
                v.setVisibility(View.INVISIBLE);
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getDrawingCache() == null)
                    v.buildDrawingCache();
                myView.addParticle(new ParticleSys4(ParticleGen.gen(v.getDrawingCache(), 8),
                        v.getX() + (v.getWidth() / 2), v.getY() + (v.getHeight() / 2),8f,4f,8
                ));
                v.setVisibility(View.INVISIBLE);
            }
        });
    }
}
