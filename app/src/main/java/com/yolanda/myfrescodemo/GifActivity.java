package com.yolanda.myfrescodemo;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/**
 * Author： yolanda
 * <p>
 * CreateTime： 2016/8/10 15:43
 * <p>
 * description：GIF动画加载示例
 */

public class GifActivity extends AppCompatActivity {
    Context context = this;

    SimpleDraweeView simpleDraweeView;
    String url = "http://uploadfile.huiyi8.com/2015/0105/20150105111626346.gif";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.simpv);
//        不可省，因为在xml布局文件中并没有对控件的样式进行设置，无法根据xml文件生成DraweeHierarchy。
        GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(getResources())
                .build();
        final DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(url))
                .setAutoPlayAnimations(true)
                .setControllerListener(new BaseControllerListener<ImageInfo>() {
                    @Override
                    public void onFailure(String id, Throwable throwable) {
                        super.onFailure(id, throwable);
                        Toast.makeText(context, "对不起，加载失败！", Toast.LENGTH_LONG).show();
                    }
                })
                .build();
        simpleDraweeView.setController(controller);
        simpleDraweeView.setHierarchy(hierarchy);
    }
}
