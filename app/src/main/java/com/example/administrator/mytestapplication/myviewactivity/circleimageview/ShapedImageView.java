package com.example.administrator.mytestapplication.myviewactivity.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.mytestapplication.R;

import java.util.Arrays;


public class ShapedImageView extends PhotoView {

    private static final int SHAPE_MODE_ROUND_RECT = 1;
    private static final int SHAPE_MODE_CIRCLE = 2;

    private int mShapeMode = 0;
    private float mRadius = 0;
    private Shape mShape;
    private Paint mPaint;

    public ShapedImageView(Context context) {
        super(context);
        init(null);
    }

    public ShapedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ShapedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(LAYER_TYPE_HARDWARE, null);
        }
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ShapedImageView);
            mShapeMode = a.getInt(R.styleable.ShapedImageView_shape_mode, 0);
            mRadius = a.getDimension(R.styleable.ShapedImageView_round_radius, 0);
            a.recycle();
        }
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setFilterBitmap(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));//PorterDuff.Mode.DST_IN：取交集，显示下层。
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (changed) {
            switch (mShapeMode) {
                case SHAPE_MODE_ROUND_RECT:
                    break;
                case SHAPE_MODE_CIRCLE:
                    int min = Math.min(getWidth(), getHeight());
                    mRadius = (float) min / 2;
                    break;
            }
            if (mShape == null) {
                float[] radius = new float[8];
                Arrays.fill(radius, mRadius);
                mShape = new RoundRectShape(radius, null, null);
            }
            mShape.resize(getWidth(), getHeight());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.onDraw(canvas);
        switch (mShapeMode) {
            case SHAPE_MODE_ROUND_RECT:
            case SHAPE_MODE_CIRCLE:
                if (mShape != null) {
                    mShape.draw(canvas, mPaint);
        }
                break;
    }
        canvas.restoreToCount(saveCount);
    }


    /**
     * @param drawable
     * @see super.setImageDrawable 关闭超长图的 硬件加速功能 保障超长图的 显示。
     */
    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);

//        if (drawable == null) {
//            return;
//        }
////         关闭超长图的 硬件加速功能 保障超长图的 显示。
        if (getDrawableHeight(drawable) > 8192) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    private static int getDrawableHeight(Drawable d) {
        int height = d.getIntrinsicHeight();
        if (height <= 0) height = d.getMinimumHeight();
        if (height <= 0) height = d.getBounds().height();
//        LogUtils.e("multiple","==imageHeight=="+height);
        return height;
    }

}