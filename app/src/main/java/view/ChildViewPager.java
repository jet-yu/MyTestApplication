package view;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Adapter.BannerAdapter;

/**
 * viwepager嵌套使用时，子pager
 *
 * @author jack.yang
 *
 */
public class ChildViewPager extends ViewPager {

	/** 触摸时按下的点 **/

	PointF downP = new PointF();

	/** 触摸时当前的点 **/

	PointF curP = new PointF();

	OnSingleTouchListener onSingleTouchListener;

	boolean isPlay = false;

	private int currentPage = 0;
	private ScheduledExecutorService scheduledExecutorService;
	private boolean isMove;

	public ChildViewPager(Context context, AttributeSet attrs) {

		super(context, attrs);
	}

	public ChildViewPager(Context context) {

		super(context);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {


		// 当拦截触摸事件到达此位置的时候，返回true，

		// 说明将onTouch拦截在此控件，进而执行此控件的onTouchEvent

		return true;

	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {

		// 每次进行onTouch事件都记录当前的按下的坐标

		curP.x = arg0.getX();

		curP.y = arg0.getY();

		if (arg0.getAction() == MotionEvent.ACTION_DOWN) {
			// 记录按下时候的坐标

			// 切记不可用 downP = curP ，这样在改变curP的时候，downP也会改变

			downP.x = arg0.getX();

			downP.y = arg0.getY();

			// 此句代码是为了通知他的父ViewPager现在进行的是本控件的操作，不要对我的操作进行干扰

			getParent().requestDisallowInterceptTouchEvent(true);

		}

		if (arg0.getAction() == MotionEvent.ACTION_MOVE) {

			isMove = true;

			// 此句代码是为了通知他的父ViewPager现在进行的是本控件的操作，不要对我的操作进行干扰

			getParent().requestDisallowInterceptTouchEvent(true);

		}

		if (arg0.getAction() == MotionEvent.ACTION_UP) {

			isMove = false;
			// 在up时判断是否按下和松手的坐标为一个点

			// 如果是一个点，将执行点击事件，这是我自己写的点击事件，而不是onclick

			if (downP.x == curP.x && downP.y == curP.y) {
				onSingleTouch();
				return true;

			}

			if (rangeInDefined(curP.x, downP.x - dev, downP.x +dev)&&rangeInDefined(curP.y, downP.y - dev, downP.y +dev)) {
				onSingleTouch();
				return true;
			}

		}

		return super.onTouchEvent(arg0);

	}

	public static float dev = 20;

	public static boolean rangeInDefined(Float current, Float min, Float max) {
		return Math.max(min, current) == Math.min(current, max);
	}

	/**
	 *
	 * 单击
	 */

	public void onSingleTouch() {

		if (onSingleTouchListener != null) {
			onSingleTouchListener.onSingleTouch(((BannerAdapter) getAdapter()).getPosition(getCurrentItem()));
		}

	}

	/**
	 * 创建点击事件接口
	 */

	public interface OnSingleTouchListener {

		public void onSingleTouch(int position);

	}

	public void setOnSingleTouchListener(
			OnSingleTouchListener onSingleTouchListener) {

		this.onSingleTouchListener = onSingleTouchListener;

	}



	public void start() {
		if (getAdapter().getCount() > 0) {
			scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
			scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 3, 3, TimeUnit.SECONDS);
			setIsPlay(true);
		}
	}

	public void stop() {
		if (getAdapter().getCount() > 0 && scheduledExecutorService != null){
			scheduledExecutorService.shutdown();
			setIsPlay(false);
		}
	}

	private class ScrollTask implements Runnable {

		public void run() {
			if (isMove)
				return;
			synchronized (this) {
				currentPage = getCurrentItem();
				if (currentPage == getAdapter().getCount() - 1)
					currentPage = 0;
				else
					currentPage++;
				handler.sendEmptyMessage(7);
			}
		}
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			setCurrentItem(currentPage);
		};
	};

	public boolean isPlay() {
		return isPlay;
	}

	public void setIsPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}
}
