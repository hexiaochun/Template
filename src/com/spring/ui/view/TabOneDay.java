package com.spring.ui.view;

import java.util.LinkedList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.spring.template.R;
import com.spring.ui.adapter.OneViewPageAdapter;

@EViewGroup(R.layout.tab_oneday)
public class TabOneDay extends LinearLayout {

	@ViewById(R.id.viewpager)
	protected ViewPager viewPager;
	
	private OneViewPageAdapter adapter;
	
	public TabOneDay(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TabOneDay(Context context) {
		super(context);
	}

	public TabOneDay(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	private int pageSize = 10;
	
	@AfterViews
	public void init(){
		
		List<OnePage> mListViews  = new LinkedList<OnePage>();
		for (int i = 0; i < pageSize; i++) {
			mListViews.add(OnePage_.build(getContext()));
		}
		adapter = new OneViewPageAdapter(mListViews);
		viewPager.setAdapter(adapter);
	}
	
}
