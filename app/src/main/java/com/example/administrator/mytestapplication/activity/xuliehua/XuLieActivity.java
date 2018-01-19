package com.example.administrator.mytestapplication.activity.xuliehua;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import java.io.IOException;

import butterknife.BindView;

/**
 * Created by xu.yu
 *
 * @date 2017/2/16.
 * @update
 * @function 序列化
 */
public class XuLieActivity extends Activity {


    @BindView(R.id.main_et_name)
    EditText mainEtName;
    @BindView(R.id.main_et_password)
    EditText mainEtPassword;
    @BindView(R.id.main_et_age)
    EditText mainEtAge;
    @BindView(R.id.main_tv)
    TextView mainTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuliehua);
    }

    //保存数据
    public void save(View view) {
        People people = new People(mainEtName.getText().toString(), mainEtPassword.getText().toString(), Integer.parseInt(mainEtAge.getText().toString()));
        XuLieHuaUtils.save(people);

    }

    //读取数据
    public void read(View view) {
        try {
            People people = (People) XuLieHuaUtils.read();


            //把数据显示在TextView中
            mainTv.setText(people.toString() + "年龄：" + people.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
