package com.spring.ui.view;

import org.androidannotations.annotations.EViewGroup;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.spring.template.R;


@EViewGroup(R.layout.tab_setting)
public class TabSetting extends LinearLayout {

	public TabSetting(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TabSetting(Context context) {
		super(context);
	}

	public TabSetting(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
}
