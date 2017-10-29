package com.allure.testmvvm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.allure.testmvvm.BR;
import com.bumptech.glide.Glide;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class UserModel2 extends BaseObservable {

    private String name;
    private String userPhoto;


    @BindingAdapter({"showUserPhoto"})//这是一个自定义的方法展示图片
    public static void showPhoto(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }


}
