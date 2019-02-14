package com.bawei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.active.R;
import com.bawei.bean.UserBean;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<UserBean.DataBean> list;
    private ViewHolder viewHolder;

    public UserAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(ArrayList<UserBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    @Override
    public int getItemViewType(int position) {
       if (position%2==0){
           return 0;
       }else{
           return 1;
       }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            if (getItemViewType(position)==0){
                convertView=LayoutInflater.from(context).inflate(R.layout.one,parent,false);
            }else{
                convertView=LayoutInflater.from(context).inflate(R.layout.two,parent,false);
            }
            viewHolder = new ViewHolder(convertView);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
            viewHolder.bindDatas(position);
        return convertView;
    }
    class ViewHolder{
        TextView textView,textView1;
        ImageView imageView,imageView1;

        public ViewHolder(View convertView) {
            this.textView=convertView.findViewById(R.id.text);
            this.textView1=convertView.findViewById(R.id.text1);
            this.imageView=convertView.findViewById(R.id.icon);
            this.imageView1=convertView.findViewById(R.id.icon1);
            convertView.setTag(this);

        }

        public void bindDatas(int position) {
        }
    }
}
