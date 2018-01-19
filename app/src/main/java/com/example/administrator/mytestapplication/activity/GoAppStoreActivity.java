package com.example.administrator.mytestapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
public class GoAppStoreActivity extends Activity {


    @BindView(R.id.go_google)
    Button goGoogle;
    @BindView(R.id.go_appstore)
    Button goAppstore;
    @BindView(R.id.go_store_search)
    Button goStoreSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_appstore);
        ButterKnife.bind(this);
    }


    /**
     * 申请分享，已经安装了目标软件才有选择
     */
    @OnClick({R.id.go_google, R.id.go_appstore, R.id.go_store_search})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.go_google:
                String appPackageName = "com.heavengifts.hg"; // getPackageName() from Context or Activity object
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                break;
            case R.id.go_appstore:
//                跳转微信
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.tencent.mm")));
                //        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
                break;
            case R.id.go_store_search:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=abc")));
                break;
        }
    }
}
