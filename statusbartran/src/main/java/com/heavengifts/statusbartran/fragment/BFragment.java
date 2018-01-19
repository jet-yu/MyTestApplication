package com.heavengifts.statusbartran.fragment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.heavengifts.statusbartran.R;
import com.heavengifts.statusbartran.SystemBarHelper;

/**
 * Created by xu.yu
 *
 * @date 2017/11/21.
 * @update
 * @function
 */

public class BFragment extends Fragment implements View.OnClickListener {


    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        view.findViewById(R.id.btn_f_b).setOnClickListener(this);
        imageView = view.findViewById(R.id.im_b);

        SystemBarHelper.settingBar(getActivity(), R.color.transparent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            View statusBarView = new View(getActivity());
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight());
            statusBarView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
            statusBarView.setLayoutParams(lp);
            statusBarView.setId(R.id.top_status_view);

            if (view instanceof RelativeLayout) {

                View rootView = ((ViewGroup) view).getChildAt(0);
                RelativeLayout.LayoutParams ll = (RelativeLayout.LayoutParams) rootView.getLayoutParams();
                ((ViewGroup) view).addView(statusBarView, 0);
                ll.addRule(RelativeLayout.BELOW, R.id.top_status_view);

            } else if (view instanceof LinearLayout) {

                ((ViewGroup) view).addView(statusBarView, 0);

            } else if (view instanceof FrameLayout) {

                View rootView = ((ViewGroup) view).getChildAt(0);
                FrameLayout.LayoutParams ll = (FrameLayout.LayoutParams) rootView.getLayoutParams();
                ((ViewGroup) view).addView(statusBarView, 0);
                ll.topMargin += getStatusBarHeight();
            }
        }
        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_f_b) {

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

//    /**
//     * 添加状态栏占位视图
//     *
//     * @param activity
//     */
//    private void addStatusViewWithColor(Activity activity, int color) {
//        ViewGroup contentView = findViewById(R.id.content);
//        View statusBarView = new View(activity);
//        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight());
//        statusBarView.setBackgroundColor(color);
//        contentView.addView(statusBarView, lp);
//    }
}
