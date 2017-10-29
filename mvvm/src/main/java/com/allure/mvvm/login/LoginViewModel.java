package com.allure.mvvm.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

/**
 * 作者：luomin on 16/12/27 10:55
 * 邮箱：asddavid@163.com
 */

public class LoginViewModel {

    private Context mContext;
    private ProgressDialog progressDialog;
    private UserLoginModel userLoginModel;

    public LoginViewModel(Context context, UserLoginModel userLoginModel) {
       this.mContext=context;
        this.userLoginModel = userLoginModel;
        progressDialog=new ProgressDialog(mContext);
        progressDialog.setMessage("登陆中,请稍后...");
        progressDialog.setCancelable(false);
    }


    /**
     * 登陆方法
     */
    public void login() {
        if(TextUtils.isEmpty(userLoginModel.getUserName())||TextUtils.isEmpty(userLoginModel.getPassWord())){
            Toast.makeText(mContext,"请输入用户名和密码",Toast.LENGTH_SHORT).show();
        }else{
            progressDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if ("jike".equals(userLoginModel.getUserName().toString().trim()) && "123".equals(userLoginModel.getPassWord().toString().trim())) {
                        Toast.makeText(mContext,"登陆成功",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
//                        userLoginModel.setUserName("极客");
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(mContext,"登陆失败",Toast.LENGTH_SHORT).show();
                    }

                }
            }, 3000);
        }

    }

    public void clear(){
        userLoginModel.setUserName("");
        userLoginModel.setPassWord("");
//        userLoginModel.setUserPhoto("http://www.zhuobufan.com/UserFiles/Attachment/16/12_05/e8b31de4-4f51-43b7-833c-e9a37cd174e9.jpg");

    }

    //用户名变化监听
    public TextWatcher userNameWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            Log.d("userName",editable.toString());
            userLoginModel.setUserName(editable.toString());
        }
    };
    //密码变化监听
    public TextWatcher passWordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            Log.d("passWord",editable.toString());
            userLoginModel.setPassWord(editable.toString());
        }
    };


}
