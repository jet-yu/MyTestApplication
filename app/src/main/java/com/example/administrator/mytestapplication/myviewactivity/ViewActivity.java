package com.example.administrator.mytestapplication.myviewactivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.mytestapplication.R;

import butterknife.BindView;
import view.ZiTextView;

/**
 * Created by xu.yu
 *
 * @date 16/5/10.
 * @update
 * @function
 */
public class ViewActivity extends Activity {


    @BindView(R.id.tv_circle)
    ZiTextView tvCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tvCircle.setParams(100, 100);
    }
}
