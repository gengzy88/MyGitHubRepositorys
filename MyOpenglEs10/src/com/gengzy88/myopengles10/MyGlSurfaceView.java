package com.gengzy88.myopengles10;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGlSurfaceView extends GLSurfaceView{
	private MyDrawableComposite m_drawableComposite;
	public MyGlSurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setRenderer(new MyRender());
	}

	public interface MyDrawAble{
		void draw(GL10 gl);
	}
	
	private class MyRender implements GLSurfaceView.Renderer{
		
		
		

		public void onDrawFrame(GL10 gl) {
			// TODO Auto-generated method stub
			//gl.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
			gl.glLoadIdentity();
			m_drawableComposite.draw(gl);
		}

		public void onSurfaceChanged(GL10 gl, int width, int height) {
			// TODO Auto-generated method stub
			gl.glViewport(0, 0, width, height);
//			gl.glMatrixMode(GL10.GL_PROJECTION);
//			gl.glLoadIdentity();
//			GLU.gluPerspective(gl, 45.0f,(float) width / (float) height,0.1f, 100.0f);

		}

		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			// TODO Auto-generated method stub				
//				gl.glEnable(GL10.GL_TEXTURE_2D);            //Enable Texture Mapping ( NEW )
//		        gl.glShadeModel(GL10.GL_SMOOTH);            //Enable Smooth Shading
//		        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);    //Black Background
		        gl.glClearDepthf(1.0f);                     //Depth Buffer Setup
		        gl.glEnable(GL10.GL_DEPTH_TEST);            //Enables Depth Testing
		        gl.glDepthFunc(GL10.GL_LEQUAL);             //The Type Of Depth Testing To Do
//		        //Really Nice Perspective Calculations
//		        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
		}
	}
	public void setDrawableComposite(MyDrawableComposite drawableComposite){
		m_drawableComposite = drawableComposite;
	}
}
