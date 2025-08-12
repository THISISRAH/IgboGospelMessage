package com.igbogospelmessage.app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(
    val id: String,
    val title: String,
    val description: String,
    val videoUrl: String,
    val thumbnailUrl: String,
    val duration: String,
    val publishedAt: String,
    val viewCount: String,
    val likeCount: String
) : Parcelable