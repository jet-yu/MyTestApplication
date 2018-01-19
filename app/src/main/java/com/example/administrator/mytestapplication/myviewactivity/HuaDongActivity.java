package com.example.administrator.mytestapplication.myviewactivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xu.yu on 16/4/24.
 */
public class HuaDongActivity extends Activity implements View.OnClickListener, View.OnTouchListener {


    float linHeight = -1.0f;
    float linWidth;
    @BindView(R.id.group)
    LinearLayout group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_huadong);
        ButterKnife.bind(this);
        ViewTreeObserver vto = group.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                if (linHeight < 0.0f) {
                    linHeight = group.getMeasuredHeight();
                    linWidth = group.getMeasuredWidth();
                    Log.d("onPreDraw", "linHeight:" + linHeight + " linWidth:" + linWidth);
                }
                return true;
            }
        });


    }

    private int i;
    private boolean isScrolling;

    @Override
    public void onClick(View v) {
//       float f =    linHeight * ((++i) % 3);
//        Log.d("y:", "" + f);
//        group.scrollTo(0, (int) f);
        if (!isScrolling) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    isScrolling = true;
                    float c = 0f;
                    while (c < linHeight * 2) {
                        try {
                            Thread.currentThread().sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        c = (int) c + 10;
                        handler.sendEmptyMessage((int) c);
                    }
                    isScrolling = false;

                }
            }).start();
        }


    }

    protected Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            group.scrollTo(0, msg.what);
            Log.d("getScaleY:", "" + group.getScrollY());

        }
    };


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("onWindowFocusChanged", "---");
        outRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        Log.d("linHeight:", "" + linHeight);
        Log.d("linWidth:", "" + linWidth);
        for (int j = 1; j <= 3; j++) {
            TextView tv = new TextView(this);
            final float scale = getResources().getDisplayMetrics().density;
            int w = (int) (300.0f * scale + 0.5f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, (int) linHeight);
            tv.setLayoutParams(layoutParams);
            String colorString = "0";
            switch (j) {
                case 1:
                    colorString = "#B3AAAA";
                    break;
                case 2:
                    colorString = "#53AAAA";
                    break;
                case 3:
                    colorString = "#f3AAAA";
                    break;
            }
            tv.setBackgroundColor(Color.parseColor(colorString));
            tv.setText(String.valueOf(j));
            tv.setGravity(Gravity.CENTER);
            tv.setOnClickListener(this);
            group.addView(tv);
        }


    }

    Rect outRect;

    @Override
    public boolean onTouch(View v, MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                v.scrollBy(-30, -40);
                int tvGetScrollX = v.getScrollX();
                int tvGetScrollY = v.getScrollY();

                Log.d("tv.getScrollX", "" + tvGetScrollX);
                Log.d("tv.getScrollY", "" + tvGetScrollY);

//                触摸点获取到view左边的距离
                float getX = event.getX();
//                触摸点获取到view顶边的距离
                float getY = event.getY();
//                触摸点在手机屏幕上x的距离
                float getRawX = event.getRawX();
//                触摸点在手机屏幕上y的距离
                float getRawY = event.getRawY();

//                Log.d("getX",""+getX);
//                Log.d("getY",""+getY);
//                Log.d("状态栏高度:",""+outRect.top);
//                Log.d("getRawX",""+getRawX);
//                Log.d("getRawY",""+getRawY);
                break;
        }

        return false;
    }
}



