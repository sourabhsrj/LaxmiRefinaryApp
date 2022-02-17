package com.example.LaxmiRefinary;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavapp.R;

import java.util.List;

class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    List<YoutubeVideos> youtubeVideosList;
    public VideoAdapter(){

    }
    public VideoAdapter(List<YoutubeVideos> youtubeVideosList) {
        this.youtubeVideosList = youtubeVideosList;
    }

    @NonNull
    @Override
    public VideoAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.videoWeb.loadData(youtubeVideosList.get(position).getVideoUrl(),"text/html","utf-8");
    }

    @Override
    public int getItemCount() {
        return youtubeVideosList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        WebView videoWeb;

        @SuppressLint("SetJavaScriptEnabled")
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoWeb=(WebView) itemView.findViewById(R.id.videoView);
            WebSettings webSettings = videoWeb.getSettings();
            webSettings.setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient(){



            });
        }
    }


}