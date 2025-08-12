package com.igbogospelmessage.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.igbogospelmessage.app.R
import com.igbogospelmessage.app.databinding.VideoCardBinding
import com.igbogospelmessage.app.model.Video

class VideoAdapter(
    private val onVideoClick: (Video) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
    
    private var videos: List<Video> = emptyList()
    
    fun setVideos(newVideos: List<Video>) {
        videos = newVideos
        notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = VideoCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VideoViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videos[position])
    }
    
    override fun getItemCount(): Int = videos.size
    
    inner class VideoViewHolder(
        private val binding: VideoCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        
        fun bind(video: Video) {
            binding.videoTitle.text = video.title
            binding.videoDuration.text = video.duration
            
            // Load thumbnail
            Glide.with(binding.root.context)
                .load(video.thumbnailUrl)
                .placeholder(R.drawable.card_background)
                .error(R.drawable.card_background)
                .centerCrop()
                .into(binding.videoThumbnail)
            
            // Set click listener
            binding.root.setOnClickListener {
                onVideoClick(video)
            }
        }
    }
}