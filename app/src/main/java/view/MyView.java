package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import java.text.AttributedCharacterIterator;
import java.util.ConcurrentModificationException;

/**
 * Created by Administrator on 2016/2/25.
 */
public class MyView extends LinearLayout {

    public MyView(Context context){
        super(context);
    }

    public MyView(Context context,AttributeSet attrs){
        super(context,attrs);
        int resourceId = -1;
//        attrs.getAttributeResourceValue()
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyImageView);
        ImageView iv = new ImageView(context);
        TextView tv = new TextView(context);
        int N = typedArray.getIndexCount();
        for(int i=0;i<N;i++){
            int attr = typedArray.getIndex(i);
            switch (attr){
                case R.styleable.MyImageView_Oriental:
                    resourceId = typedArray.getInt(R.styleable.MyImageView_Oriental,0);
                    this.setOrientation(resourceId==1? LinearLayout.HORIZONTAL:LinearLayout.VERTICAL);
                    break;
                case R.styleable.MyImageView_Text:
                    resourceId = typedArray.getResourceId(R.styleable.MyImageView_Text,0);
                    tv.setText(typedArray.getResources().getText(resourceId));
                    break;
                case R.styleable.MyImageView_Src:
                    resourceId = typedArray.getResourceId(R.styleable.MyImageView_Src,0);
                    iv.setImageResource(resourceId>0?resourceId:R.mipmap.ic_launcher);
                    break;
            }
        }
        addView(iv);
        addView(tv);
        typedArray.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
