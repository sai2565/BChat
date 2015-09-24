package com.example.chatapp;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class chatadapter extends ArrayAdapter<dataprovider>{
	private List<dataprovider> chat_list = new ArrayList<dataprovider>();
	  private TextView chat_text;
	  Context CTX;
		public chatadapter(Context context, int resource) {
			super(context, resource);
			CTX = context;
			// TODO Auto-generated constructor stub
		}
	@Override
	public void add(dataprovider object){
		chat_list.add(object);
		
		super.add(object);
	}
	@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return chat_list.size();
		}
	@Override
		public dataprovider getItem(int position) {
			// TODO Auto-generated method stub
			return chat_list.get(position);
		}
	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
		if(convertView == null){
			LayoutInflater lif = (LayoutInflater) CTX.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
			convertView = lif.inflate(R.layout.single_layout,parent,false );
		}
		chat_text = (TextView) convertView.findViewById(R.id.chatbox);
		String messsage;
		boolean POSITION;
		dataprovider provider = getItem(position) ;
		messsage = provider.message;
		POSITION = provider.position;
		chat_text.setText(messsage);
		chat_text.setBackgroundResource(R.drawable.f);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		if(!POSITION){
			params.gravity = Gravity.RIGHT;
		}
		else
		{
			params.gravity = Gravity.LEFT;
		}
		chat_text.setLayoutParams(params);
		return convertView;
		}
}
