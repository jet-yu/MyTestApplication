package view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;


/**
 *
 */
public class SlideView extends LinearLayout {

    private static final String TAG = "SlideView";

    private Context mContext;
    private LinearLayout mViewContent;
    private RelativeLayout mHolder;
    private Scroller mScroller;
    /** 接口*/
    private OnSlideListener mOnSlideListener;
    private int mHolderWidth = 120;

    private int mLastX = 0;
    private int mLastY = 0;
    private static final int TAN = 2;

    public interface OnSlideListener {
        public static final int SLIDE_STATUS_OFF = 0;
        public static final int SLIDE_STATUS_START_SCROLL = 1;
        public static final int SLIDE_STATUS_ON = 2;

        /**
         * @param view current SlideView
         * @param status SLIDE_STATUS_ON or SLIDE_STATUS_OFF
         */
        public void onSlide(View view, int status);
    }

    public SlideView(Context context) {
        super(context);
        initView();
    }

    public SlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mContext = getContext();
        mScroller = new Scroller(mContext);

        setOrientation(LinearLayout.HORIZONTAL);
        View.inflate(mContext, R.layout.slide_view_merge, this);
        mViewContent = (LinearLayout) findViewById(R.id.view_content);
//        dp转px
        mHolderWidth = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                mHolderWidth, getResources().getDisplayMetrics()));

        int size = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                20, getResources().getDisplayMetrics());

    }



    public void setButtonText(CharSequence text) {
        ((TextView)findViewById(R.id.delete)).setText(text);
    }

    public void setContentView(View view) {
        mViewContent.addView(view);
    }

    public void setOnSlideListener(OnSlideListener onSlideListener) {
        mOnSlideListener = onSlideListener;
    }


    /**
     * view .scroolTo(p)
     *  恢复初始状态
     */
    public void shrink() {
        if (getScrollX() != 0) {
            this.smoothScrollTo(0, 0);
        }
    }

    public void onRequireTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int scrollX = getScrollX();
        Log.d(TAG, "x=" + x + "  y=" + y);

        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN: {

        	//上次滑动还没有结束
            if (!mScroller.isFinished()) {
            	//立即结束动画直接到最后的位置
                mScroller.abortAnimation();
            }
            if (mOnSlideListener != null) {
                mOnSlideListener.onSlide(this,  OnSlideListener.SLIDE_STATUS_START_SCROLL);
            }
            break;
        }
        case MotionEvent.ACTION_MOVE: {
//            滑动过程中的控制
            int deltaX = x - mLastX;
            int deltaY = y - mLastY;
            if (Math.abs(deltaX) < Math.abs(deltaY) * TAN) {
                break;
            }

            int newScrollX = scrollX - deltaX;//getScrollX- event.getX()+mLastX
            //判断当前有没有移动
            if (deltaX != 0) {//当前移动过
                if (newScrollX < 0) {
                    newScrollX = 0;
                } else if (newScrollX > mHolderWidth) {//大于固定长度的，设置成固定长度予以移动
                    newScrollX = mHolderWidth;
                }
                this.scrollTo(newScrollX, 0);
            }
            break;
        }
        case MotionEvent.ACTION_UP: {
//            滑动结果的展示
            int newScrollX = 0;
            if (scrollX >mHolderWidth * 0.75) {
                newScrollX = mHolderWidth;
            }
            this.smoothScrollTo(newScrollX, 0);
            if (mOnSlideListener != null) {
                mOnSlideListener.onSlide(this, newScrollX == 0 ? OnSlideListener.SLIDE_STATUS_OFF
                                : OnSlideListener.SLIDE_STATUS_ON);
            }
            break;
        }
        default:
            break;
        }

        mLastX = x;
        mLastY = y;
        Log.d(TAG, "mLastX=" + mLastX + "  mLastY=" + mLastY);
    }
    /**
     *  缓慢滚动到指定位置
     * @param destX
     * @param destY
     */
    private void smoothScrollTo(int destX, int destY) {
        //获取自定义view 以view为原点（0） 屏幕左边的位移
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        //delta 负值向右滑动
        mScroller.startScroll(scrollX,0,delta, 0, Math.abs(delta) * 3);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

}
