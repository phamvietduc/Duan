package com.example.amthucvasuckhoe;

import java.util.ArrayList;
import java.util.List;

import com.androidbegin.multipledeletelistview.ListViewAdapter;
import com.androidbegin.multipledeletelistview.WorldPopulation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MeoVat extends Activity {
	ListView list;
	ListViewAdapter listviewadapter;
	List<WorldPopulation> worldpopulationlist = new ArrayList<WorldPopulation>();
	String[] rank;
	String[] country;
	String[] population;
	int[] flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meo_vat);
		rank = new String[] { " mẹo làm nhanh", " chien ", " xào", " Rau Trộn" };

		country = new String[] { " Gia Lai", " Quảng Nam", " Nghệ an",
				" Hà Tĩnh"," Sài Gòn"};

		population = new String[] { "1h30 phut", "1h30 phut",
				"1h30 phut", "1h30 phut", "1h30 phut" };

		flag = new int[] { R.drawable.m, R.drawable.h,
				R.drawable.b, R.drawable.m,
				R.drawable.n };

		for (int i = 0; i < rank.length; i++) {
			WorldPopulation worldpopulation = new WorldPopulation(flag[i],
					rank[i], country[i], population[i]);
			worldpopulationlist.add(worldpopulation);
		}

		// Locate the ListView in listview_main.xml
		list = (ListView) findViewById(R.id.listview);

		// Pass results to ListViewAdapter Class
		listviewadapter = new ListViewAdapter(this, R.layout.listview_item,
				worldpopulationlist);

		// Binds the Adapter to the ListView
		list.setAdapter(listviewadapter);
		list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		// Capture ListView item click
		

	}
}
