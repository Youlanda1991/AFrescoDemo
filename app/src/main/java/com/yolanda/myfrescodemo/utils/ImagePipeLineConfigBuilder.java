package com.yolanda.myfrescodemo.utils;

import android.content.Context;

import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import okhttp3.OkHttpClient;

/**
 * Author： yolanda
 *
 * CreateTime： 2016/8/10 15:43
 *
 * description：ImagePipleLineConfig管理类
 */

public class ImagePipeLineConfigBuilder {

    /**
     * 设置ImagePipleLineConfig
     * @param context
     * @return
     */
    public static ImagePipelineConfig getImagePipleLineConfig(Context context) {
        return ImagePipelineConfig.newBuilder(context).build();
    }

    /**
     * 设置ImagePipleLineConfig
     * @param context
     * @return
     */
    public static ImagePipelineConfig getOkHttpImagePipleLineConfig(Context context) {
        OkHttpClient client = new OkHttpClient();
        return OkHttpImagePipelineConfigFactory.newBuilder(context, client).build();
    }
}
