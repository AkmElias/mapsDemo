package com.example.elias.mapsdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    TextView tv;
    RatingBar rv;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    private Handler handler;

    int[] mResources = {

            R.drawable.second,
            R.drawable.third,
            R.drawable.fourth,

    };
    private final int delay = 2000;
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this);
        tv = (TextView)findViewById(R.id.facts);
        String facts = "1. This city is one of the most beautiful city in bangladesh\n 2. It has so many places to visit.\n 3. Like madavpur lake , bisanakandi lol";
        tv.setText(facts);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
        rv = (RatingBar)findViewById(R.id.rating);
        rv.setRating(5);
        rv.setRating(Float.parseFloat("4.0"));
        rv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        rv.setFocusable(false);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);

        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radiogroup);

       /* final int delay = 2000;
        Runnable runnable = new Runnable() {
            public void run() {
                if (adapter.getItemCount() == page) {
                    page = 0;
                } else {
                    page++;
                }
                mViewPager.setCurrentItem(page, true);
                handler.postDelayed(this, delay);
            }
        };*/


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                page = position;
                switch (position){                    case 0:

                    radioGroup.check(R.id.radioButton);
                    break;
                    case 1:
                        radioGroup.check(R.id.radioButton2);
                        break;
                    case 2:
                        radioGroup.check(R.id.radioButton3);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            //imageView.setImageResource(mResources[position]);
            Glide
                    .with(mContext)
                    .load(mResources[position])
                    .override(715,548)
                    .into(imageView);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }

    //handling buttons...clickEvent

    public void OnClick(View v){

        if(v.getId()==R.id.ch){

            Intent i = new Intent(MainActivity.this,MapsActivity.class);
            startActivity(i);

        }
        if(v.getId()==R.id.ph){

            Intent i = new Intent(MainActivity.this,GridViewOfPhotos.class);
            startActivity(i);
        }
    }


}
