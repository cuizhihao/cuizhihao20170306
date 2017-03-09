package com.bwie.cuizhihao20170306;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by ASUS on 2017/3/6.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration.Builder builder=new ImageLoaderConfiguration.Builder(this);
        imageLoader.init(builder.build());
    }
}
