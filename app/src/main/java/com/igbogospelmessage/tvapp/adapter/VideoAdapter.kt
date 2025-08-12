package com.igbogospelmessage.tvapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.igbogospelmessage.tvapp.R
import com.igbogospelmessage.tvapp.model.Video

class VideoAdapter : ArrayObjectAdapter(VideoPresenter()) {
    
    fun setVideos(videos: List<Video>) {
        clear()
        addAll(0, videos)
    }
}

class VideoPresenter : Presenter() {
    
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = ImageCardView(parent.context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
            setMainImageDimensions(280, 200)
        }
        return ViewHolder(cardView)
    }
    
    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val video = item as Video
        val cardView = viewHolder.view as ImageCardView
        
        cardView.titleText = video.title
        cardView.contentText = video.duration
        
        // Load thumbnail image
        Glide.with(cardView.context)
            .load(video.thumbnailUrl)
            .centerCrop()
            .placeholder(R.drawable.card_background)
            .error(R.drawable.card_background)
            .into(cardView.mainImageView)
    }
    
    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        val cardView = viewHolder.view as ImageCardView
        cardView.mainImage = null
    }
}