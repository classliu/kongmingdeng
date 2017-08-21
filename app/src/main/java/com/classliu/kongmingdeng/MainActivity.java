package com.classliu.kongmingdeng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.classliu.kongmingdeng.service.TrackerService;
import com.classliu.kongmingdeng.utils.AccessibilityUtil;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //当需要权限时去申请
    private void initView() {
        Button btnOpen = (Button) findViewById(R.id.btn_open);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AccessibilityUtil.checkAccessibility(MainActivity.this)) {
                    startService(new Intent(MainActivity.this, TrackerService.class)
                            .putExtra(TrackerService.COMMAND, TrackerService.COMMAND_OPEN));
                    finish();
                }
            }
        });
    }
}
