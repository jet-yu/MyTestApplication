package com.example.administrator.mytestapplication.myviewactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.mytestapplication.R;

import java.util.ArrayList;

import Adapter.BannerAdapter;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import view.ChildViewPager;

/**
 * Created by xu.yu on 16/4/29.
 */
public class GifActivity extends Activity implements ViewPager.OnPageChangeListener {

    /**
     * viewPager  适配器
     */
    private BannerAdapter adapter;

    /**
     * 轮播框View集合
     */
    private ArrayList<View> viewList = new ArrayList<View>();

    private ChildViewPager viewPager;
    public static final int pagerNum = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //        Rect outRect = new Rect();
//        getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
//        System.out.println("outRect.top：" + outRect.top);//状态栏高度
//
//        DisplayMetrics metric = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metric);
//        int width = metric.widthPixels;  // 屏幕宽度（像素）
//        int height = metric.heightPixels;  // 屏幕高度（像素）
//        float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
//        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
//        System.out.println("宽：" + width + "\n  高：" +
//                height + "\n屏幕密度density" + density + "\n 屏幕密度dpi: " + densityDpi);








        setContentView(R.layout.activity_gif);
        viewPager = (ChildViewPager) findViewById(R.id.view_pager);
        viewPager.setOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(pagerNum);

        int id = 0;
        GifImageView gf = null;
        GifDrawable gifDraw = null;

        for (int i = 0; i < 3; i++) {
            gf = new GifImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            gf.setLayoutParams(layoutParams);
            if (i == 0) id = R.drawable.loading_1_736;
            if (i == 1) id = R.drawable.loading_2_736;
            if (i == 2) id = R.drawable.loading_3_736;
            gf.setScaleType(ImageView.ScaleType.FIT_XY);
            gf.setImageResource(id);
            gifDraw = (GifDrawable) gf.getDrawable();
            //设置循环此次数
            gifDraw.setLoopCount(1);
            gifDraw.setSpeed(1.0f);
            viewList.add(gf);
        }
        adapter = new BannerAdapter(viewList);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("onPageScrolled", "position:" + position
                + "positionOffset:" + positionOffset
                + "positionOffsetPixels:" + positionOffsetPixels);

        int index = -1;
        if (position == 0) index = 1;
        if (position == 1) index = 2;
        if (index > 0) {
            GifImageView gfView = (GifImageView) viewList.get(index);
            GifDrawable gifDraw = (GifDrawable) gfView.getDrawable();
            gifDraw.reset();
        }

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("第一次：", "" + position);

        GifImageView gfView = null;
        GifDrawable gifDraw = null;

        for (int i = 0; i < viewList.size(); i++) {
            gfView = (GifImageView) viewList.get(i);
            gifDraw = (GifDrawable) gfView.getDrawable();

            if (position == i) {
                gifDraw.stop();
                gifDraw.start();
            } else {
                gifDraw.reset();
            }

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d("onPage..Changed", "state:" + state);
    }

    @Override
    protected void onDestroy() {
        for (int i = 0; i < viewList.size(); i++) {

            GifImageView gfView = (GifImageView) viewList.get(i);
            GifDrawable gifDraw = (GifDrawable) gfView.getDrawable();
            if (gfView.getDrawable() != null && !gifDraw.isRecycled()) {
                gifDraw.recycle();
            }
        }
        super.onDestroy();
    }
}
