package com.gengzy88.myopengles10;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class MyCube extends MyShape{
	private FloatBuffer m_vetexBuffer;
	private FloatBuffer m_colorBuffer;
	private ShortBuffer m_indecsBuffer;
	private float m_angel;
	public MyCube() {
		// TODO Auto-generated constructor stub
		m_angel = 0f;
		float vetexCoords[] = new float[]{
				0.5f, 0.5f, 0.5f,
				0.5f, 0.5f, -0.5f,
				-0.5f, 0.5f, -0.5f,
				-0.5f, 0.5f, 0.5f,
				0.5f, -0.5f, 0.5f,
				0.5f, -0.5f, -0.5f,
				-0.5f, -0.5f, -0.5f,
				-0.5f, -0.5f, 0.5f,
			};
			ByteBuffer vetexCoordsBuffer = ByteBuffer.allocateDirect(vetexCoords.length*4);
			vetexCoordsBuffer.order(ByteOrder.nativeOrder());
			m_vetexBuffer = vetexCoordsBuffer.asFloatBuffer();
			m_vetexBuffer.put(vetexCoords);
			m_vetexBuffer.position(0);
			
			float colorCoords[] = new float[]{
				1.0f, 1.0f, 1.0f, 1.0f,
				1.0f, 0f, 0f, 1.0f,
				0f, 1.0f, 0f, 1.0f,
				0f, 0f, 1.0f, 1.0f,
				
				0f, 1.0f, 0f, 1.0f,
				0f, 0f, 1.0f, 1.0f,
				1.0f, 1.0f, 1.0f, 1.0f,
				1.0f, 0f, 0f, 1.0f,
				
			};
			ByteBuffer colorBuffer = ByteBuffer.allocateDirect(colorCoords.length*4);
			colorBuffer.order(ByteOrder.nativeOrder());
			m_colorBuffer = colorBuffer.asFloatBuffer();
			m_colorBuffer.put(colorCoords);
			m_colorBuffer.position(0);
			
			short indices[] = new short[]{
				0, 1, 2,  0, 2, 3,
				0, 4, 5, 0, 5, 1,
				0, 7, 4, 0, 3, 7,
				3, 6, 7, 3, 2, 6,
				1, 5, 6, 1, 6, 2,
				4, 6, 5, 4, 7, 6,
			};
			ByteBuffer indicesBuffer = ByteBuffer.allocateDirect(indices.length*2);
			indicesBuffer.order(ByteOrder.nativeOrder());
			m_indecsBuffer = indicesBuffer.asShortBuffer();
			m_indecsBuffer.put(indices);
			m_indecsBuffer.position(0);
	}
	public void draw(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glFrontFace(GL10.GL_CCW);//逆时针为正面， GLC_CW逆时针为反面
		gl.glCullFace(GL10.GL_BACK);
		
		gl.glRotatef(m_angel, 1.0f, 1.0f, 1.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_vetexBuffer);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_colorBuffer);
		gl.glDrawElements(GL10.GL_TRIANGLES, 36, GL10.GL_UNSIGNED_SHORT, m_indecsBuffer);
		
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
		m_angel += 2.0f;
	}

}
