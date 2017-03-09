package com.bwie.cuizhihao20170306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * 崔志豪
 * 主界面
 */
public class MainActivity extends AppCompatActivity {
private List<String> images=new ArrayList<>();
    private GridView gridView;
    private String path="http://www.babybuy100.com/API/getShopOverview.ashx";
    private TextView textview;
    private String result;
    private List<Bean.ResultBean.BrandsBean> brands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        images.add("http://www.babybuy100.com/Storage/master/nation/201701111356197689230.png");
        images.add("http://www.babybuy100.com/Storage/master/nation/201701111356356152340.png");
        images.add("http://www.babybuy100.com/Storage/master/nation/201701111356493599030.png");
        images.add("http://www.babybuy100.com/Storage/master/nation/201701111357008574140.png");
        images.add("http://www.babybuy100.com/Storage/master/nation/201701111357203454670.png");
        setContentView(R.layout.activity_main);
        final Banner banner = (Banner) findViewById(R.id.banner);
        banner.setImages(images).setImageLoader(new GlideImageLoader()).start();
        gridView = (GridView) findViewById(R.id.gridView);
        textview = (TextView) findViewById(R.id.bbbb);
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, path, new RequestCallBack<String>() {



            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                result =  responseInfo.result;
                Log.d("TAG", "onSuccess: +++"+result);
                Gson gson=new Gson();
                Bean bean = gson.fromJson(result, Bean.class);
                brands = bean.getResult().getBrands();
                for (Bean.ResultBean.BrandsBean b:brands){
                    List<Bean.ResultBean.BrandsBean.ProductsBean> products = b.getProducts();
                    gridView.setAdapter(new MyBaseAdapter(MainActivity.this, products));
                }
             textview.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                     intent.putExtra("name",result);
                     startActivity(intent);
                 }
             });
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }

}
