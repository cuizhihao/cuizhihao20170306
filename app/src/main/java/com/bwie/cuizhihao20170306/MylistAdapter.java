package com.bwie.cuizhihao20170306;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by ASUS on 2017/3/6.
 * 崔志豪
 */
//详情界面的适配器
public class MylistAdapter extends BaseAdapter{
    public Context context;
    List<Bean.ResultBean.BrandsBean.ProductsBean> products;
    private final ImageLoader imageLoader;

    public MylistAdapter(Context context, List<Bean.ResultBean.BrandsBean.ProductsBean> products) {
        this.context=context;
      this.products=products;
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
//优化
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
       ViewHolder1 viewHolder1;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item, null);
            viewHolder1 = new ViewHolder1();
            viewHolder1.text_name = (TextView) convertView.findViewById(R.id.text_name);
            viewHolder1.text_price = (TextView) convertView.findViewById(R.id.text_price);
            viewHolder1.image_prc = (ImageView) convertView.findViewById(R.id.image_pic);
            convertView.setTag(viewHolder1);
        } else {
           viewHolder1= (ViewHolder1) convertView.getTag();
        }
        //赋值
        viewHolder1.text_name.setText(products.get(position).getName());
        viewHolder1.text_price.setText("￥:"+products.get(position).getPrice());
        imageLoader.displayImage(products.get(position).getPic(),viewHolder1.image_prc);
        return convertView;
    }
    class ViewHolder1 {
        ImageView image_prc;
        TextView text_name;
        TextView text_price;
    }
}
