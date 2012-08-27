package com.gengzy88.myopengles10;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;


public class MyTriangle extends MyShape{

//	private FloatBuffer m_floatBuffer;
//	
//	public MyTriangle(){
//		float vertexCoord[] = new float[]{
//			0, 0.68f, 0,
//			-1f, 0, 0,
//			1f, 0, 0,
//		};
//		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertexCoord.length*4);
//		byteBuffer.order(ByteOrder.nativeOrder());
//		m_floatBuffer = byteBuffer.asFloatBuffer();
//		m_floatBuffer.put(vertexCoord);
//		m_floatBuffer.position(0);
//	}
//	public void draw(GL10 gl) {
//		// TODO Auto-generated method stub
//		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
//		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_floatBuffer);
//		gl.glColor4f(1.0f, 0f, 0f, 1.0f);
//		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
//		//gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
//	}
		private FloatBuffer floatBuffer;
		private FloatBuffer colorBuffer;
		public MyTriangle(){
			float triangleCoods[] = {
					-0.5f, -0.25f, 0.6f,  
	                0.5f, -0.25f, 0.6f,  
	                0.0f,  0.559016994f, -0.6f	
			};
			
			float colorCoods[] = new float[]{
				1.0f, 0, 0, 1.0f,
				0, 1.0f, 0, 1.0f,
				0, 0, 1.0f, 1.0f,
			};
			
			int len = triangleCoods.length;
			ByteBuffer byteBuffer = ByteBuffer.allocateDirect(triangleCoods.length*4);//ByteBuffer.allocate(triangleCoods.length*4);
			byteBuffer.order(ByteOrder.nativeOrder());
			floatBuffer = byteBuffer.asFloatBuffer();
			floatBuffer.put(triangleCoods);
			floatBuffer.position(0);
			
			ByteBuffer colorByteBuffer = ByteBuffer.allocateDirect(colorCoods.length*4);
			colorByteBuffer.order(ByteOrder.nativeOrder());
			colorBuffer = colorByteBuffer.asFloatBuffer();
			colorBuffer.put(colorCoods);
			colorBuffer.position(0);
			//floatBuffer.order();
		}
		
		public void draw(GL10 gl){
			//gl.glColor4f(0.5f, 0.3f, 0.3f, 0.5f);
			gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, floatBuffer);
			gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
			gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		}
}
