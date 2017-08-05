package com.example.elias.mapsdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by Elias on 02-08-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {
            "FirstCity","Jaflong","Madavkundo"
    };
    private String[] ratings = {

            "rating  4.5*","rating  5*","rating  3.5*"
    };
    private int images[] = {

            R.drawable.second,
            R.drawable.third,
            R.drawable.fourth,
    };
    Context mcontext;
    public RecyclerAdapter(Context c){

        mcontext = c;
    }
    private ViewHolder holder;
    private int position;

    class ViewHolder extends RecyclerView.ViewHolder{


        public int itemnum;
        public ImageView img;
        public TextView title;
        public TextView rating;
        public ViewHolder(View itemView){
            super(itemView);

            img = (ImageView)itemView.findViewById(R.id.image);
            title = (TextView)itemView.findViewById(R.id.title);
            rating= (TextView)itemView.findViewById(R.id.ratings);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    Toast.makeText(mcontext,"Clicked detected on Item", LENGTH_LONG).show();

                }
            });


        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(titles[position]);
        holder.rating.setText(ratings[position]);
        holder.img.setImageResource(images[position]);
    }



    @Override
    public int getItemCount() {
        return titles.length;
    }
}
