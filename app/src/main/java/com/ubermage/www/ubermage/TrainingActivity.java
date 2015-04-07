package com.ubermage.www.ubermage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ubermage.www.ubermage.customAdapters.userCanvasAdapter;


public class TrainingActivity extends ActionBarActivity {

    GridView userCanvas;
    Paint paint;
    private GridView mGrid;
    private LinearLayout mCanvas;
    private ImageView mLastImageView;
    private boolean[] inputImage = new boolean[25];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        userCanvas = (GridView) findViewById(R.id.userCanvas);
        LinearLayout canvas = (LinearLayout) findViewById(R.id.userCanvasLinearLayout);
        paint = new Paint();


        userCanvas.findViewById(R.id.userCanvas);
        userCanvas.setAdapter(new userCanvasAdapter(this));

        userCanvas.setOnTouchListener(new View.OnTouchListener() {

            private boolean isInside = false;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int x = (int) event.getX();
                int y = (int) event.getY();
                int action = event.getAction();
                inputImage = new boolean[25];
                for(int i = 0; i<inputImage.length; i++ ){
                    inputImage[i] = false;
                }
                for (int i = 0; i < userCanvas.getChildCount(); i++) {
                    View current = userCanvas.getChildAt(i);
                    if (current instanceof ImageView) {
                        ImageView b = (ImageView) current;

                        if (isPointWithin(x, y, b.getLeft(), b.getRight(), b.getTop(), b.getBottom())) {

                            if (b != mLastImageView) {
                                mLastImageView = b;
                                Toast.makeText(v.getContext(), "ImageView clicked: " + b.getId(),
                                        Toast.LENGTH_SHORT).show();
                                inputImage[b.getId()] = true;
                            }
                        }

                    }
                }

                if(action == MotionEvent.ACTION_UP){
                    Toast.makeText(TrainingActivity.this, "stahp "  ,
                            Toast.LENGTH_SHORT).show();
                }

                return true;
            }



        });
        /*userCanvas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(TrainingActivity.this, "" + position ,
                        Toast.LENGTH_SHORT).show();
            }
        });*/

        /*userCanvas.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    Toast.makeText(TrainingActivity.this, "Ahojk"  ,
                            Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });*/

       /* userCanvas.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                int x = (int) event.getX();
                int y = (int) event.getY();
                switch(action){
                    case MotionEvent.ACTION_DOWN:
                        drawOnProjectedBitMap((GridView) v, bitmapMaster, x, y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        drawOnProjectedBitMap((GridView) v, bitmapMaster, x, y);
                        break;
                    case MotionEvent.ACTION_UP:
                        drawOnProjectedBitMap((GridView) v, bitmapMaster, x, y);
                        break;
                }
                return true;
            }});*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_training, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    static boolean isPointWithin(int x, int y, int x1, int x2, int y1, int y2) {
        return (x <= x2 && x >= x1 && y <= y2 && y >= y1);
    }
}

