package com.example.amthucvasuckhoe;


import xml.parser.ListEntry;
import xml.parser.ParseXml;

import com.androidbegin.multipledeletelistview.MonAnActivity;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AmThucViet extends Activity {
	ImageView image1, image2, image3;
	public static ListEntry listRssItem;
	private String url1 = "http://monngon3mien.thongtin24h.net/mon-an-mien-bac/feed/";
	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_am_thuc_viet);
		// create the TabHost that will contain the Tabs
		image1 = (ImageView) findViewById(R.id.image1);
		image2 = (ImageView) findViewById(R.id.image2);
		image3 = (ImageView) findViewById(R.id.image3);
		image1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				Intent intent = new Intent(AmThucViet.this, DetailActivity.class);
				startActivity(intent);
				
				try {
					listRssItem = new ListEntry();
					ParseXml parse = new ParseXml(url1);
					listRssItem = parse.parseXMLHotel();
					DetailActivity.listTinTuc = listRssItem.getListEntry();
					Log.d("//=================", "Tong so phan tu RSS"+ listRssItem.getListEntry().size());
				} catch (Exception e) {
					listRssItem = null;
					Log.i("Error", "Here");
				}
			}
		});
		image2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(AmThucViet.this, Trung.class);
				startActivity(intent);
			}
		});
		image3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(AmThucViet.this, Nam.class);
				startActivity(intent);
			}
		});
	}
}