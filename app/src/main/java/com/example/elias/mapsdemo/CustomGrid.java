package com.example.elias.mapsdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Elias on 03-08-2017.
 */

public class CustomGrid extends BaseAdapter {

    private Context mContext;

    private final int[] Imageid;

    public CustomGrid(Context c, int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;

    }



    @Override
    public int getCount() {
        return Imageid.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);

            ImageView imageView = (ImageView)grid.findViewById(R.id.gridImage);

            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;

    }
}
