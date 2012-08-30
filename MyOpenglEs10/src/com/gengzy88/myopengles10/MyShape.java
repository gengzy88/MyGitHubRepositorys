package com.gengzy88.myopengles10;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import com.gengzy88.myopengles10.MyGlSurfaceView.MyDrawAble;


public abstract class MyShape implements MyDrawAble{
	public void onInit(Context context){
		
	}
	
	public void onSurfaceChanged(GL10 gl){
		
	}
	public void onSurfaceCreate(GL10 gl){
		
	}
	public FloatBuffer floatToGlBuffer(float arr[]){
		FloatBuffer floatBuffer;
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(arr.length*4);
		byteBuffer.order(ByteOrder.nativeOrder());
		floatBuffer = byteBuffer.asFloatBuffer();
		floatBuffer.put(arr);
		floatBuffer.position(0);
		return floatBuffer;
	}
	
	public ShortBuffer shortToGlBuffer(short arr[]){
		ShortBuffer shortBuffer;
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(arr.length*2);
		byteBuffer.order(ByteOrder.nativeOrder());
		shortBuffer = byteBuffer.asShortBuffer();
		shortBuffer.put(arr);
		shortBuffer.position(0);
		return shortBuffer;
	}
}
