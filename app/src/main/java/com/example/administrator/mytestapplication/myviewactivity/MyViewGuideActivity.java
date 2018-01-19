package com.example.administrator.mytestapplication.myviewactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
public class MyViewGuideActivity extends Activity {

    @BindView(R.id.btn_item1)
    Button btnItem1;
    @BindView(R.id.btn_item2)
    Button btnItem2;
    @BindView(R.id.btn_item3)
    Button btnItem3;
    @BindView(R.id.btn_item4)
    Button btnItem4;
    @BindView(R.id.btn_item5)
    Button btnItem5;
    @BindView(R.id.btn_item6)
    Button btnItem6;
    @BindView(R.id.btn_item7)
    Button btnItem7;
    @BindView(R.id.btn_item8)
    Button btnItem8;
    @BindView(R.id.btn_item9)
    Button btnItem9;
    @BindView(R.id.btn_item10)
    Button btnItem10;
    @BindView(R.id.btn_item11)
    Button btnItem11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myviewguide);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_item1, R.id.btn_item2, R.id.btn_item3, R.id.btn_item4,
            R.id.btn_item5, R.id.btn_item6, R.id.btn_item7, R.id.btn_item8, R.id.btn_item9,
            R.id.btn_item10, R.id.btn_item11, R.id.btn_item12})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_item1:
                intent = new Intent(this, View1Activity.class);
                break;
            case R.id.btn_item2:
                intent = new Intent(this, ViewActivity.class);
                break;
            case R.id.btn_item3:
                intent = new Intent(this, ViewPagerActivity.class);
                break;
            case R.id.btn_item4:
                intent = new Intent(this, SlideViewActivity.class);
                break;
            case R.id.btn_item5:
                intent = new Intent(this, ScrollActivity.class);
                break;
            case R.id.btn_item6:
                intent = new Intent(this, MultiScreenActivity.class);
                break;
            case R.id.btn_item7:
                intent = new Intent(this, ScrollActivity2.class);
                break;
            case R.id.btn_item8:
                intent = new Intent(this, GifActivity.class);
                break;
            case R.id.btn_item9:
                intent = new Intent(this, DragGridActivity.class);
                break;
            case R.id.btn_item10:
                intent = new Intent(this, ZuoBiaoActivity.class);
                break;
            case R.id.btn_item11:
                intent = new Intent(this, AActivity.class);
                break;
            case R.id.btn_item12:
                intent = new Intent(this, CircleActivity.class);
                break;
        }
        startActivity(intent);


    }
}
