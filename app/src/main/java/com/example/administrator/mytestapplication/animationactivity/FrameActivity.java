package com.example.administrator.mytestapplication.animationactivity;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.mytestapplication.R;

/**
 * Created by xu.yu
 *
 * @date 2016/10/18.
 * @update
 * @function
 */
public class FrameActivity  extends Activity  implements View.OnClickListener {

    Button startBtn;
    Button stopBtn;
    ImageView imgContent;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frameanimation);
        startBtn = (Button) findViewById(R.id.btn_start);
        stopBtn = (Button) findViewById(R.id.btn_stop);
        imgContent = (ImageView) findViewById(R.id.img_content);
//        方式1：XMl文件
//         animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.animationframe);

//        方式2：手动添加
        animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img0),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img1),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img2),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img3),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img4),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img5),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img6),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img7),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img8),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img9),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img10),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img11),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img12),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img13),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img14),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img15),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img16),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img17),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img18),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img19),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img20),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img21),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img22),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img23),50);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img24),50);
//        设置是否循环
        animationDrawable.setOneShot(true);

        imgContent.setBackgroundDrawable(animationDrawable);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                start();
                break;
            case R.id.btn_stop:
                stop();
                break;
        }

    }

    public void start(){
        if(animationDrawable!=null&&!animationDrawable.isRunning()){
            animationDrawable.start();
            Toast.makeText(this,"开始播放",Toast.LENGTH_LONG).show();
            Log.i("mian","index 为5的真持续时间:"+animationDrawable.getDuration(5)+"毫秒");
        }


    }
    public void stop(){
        if (animationDrawable != null && animationDrawable.isRunning()) {
            animationDrawable.stop();
                        Toast.makeText(this, "停止播放", Toast.LENGTH_SHORT).show();
                    }
    }
}
