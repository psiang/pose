package com.siang.pc.pose.fragment;

import com.siang.pc.pose.R;
import com.siang.pc.pose.activity.ScoreActivity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by siang on 2019/5/3.
 */

public class PoseFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //mxl文件
        return inflater.inflate(R.layout.pose_fragment, container, false);
    }

}