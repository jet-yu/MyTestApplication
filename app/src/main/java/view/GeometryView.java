package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xu.yu
 *
 * @date 16/5/10.
 * @update
 * @function  自定义绘图
 */
public class GeometryView extends View {

    private Paint paint;
    private float z ;

    public GeometryView(Context context) {

        super(context);
        paint = new Paint();

    }

    public GeometryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public GeometryView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        设置背景颜色
        canvas.drawColor(Color.WHITE);

//         绘制一条线
//        canvas.drawColor(Color.BLACK);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5f);
//        view视图坐标系
        canvas.drawLine(0,0,100,0,paint);
        canvas.drawLine(105,0,205,0,paint);
        canvas.drawLine(210,0,310,0,paint);

//        画一个矩形
//        canvas.drawColor(Color.WHITE);
//        paint.setStrokeWidth(10f);
//        paint.setColor(Color.BLUE);
//        canvas.drawRect(100,100,200,200,paint);

//        画圆
//        canvas.drawColor(Color.WHITE);
//        paint.setStrokeWidth(10f);
//        paint.setColor(Color.BLUE);
//        canvas.drawCircle(400,400,400,paint);

//        画椭圆
//        canvas.drawColor(Color.WHITE);
//        paint.setStrokeWidth(10f);
//        paint.setColor(Color.BLUE);
//        paint.setAntiAlias(true);
//        canvas.drawOval(new RectF(0, 100, 800, 700), paint);

//        画轨迹
//        canvas.drawColor(Color.WHITE);
//        paint.setStrokeWidth(10f);
//        paint.setColor(Color.BLUE);
//        paint.setAntiAlias(true);
//        Path path = new Path();
//        path.moveTo(100,100);
//        path.lineTo(700, 100);
//        path.lineTo(700, 700);
//        path.lineTo(100, 700);
//        path.close();
//        canvas.drawPath(path,paint);

    }
}

