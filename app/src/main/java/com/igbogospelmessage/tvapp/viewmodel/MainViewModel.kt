package com.igbogospelmessage.tvapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.igbogospelmessage.tvapp.data.VideoData
import com.igbogospelmessage.tvapp.model.Video

class MainViewModel : ViewModel() {
    
    private val _videos = MutableLiveData<List<Video>>()
    val videos: LiveData<List<Video>> = _videos
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    init {
        loadVideos()
    }
    
    private fun loadVideos() {
        _isLoading.value = true
        _error.value = null
        
        try {
            // Simulate network delay
            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                val videoList = VideoData.getSampleVideos()
                _videos.value = videoList
                _isLoading.value = false
            }, 1000)
        } catch (e: Exception) {
            _error.value = e.message ?: "Unknown error occurred"
            _isLoading.value = false
        }
    }
    
    fun refreshVideos() {
        loadVideos()
    }
    
    fun getLatestVideo(): Video? {
        return _videos.value?.firstOrNull()
    }
    
    fun getRecentVideos(count: Int = 5): List<Video> {
        return _videos.value?.take(count) ?: emptyList()
    }
    
    fun getPlaylistVideos(): List<Video> {
        return _videos.value?.drop(5) ?: emptyList()
    }
    
    override fun onCleared() {
        super.onCleared()
        // Clean up resources if needed
    }
}

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}