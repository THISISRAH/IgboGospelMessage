package com.igbogospelmessage.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.igbogospelmessage.app.adapter.VideoAdapter
import com.igbogospelmessage.app.data.VideoData
import com.igbogospelmessage.app.databinding.ActivityMainBinding
import com.igbogospelmessage.app.model.Video
import com.igbogospelmessage.app.viewmodel.MainViewModel
import com.igbogospelmessage.app.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var recentVideosAdapter: VideoAdapter
    private lateinit var playlistAdapter: VideoAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupToolbar()
        setupViewModel()
        setupRecyclerViews()
        setupSwipeRefresh()
        observeViewModel()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
    
    private fun setupViewModel() {
        val factory = MainViewModelFactory()
        mainViewModel = factory.create(MainViewModel::class.java)
    }
    
    private fun setupRecyclerViews() {
        // Recent Videos RecyclerView
        recentVideosAdapter = VideoAdapter { video ->
            openVideoPlayer(video)
        }
        binding.recentVideosRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = recentVideosAdapter
        }
        
        // Playlist RecyclerView
        playlistAdapter = VideoAdapter { video ->
            openVideoPlayer(video)
        }
        binding.playlistRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = playlistAdapter
        }
    }
    
    private fun setupSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            mainViewModel.refreshVideos()
        }
    }
    
    private fun observeViewModel() {
        mainViewModel.videos.observe(this) { videos ->
            if (videos.isNotEmpty()) {
                setupFeaturedVideo(videos.first())
                setupRecentVideos(videos.take(5))
                setupPlaylist(videos.drop(5))
                hideLoading()
            }
        }
        
        mainViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                showLoading()
            } else {
                hideLoading()
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }
        
        mainViewModel.error.observe(this) { error ->
            if (error != null) {
                showError(error)
            }
        }
    }
    
    private fun setupFeaturedVideo(video: Video) {
        binding.featuredVideoTitle.text = video.title
        binding.featuredVideoDuration.text = video.duration
        
        // Load thumbnail
        Glide.with(this)
            .load(video.thumbnailUrl)
            .into(binding.featuredVideoThumbnail)
        
        // Set click listener
        binding.featuredVideoCard.setOnClickListener {
            openVideoPlayer(video)
        }
    }
    
    private fun setupRecentVideos(videos: List<Video>) {
        recentVideosAdapter.setVideos(videos)
    }
    
    private fun setupPlaylist(videos: List<Video>) {
        playlistAdapter.setVideos(videos)
    }
    
    private fun openVideoPlayer(video: Video) {
        val intent = Intent(this, VideoPlayerActivity::class.java).apply {
            putExtra("video_id", video.id)
            putExtra("video_title", video.title)
            putExtra("video_description", video.description)
            putExtra("video_url", video.videoUrl)
            putExtra("video_thumbnail", video.thumbnailUrl)
        }
        startActivity(intent)
    }
    
    private fun showLoading() {
        binding.loadingProgress.visibility = View.VISIBLE
        binding.errorText.visibility = View.GONE
    }
    
    private fun hideLoading() {
        binding.loadingProgress.visibility = View.GONE
    }
    
    private fun showError(error: String) {
        binding.loadingProgress.visibility = View.GONE
        binding.errorText.apply {
            visibility = View.VISIBLE
            text = error
        }
    }
}