package com.siang.pc.pose.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.siang.pc.pose.R;

/**
 * Created by siang on 2019/5/3.
 */

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.ViewHolder> {

    private int[] imgs = {R.mipmap.img_video_1,R.mipmap.img_video_2,R.mipmap.img_video_3};
    private int[] videos = {R.raw.video_1, R.raw.video_2, R.raw.video_3};
    private int len_video = 3;
    Context mContext;

    public SocialAdapter(Context context){
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.img_thumb.setImageResource(imgs[position%len_video]);
        holder.videoView.setVideoURI(Uri.parse("android.resource://" + mContext.getPackageName() + "/" + videos[position % len_video]));
    }

    @Override
    public int getItemCount() {
        return 20;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        ImageView img_thumb;

        public ViewHolder(View itemView) {
            super(itemView);
            img_thumb = itemView.findViewById(R.id.img_thumb);
            videoView = itemView.findViewById(R.id.video_view);
        }
    }

}
