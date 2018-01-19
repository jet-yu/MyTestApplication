package com.example.administrator.mytestapplication.eventbusactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by xu.yu
 *
 * @date 16/6/27.
 * @update
 * @function
 */
public class FirstActivity extends Activity {


    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_go_secend)
    TextView tvGoSecend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tv_register, R.id.tv_go_secend})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
                EventBus.getDefault().register(this);
                break;
            case R.id.tv_go_secend:
                Intent intent = new Intent();
                intent.setClass(this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 无论事件在哪个线程发布，该事件处理函数都会在新建的子线程中执行，
     * 同样，此事件处理函数中禁止进行UI更新操作
     *
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.Async)
    public void reAsync(MessageEvent messageEvent) {
        System.out.println("reAsync:" + messageEvent.getMessage());

    }

    /**
     * POSTING（默认）：如果使用事件处理函数指定了线程模型为POSTING，那么该事件在哪个线程发布出来的，
     * 事件处理函数就会在这个线程中运行，也就是说发布事件和接收事件在同一个线程。
     * 在线程模型为POSTING的事件处理函数中尽量避免执行耗时操作，因为它会阻塞事件的传递，甚至有可能会引起ANR。
     *
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.PostThread)
    public void rePost(MessageEvent messageEvent) {
        System.out.println("rePost:" + messageEvent.getMessage());

    }

    /**
     * 事件的处理会在UI线程中执行。事件处理时间不能太长，长了会ANR的
     *
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void reMain(MessageEvent messageEvent) {
        System.out.println("reMain:" + messageEvent.getMessage());

    }

    /**
     * 如果事件是在UI线程中发布出来的，那么该事件处理函数就会在新的线程中运行，
     * 如果事件本来就是子线程中发布出来的，那么该事件处理函数直接在发布事件的线程中执行
     *
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void reBackGround(MessageEvent messageEvent) {
        System.out.println("reBackGround:" + messageEvent.getMessage());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
