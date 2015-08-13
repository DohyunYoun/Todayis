package kr.ac.todayis.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import kr.ac.todayis.R;

/**
 * Created by Min on 2015-08-13.
 */
public class EmotionAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<EmotionItem> myData;
    private LayoutInflater inflater;

    public EmotionAdapter(Context context, int layout, ArrayList<EmotionItem> data) {
        this.context = context;
        this.layout = layout;
        this.myData = data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return myData.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return myData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final int pos = position;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item, parent, false);
        }
        return convertView;
    }
}

