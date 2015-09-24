package com.example.chatapp;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
	ListView lv;
	Button b;
	EditText et;
	boolean position = false;
    chatadapter adapter;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.chat_list_view);
        b = (Button) findViewById(R.id.sendbutton);
        et = (EditText) findViewById(R.id.chat_text);
        adapter = new chatadapter(ctx, R.layout.single_layout);
        lv.setAdapter(adapter);
        lv.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        adapter.registerDataSetObserver(new DataSetObserver() {
     	   @Override
     	public void onChanged() {
     		// TODO Auto-generated method stub
     		super.onChanged();
     		lv.setSelection(adapter.getCount()-1);
     	}
     });
        b.setOnClickListener(new OnClickListener() {
     	@Override
     	public void onClick(View arg0) {
     		// TODO Auto-generated method stub
     		adapter.add(new dataprovider(position, et.getText().toString()));
     		position = !position;
     		et.setText("");
     	}
        });
    }
}
