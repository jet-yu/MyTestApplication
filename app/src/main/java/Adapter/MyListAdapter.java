package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

import Mode.PersonBean;

/**
 * Created by Administrator on 2016/2/27.
 */
public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private PersonBean[] datas;
    private LayoutInflater inflater;

    public MyListAdapter(Context context, PersonBean[] datas) {
        mContext = context;
        this.datas = datas;
        inflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            Log.d("MyListAdapter:","position:"+position+"convertView==null");
            convertView = inflater.inflate(R.layout.list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.addressTv =(TextView) convertView.findViewById(R.id.person_address);
            viewHolder.ageTv = (TextView)convertView.findViewById(R.id.person_age);
            viewHolder.emailTv = (TextView) convertView.findViewById(R.id.person_email);
            viewHolder.nameTv = (TextView)convertView.findViewById(R.id.person_name);
            viewHolder.myEd = (EditText)convertView.findViewById(R.id.ed_tv);
            convertView.setTag(viewHolder);
        }else{
            Log.d("MyListAdapter:","position:"+position+"convertView!=null");
            viewHolder = (ViewHolder)convertView.getTag();
        }
        PersonBean bean = datas[position];
        viewHolder.addressTv.setText(bean.getAddress());
        viewHolder.ageTv.setText(""+bean.getAge());
        viewHolder.emailTv.setText(bean.getEmail());
        viewHolder.nameTv.setText(bean.getName());
        viewHolder.myEd.setText("1");

        viewHolder.myEd.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Log.d("touchedPo:pos", "touchedPosition" + touchedPosition
                            + "  position" + position);
                    touchedPosition = position;
                }
                return false;
            }
        });

        if (touchedPosition == position) {
            // 如果当前的行下标和点击事件中保存的index一致，手动为EditText设置焦点。
            Log.d("touchedPo=pos","touchedPosition" +touchedPosition
                    +"  position"+position);
            viewHolder.myEd.requestFocus();
            viewHolder.myEd.setSelection( viewHolder.myEd.getText().toString().trim().length());

        }else {
            Log.d("touchedPo!=pos","touchedPosition" +touchedPosition +"  position"+position);
            viewHolder.myEd.findViewById(R.id.ed_tv).clearFocus();
        }

        return convertView;
    }

int touchedPosition =-1;
    private static class ViewHolder{
        public TextView addressTv;
        public TextView ageTv;
        public TextView emailTv;
        public TextView nameTv;
        public EditText myEd;

    }
}
