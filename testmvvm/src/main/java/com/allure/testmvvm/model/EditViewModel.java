package com.allure.testmvvm.model;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class EditViewModel {
    private Context context;
    private EditModel editModel;
    public EditViewModel(Context context,EditModel editModel) {
        this.context=context;
        this.editModel=editModel;
    }

    public void changeText(){
        editModel.setName("我是改变了");
    }


    public TextWatcher editChangeName=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            editModel.setName(editable.toString());
        }
    };
}
