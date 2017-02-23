package com.example.chen.news.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chen.news.R;
import com.example.chen.news.bean.NewsBean;
import com.example.chen.news.utils.ImageLoaderUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chen on 2017/2/8.
 */
public class NewsAdapter extends BaseAdapter {
    private List<NewsBean.ResultBean.DataBean> list;
    private Context ctx;

    public NewsAdapter(List<NewsBean.ResultBean.DataBean> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView = View.inflate(ctx, R.layout.item_recycle_fragment, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
           holder.authorNameTv.setText(list.get(position).getAuthor_name().toString());
          holder.timeTv.setText(list.get(position).getDate().toString());
        holder.titleTv.setText(list.get(position).getTitle().toString());
        ImageLoaderUtils.imageLoader(ctx,list.get(position).getThumbnail_pic_s(),holder.imageIv);
        return convertView;
    }


    static class ViewHolder {
        @Bind(R.id.image_iv)
        ImageView imageIv;
        @Bind(R.id.title_tv)
        TextView titleTv;
        @Bind(R.id.author_name_tv)
        TextView authorNameTv;
        @Bind(R.id.time_tv)
        TextView timeTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
