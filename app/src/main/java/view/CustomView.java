package view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by xu.yu on 16/4/25.
 */
public class CustomView extends LinearLayout {
    private static final String TAG = "Scroller";

    private Scroller mScroller;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public void smoothScrollTo(int fx,int fy){
        int dx = fx- mScroller.getFinalX();
        int dy = fy-mScroller.getFinalY();
        mScroller.startScroll(mScroller.getFinalX(),mScroller.getFinalY(),dx,dy);
        invalidate();

    }
    @Override
    public void computeScroll() {
//        mScroller.computeScrollOffset() ==true 表示还在滑动
        if(mScroller.computeScrollOffset()){
            //这里调用View的scrollTo完成实际的滑动
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            //显示滑动效果
            postInvalidate();

        }
        super.computeScroll();
    }


}
