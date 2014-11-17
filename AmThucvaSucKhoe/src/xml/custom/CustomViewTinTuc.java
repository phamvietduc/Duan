package xml.custom;

import java.util.List;

import com.example.amthucvasuckhoe.R;


import xml.parser.Entry;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomViewTinTuc extends BaseAdapter{
	
	List<Entry> arrayTinTuc;
 
    public Activity context;
    public LayoutInflater inflater;
 
    public CustomViewTinTuc(Activity context,List<Entry> arrayTinTuc) {
        super();
 
        this.context = context;
        this.arrayTinTuc = arrayTinTuc;
        
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayTinTuc.size();
    }
 
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return arrayTinTuc.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
 
    public static class ViewHolder
    {
        ImageView imgLogoTaxi;
        TextView txtNameTaxi;
        TextView txtPhoneTaxi;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
 
        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.viewtaxi, null);
 
            holder.imgLogoTaxi = (ImageView) convertView.findViewById(R.id.imgLogoTaxi);
            holder.txtNameTaxi = (TextView) convertView.findViewById(R.id.txtNameTaxi);
            holder.txtPhoneTaxi = (TextView) convertView.findViewById(R.id.txtPhoneTaxi);
 
            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
 
        Entry _entry = (Entry) arrayTinTuc.get(position);        
//	        holder.imgLogoTaxi.setImageResource(_entry.getLogoTaxi());
	        holder.txtNameTaxi.setText(_entry.getTitle());
	        holder.txtPhoneTaxi.setText(_entry.getDescription());
	 
	        return convertView;
    }
 
}
