package com.gengzy88.myopengles10;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	private MyGlSurfaceView m_surfaceView;
	private MyDrawableComposite m_drawableComposite;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
         getWindow().setFlags(
         WindowManager.LayoutParams.FLAG_FULLSCREEN,
         WindowManager.LayoutParams.FLAG_FULLSCREEN);

        m_surfaceView = new MyGlSurfaceView(this);
        m_drawableComposite = m_surfaceView.getDrawableComposite();
        
        setContentView(m_surfaceView);
        
        //m_drawableComposite.add(new MyTriangle());
        //m_drawableComposite.add(new MySquare());
        //m_drawableComposite.add(new MyTriangularPyramid());
        //m_drawableComposite.add(new MyCube());
        m_drawableComposite.add(new MyTexture());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
