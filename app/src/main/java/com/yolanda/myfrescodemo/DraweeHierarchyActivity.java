package com.yolanda.myfrescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Author： yolanda
 *
 * CreateTime： 2016/8/10 15:48
 *
 * description：自定义DraweeHierarchy定义加载的图片的样式
 */

public class DraweeHierarchyActivity extends AppCompatActivity {
    SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draweehierarchy);
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.simv);
        showPic();
    }

    /**
     * 运行可发现，progressBar并没有根据xml设置的那样自动旋转
     */
    private void showPic() {
        GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(getResources())
                .setFailureImage(R.mipmap.faile, ScalingUtils.ScaleType.CENTER)
                .setProgressBarImage(R.mipmap.retry, ScalingUtils.ScaleType.CENTER)
                .setRetryImage(R.mipmap.retry, ScalingUtils.ScaleType.CENTER)
                .setFadeDuration(3000)
                .setRoundingParams(RoundingParams.asCircle())
//                圆角矩形
//                .setRoundingParams(RoundingParams.fromCornersRadius(50f))
                .build();
        simpleDraweeView.setHierarchy(hierarchy);
        simpleDraweeView.setImageURI(Uri.parse("http://imgsrc.baidu.com/forum/pic/item/a275666b3b092e466a60fbfe.jpg"));
    }
}
