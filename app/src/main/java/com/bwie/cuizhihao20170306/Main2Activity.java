package com.bwie.cuizhihao20170306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;
/**
 * 崔志豪
 * 详情界面
 */
public class Main2Activity extends AppCompatActivity {

    private ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listview = (ListView) findViewById(R.id.listview);
        //接收值
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        //解析数据
        Gson gson = new Gson();
        Bean bean = gson.fromJson(name, Bean.class);
        List<Bean.ResultBean.BrandsBean> brands = bean.getResult().getBrands();

        for (Bean.ResultBean.BrandsBean bb:brands){
            List<Bean.ResultBean.BrandsBean.ProductsBean> products = bb.getProducts();
            listview.setAdapter(new MylistAdapter(Main2Activity.this,products));

        }


    }




}
