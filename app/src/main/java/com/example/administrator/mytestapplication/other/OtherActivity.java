package com.example.administrator.mytestapplication.other;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.mytestapplication.R;

import java.io.File;

import butterknife.ButterKnife;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        createSDCardDir();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void createSDCardDir() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

            File sd = Environment.getExternalStorageDirectory();
            String path = sd.getPath() + "/vape";
            File file = new File(path);
            Log.e("q", file.getPath());
            if (!file.exists()) {
                file.mkdir();
                Log.e("r", file.getPath());
            }
            Log.e("r", "" + file.exists());
        }
    }


}
