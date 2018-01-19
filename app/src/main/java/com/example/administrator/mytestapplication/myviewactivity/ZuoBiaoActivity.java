package com.example.administrator.mytestapplication.myviewactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by xu.yu on 16/4/24.
 */
public class ZuoBiaoActivity extends Activity implements View.OnClickListener, View.OnTouchListener {


    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn_reset)
    Button btnReset;
    @BindView(R.id.btn2)
    Button btn2;
    private int i;//屏幕旋转i的变量值不保存

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_zuobiao);
        ButterKnife.bind(this);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        tv.setOnTouchListener(this);


    }


    @OnClick({R.id.tv, R.id.btn, R.id.btn2, R.id.btn_reset})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
//                int[] locationWindow = new int[2];
//                int[] locationScreen = new int[2];
//                //这两方法除了dialog没有占标题栏的时候是一样大的
//                tv.getLocationInWindow(locationWindow);
//                tv.getLocationOnScreen(locationScreen);
//                Log.d("locationWindow", "x:" + locationWindow[0] + " y:" + locationWindow[1]);
//                Log.d("locationScreen", "x:" + locationScreen[0] + " y:" + locationScreen[1]);

//             view.getScrollX() 或者view.getScrollY  获得内容相对相对于原来偏移了多少，向上滑为正向下为负
                Log.d("mScrollX:", "" + tv.getScrollX());
                Log.d("mScrollY:", "" + tv.getScrollY());
                break;
            case R.id.btn:
                tv.scrollBy(-10, -10);
                break;
            case R.id.btn_reset:
                tv.scrollTo(0, 0);
                break;
            case R.id.btn2:
                //跳转滑动页面例子
                Intent intent = new Intent(this, HuaDongActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        outRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
    }

    Rect outRect;
    private int f;

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
                Log.d("action_DOWN", "----" + v);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("action_MOVE", String.valueOf(f++));
                break;
            case MotionEvent.ACTION_UP:
                Log.d("action_UP", "----");
                break;
        }

        return true;
    }


}
