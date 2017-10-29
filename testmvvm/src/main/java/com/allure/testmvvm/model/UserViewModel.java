package com.allure.testmvvm.model;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class UserViewModel {


    private Context mContext;
    private UserModel2 userModel;
    private UserModel3 userModel3;



    public UserViewModel(Context mContext, UserModel2 userModel) {
        this.userModel = userModel;
        this.mContext = mContext;
    }

    public UserModel3 getUserModel3() {
        return userModel3;
    }

    public void setUserModel3(UserModel3 userModel3) {
        this.userModel3 = userModel3;
    }



    /**
     * 展示名字
     */
    public void showName() {
        Toast.makeText(mContext, userModel.getName(), Toast.LENGTH_SHORT).show();
    }

    public void update() {
        userModel.setName("我是实现Observable更新的数据");
    }

    public void update2() {
        userModel.setName("我是继承BaseObservable更新的数据");
    }

    public void update3() {
        userModel3.desc.set("我是ObservabelFields更新的描述");
    }


}
