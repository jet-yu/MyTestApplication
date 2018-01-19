package com.example.administrator.mytestapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mytestapplication.R;

import java.security.PrivateKey;
import java.security.PublicKey;

import butterknife.ButterKnife;
import utils_srcurity.RSAUtils;

/**
 * Created by Administrator on 2016/2/29.
 */
public class RSAActivity extends Activity implements View.OnClickListener {

    private EditText orgContent;
    private TextView jiamiTv;
    private TextView jiemiTv;

    private static String PUCLIC_KEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCt1j617gu026LVbUl63LPEbYYj" +"\r"
            +"v4J6sDtpEMVJ9TYhrxcbVd9+lzy52+Qt71SEzFPCCqjW4gaaM9FEYg4+5+CfTXQk" +"\r"
            +"ya/2YJ4XOuYLqMu3sv0Vg53O114QzVvlyAumhzRbxmh+t0RfzxHDs4bR0ZerfwYt" +"\r"
            +"lOKKBY2eJnOvsrTB0QIDAQAB"+"\r";

    private static String PRIVATE_KEY ="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK3WPrXuC7TbotVt"+"\r"
    +"SXrcs8RthiO/gnqwO2kQxUn1NiGvFxtV336XPLnb5C3vVITMU8IKqNbiBpoz0URi"+"\r"
    +"Dj7n4J9NdCTJr/Zgnhc65guoy7ey/RWDnc7XXhDNW+XIC6aHNFvGaH63RF/PEcOz"+"\r"
    +"htHRl6t/Bi2U4ooFjZ4mc6+ytMHRAgMBAAECgYBxdp2H8dACRDmMRMDpSJStaS9c"+"\r"
    +"tetcWRruANxE4aBra/URCoPOBLjGNxhAQy5PX25sALkjSHQ2wgudLsNNm9uoCq47"+"\r"
    +"Uj5qkVRGGM5f6CCwTZLl3Sr04bRLqbwsQ33MAnV6gC8vn/tZZAkibokpXEHsCEDH"+"\r"
    +"7IoFL9OnCza1kcTGgQJBAOL7AhViGs9I7624zHvgwBqU8vdszIkD/Aj84PWy72Cd"+"\r"
    +"h0q+SyqqUV/5roCcz74ZGCVIDfA48qHvB9Tpsp2q/vUCQQDED92EzKfo2/r+w0o+"+"\r"
    +"fDlv4idVwAGbnmr1QUBJjHlKrgVU+EpYA8LjIjGwF33/gow0LZS4Iwu4TzaeWQFj"+"\r"
    +"ZjXtAkEAknI5CereOVdprMBKzrJXv87SZGlCHjT/7BycWGo2oDODEupsPP7eufmy"+"\r"
    +"aTDDqHcwaP1wYMmdYnWCrBCMOcYV8QJAPI2t3AMdZOT0K1UDjDLvxmdxwKExne+a"+"\r"
    +"ly7U/SI+n9sJWInq5C4dNetsrzdCOfUG+mKNiSWBzCXi95sDu8BorQJBANzXXzhO"+"\r"
    +"UidHL/M0x+ulM0DTKVXvwG4FkBMjhEuSMwTIzBRejaLikNJ3ZHl0aZj3I7XGoxGF"+"\r"
    +"FbZmFu3x7IpjSlA="+"\r";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsa);
        ButterKnife.bind(this);
        orgContent =  (EditText)findViewById(R.id.ed_content);

        jiamiTv =  (TextView)findViewById(R.id.tv_jiami);
        jiemiTv =  (TextView)findViewById(R.id.tv_jiemi);

        jiamiTv.setOnClickListener(this);
        jiemiTv.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()){

                case R.id.tv_jiami:
                   String str =  Enctry(orgContent.getEditableText().toString().trim());
                    jiamiTv.setText(str);
                    break;
                case R.id.tv_jiemi:
                    String str1 = DecodeEnctry(jiamiTv.getText().toString().trim());
                    jiemiTv.setText(str1);
                    break;
            }

        }catch(Exception e){

        }

    }

    /**
     * 加密
     */
    private String Enctry(String orgContent) throws Exception {
        Log.d("想要加密的字符串",orgContent);
        // 从字符串中得到公钥
         PublicKey publicKey = RSAUtils.loadPublicKey(PUCLIC_KEY);
        // 从文件中得到公钥
//        InputStream inPublic = getResources().getAssets().open("rsa_public_key.pem");
//        InputStream inPublic = this.getClass().getClassLoader().getResourceAsStream("assets/rsa_public_key.pem");
//        PublicKey publicKey = RSAUtils.loadPublicKey(inPublic);
        // 加密
        byte[] encryptByte = RSAUtils.encryptData(orgContent.getBytes(), publicKey);
        // 为了方便观察吧加密后的数据用base64加密转一下，要不然看起来是乱码,所以解密是也是要用Base64先转换
        String afterencrypt = new String(Base64.encode(encryptByte, Base64.DEFAULT));
        Log.d("密码加密",afterencrypt);
        return afterencrypt;

    }

    /**
     * 解密
     */
    private String DecodeEnctry(String alenStr) throws Exception {
        Log.d("想要解密的字符串",alenStr);
        // 从字符串中得到私钥
        PrivateKey privateKey =null;
        try {
            privateKey = RSAUtils.loadPrivateKey(PRIVATE_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 从文件中得到私钥
//        InputStream inPrivate = getResources().getAssets().open("pkcs8_rsa_private_key.pem");
//        InputStream inPrivate = this.getClass().getClassLoader().getResourceAsStream("assets/pkcs8_rsa_private_key.pem");
//        PrivateKey privateKey = RSAUtils.loadPrivateKey(inPrivate);
        // 因为RSA加密后的内容经Base64再加密转换了一下，所以先Base64解密回来再给RSA解密

      byte[] decryptByte = RSAUtils.decryptData( Base64.decode(alenStr.getBytes(), Base64.DEFAULT), privateKey);
        String decryptStr = new String(decryptByte);
        Log.d("密码解密",decryptStr);
        return decryptStr;
    }
}
