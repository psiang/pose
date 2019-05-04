package com.siang.pc.pose.fragment;

import com.siang.pc.pose.R;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by siang on 2019/5/3.
 */

public class MyFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //mxl文件
        return inflater.inflate(R.layout.my_fragment, container, false);
    }

}