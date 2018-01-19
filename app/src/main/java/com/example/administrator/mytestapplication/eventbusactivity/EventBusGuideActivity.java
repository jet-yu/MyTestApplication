package com.example.administrator.mytestapplication.eventbusactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xu.yu
 *
 * @date 16/7/6.
 * @update
 * @function
 */
public class EventBusGuideActivity extends Activity {


    @BindView(R.id.tv_firstactivity)
    TextView tvFirstactivity;
    @BindView(R.id.tv_sticky_activity)
    TextView tvStickyActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbusguide);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_firstactivity, R.id.tv_sticky_activity})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {

            case R.id.tv_firstactivity:
                intent.setClass(this, FirstActivity.class);

                break;
            case R.id.tv_sticky_activity:
                intent.setClass(this, StickyActivity.class);
                break;
        }
        startActivity(intent);
    }

}
