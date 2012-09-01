package com.gengzy88.myjnitest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class MyJniTestActivity extends Activity {

	public native String getNativeString();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_jni_test);
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(getNativeString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_my_jni_test, menu);
        return true;
    }

    static{
    	System.loadLibrary("MyJniTest");
    }
}
