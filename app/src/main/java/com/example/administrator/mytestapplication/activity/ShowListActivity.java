package com.example.administrator.mytestapplication.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mytestapplication.R;

import java.util.List;

import Adapter.MyListAdapter;
import Mode.PersonBean;

/**
 * Created by Administrator on 2016/2/27.
 * 展示ListView
 */
public class ShowListActivity extends Activity implements AdapterView.OnItemClickListener ,View.OnClickListener

{
    private ListView mList;
    private PersonBean[] listPersons = new PersonBean[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlinearlayout);
        Button btn = (Button) findViewById(R.id.testBug);
        btn.setOnClickListener((View.OnClickListener) this);
        mList = (ListView) findViewById(R.id.list_show);
        PersonBean bean = null;
        for (int i = 0; i < listPersons.length; i++) {
            bean = new PersonBean("上海" + i, i, "www@163" + i, "喻旭" + i);
            listPersons[i] = bean;
        }
        mList.setAdapter(new MyListAdapter(this, listPersons));
        mList.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, listPersons[position].toString(), Toast.LENGTH_LONG).show();

    }



    @Override
    public void onClick(View v) {
        System.out.println("fdghjk");
    }
}
