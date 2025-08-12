package com.igbogospelmessage.tv.adapter

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.igbogospelmessage.tv.R
import com.igbogospelmessage.tv.VideoPlayerActivity
import com.igbogospelmessage.tv.model.Video

class VideoPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val context = parent.context
        val cardView = ImageCardView(context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
            setMainImageDimensions(313, 176)
        }
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val video = item as Video
        val cardView = viewHolder.view as ImageCardView
        
        cardView.titleText = video.title
        cardView.contentText = video.description
        
        // Load thumbnail (placeholder for now)
        // In a real app, you'd use Glide or similar to load actual thumbnails
        cardView.mainImage = null
        
        // Set click listener
        cardView.setOnClickListener {
            val intent = Intent(cardView.context, VideoPlayerActivity::class.java)
            intent.putExtra("video_url", video.videoUrl)
            intent.putExtra("video_title", video.title)
            cardView.context.startActivity(intent)
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        val cardView = viewHolder.view as ImageCardView
        cardView.mainImage = null
    }
}