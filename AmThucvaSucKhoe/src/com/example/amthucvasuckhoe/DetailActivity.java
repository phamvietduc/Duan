package com.example.amthucvasuckhoe;

import java.util.ArrayList;
import java.util.List;

import xml.custom.CustomViewTinTuc;
import xml.parser.Entry;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class DetailActivity extends Activity {
	ListView listViewTinTuc;
	public static List<Entry> listTinTuc = new ArrayList<Entry>();
	CustomViewTinTuc adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		listViewTinTuc = (ListView) findViewById(R.id.listviewTinTuc);
		adapter = new CustomViewTinTuc(this, listTinTuc);
		listViewTinTuc.setAdapter(adapter);
		
		listViewTinTuc.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), WebviewActivity.class);
				startActivity(intent);
				WebviewActivity.URL = listTinTuc.get(position).getLink();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

}
