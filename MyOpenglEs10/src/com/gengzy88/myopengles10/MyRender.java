package com.gengzy88.myopengles10;
import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;

public class MyRender implements GLSurfaceView.Renderer{

	ArrayList<MyDrawAble> m_shapList;
	interface MyDrawAble{
		void draw(GL10 gl);
	}

	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		
		for (MyDrawAble shape : m_shapList) {
			shape.draw(gl);
		}
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		
	}

}
