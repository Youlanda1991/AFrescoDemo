package com.yolanda.myfrescodemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3,btn4;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.simple);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.draweeHierarchy);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.frescoList);
        btn3.setOnClickListener(this);
        btn4= (Button) findViewById(R.id.gif);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simple:
                startActivity(new Intent(context, SimpleLoadActivity.class));
                break;
            case R.id.draweeHierarchy:
                startActivity(new Intent(context, DraweeHierarchyActivity.class));
                break;
            case R.id.frescoList:
                startActivity(new Intent(context, FrescoListActivity.class));
                break;
            case R.id.gif:
                startActivity(new Intent(context,GifActivity.class));
        }
    }
}
