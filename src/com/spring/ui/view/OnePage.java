package com.spring.ui.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.spring.template.R;

@EViewGroup(R.layout.one_page)
public class OnePage extends LinearLayout {

	@ViewById(R.id.page_image_big)
	protected ImageView pageImageView;
	
	@ViewById(R.id.page_day_time)
	protected TextView pageTime;
	
	@ViewById(R.id.page_peotry)
	protected TextView pagePeotry;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd",Locale.CHINA);
	
	@AfterViews
	public void init(){
		pageTime.setText(dateFormat.format(new Date(System.currentTimeMillis())));
	}
	
	public OnePage(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public OnePage(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public OnePage(Context context) {
		super(context);
	}

}
