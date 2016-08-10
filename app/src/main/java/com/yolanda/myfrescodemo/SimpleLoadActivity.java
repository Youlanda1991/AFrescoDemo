package com.yolanda.myfrescodemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Author： yolanda
 *
 * CreateTime： 2016/8/10 15:49
 *
 * description： 在xml里设置加载图片显示的样式
 */

public class SimpleLoadActivity extends AppCompatActivity {
    SimpleDraweeView simpleDraweeView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        simpleDraweeView= (SimpleDraweeView) findViewById(R.id.sv);
        simpleDraweeView.setImageURI("http://img2.3lian.com/2014/f4/184/d/117.jpg");
    }
}
