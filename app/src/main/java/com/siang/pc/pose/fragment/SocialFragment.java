package com.siang.pc.pose.fragment;

import com.siang.pc.pose.R;
import com.siang.pc.pose.adapter.SocialAdapter;
import com.siang.pc.pose.listener.OnViewPagerListener;
import com.siang.pc.pose.widget.ViewPagerLayoutManager;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.VideoView;

/**
 * Created by siang on 2019/5/3.
 */

public class SocialFragment extends Fragment implements OnViewPagerListener {

    RecyclerView mRecyclerView;
    ViewPagerLayoutManager mLayoutManager;
    SocialAdapter mAdapter;
    View view;
    private boolean first = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.social_fragment, container, false);
        //initView();
        //initListener();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            if (first == false) {
                initView();
                initListener();
            }
            else {
                View itemView = mRecyclerView.getChildAt(0);
                VideoView videoView = itemView.findViewById(R.id.video_view);
                videoView.start();
            }
            first = true;
        }else {
            if (first == true) {
                View itemView = mRecyclerView.getChildAt(0);
                VideoView videoView = itemView.findViewById(R.id.video_view);
                videoView.pause();
            }
        }
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        mLayoutManager = new ViewPagerLayoutManager(getActivity(), OrientationHelper.VERTICAL);
        mAdapter = new SocialAdapter(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initListener() {
        mLayoutManager.setOnViewPagerListener(this);
    }

    @Override
    public void onInitComplete() {
        playVideo(0);
    }

    @Override
    public void onPageRelease(boolean isNext, int position) {
        int index = 0;
        if (isNext) {
            index = 0;
        } else {
            index = 1;
        }
        releaseVideo(index);
    }

    @Override
    public void onPageSelected(int position, boolean isBottom) {
        playVideo(0);
    }


    private void playVideo(int position) {
        View itemView = mRecyclerView.getChildAt(0);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        videoView.start();
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                mediaPlayer[0] = mp;
                mp.setLooping(true);
                imgThumb.animate().alpha(0).setDuration(200).start();
                return false;
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

            }
        });
    }

    private void releaseVideo(int index) {
        View itemView = mRecyclerView.getChildAt(index);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        videoView.stopPlayback();
        imgThumb.animate().alpha(1).start();
    }
}