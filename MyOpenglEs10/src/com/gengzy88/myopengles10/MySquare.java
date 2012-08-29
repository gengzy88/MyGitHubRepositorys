package com.gengzy88.myopengles10;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;



public class MySquare extends MyShape{
	private FloatBuffer m_vertexBuffer;
	private FloatBuffer m_colorBuffer;
	private float m_angle;
	
	public MySquare() {
		m_angle = 0f;
		float floatCoord[] = new float[]{
			-0.5f, 0.5f, -0.5f,	
			0.5f, 0.5f, -0.5f,
			0.5f, -0.5f, -0.5f,
			-0.5f, -0.5f, -0.5f,
		};
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(floatCoord.length*4);
		byteBuffer.order(ByteOrder.nativeOrder());
		m_vertexBuffer = byteBuffer.asFloatBuffer();
		m_vertexBuffer.put(floatCoord);
		m_vertexBuffer.position(0);
		
		float colorCoods[] = new float[]{
				1.0f, 0, 0, 1.0f,
				0, 1.0f, 0, 1.0f,
				0, 0, 1.0f, 1.0f,
				0, 0, 1.0f, 1.0f,
			};
		ByteBuffer colorByteBuffer = ByteBuffer.allocateDirect(colorCoods.length*4);
		colorByteBuffer.order(ByteOrder.nativeOrder());
		m_colorBuffer = colorByteBuffer.asFloatBuffer();
		m_colorBuffer.put(colorCoods);
		m_colorBuffer.position(0);
	}
	public void draw(GL10 gl) {
		// TODO Auto-generated method stub
		//gl.glPointSize(8f);
		m_angle += 2;
		gl.glRotatef(m_angle, 0, 0, 1.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_vertexBuffer);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_colorBuffer);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
}
