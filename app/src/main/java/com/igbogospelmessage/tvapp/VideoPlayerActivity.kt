package com.igbogospelmessage.tvapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.bumptech.glide.Glide
import com.igbogospelmessage.tvapp.databinding.ActivityVideoPlayerBinding

class VideoPlayerActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityVideoPlayerBinding
    private var player: ExoPlayer? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupVideoPlayer()
        loadVideoData()
    }
    
    private fun setupVideoPlayer() {
        binding.playerView.setOnClickListener {
            toggleControls()
        }
        
        // Initialize player
        player = ExoPlayer.Builder(this).build().also { exoPlayer ->
            binding.playerView.player = exoPlayer
            exoPlayer.playWhenReady = playWhenReady
            exoPlayer.seekTo(currentWindow, playbackPosition)
            exoPlayer.addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(playbackState: Int) {
                    when (playbackState) {
                        Player.STATE_BUFFERING -> showBuffering(true)
                        Player.STATE_READY -> showBuffering(false)
                        Player.STATE_ENDED -> {
                            // Handle video end
                        }
                    }
                }
                
                override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                    showError(getString(R.string.error_playing_video))
                }
            })
        }
    }
    
    private fun loadVideoData() {
        val videoTitle = intent.getStringExtra("video_title") ?: ""
        val videoDescription = intent.getStringExtra("video_description") ?: ""
        val videoUrl = intent.getStringExtra("video_url") ?: ""
        val thumbnailUrl = intent.getStringExtra("video_thumbnail") ?: ""
        
        binding.videoTitleOverlay.text = videoTitle
        binding.videoDescriptionOverlay.text = videoDescription
        
        // Load thumbnail
        if (thumbnailUrl.isNotEmpty()) {
            Glide.with(this)
                .load(thumbnailUrl)
                .into(binding.playerView.posterImage)
        }
        
        // Prepare video
        if (videoUrl.isNotEmpty()) {
            val mediaItem = MediaItem.fromUri(videoUrl)
            player?.setMediaItem(mediaItem)
            player?.prepare()
        }
    }
    
    private fun toggleControls() {
        val controlsOverlay = binding.controlsOverlay
        if (controlsOverlay.visibility == View.VISIBLE) {
            controlsOverlay.visibility = View.GONE
        } else {
            controlsOverlay.visibility = View.VISIBLE
            // Auto-hide controls after 3 seconds
            controlsOverlay.postDelayed({
                if (controlsOverlay.visibility == View.VISIBLE) {
                    controlsOverlay.visibility = View.GONE
                }
            }, 3000)
        }
    }
    
    private fun showBuffering(show: Boolean) {
        binding.bufferingProgress.visibility = if (show) View.VISIBLE else View.GONE
        binding.bufferingText.visibility = if (show) View.VISIBLE else View.GONE
    }
    
    private fun showError(errorMessage: String) {
        // Show error message
        binding.bufferingText.text = errorMessage
        binding.bufferingText.visibility = View.VISIBLE
        binding.bufferingProgress.visibility = View.GONE
    }
    
    override fun onStart() {
        super.onStart()
        if (player == null) {
            setupVideoPlayer()
        }
    }
    
    override fun onResume() {
        super.onResume()
        if (player == null) {
            setupVideoPlayer()
        }
    }
    
    override fun onPause() {
        super.onPause()
        releasePlayer()
    }
    
    override fun onStop() {
        super.onStop()
        releasePlayer()
    }
    
    private fun releasePlayer() {
        player?.let { exoPlayer ->
            playbackPosition = exoPlayer.currentPosition
            currentWindow = exoPlayer.currentMediaItemIndex
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.release()
        }
        player = null
    }
    
    override fun onBackPressed() {
        if (binding.controlsOverlay.visibility == View.VISIBLE) {
            binding.controlsOverlay.visibility = View.GONE
        } else {
            super.onBackPressed()
        }
    }
}