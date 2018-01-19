package utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author xu.yu
 * @version 1.0.0
 * @create 2015年6月5日
 * @function 拍照工具类
 * @id ASUPAY-115
 */

public class ImagePicker {

    private static Activity mActivity;


    public static final int PICKED_WITH_DATA = 3021;
    public static final int TAKE_PHOTO = 3022;

	//图片名称
	public String TEMP_PHOTO_FILE = "";
	private static ImagePicker picker = null;

	private ImagePicker() {
	}

	public static ImagePicker createInstance(Activity activity) {
		mActivity = activity;
		if (picker == null) {
			picker = new ImagePicker();
		}
		return picker;
	}

	public static ImagePicker createInstance(Activity activity, String FileName) {
		mActivity = activity;
		if (picker == null) {
			picker = new ImagePicker();
			picker.TEMP_PHOTO_FILE = FileName;
		}
		return picker;
	}

	/**
	 * 拍照
	 */
	public void takePhoto() {
		if (isSDCARDMounted()) {
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, null);
			intent.putExtra(MediaStore.EXTRA_OUTPUT, getTempUri());
			mActivity.startActivityForResult(intent, TAKE_PHOTO);
		} else {
			Toast.makeText(mActivity, "SD卡未找到或已损坏", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 从相册抓取，并裁剪
	 * 
	 * @param isCrop
	 */
	public void chooseImageFromGallery(boolean isCrop) {

		if (isSDCARDMounted()) {
			// Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
			// intent.setType("image/*");

			Intent intent = new Intent(Intent.ACTION_PICK, null);
			intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
					"image/*");
			if (isCrop) {
				intent.putExtra("crop", "true");
				intent.putExtra("aspectX", 1);
				intent.putExtra("aspectY", 1);
				intent.putExtra("outputX", 200);
				intent.putExtra("outputY", 200);
			}
			intent.putExtra("scale", true);
			intent.putExtra("return-data", false);
			intent.putExtra(MediaStore.EXTRA_OUTPUT, getTempUri());
			intent.putExtra("outputFormat",
					Bitmap.CompressFormat.JPEG.toString());
			intent.putExtra("noFaceDetection", false);
			mActivity.startActivityForResult(intent, PICKED_WITH_DATA);
		} else {
			Toast.makeText(mActivity, "SD卡未找到或已损坏", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 从相册抓取，返回个一个媒体uri
	 */
	public void chooseImageFromGallery() {

		if (isSDCARDMounted()) {
			Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
			intent.setType("image/*");

			mActivity.startActivityForResult(intent, PICKED_WITH_DATA);
		} else {
			Toast.makeText(mActivity, "SD卡未找到或已损坏", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 裁剪图片
	 */
	public void cropImage() {

		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(getTempUri(), "image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 400);
		intent.putExtra("outputY", 400);
		intent.putExtra("return-data", false);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, getTempUri());
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("noFaceDetection", false);
		mActivity.startActivityForResult(intent, PICKED_WITH_DATA);
	}


	private Uri getTempUri() {
		return Uri.fromFile(getTempFile());
	}

	public File getTempFile() {
		if (isSDCARDMounted()) {
			File f = new File(Environment.getExternalStorageDirectory(),
					TEMP_PHOTO_FILE);
			// logger.d("getTempFile ----> " + f.getAbsolutePath());
			try {
				f.createNewFile();
			} catch (IOException e) {
				// logger.e("getTempFile error --------------------->");
			}
			return f;
		} else {
			return null;
		}
	}

    private boolean isSDCARDMounted() {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED))
            return true;
        return false;
    }

}
