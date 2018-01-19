package com.heavengifts.statusbartran.activity;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.heavengifts.statusbartran.R;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View statusBar = findViewById(R.id.statusBarView);
        ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            layoutParams.height = getStatusBarHeight();
        } else {
            layoutParams.height = 0;
        }
        imageView = (ImageView) findViewById(R.id.main_imageView);
        editText = findViewById(R.id.abc);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                a();
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        Log.e("onTextChanged:", "onTextChanged");

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b();
            }
        });
//        addStatusViewWithColor(this, ContextCompat.getColor(this, R.color.colorPrimaryDark));
    }

    private void a() {
        //相对于自己的高度往下平移

        TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,

                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1f, Animation.RELATIVE_TO_SELF, 0.0f);
        translate.setDuration(500);//动画时间500毫秒
        translate.setFillAfter(true);//动画出来控件可以点击
        translate.setInterpolator(new AccelerateInterpolator());
        imageView.startAnimation(translate);//开始动画
        imageView.setVisibility(View.VISIBLE);//设置可见
    }

    private void b() {
        //相对于自己的高度往上平移

        TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF,

                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f);
        translate.setDuration(500);
        translate.setFillAfter(false);//设置动画结束后控件不可点击
        translate.setInterpolator(new AccelerateInterpolator());
        imageView.startAnimation(translate);
        imageView.setVisibility(View.GONE);//隐藏不占位置

    }


    /**
     * 添加状态栏占位视图
     *
     * @param activity
     */
    private void addStatusViewWithColor(Activity activity, int color) {
        ViewGroup contentView = activity.findViewById(android.R.id.content);
        View statusBarView = new View(activity);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight());
        statusBarView.setBackgroundColor(color);
        contentView.addView(statusBarView, lp);
    }

    /**
     * 利用反射获取状态栏高度
     *
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


}
