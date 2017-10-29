package com.allure.testmvvm.recycle;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.allure.testmvvm.BR;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class TestBean extends BaseObservable {
    private String name;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public  static List<TestBean>  getData(){
       List<TestBean> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestBean testBean=new TestBean();
            testBean.setName(i+"");
            list.add(testBean);
        }
        return list;
    }
}
