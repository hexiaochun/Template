package com.spring.ui.adapter;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.spring.template.R;
import com.spring.ui.ListActivity_;
import com.spring.ui.domain.PeotryItem;

public class PeotryAdapter extends BaseAdapter {

	private Context context ;
	
	private List<PeotryItem> items = new LinkedList<PeotryItem>();
	
	public PeotryAdapter(Context context) {
		this.context = context;
	}
	
	public void updateList(List<PeotryItem> items){
		this.items.clear();
		if(items!=null){
			this.items.addAll(items);
		}
		notifyDataSetChanged();
		
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int arg0) {
		return items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.peotry_item, null);
		}
		convertView.findViewById(R.id.peotry_item_rl_layout).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(context, ListActivity_.class);
				context.startActivity(intent);
			}
		});
		
		return convertView;
	}

}
