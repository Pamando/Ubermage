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

import static com.ubermage.www.ubermage.tools.ocr.OCR.g0_1_2_5x5;


public class TrainingActivity extends ActionBarActivity {

    GridView userCanvas;
    Paint paint;
    private GridView mGrid;
    private LinearLayout mCanvas;
    private ImageView mLastImageView;
    private TextView debuggingView;
    private Boolean[] inputImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        debuggingView = (TextView) findViewById(R.id.debuggingViewTraining);
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
                inputImage = new Boolean[25];


                if(action == MotionEvent.ACTION_DOWN){
                    //------
                    debuggingView.setText("");
                    //------
                }

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

                                String placeHolder;
                                placeHolder = debuggingView.getText().toString();
                                placeHolder = placeHolder + " > " + String.valueOf(b.getId());
                                debuggingView.setText(placeHolder);
                                inputImage[b.getId()] = true;
                            }
                        }

                    }
                }

                if(action == MotionEvent.ACTION_UP){
                    debuggingView.setText(g0_1_2_5x5(inputImage));
                }

                return true;
            }



        });
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

