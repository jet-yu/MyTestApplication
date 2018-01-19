package com.example.administrator.mytestapplication.securityactivity;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import utils_srcurity.TestMD5Two;

/**
 * Created by xu.yu
 *
 * @date 16/5/30.
 * @update
 * @function
 */
public class CheckFileRightActivity extends Activity {


    @BindView(R.id.tv_show_result)
    TextView tvShowResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkfileright);
        test();
    }

    private void test() {
        StringBuffer buffer = new StringBuffer();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/insert/1.zip");
        if (is != null) {
            buffer.append("is 不为空\n");
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        AssetManager assetManager = this.getAssets();
        try {
            String[] paths = assetManager.list("insert");
            for (String path : paths) {
                buffer.append(path + "\n");
            }

            InputStream iss = assetManager.open("insert/1.zip");
//            获取文件的MD5值进行完整性校验
            buffer.append("Md5:" + TestMD5Two.getFileMD5String(iss) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvShowResult.setText(buffer.toString());

    }
}
