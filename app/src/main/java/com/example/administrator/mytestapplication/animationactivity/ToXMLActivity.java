package com.example.administrator.mytestapplication.animationactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.mytestapplication.R;

/**
 * @function 补间动画 XML文件实现
 */
public class ToXMLActivity extends Activity {
    private Button btn_Alpha, btn_Rotate, btn_Scale, btn_Translate,
            btn_setAnim,btn_reset;
    private ImageView iv_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        btn_Alpha = (Button) findViewById(R.id.btn_Alpha);
        btn_Rotate = (Button) findViewById(R.id.btn_Rotate);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_Scale = (Button) findViewById(R.id.btn_Scale);
        btn_Translate = (Button) findViewById(R.id.btn_Translate);
        btn_setAnim = (Button) findViewById(R.id.btn_setAnim);
        iv_anim = (ImageView) findViewById(R.id.iv_anim);

        btn_Alpha.setOnClickListener(click);
        btn_Rotate.setOnClickListener(click);
        btn_reset.setOnClickListener(click);
        btn_Scale.setOnClickListener(click);
        btn_Translate.setOnClickListener(click);
        btn_setAnim.setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_Alpha:
                    toAlpha();
                    break;
                case R.id.btn_Rotate:
                    toRotate();
                    break;
                case R.id.btn_reset:
                    toreset();
                    break;
                case R.id.btn_Scale:
                    toScale();
                    break;
                case R.id.btn_Translate:
                    toTranslate();
                    break;
                case R.id.btn_setAnim:
                    toSetAnim();
                    break;
                default:
                    break;
            }
        }
    };

    int i = 0;

    /**
     * 透明度变化
     */
    protected void toAlpha() {
        Animation anim = AnimationUtils.loadAnimation(ToXMLActivity.this, R.anim.anim_alpha);
        iv_anim.startAnimation(anim);
    }



    /**
     * 组合动画
     */
    protected void toSetAnim() {

        Animation anim = (RotateAnimation) AnimationUtils.loadAnimation(ToXMLActivity.this, R.anim.anim_set);


        iv_anim.startAnimation(anim);


    }

    RotateAnimation  anim;
    /**
     * 旋转变化
     */
    protected void toRotate() {

        anim = (RotateAnimation) AnimationUtils.loadAnimation(ToXMLActivity.this, R.anim.anim_rotate);

        iv_anim.startAnimation(anim);


    }
    protected void  toreset(){
        iv_anim.clearAnimation();
//        anim.setRepeatCount(1);
//        iv_anim.startAnimation(anim);
    }

        /**
         * 比例缩放变化
         */

    protected void toScale() {
        Animation anim = AnimationUtils.loadAnimation(ToXMLActivity.this, R.anim.anim_scale);
        iv_anim.startAnimation(anim);
    }

    /**
     * 移动变化
     */
    protected void toTranslate() {
        Animation anim = AnimationUtils.loadAnimation(ToXMLActivity.this, R.anim.anim_translate);
        iv_anim.startAnimation(anim);
    }

}
