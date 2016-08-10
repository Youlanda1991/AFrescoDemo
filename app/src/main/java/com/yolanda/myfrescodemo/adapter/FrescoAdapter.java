package com.yolanda.myfrescodemo.adapter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.yolanda.myfrescodemo.R;

/**
 * Created by YolandaLi on 2016/8/5 0005.
 */
public class FrescoAdapter extends BaseAdapter {
    private Context context;
    private String[] urls;

    public FrescoAdapter() {
    }

    public FrescoAdapter(Context context, String[] urls) {
        this.context = context;
        this.urls = urls;
    }

    @Override
    public int getCount() {
        return urls.length;
    }

    @Override
    public Object getItem(int position) {
        return urls[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_frescoadapter, null);
            holder = new Holder(convertView);
        } else {
            holder = (Holder) convertView.getTag();
        }

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setOldController(holder.simpleDraweeView.getController())
                .setUri(Uri.parse(urls[position]))
                .setTapToRetryEnabled(true)
                .setControllerListener(new BaseControllerListener<ImageInfo>() {

                    private float start;

                    @Override
                    public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                        super.onFinalImageSet(id, imageInfo, animatable);
                        Log.e("OK", "----ok");
                        float end = System.currentTimeMillis();
                        Log.e("onFinalImageSet: ", (end - start) + "----" + position);
                    }

                    @Override
                    public void onSubmit(String id, Object callerContext) {
                        super.onSubmit(id, callerContext);
                        start = System.currentTimeMillis();
                    }

                    @Override
                    public void onFailure(String id, Throwable throwable) {
                        super.onFailure(id, throwable);
                        Log.e("Failure", "----fail");
                    }
                })
                .build();
        holder.simpleDraweeView.setController(controller);
//        holder.simpleDraweeView.setImageURI(urls[position]);
        return convertView;
    }

    class Holder {
        SimpleDraweeView simpleDraweeView;

        public Holder(View view) {
            simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.sdv);
            view.setTag(this);
        }
    }
}
