package com.gengzy88.myopengles10;

import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import com.gengzy88.myopengles10.MyRender.MyDrawAble;

public class MyDrawableComposite implements MyDrawAble{
	private ArrayList<MyDrawAble> m_DrawAbles;
	
	public MyDrawableComposite(){
		m_DrawAbles = new ArrayList<MyRender.MyDrawAble>();
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
