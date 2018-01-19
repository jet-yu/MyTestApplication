package view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import utils.DensityUtil;

/**
 * Created by xu.yu
 *
 * @date 16/5/10.
 * @update
 * @function 自定义绘图 一个圈
 */
public class ZiTextView extends TextView {
//    画笔宽度
    public static final int  STROKEWIDTH = 30;

    private Paint paint;
    public int mHeight;
    public int mWidth;
    public Context mContext;

    public ZiTextView(Context context) {

        super(context);

        init(context);
    }

    public ZiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ZiTextView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        mContext = context;
        this.setGravity(Gravity.CENTER);
        this.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        this.setText("" + 60);
        paint = new Paint();
        paint.setAntiAlias(true);

        timer = new Timer();
                timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ((Activity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        time ++;
                        if(time%6==0){
                            i--;
                        }
                        System.out.println("he" + time);

                        invalidate();
                        if (i == 0) {
                            timer.cancel();
                        }



                    }
                });
            }
        }, 0, 166);
}

    Timer timer;
public int time = 0;
    public int i = 60;

    public void setParams(int width, int height) {
        mWidth = DensityUtil.dip2px(mContext, (float) width);
        mHeight = DensityUtil.dip2px(mContext, (float) height);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(mWidth, mHeight);
        lp.setMargins(40, 40, 40, 40);
        this.setLayoutParams(lp);

    }

    int row = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("onDraw");
        String testString = i+"s";
//        设置背景颜色
        canvas.drawColor(Color.BLACK);
//        画线条
//        DrawLine(canvas);
//        画矩形
//        DrawRect(canvas);
//        画圆
//        drawCircle(canvas);
//        画椭圆
//        DrawTuoYuan(canvas);

        drawCircle(canvas);
        drawArc(canvas, testString);
        DrawText(canvas, testString);


    }

    /**
     * 画弧形
     * @param canvas
     * @param testString
     */
    private void drawArc(Canvas canvas, String testString) {

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(new RectF(STROKEWIDTH / 2, STROKEWIDTH / 2, mWidth - STROKEWIDTH / 2,
                mHeight - STROKEWIDTH / 2), 0, ++row% 360, false, paint);


    }

    /**
     * 画文字
     * @param canvas
     * @param testString
     */
    private void DrawText(Canvas canvas, String testString) {

        float widthOfStr = paint.measureText(testString);

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);// canvas.drawText x的位置 取的是文字的中点
        paint.setTextSize(DensityUtil.sp2px(mContext, 13.0f));
        paint.getTextBounds(testString, 0, testString.length(), new Rect());
//      文字的高宽
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
//        mbase 文字baseline的视图坐标
        int mbase = ((int) mHeight - (fontMetricsInt.descent - fontMetricsInt.ascent)) / 2 - fontMetricsInt.ascent;// fontMetricsInt.descent 为正数 fontMetricsInt.ascent为负数

        canvas.drawText(testString, mWidth / 2, mbase, paint);
    }


    /**
     * 画一个矩形
     */
    private void DrawRect(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        paint.setStrokeWidth(10f);
        paint.setColor(Color.BLUE);
        canvas.drawRect(100, 100, 200, 200, paint);
    }

    /**
     * 绘制一条线
     */
    private void DrawLine(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5f);
//        view视图坐标系
        canvas.drawLine(0, 0, 100, 100, paint);
    }

    /**
     * 画圆
     *
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {

        paint.setStrokeWidth(STROKEWIDTH);//笔宽
        paint.setStyle(Paint.Style.STROKE);//STROKE空心  FILL实心
        paint.setColor(Color.WHITE);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mHeight / 2 - STROKEWIDTH / 2, paint);
    }


    /**
     * 画椭圆
     *
     * @param canvas
     */
    private void DrawTuoYuan(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        paint.setStrokeWidth(10f);
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        canvas.drawOval(new RectF(0, 100, 800, 700), paint);
    }

    /**
     * 画轨迹
     *
     * @param p
     * @param canvas
     */
    private void drawPath(Paint p, Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        paint.setStrokeWidth(20f);
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(700, 100);
        path.lineTo(700, 700);
        path.lineTo(100, 700);
        path.close();
        canvas.drawPath(path, paint);
    }

}

