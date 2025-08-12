package com.igbogospelmessage.tv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.igbogospelmessage.tv.adapter.VideoPresenter
import com.igbogospelmessage.tv.model.Video
import com.igbogospelmessage.tv.service.NotificationService

class MainActivity : FragmentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val browseSupportFragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, browseSupportFragment)
            .commit()
            
        // Start notification service
        startService(Intent(this, NotificationService::class.java))
    }
    
    class MainFragment : BrowseSupportFragment() {
        
        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            
            setupUI()
            loadVideos()
        }
        
        private fun setupUI() {
            title = getString(R.string.app_name)
            headersState = BrowseSupportFragment.HEADERS_ENABLED
            isHeadersTransitionOnBackEnabled = true
            
            brandColor = resources.getColor(R.color.primary, null)
            searchAffordanceColor = resources.getColor(R.color.accent, null)
        }
        
        private fun loadVideos() {
            val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
            
            // Latest Videos Row
            val latestVideosAdapter = ArrayObjectAdapter(VideoPresenter())
            val latestVideos = getLatestVideos()
            latestVideosAdapter.addAll(0, latestVideos)
            
            val latestVideosHeader = HeaderItem(0, getString(R.string.latest_videos))
            rowsAdapter.add(ListRow(latestVideosHeader, latestVideosAdapter))
            
            // Playlist Row
            val playlistAdapter = ArrayObjectAdapter(VideoPresenter())
            val playlistVideos = getPlaylistVideos()
            playlistAdapter.addAll(0, playlistVideos)
            
            val playlistHeader = HeaderItem(1, getString(R.string.playlist))
            rowsAdapter.add(ListRow(playlistHeader, playlistAdapter))
            
            adapter = rowsAdapter
        }
        
        private fun getLatestVideos(): List<Video> {
            return listOf(
                Video(
                    id = "latest_video_id",
                    title = "Latest Igbo Gospel Message",
                    description = "The most recent message from our channel",
                    thumbnailUrl = "https://example.com/thumbnail.jpg",
                    videoUrl = "https://example.com/video.mp4",
                    duration = "45:30",
                    uploadDate = "2024-01-19"
                )
            )
        }
        
        private fun getPlaylistVideos(): List<Video> {
            return listOf(
                Video(
                    id = "video_1",
                    title = "Igbo Gospel Message - Week 1",
                    description = "First week message",
                    thumbnailUrl = "https://example.com/thumbnail1.jpg",
                    videoUrl = "https://example.com/video1.mp4",
                    duration = "42:15",
                    uploadDate = "2024-01-12"
                ),
                Video(
                    id = "video_2",
                    title = "Igbo Gospel Message - Week 2",
                    description = "Second week message",
                    thumbnailUrl = "https://example.com/thumbnail2.jpg",
                    videoUrl = "https://example.com/video2.mp4",
                    duration = "38:45",
                    uploadDate = "2024-01-05"
                )
            )
        }
    }
}