package com.gengzy88.myopengles10;

import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

import com.gengzy88.myopengles10.MyGlSurfaceView.MyDrawAble;

public class MyDrawableComposite implements MyGlSurfaceView.MyDrawAble{
	private ArrayList<MyDrawAble> m_DrawAbles;
	
	public MyDrawableComposite(){
		m_DrawAbles = new ArrayList<MyDrawAble>();
	}
	
	public void draw(GL10 gl) {
		// TODO Auto-generated method stub
		for(MyDrawAble drawable : m_DrawAbles) {
			drawable.draw(gl);
		}
	}

	public void add(MyDrawAble drawAble){
		m_DrawAbles.add(drawAble);
	}
	
	public void delete(MyDrawAble drawAble){
		m_DrawAbles.remove(drawAble);
	}
}
