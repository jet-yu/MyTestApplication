package com.example.administrator.mytestapplication.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import extendsorimpl.DividerGridItemDecoration;

/**
 * @author xu.yu
 * @function
 * @date 2016/2/2
 * @update
 */

/*mRecyclerView = findView(R.id.id_recyclerview);
//设置布局管理器
        mRecyclerView.setLayoutManager(layout);
//设置adapter
        mRecyclerView.setAdapter(adapter)
//设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(
        getActivity(), DividerItemDecoration.HORIZONTAL_LIST));*/
public class RecyclerViewActivity extends ActionBarActivity {
    private RecyclerView recyclerView;
    private List<String> mDatas;
    private  HomeAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        ButterKnife.bind(this);
        setContentView(R.layout.activity_recyclerview);
        recyclerView =  (RecyclerView)findViewById(R.id.recyview);
        /*RecyclerView.LayoutManager这是一个抽象类，提供了3个实现类.LinearLayoutManager是其中之一
        LinearLayoutManager 现行管理器，支持横向、纵向。
        GridLayoutManager 网格布局管理器
        StaggeredGridLayoutManager 瀑布就式布局管理器*/

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));//支持横向List,调用重载方法
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,OrientationHelper.HORIZONTAL,true));//横向list
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

//        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
//        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        //四列往下排 从左往右
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        //四行 从上往下
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        recyclerView.setAdapter(mAdapter = new HomeAdapter());

    }

    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(RecyclerViewActivity.this)
                    .inflate(R.layout.item_home, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));
        }


        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;
            public MyViewHolder(View view)
            {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }

        }
    }



}
