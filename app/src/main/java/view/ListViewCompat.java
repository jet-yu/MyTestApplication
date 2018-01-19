package view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.mytestapplication.myviewactivity.SlideViewActivity;


/**
 * 
 * @author Administrator
 *
 */
public class ListViewCompat extends ListView {

	/**log标签*/
    private static final String TAG = "ListViewCompat";

    private SlideView mFocusedItemView;

    public ListViewCompat(Context context) {
        super(context);
    }

    public ListViewCompat(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewCompat(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 指定某个位置的item恢复初始状态
     * @param position
     */
    public void shrinkListItem(int position) {
        View item = getChildAt(position);

        if (item != null) {
            try {
                ((SlideView) item).shrink();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
        //按下按钮
        case MotionEvent.ACTION_DOWN: {
        	//接触点在父view中的位置
            int x = (int) event.getX();
            int y = (int) event.getY();
            //根据点击点，找出这个点在父列表的行数
            int position = pointToPosition(x, y);
            Log.e(TAG, "postion=" + position);
            //INVALID_POSITION 无效的行数
            if (position != INVALID_POSITION) {
            	//拿到点击位置当前行的数据
                SlideViewActivity.MessageItem data = (SlideViewActivity.MessageItem) getItemAtPosition(position);
                //当前的自定义view
                mFocusedItemView = data.slideView;
                Log.e(TAG, "FocusedItemView=" + mFocusedItemView);
            }
        }
        default:
            break;
        }
        
        //自定义View不为空的时候，把时间传递给自定义view，让自定义view自己处理
        if (mFocusedItemView != null) {
            mFocusedItemView.onRequireTouchEvent(event);
        }

        return super.onTouchEvent(event);
    }

}
