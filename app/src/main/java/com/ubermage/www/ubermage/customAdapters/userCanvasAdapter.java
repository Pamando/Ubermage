package com.ubermage.www.ubermage.customAdapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.ubermage.www.ubermage.R;

/**
 * Created by Patrik Granec on 31.3.2015.
 */
public class userCanvasAdapter extends BaseAdapter {
    private Context mContext;

    public userCanvasAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.test01 , R.drawable.test02 , R.drawable.test03 , R.drawable.test04 , R.drawable.test05,
            R.drawable.test06 , R.drawable.test07 , R.drawable.test08 , R.drawable.test09 , R.drawable.test10,
            R.drawable.test11 , R.drawable.test12 , R.drawable.test13 , R.drawable.test14 , R.drawable.test15,
            R.drawable.test16 , R.drawable.test17 , R.drawable.test18 , R.drawable.test19 , R.drawable.test20,
            R.drawable.test21 , R.drawable.test22 , R.drawable.test23 , R.drawable.test24 , R.drawable.test25

    };
}
