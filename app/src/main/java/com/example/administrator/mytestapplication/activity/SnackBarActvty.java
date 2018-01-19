package com.example.administrator.mytestapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mytestapplication.R;

/**
 * Created by Administrator on 2016/2/1.
 */
public class SnackBarActvty  extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_snackbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ((TextView)findViewById(R.id.tv_1)).setOnClickListener(this);
    }
    Snackbar sBar;
    @Override
    public void onClick(View v) {




         sBar =   Snackbar.make(v, "snackbar_show", Snackbar.LENGTH_LONG);
//        sBar.setAction("12345", null).show();
        sBar.getView().setBackgroundColor(0xffffffff);//设置背景颜色

        sBar.setActionTextColor(0xff000000);//设置action 字体颜色
        sBar.setAction("12345", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackBarActvty.this, "toast", Toast.LENGTH_LONG).show();
//                sBar.dismiss();
            }
        }).show();
    }
}
