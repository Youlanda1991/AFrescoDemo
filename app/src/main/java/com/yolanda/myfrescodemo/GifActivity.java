package com.yolanda.myfrescodemo;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by YolandaLi on 2016/8/5 0005.
 */
public class GifActivity extends AppCompatActivity {

    SimpleDraweeView simpleDraweeView;
    String url = "http://img4.imgtn.bdimg.com/it/u=3358554156,2066728760&fm=21&gp=0.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.simpv);
//        不可省，因为在xml布局文件中并没有对控件的样式进行设置，无法根据xml文件生成DraweeHierarchy。
        GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(getResources()).build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(url))
                .setAutoPlayAnimations(true)
                .build();
        simpleDraweeView.setController(controller);
        simpleDraweeView.setHierarchy(hierarchy);
    }
}
