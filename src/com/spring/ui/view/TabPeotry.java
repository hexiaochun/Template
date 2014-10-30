package com.spring.ui.view;

import java.util.LinkedList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.spring.template.R;
import com.spring.ui.adapter.PeotryAdapter;
import com.spring.ui.domain.PeotryItem;


@EViewGroup(R.layout.tab_peotry)
public class TabPeotry extends LinearLayout {

	@ViewById(R.id.list_view)
	protected ListView listView;
	
	private PeotryAdapter adapter = null;
	
	@AfterViews
	public void init(){
		
		adapter = new PeotryAdapter(getContext());
		listView.setAdapter(adapter);
		
		List<PeotryItem> items = new LinkedList<PeotryItem>();
		
		for (int i = 0; i < 10; i++) {
			items.add(new PeotryItem());
		}
		
		adapter.updateList(items);
		
	}
	
	public TabPeotry(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TabPeotry(Context context) {
		super(context);
	}

	public TabPeotry(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
}
