package com.allure.testmvvm.recycle;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.allure.testmvvm.R;
import com.allure.testmvvm.databinding.ActivityRecycleBinding;


/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class RecycleViewActivity extends AppCompatActivity {

    private ActivityRecycleBinding activityRecycleBinding;
    private  RecycleAdapter adpter;
//    private List<TestBean> testBeen=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRecycleBinding= DataBindingUtil.setContentView(this, R.layout.activity_recycle);

        activityRecycleBinding.recycleview.setLayoutManager(new LinearLayoutManager(this));


        adpter=new RecycleAdapter(this,TestBean.getData());
        activityRecycleBinding.recycleview.setAdapter(adpter);

    }
}
