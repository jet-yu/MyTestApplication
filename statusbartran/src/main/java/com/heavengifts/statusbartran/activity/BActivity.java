package com.heavengifts.statusbartran.activity;

import android.app.Activity;
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

public class BActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        SystemBarHelper.immersiveStatusBar(this, 0);
        SystemBarHelper.settingBar(this, R.color.colorAccent);

//        fullScreen(this);
    }


    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param activity
     */
    private void fullScreen(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
//                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);

            } else {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                //导航栏颜色也可以正常设置
//                window.setNavigationBarColor(Color.TRANSPARENT);
            }
        }
    }

}
