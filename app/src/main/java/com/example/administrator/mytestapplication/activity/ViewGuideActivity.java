package com.example.administrator.mytestapplication.activity;

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
 * @date 16/7/7.
 * @update
 * @function
 */
public class ViewGuideActivity extends Activity {

    @BindView(R.id.btn_go_recycleview)
    Button btnGoRecycleview;
    @BindView(R.id.btn_go_cardview)
    Button btnGoCardview;
    @BindView(R.id.btn_go_snackbar)
    Button btnGoSnackbar;
    @BindView(R.id.btn_go_spinner)
    Button btnGoSpinner;
    @BindView(R.id.btn_go_property)
    Button btnGoProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewguide);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_go_recycleview, R.id.btn_go_cardview, R.id.btn_go_snackbar, R.id.btn_go_spinner, R.id.btn_go_property})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_go_recycleview:
                intent = new Intent(this, RecyclerViewActivity.class);
                break;
            case R.id.btn_go_cardview:
                intent = new Intent(this, CardViewActvity.class);
                break;
            case R.id.btn_go_snackbar:
                intent = new Intent(this, SnackBarActvty.class);
                break;
            case R.id.btn_go_spinner:
                intent = new Intent(this, SpinnerActivity.class);
                break;
            case R.id.btn_go_property:
                intent = new Intent(this, PropertyAnimationActivity.class);
                break;
        }
        startActivity(intent);
    }
}
