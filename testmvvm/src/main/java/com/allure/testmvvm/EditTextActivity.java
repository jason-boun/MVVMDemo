package com.allure.testmvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.allure.testmvvm.databinding.ActivityEditBinding;
import com.allure.testmvvm.model.EditModel;
import com.allure.testmvvm.model.EditViewModel;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEditBinding activityEditBinding= DataBindingUtil.setContentView(this,R.layout.activity_edit);
        EditModel editModel=new EditModel();
        editModel.setName("");

        activityEditBinding.setEditModel(editModel);

        EditViewModel editViewModel=new EditViewModel(this,editModel);
        activityEditBinding.setEditViewModel(editViewModel);

        activityEditBinding.button.setText("我是特殊变量ID设置的");
    }
}
