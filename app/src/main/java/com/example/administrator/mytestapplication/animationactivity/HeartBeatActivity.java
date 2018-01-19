package com.example.administrator.mytestapplication.animationactivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.mytestapplication.R;

/**
 * Created by xu.yu
 *
 * @date 2017/10/23.
 * @update
 * @function
 */

public class HeartBeatActivity extends Activity {
    AnimatorSet set;

    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heartbeat);

        imgView = (ImageView) findViewById(R.id.hhh);
        findViewById(R.id.abcabc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("abc", "123");
            }
        });
        findViewById(R.id.abcabc).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imgView.setImageResource(R.color.bg_black);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    imgView.setImageResource(R.color.aqua);
                }
                return false;
            }
        });

        ImageView iv = (ImageView) findViewById(R.id.iv_liwu);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(iv, "scaleX", 0.7f, 1.3f, 1.0f);
        anim1.setRepeatCount(0);//Animation.INFINITE
        anim1.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(iv, "scaleY", 0.7f, 1.3f, 1.0f);
        anim2.setInterpolator(new AccelerateDecelerateInterpolator());
        anim2.setRepeatCount(0);//Animation.INFINITE
        set = new AnimatorSet();
        set.play(anim1).with(anim2);
        set.setDuration(400);


//        startAnimator();

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                set.start();
            }
        });
    }

    private void startAnimator() {
        ImageView iv = (ImageView) findViewById(R.id.iv_liwu);

//        Animator anim = AnimatorInflater.loadAnimator(this,R.anim.anim_heartbeat);
//        anim.setTarget(iv);
//        anim.start();
    }
}
