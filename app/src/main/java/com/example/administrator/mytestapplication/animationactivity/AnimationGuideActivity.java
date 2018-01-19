package com.example.administrator.mytestapplication.animationactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mytestapplication.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xu.yu
 *
 * @date 2016/10/19.
 * @update
 * @function
 */
public class AnimationGuideActivity extends Activity {

    @BindView(R.id.item1)
    Button item1;
    @BindView(R.id.btn_item2)
    Button btnItem2;
    @BindView(R.id.item3)
    Button item3;
    @BindView(R.id.item4)
    Button item4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_guide);
    }

    @OnClick({R.id.item1, R.id.btn_item2, R.id.item3, R.id.item4})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.item1:
                intent = new Intent(this, FrameActivity.class);
                break;
            case R.id.btn_item2:
//                intent = new Intent(this,ToCodeActivity.class);
                intent = new Intent(this, ToXMLActivity.class);
                break;
            case R.id.item3:
                break;
            case R.id.item4:
                intent = new Intent(this, HeartBeatActivity.class);
                break;
        }
        startActivity(intent);
    }
}
