package com.igbogospelmessage.tv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.igbogospelmessage.tv.R

class VideoPlayerActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)
        
        val videoUrl = intent.getStringExtra("video_url")
        val videoTitle = intent.getStringExtra("video_title")
        
        title = videoTitle
        
        // For now, we'll just show a placeholder
        // In a real app, you'd integrate ExoPlayer here
    }
}