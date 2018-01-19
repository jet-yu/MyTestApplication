package com.example.administrator.mytestapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.administrator.mytestapplication.R;

import java.util.List;

/**
 * Created by xu.yu
 *
 * @date 2017/2/16.
 * @update
 * @function
 */
public class SNSActivity extends Activity {

    public final static int REQUEST_CODE_SHARE = 100;
    public static Uri SHARE_IMAGE_URI = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sns);
        findViewById(R.id.intent_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(SNSActivity.this, null, "天气好");
            }
        });

    }

    /**
     * share
     *
     * @param context
     * @param url
     * @param str
     */
    public  void share(final Context context, String url, String str) {

        try {
//            List<Bitmap> bitmapList = MemoryCacheUtils.findCachedBitmapsForImageUri(url, ImageLoader.getInstance().getMemoryCache());
//            if (bitmapList.size() > 0) {
//                Bitmap bitmap = bitmapList.get(0);
//                String uriStr = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, null, null);
//                SHARE_IMAGE_URI = Uri.parse(uriStr);
//            }

//            SHARE_IMAGE_URI = Uri.parse(uriStr);
            shareIntent(context, str);

        } catch (NullPointerException ex) {
            shareIntent(context, str);
        }

    }

    private  void shareIntent(Context context, String content) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, content);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, SHARE_IMAGE_URI);
        startActivityForResult(intent, REQUEST_CODE_SHARE);
    }
}
