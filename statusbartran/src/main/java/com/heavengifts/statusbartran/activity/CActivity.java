package com.heavengifts.statusbartran.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.heavengifts.statusbartran.R;
import com.heavengifts.statusbartran.SystemBarHelper;

/**
 * Created by xu.yu
 *
 * @date 2017/11/21.
 * @update
 * @function
 */

public class CActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        SystemBarHelper.immersiveStatusBar(this, 0);
    }
}
