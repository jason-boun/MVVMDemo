package com.allure.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allure.mvvm.databinding.ActivityLoginBinding;
import com.allure.mvvm.login.UserLoginModel;
import com.allure.mvvm.login.LoginViewModel;

public class MVVMLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login);

        UserLoginModel userLoginModel=new UserLoginModel();
        userLoginModel.setUserName("");
        userLoginModel.setPassWord("");
//        userLoginModel.setUserPhoto("http://i.dimg.cc/6f/65/e5/0a/35/f4/97/64/4f/93/d1/0d/7a/f5/f9/10.jpg");
        activityLoginBinding.setUserLoginModel(userLoginModel);

        LoginViewModel loginViewModel=new LoginViewModel(this,userLoginModel);
        activityLoginBinding.setLoginViewModel(loginViewModel);


    }

}
