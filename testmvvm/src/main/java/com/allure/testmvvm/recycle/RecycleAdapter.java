package com.allure.testmvvm.recycle;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allure.testmvvm.R;
import com.allure.testmvvm.databinding.RecycleItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleHolder> {


    private Context mContext;
    private List<TestBean> list = new ArrayList<>();

    public RecycleAdapter(Context context, List<TestBean> data) {
        this.mContext = context;
        this.list = data;
    }

    @Override
    public RecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecycleItemBinding recycleItemBinding= DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.recycle_item,parent,false
        );
        RecycleHolder holder=new RecycleHolder(recycleItemBinding.getRoot());
        holder.setRecycleItemBinding(recycleItemBinding);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecycleHolder holder, int position) {
        TestBean testBean=list.get(position);
        holder.recycleItemBinding.setTestBean(testBean);
        holder.recycleItemBinding.executePendingBindings();//绑定数据时更新UI
    }

    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() : 0;
    }


    public class RecycleHolder extends RecyclerView.ViewHolder {

        private RecycleItemBinding recycleItemBinding;

        public RecycleItemBinding getRecycleItemBinding() {
            return recycleItemBinding;
        }

        public void setRecycleItemBinding(RecycleItemBinding recycleItemBinding) {
            this.recycleItemBinding = recycleItemBinding;
        }

        public RecycleHolder(View itemView) {
            super(itemView);
        }
    }
}
