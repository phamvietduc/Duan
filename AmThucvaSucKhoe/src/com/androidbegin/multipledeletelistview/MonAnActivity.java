package com.androidbegin.multipledeletelistview;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

import com.example.amthucvasuckhoe.R;

import android.widget.AbsListView.MultiChoiceModeListener;

public class MonAnActivity extends Activity {

	// Declare Variables
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
		// Get the view from listview_main.xml
		setContentView(R.layout.listview_main);

		// Generate sample data into string arrays
		rank = new String[] { " Thịt Nướng", " Gà Luộc", " Gỏi", " Rau Trộn" };

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
