package com.yolanda.myfrescodemo.application;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.yolanda.myfrescodemo.utils.ImagePipeLineConfigBuilder;

/**
 * Created by YolandaLi on 2016/8/5 0005.
 */
public class MyApp extends Application {
    Context context = this;
    String httpProxy = "okhttp";
    ImagePipelineConfig config;

    @Override
    public void onCreate() {
        super.onCreate();

//        使用Fresco需要进行初始化，ImagePipleLineCOnfig可以根据需要进行设置
        if (!httpProxy.equals("okhttp")) {
            config = ImagePipeLineConfigBuilder.getImagePipleLineConfig(this);
        } else {
            config = ImagePipeLineConfigBuilder.getOkHttpImagePipleLineConfig(this);
        }
        Fresco.initialize(context, config);
    }
}
