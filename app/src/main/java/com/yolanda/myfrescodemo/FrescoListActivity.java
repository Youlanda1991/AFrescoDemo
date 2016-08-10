package com.yolanda.myfrescodemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.yolanda.myfrescodemo.adapter.FrescoAdapter;
import com.yolanda.myfrescodemo.utils.ImageUrlUtils;

/**
 * Author： yolanda
 *
 * CreateTime： 2016/8/10 15:48
 *
 * description：加载很多图片
 */

public class FrescoListActivity extends AppCompatActivity {

    Context context = this;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.lv);
        FrescoAdapter frescoAdapter = new FrescoAdapter(context, ImageUrlUtils.getImageUrls());
        listView.setAdapter(frescoAdapter);
    }
}
