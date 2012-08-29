package com.gengzy88.myopengles10;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class MyTriangularPyramid extends MyShape{
	private FloatBuffer m_vertexBuffer;
	private FloatBuffer m_colorBuffer;
	private float m_angle;
	public MyTriangularPyramid(){
		m_angle = 0;
		float vertexCoord[] = new float[]{
			0f, 0f, 0.5f,
			0.5f, 0f, 0f,
			0f, -0.5f, 0f,
			
			0f, 0f, 0.5f,
			0.5f, 0f, 0f,
			0f, 0.5f, 0f,
			
			0f, 0f, 0.5f,
			0f, -0.5f, 0f,
			0f, 0.5f, 0f,
			
			0f, -0.5f, 0f,
			0f, -0.5f, 0f,
			0f, 0.5f, 0f,
		};
		ByteBuffer byteVertexBuffer = ByteBuffer.allocateDirect(vertexCoord.length*4);
		byteVertexBuffer.order(ByteOrder.nativeOrder());
		m_vertexBuffer = byteVertexBuffer.asFloatBuffer();
		m_vertexBuffer.put(vertexCoord);
		m_vertexBuffer.position(0);
		
		float colorCoord[] = new float[]{
			1.0f, 0f, 0f, 1.0f,
			0f, 1.0f, 0f, 1.0f,
			0f, 0f, 1.0f, 1.0f,
			
			1.0f, 1.0f, 1.0f, 1.0f,
			0f, 1.0f, 0f, 1.0f,
			0f, 0f, 1.0f, 1.0f,
			
			1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 0f, 0f, 1.0f,
			0f, 0f, 1.0f, 1.0f,
			
			1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 0f, 0f, 1.0f,
			0f, 1.0f, 0f, 1.0f,
		};
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(colorCoord.length*4);
		byteBuffer.order(ByteOrder.nativeOrder());
		m_colorBuffer = byteBuffer.asFloatBuffer();
		m_colorBuffer.put(colorCoord);
		m_colorBuffer.position(0);
	}
	public void draw(GL10 gl) {
		// TODO Auto-generated method stub
		m_angle += 2;
		gl.glRotatef(m_angle, 1.0f, 1.0f, 1.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_vertexBuffer);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_colorBuffer);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);
		
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
	}

}
