package com.gengzy88.myopengles10;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

public class MyRender implements GLSurfaceView.Renderer{
	private MyDrawableComposite m_drawableComposite;
	
	interface MyDrawAble{
		void draw(GL10 gl);
	}

	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		//gl.glClear(GL10.GL_DEPTH_TEST);
		gl.glLoadIdentity();
		m_drawableComposite.draw(gl);
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		gl.glViewport(0, 0, width, height);
		 // Select the projection matrix
		 gl.glMatrixMode(GL10.GL_PROJECTION);
		 // Reset the projection matrix
		 gl.glLoadIdentity();
		 // Calculate the aspect ratio of the window
		 GLU.gluPerspective(gl, 45.0f,
		 (float) width / (float) height,
		 0.1f, 100.0f);

	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
//		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
//		 // Enable Smooth Shading, default not really needed.
//		 gl.glShadeModel(GL10.GL_SMOOTH);
//		 // Depth buffer setup.
//		 gl.glClearDepthf(1.0f);
//		 // Enables depth testing.
//		 gl.glEnable(GL10.GL_DEPTH_TEST);
//		 // The type of depth testing to do.
//		 gl.glDepthFunc(GL10.GL_LEQUAL);
//		 // Really nice perspective calculations.
//		 gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
//		 GL10.GL_NICEST);

			
			gl.glEnable(GL10.GL_TEXTURE_2D);            //Enable Texture Mapping ( NEW )
	        gl.glShadeModel(GL10.GL_SMOOTH);            //Enable Smooth Shading
	        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);    //Black Background
	        gl.glClearDepthf(1.0f);                     //Depth Buffer Setup
	        gl.glEnable(GL10.GL_DEPTH_TEST);            //Enables Depth Testing
	        gl.glDepthFunc(GL10.GL_LEQUAL);             //The Type Of Depth Testing To Do
	        //Really Nice Perspective Calculations
	        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
	}

	public void setDrawableComposite(MyDrawableComposite drawableComposite){
		m_drawableComposite = drawableComposite;
	}
}
