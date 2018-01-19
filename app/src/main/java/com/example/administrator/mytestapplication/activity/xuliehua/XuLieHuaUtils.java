package com.example.administrator.mytestapplication.activity.xuliehua;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by xu.yu
 *
 * @date 2017/2/17.
 * @update
 * @function
 */
public class XuLieHuaUtils {

    //保存文件的路径
    public static  final  String FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aaa/bbb";
    public static  final  String FILE_NAME = "constants_value.txt";

    //保存数据
    public static void save(People people) {
        ObjectOutputStream fos = null;
        try {

            //如果文件不存在就创建文件
            File file = new File(FILE_PATH);
            file.mkdirs();
//            file.createNewFile();

//            //这里如果文件不存在会创建文件，这是写文件和读文件不同的地方
            fos = new ObjectOutputStream(new FileOutputStream(new File(FILE_PATH,FILE_NAME)));

            //要使用writeObject
            fos.writeObject(people);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
            }

        }

    }


    //读取数据
    public static Object read() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = null;
        Object p =null;
        try {
            Log.e("TAG", new File(FILE_PATH,FILE_NAME).getAbsolutePath() + "<---");
            //获取输入流
            ois = new ObjectInputStream(new FileInputStream(new File(FILE_PATH,FILE_NAME)));
             p  = ois.readObject();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  p;
    }
}
