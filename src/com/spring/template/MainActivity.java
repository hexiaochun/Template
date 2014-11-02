package com.spring.template;

import org.androidannotations.annotations.AfterViews;
<<<<<<< HEAD
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.spring.ui.BaseActivity;
import com.spring.ui.view.TabOneDay;
import com.spring.ui.view.TabOneDay_;
import com.spring.ui.view.TabPeotry;
import com.spring.ui.view.TabPeotry_;
import com.spring.ui.view.TabSetting;
import com.spring.ui.view.TabSetting_;
import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity implements
		OnCheckedChangeListener {

	@ViewById(R.id.main_container)
	protected FrameLayout main_container;

	@ViewById(R.id.main_radio_tab)
	protected RadioGroup main_radio_tab;

	private TabOneDay tabOneDay = null;

	private TabPeotry tabPeotry = null;

	private TabSetting tabSetting = null;

	@AfterViews
	public void init() {

		MobclickAgent.updateOnlineConfig(this);
		UmengUpdateAgent.update(this);
		main_radio_tab.setOnCheckedChangeListener(this);

		setCheck(0);

	}

	private void setCheck(int current) {
		switch (current) {
		case 0:
			main_radio_tab.check(R.id.tab_one_day);
			break;
		case 1:
			main_radio_tab.check(R.id.tab_peotry);
			break;
		case 2:
			main_radio_tab.check(R.id.tab_setting);
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		main_container.removeAllViews();
		switch (arg0.getCheckedRadioButtonId()) {
		case R.id.tab_one_day:
			if (tabOneDay == null) {
				tabOneDay = TabOneDay_.build(this);
			}
			main_container.addView(tabOneDay);
			break;
		case R.id.tab_peotry:
			if (tabPeotry == null) {
				tabPeotry = TabPeotry_.build(this);
			}
			main_container.addView(tabPeotry);
			break;
		case R.id.tab_setting:
			if (tabSetting == null) {
				tabSetting = TabSetting_.build(this);
			}
			main_container.addView(tabSetting);
			break;
		default:
			break;
		}
	}

=======
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
>>>>>>> ad62b74a1712027de111fca6d6beece190a11a54
}
