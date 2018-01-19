package com.example.administrator.mytestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mytestapplication.activity.CardViewActvity;
import com.example.administrator.mytestapplication.activity.GoAppStoreActivity;
import com.example.administrator.mytestapplication.activity.RSAActivity;
import com.example.administrator.mytestapplication.activity.RecyclerViewActivity;
import com.example.administrator.mytestapplication.activity.SNSActivity;
import com.example.administrator.mytestapplication.activity.SnackBarActvty;
import com.example.administrator.mytestapplication.activity.SpinnerActivity;
import com.example.administrator.mytestapplication.activity.TranspaStatusBarActivity;
import com.example.administrator.mytestapplication.activity.ViewGuideActivity;
import com.example.administrator.mytestapplication.activity.xuliehua.XuLieActivity;
import com.example.administrator.mytestapplication.animationactivity.AnimationGuideActivity;
import com.example.administrator.mytestapplication.eventbusactivity.EventBusGuideActivity;
import com.example.administrator.mytestapplication.myviewactivity.MyViewGuideActivity;
import com.example.administrator.mytestapplication.other.OtherActivity;
import com.example.administrator.mytestapplication.securityactivity.CheckFileRightActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_go_viewguide)
    Button btnGoViewguide;
    @BindView(R.id.btn_go_myviewguide)
    Button btnGoMyviewguide;
    @BindView(R.id.btn_check_fileright)
    Button btnCheckFileright;
    @BindView(R.id.btn_go_ras)
    Button btnGoRas;
    @BindView(R.id.btn_go_transpanrenttitle)
    Button btnGoTranspanrenttitle;
    @BindView(R.id.btn_go_appstore)
    Button btnGoAppstore;
    @BindView(R.id.btn_go_eventbus)
    Button btnGoEventbus;
    @BindView(R.id.btn_go_animation)
    Button btnGoAnimation;
    @BindView(R.id.btn_sns)
    Button btnSns;
    @BindView(R.id.btn_xuliehua)
    Button btnXuliehua;
    @BindView(R.id.btn_other)
    Button btnOther;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @OnClick({R.id.toolbar, R.id.btn_go_viewguide, R.id.btn_go_myviewguide, R.id.btn_check_fileright, R.id.btn_go_ras, R.id.btn_go_transpanrenttitle, R.id.btn_go_appstore, R.id.btn_go_eventbus, R.id.btn_go_animation, R.id.btn_sns, R.id.btn_xuliehua, R.id.btn_other, R.id.fab})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_go_viewguide:
                intent = new Intent(this, ViewGuideActivity.class);
                break;
            case R.id.btn_go_myviewguide:
                intent = new Intent(this, MyViewGuideActivity.class);
                break;
            case R.id.btn_check_fileright:
                intent = new Intent(this, CheckFileRightActivity.class);
                break;
            case R.id.btn_go_recycleview:
                intent = new Intent(this, RecyclerViewActivity.class);
                break;
            case R.id.btn_go_cardview:
                intent = new Intent(this, CardViewActvity.class);
                break;
            case R.id.btn_go_snackbar:
                intent = new Intent(this, SnackBarActvty.class);
                break;
            case R.id.btn_go_ras:
                intent = new Intent(this, RSAActivity.class);
                break;
            case R.id.btn_go_appstore:
                intent = new Intent(this, GoAppStoreActivity.class);
                break;
            case R.id.btn_go_transpanrenttitle:
                intent = new Intent(this, TranspaStatusBarActivity.class);
                break;
            case R.id.btn_go_eventbus:
                intent = new Intent(this, EventBusGuideActivity.class);
                break;

            case R.id.btn_go_spinner:
                intent = new Intent(this, SpinnerActivity.class);
                break;

            case R.id.btn_go_animation:
                intent = new Intent(this, AnimationGuideActivity.class);
                break;

            case R.id.btn_sns:
                intent = new Intent(this, SNSActivity.class);
                break;
            case R.id.btn_xuliehua:
                intent = new Intent(this, XuLieActivity.class);
                break;
            case R.id.btn_other:
                intent = new Intent(this, OtherActivity.class);
                break;

        }
        startActivity(intent);
    }
}
