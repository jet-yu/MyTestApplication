package com.heavengifts.statusbartran.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.heavengifts.statusbartran.R;
import com.heavengifts.statusbartran.SystemBarHelper;

/**
 * Created by xu.yu
 *
 * @date 2017/11/21.
 * @update
 * @function
 */

public class AActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        SystemBarHelper.immersiveStatusBar(this, 0);
        findViewById(R.id.button_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, BActivity.class);
                AActivity.this.startActivity(intent);
            }
        });
        SystemBarHelper.settingBar(this,R.color.colorPrimary);
    }

    private void a() {
        //设置 paddingTop
        ViewGroup rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        rootView.setPadding(0, getStatusBarHeight(), 0, 0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0 以上直接设置状态栏颜色
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        } else {
            //根布局添加占位状态栏
            ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
            View statusBarView = new View(this);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight());
            statusBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            decorView.addView(statusBarView, lp);
        }
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


    private void ab() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentStatus | flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }


}
