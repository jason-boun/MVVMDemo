package com.allure.testmvvm.model;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.widget.ImageView;

import com.allure.testmvvm.BR;
import com.bumptech.glide.Glide;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class UserModel implements Observable{


    private String name;
    private String userPhoto;

    private transient  PropertyChangeRegistry propertyChangeRegistry=new PropertyChangeRegistry();


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
        notifyChanged(BR.name);
    }


    private  void notifyChanged(int propertyId){
        if(propertyChangeRegistry==null){
            propertyChangeRegistry=new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this,propertyId);

    }
    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        if(propertyChangeRegistry==null){
            propertyChangeRegistry=new PropertyChangeRegistry();
        }

        propertyChangeRegistry.add(onPropertyChangedCallback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        if(propertyChangeRegistry!=null){
            propertyChangeRegistry.remove(onPropertyChangedCallback);
        }
    }
}
