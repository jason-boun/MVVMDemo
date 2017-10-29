package com.allure.testmvvm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.allure.testmvvm.BR;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class EditModel extends BaseObservable {
    private String name;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
