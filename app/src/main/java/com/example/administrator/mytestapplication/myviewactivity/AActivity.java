package com.example.administrator.mytestapplication.myviewactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import view.RevealFollowButton;


/**
 * Created by xu.yu on 16/4/24.
 * 模仿知乎按钮
 */
public class AActivity extends Activity implements View.OnClickListener {


    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.test_rfb)
    RevealFollowButton testRfb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_view_a);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                break;
        }
    }
}
