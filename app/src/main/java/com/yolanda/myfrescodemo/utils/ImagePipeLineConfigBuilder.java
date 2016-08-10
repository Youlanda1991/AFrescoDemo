package com.yolanda.myfrescodemo.utils;

import android.content.Context;

import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/8/10.
 */
public class ImagePipeLineConfigBuilder {
    public static ImagePipelineConfig getImagePipleLineConfig(Context context) {
        return ImagePipelineConfig.newBuilder(context).build();
    }
    public static ImagePipelineConfig getOkHttpImagePipleLineConfig(Context context) {
        OkHttpClient client=new OkHttpClient();
        return OkHttpImagePipelineConfigFactory.newBuilder(context,client).build();
    }
}
