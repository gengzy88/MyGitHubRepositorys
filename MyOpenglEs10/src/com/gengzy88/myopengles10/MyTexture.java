package com.gengzy88.myopengles10;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class MyTexture extends MyShape{
	private Bitmap m_shuiche;
	private FloatBuffer m_vetexBuffer;
	private FloatBuffer m_textureBuffer;
	private ShortBuffer m_indicesBuffer;
	private int m_textures[];
	
	@Override
	public void onInit(Context context) {
		// TODO Auto-generated method stub
		super.onInit(context);
		m_shuiche = BitmapFactory.decodeResource(context.getResources(), R.drawable.shuiche);
	}

	@Override
	public void onSurfaceChanged(GL10 gl) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onSurfaceCreate(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glGenTextures(1, m_textures, 0);
		
		 // ...and bind it to our array
		 gl.glBindTexture(GL10.GL_TEXTURE_2D, m_textures[0]);
		 
		 // Create Nearest Filtered Texture
		 gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
		 GL10.GL_LINEAR);
		 gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
		 GL10.GL_LINEAR);
		 
		 // Different possible texture parameters, e.g. GL10.GL_CLAMP_TO_EDGE
		 gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S,
		 GL10.GL_CLAMP_TO_EDGE);
		 gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T,
		 GL10.GL_REPEAT);
		 // Use the Android GLUtils to specify a two-dimensional texture image
		 // from our bitmap
		 GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, m_shuiche, 0);
		 m_shuiche.recycle();
	}

	public MyTexture() {
		// TODO Auto-generated constructor stub
		float vetex[] = new float[]{
			-0.5f, 0.5f, 0f,
			-0.5f, -0.5f, 0f,
			0.5f, -0.5f, 0f,
			0.5f, 0.5f, 0f,
		};
		ByteBuffer veteBuffer = ByteBuffer.allocateDirect(vetex.length*4);
		veteBuffer.order(ByteOrder.nativeOrder());
		m_vetexBuffer = veteBuffer.asFloatBuffer();
		m_vetexBuffer.put(vetex);
		m_vetexBuffer.position(0);
		
		float texture[] = new float[]{
			0, 0,
			0, 1,
			1, 1,
			1, 0,
		};
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(texture.length*4);
		byteBuffer.order(ByteOrder.nativeOrder());
		m_textureBuffer = byteBuffer.asFloatBuffer();
		m_textureBuffer.put(texture);
		m_textureBuffer.position(0);
		
		m_indicesBuffer = shortToGlBuffer(new short[]{
			0, 1, 2, 0, 2, 3,	
		});
		
		m_textures = new int[1];
	}
	
	public void draw(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glBindTexture(GL10.GL_TEXTURE_2D, m_textures[0]);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_vetexBuffer);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_textureBuffer);
		//gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
		gl.glDrawElements(GL10.GL_TRIANGLES, 6, GL10.GL_UNSIGNED_SHORT, m_indicesBuffer);
		
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}

}
