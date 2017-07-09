package com.example.administrator.getjsons.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.administrator.getjsons.R;
import com.example.administrator.getjsons.entity.Txintroduction;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import java.util.List;
/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class F3adapter extends RecyclerView.Adapter<F3adapter.ViewHolder> {
    private List<Txintroduction> mList;
    private Context ocontext;           //联系上下文
    private ImageLoader imageLoader;    //第二种方法加载网络图片


    //匹配RecyclerView行内样式页面
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView content;
        TextView theme;
        public ViewHolder(View itemView) {
            super(itemView);
            //获取ui控件
            imageView= (ImageView) itemView.findViewById(R.id.txsrc);
            content= (TextView) itemView.findViewById(R.id.content);
            theme= (TextView) itemView.findViewById(R.id.theme);
        }
    }

    public F3adapter(List<Txintroduction> oList,Context ocontext){
        mList=oList;
        this.ocontext=ocontext;
        //第二种方法加载网络图片
        imageLoader=ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(ocontext));
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Txintroduction txintroduction=mList.get(position);

        imageLoader.displayImage(txintroduction.getTxsrc(),holder.imageView);
        holder.content.setText(txintroduction.getContent());
        holder.theme.setText(txintroduction.getTheme());
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }


}
