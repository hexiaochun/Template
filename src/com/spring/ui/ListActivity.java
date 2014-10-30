package com.spring.ui;

import java.util.Random;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.webkit.WebView;

import com.spring.template.R;

@EActivity(R.layout.listview)
public class ListActivity extends BaseActivity {

	@ViewById(R.id.webview)
	protected WebView webView;

	@AfterViews
	public void init() {
		setBack();

		webView.getSettings().setJavaScriptEnabled(true);
		int i = 	new Random().nextInt(100);
		if (i % 2 == 0) {
			webView.loadUrl("http://mp.weixin.qq.com/s?__biz=MjM5OTI5NjQ4MQ==&mid=201333309&idx=1&sn=0e1b90476c00a706aab3fcfc06b8d5c9&3rd=MzA3MDU4NTYzMw==&scene=6#rd");
		} else {
			webView.loadUrl("http://mp.weixin.qq.com/s?__biz=MzAwMTA0NTkyMQ==&mid=201586844&idx=1&sn=e1fa18028249e9a35e4b9e777075258b&3rd=MzA3MDU4NTYzMw==&scene=6#rd");
		}

	}

}
