package com.allure.testmvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allure.testmvvm.databinding.ActivityMainBinding;
import com.allure.testmvvm.model.UserModel2;
import com.allure.testmvvm.model.UserModel3;
import com.allure.testmvvm.model.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        UserModel2 userModel=new UserModel2();
        userModel.setName("Allure");
        userModel.setUserPhoto("http://photocdn.sohu.com/20140707/Img401905939.jpg");
        mainBinding.setUsermodel(userModel);


        //ObservabelFiled
        UserModel3 userModel3=new UserModel3();
        userModel3.desc.set("我是刚开始的描述");
        mainBinding.setUsermodel3(userModel3);

        UserViewModel userViewModel=new UserViewModel(this,userModel);
        userViewModel.setUserModel3(userModel3);
        mainBinding.setUserviewmodel(userViewModel);
    }
}
