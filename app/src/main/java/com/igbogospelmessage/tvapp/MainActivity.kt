package com.igbogospelmessage.tvapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.igbogospelmessage.tvapp.adapter.VideoAdapter
import com.igbogospelmessage.tvapp.data.VideoData
import com.igbogospelmessage.tvapp.model.Video
import com.igbogospelmessage.tvapp.viewmodel.MainViewModel
import com.igbogospelmessage.tvapp.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    
    private lateinit var mainViewModel: MainViewModel
    private lateinit var browseFragment: BrowseSupportFragment
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        setupViewModel()
        setupBrowseFragment()
        observeViewModel()
    }
    
    private fun setupViewModel() {
        val factory = MainViewModelFactory()
        mainViewModel = factory.create(MainViewModel::class.java)
    }
    
    private fun setupBrowseFragment() {
        browseFragment = supportFragmentManager.findFragmentById(R.id.browse_fragment) as BrowseSupportFragment
        
        browseFragment.apply {
            title = getString(R.string.app_name)
            badgeDrawable = getDrawable(R.drawable.app_banner)
            headersState = BrowseSupportFragment.HEADERS_ENABLED
            isHeadersTransitionOnBackEnabled = true
            
            setOnSearchClickedListener {
                // Handle search functionality
            }
            
            setOnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
                if (item is Video) {
                    val intent = Intent(this@MainActivity, VideoPlayerActivity::class.java).apply {
                        putExtra("video_id", item.id)
                        putExtra("video_title", item.title)
                        putExtra("video_description", item.description)
                        putExtra("video_url", item.videoUrl)
                        putExtra("video_thumbnail", item.thumbnailUrl)
                    }
                    startActivity(intent)
                }
            }
            
            setOnItemViewSelectedListener { itemViewHolder, item, rowViewHolder, row ->
                // Handle item selection
            }
        }
    }
    
    private fun observeViewModel() {
        mainViewModel.videos.observe(this) { videos ->
            if (videos.isNotEmpty()) {
                setupRows(videos)
                hideLoading()
            }
        }
        
        mainViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                showLoading()
            } else {
                hideLoading()
            }
        }
        
        mainViewModel.error.observe(this) { error ->
            if (error != null) {
                showError(error)
            }
        }
    }
    
    private fun setupRows(videos: List<Video>) {
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        
        // Featured/Recent Video Row
        val featuredAdapter = VideoAdapter()
        featuredAdapter.setVideos(videos.take(1))
        val featuredHeader = HeaderItem(0, getString(R.string.featured_video))
        rowsAdapter.add(ListRow(featuredHeader, featuredAdapter))
        
        // Recent Videos Row
        if (videos.size > 1) {
            val recentAdapter = VideoAdapter()
            recentAdapter.setVideos(videos.take(5))
            val recentHeader = HeaderItem(1, getString(R.string.recent_videos))
            rowsAdapter.add(ListRow(recentHeader, recentAdapter))
        }
        
        // Playlist Row
        if (videos.size > 5) {
            val playlistAdapter = VideoAdapter()
            playlistAdapter.setVideos(videos.drop(5))
            val playlistHeader = HeaderItem(2, getString(R.string.playlist))
            rowsAdapter.add(ListRow(playlistHeader, playlistAdapter))
        }
        
        browseFragment.adapter = rowsAdapter
    }
    
    private fun showLoading() {
        findViewById<View>(R.id.loading_progress).visibility = View.VISIBLE
        findViewById<View>(R.id.error_text).visibility = View.GONE
    }
    
    private fun hideLoading() {
        findViewById<View>(R.id.loading_progress).visibility = View.GONE
    }
    
    private fun showError(error: String) {
        findViewById<View>(R.id.loading_progress).visibility = View.GONE
        findViewById<View>(R.id.error_text).apply {
            visibility = View.VISIBLE
            setText(error)
        }
    }
}