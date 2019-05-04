package com.siang.pc.pose.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.siang.pc.pose.R;

/**
 * Created by siang on 2019/5/4.
 */
public class ScoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_activity);
    }

    public void onUploadClick(View v) {
        Intent intent = new Intent(this, UpdateActivity.class);
        startActivity(intent);
    }

}
