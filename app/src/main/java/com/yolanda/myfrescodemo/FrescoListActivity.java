package com.yolanda.myfrescodemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.yolanda.myfrescodemo.adapter.FrescoAdapter;
import com.yolanda.myfrescodemo.utils.ImageUrlUtils;

/**
 * Created by YolandaLi on 2016/8/5 0005.
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
