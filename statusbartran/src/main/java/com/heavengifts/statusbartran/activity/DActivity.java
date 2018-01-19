package com.heavengifts.statusbartran.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.heavengifts.statusbartran.MyFragmentManager;
import com.heavengifts.statusbartran.R;
import com.heavengifts.statusbartran.SystemBarHelper;
import com.heavengifts.statusbartran.fragment.AFragment;


/**
 * Created by xu.yu
 *
 * @date 2017/11/21.
 * @update
 * @function
 */

public class DActivity extends AppCompatActivity {


    FrameLayout mainFrame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        mainFrame = (FrameLayout) findViewById(R.id.main_frame);

        //沉浸式全屏模式
        SystemBarHelper.immersiveStatusBar(this, 0);
        // 加padding 模拟状态栏的高度 不要在Activity的顶级布局加padding 不然小键盘会将activity的顶级布局的padding给顶掉
        //Me模块 其他页面只需要动态设置这个padding就可以实现沉浸式了 gaoyj
//        SystemBarHelper.setPadding(this, mainFrame);

        SystemBarHelper.settingBar(this, R.color.transparent);

        MyFragmentManager.getInstance().setActivity(this);
        MyFragmentManager.getInstance().setIsDisplayAnimation(false);
        Fragment fragment = new AFragment();
        MyFragmentManager.getInstance().addFragment(fragment);
    }

    public Fragment getFragmentByName(String fragName) {

        Fragment fragment = null;
        try {
            fragment = (Fragment) Class.forName(fragName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fragment;
    }

    public void clearPadding() {
        SystemBarHelper.clearPadding(this, mainFrame);
    }

    public void setPadding() {
        SystemBarHelper.setPadding(this, mainFrame);
    }


}
