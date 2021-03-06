package com.allure.mvvm.login;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.text.TextUtils;
import android.widget.ImageView;

import com.allure.mvvm.BR;
import com.bumptech.glide.Glide;

/**
 * 单纯的数据
 * 作者：luomin on 16/12/27 11:44
 * 邮箱：asddavid@163.com
 */

public class UserLoginModel implements Observable {
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    public String userName;
    public String passWord;
    public String userPhoto;

    @BindingAdapter({"showImage"})//表示自定一个展示照片属性
    public static void show(ImageView iv, String url) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(iv.getContext()).
                    load(url)
                    .into(iv);
        }
    }

    private void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }


    @Bindable
    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
        notifyChange(BR.userPhoto);

    }

    @Bindable
    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
//        notifyPropertyChanged(BR.userName);
        notifyChange(BR.userName);
    }

    @Bindable
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
        notifyChange(BR.passWord);


    }


    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(onPropertyChangedCallback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(onPropertyChangedCallback);
        }
    }
}
