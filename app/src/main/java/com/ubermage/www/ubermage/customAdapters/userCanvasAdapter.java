package com.ubermage.www.ubermage.customAdapters;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ubermage.www.ubermage.R;
import com.ubermage.www.ubermage.TrainingActivity;

/**
 * Created by Patrik Granec on 31.3.2015.
 */
public class userCanvasAdapter extends BaseAdapter {
    private Context mContext;
    private int mCanvasWidth;
    private int mCanvasHeigth;

    public userCanvasAdapter(Context c) {
        mContext = c;
        WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mCanvasWidth = ((size.x / 2 )) / 5 ;
        mCanvasHeigth = ((size.y / 2) - 8*10) / 6;

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes

            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(mCanvasWidth, mCanvasHeigth ));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }


        imageView.setImageResource(mThumbIds[position]);
        imageView.setId(position);
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
