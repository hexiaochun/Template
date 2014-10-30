package com.spring.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.spring.template.R;
import com.umeng.analytics.MobclickAgent;


public class BaseActivity extends Activity {

	private FrameLayout container = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.base_container	);
		container = (FrameLayout) this.findViewById(R.id.container);
	}

	/**
	 * 设置回退
	 */
	public void setBack(){
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	private long lastBackTime = 0;
	
	private int subTime = 1*1000;
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if(System.currentTimeMillis() - lastBackTime >subTime){
				lastBackTime = System.currentTimeMillis();
				onBackPressed();
				return true;
			}
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}
	
	
	@Override
	public void setContentView(int layoutResID) {
		container.removeAllViews();
		View view = LayoutInflater.from(this).inflate(layoutResID, container,false);
		container.addView(view);
	}
	
	
}
