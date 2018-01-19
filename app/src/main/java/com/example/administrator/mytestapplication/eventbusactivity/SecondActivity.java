package com.example.administrator.mytestapplication.eventbusactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * Created by xu.yu
 *
 * @date 16/6/27.
 * @update
 * @function
 */
public class SecondActivity extends Activity {

    @BindView(R.id.tv_post)
    TextView tvPost;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    @OnClick(R.id.tv_post)
    public void onClick() {
        EventBus.getDefault().post(new MessageEvent("" + i++));
    }
}
