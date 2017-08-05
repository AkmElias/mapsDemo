package com.example.elias.mapsdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class GridViewOfPhotos extends AppCompatActivity {
    GridView grid;
    // public ImageView iv;
   //ArrayList<Integer> imglist = new ArrayList<>();

    private int[]listimg = { R.drawable.second,
            R.drawable.third,
            R.drawable.fourth,
            R.drawable.rabel1,
            R.drawable.rabel1


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_of_photos);
        CustomGrid adapter = new CustomGrid(GridViewOfPhotos.this,  listimg);
       // imglist = imageReader(Environment.getExternalStorageDirectory());
        grid= (GridView)findViewById(R.id.gridview);

        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(GridViewOfPhotos.this, "You Clicked at " +listimg[ position], Toast.LENGTH_SHORT).show();

            }
        });
      /*  gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(),ViewImage.class).putExtra("img",listimg[position].toString()));
            }
        });*/
    }


}
