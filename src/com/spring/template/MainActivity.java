package com.spring.template;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.widget.ImageView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.spring.app.UILApplication;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.FeedbackAgent;
import com.umeng.update.UmengUpdateAgent;


@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	@ViewById(R.id.imageView)
	protected ImageView imageView;
	
	@AfterViews
	public void init(){
		
		MobclickAgent.updateOnlineConfig(this);
		
		UmengUpdateAgent.update(this);
		
		ImageLoader.getInstance().displayImage("http://img0.bdstatic.com/img/image/shouye/hjxnz-11723371136.jpg", imageView);
		
		StringRequest request = new StringRequest(Method.GET, "http://blog.csdn.net/guolin_blog/article/details/17482095", new Listener<String>() {

			@Override
			public void onResponse(String arg0) {
//				System.out.println(arg0);
			}
		},new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
//				System.err.println(arg0);
			}
		});
		
		UILApplication.getInstance().addToRequestQueue(request);
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
	
	@Click(R.id.test_fb)
	public void onFbClick(){
		FeedbackAgent agent = new FeedbackAgent(this);
	    agent.startFeedbackActivity();
	}
}
