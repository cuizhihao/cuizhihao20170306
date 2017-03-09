package com.bwie.cuizhihao20170306;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by ASUS on 2017/3/6.
 * 崔志豪
 */
//界面适配器
public class MyBaseAdapter extends BaseAdapter {
    public Context context;
    public List<Bean.ResultBean.BrandsBean.ProductsBean> products;
    private final ImageLoader imageLoader;

    public MyBaseAdapter(Context context, List<Bean.ResultBean.BrandsBean.ProductsBean> products) {
        this.products = products;
        this.context = context;
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //优化
        ViewHolder viewHolder;
        Bean.ResultBean.BrandsBean.ProductsBean productsBean = products.get(position);
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item, null);
            viewHolder = new ViewHolder();
            viewHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);
            viewHolder.text_price = (TextView) convertView.findViewById(R.id.text_price);
            viewHolder.image_prc = (ImageView) convertView.findViewById(R.id.image_pic);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //赋值
        viewHolder.text_name.setText(productsBean.getName());
        viewHolder.text_price.setText("￥:"+productsBean.getPrice());
        imageLoader.displayImage(productsBean.getPic(),viewHolder.image_prc);
        return convertView;

    }

    class ViewHolder {
        ImageView image_prc;
        TextView text_name;
        TextView text_price;
    }
}
