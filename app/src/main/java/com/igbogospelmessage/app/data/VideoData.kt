package com.igbogospelmessage.app.data

import com.igbogospelmessage.app.model.Video

object VideoData {
    
    fun getSampleVideos(): List<Video> {
        return listOf(
            Video(
                id = "1",
                title = "Igbo Gospel Message - Week 1: The Power of Faith",
                description = "Join us as we explore the power of faith in our daily lives through the lens of Igbo culture and Christian teachings.",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                thumbnailUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
                duration = "15:30",
                publishedAt = "2024-01-05",
                viewCount = "1,250",
                likeCount = "89"
            ),
            Video(
                id = "2",
                title = "Igbo Gospel Message - Week 2: Love Thy Neighbor",
                description = "Discover the meaning of loving your neighbor as yourself in the context of Igbo community values.",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                thumbnailUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg",
                duration = "12:45",
                publishedAt = "2024-01-12",
                viewCount = "980",
                likeCount = "67"
            ),
            Video(
                id = "3",
                title = "Igbo Gospel Message - Week 3: The Gift of Grace",
                description = "Understanding God's grace and how it manifests in our Igbo traditions and modern life.",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                thumbnailUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg",
                duration = "18:20",
                publishedAt = "2024-01-19",
                viewCount = "1,120",
                likeCount = "76"
            ),
            Video(
                id = "4",
                title = "Igbo Gospel Message - Week 4: Building Community",
                description = "How the gospel helps us build stronger communities based on Igbo principles of unity.",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                thumbnailUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerEscapes.jpg",
                duration = "14:15",
                publishedAt = "2024-01-26",
                viewCount = "890",
                likeCount = "54"
            ),
            Video(
                id = "5",
                title = "Igbo Gospel Message - Week 5: The Path to Salvation",
                description = "Exploring the path to salvation through faith, works, and the teachings of Jesus Christ.",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
                thumbnailUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerFun.mp4",
                duration = "16:40",
                publishedAt = "2024-02-02",
                viewCount = "1,450",
                likeCount = "92"
            ),
            Video(
                id = "6",
                title = "Igbo Gospel Message - Week 6: Family Values",
                description = "Strengthening family bonds through gospel principles and Igbo cultural heritage.",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
                thumbnailUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerJoyrides.jpg",
                duration = "13:55",
                publishedAt = "2024-02-09",
                viewCount = "1,080",
                likeCount = "71"
            ),
            Video(
                id = "7",
                title = "Igbo Gospel Message - Week 7: Overcoming Challenges",
                description = "Finding strength in faith to overcome life's challenges and difficulties.",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
                thumbnailUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerMeltdowns.jpg",
                duration = "17:10",
                publishedAt = "2024-02-16",
                viewCount = "1,320",
                likeCount = "83"
            ),
            Video(
                id = "8",
                title = "Igbo Gospel Message - Week 8: The Power of Prayer",
                description = "Understanding the importance of prayer in our spiritual journey and daily life.",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
                thumbnailUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/Sintel.jpg",
                duration = "15:25",
                publishedAt = "2024-02-23",
                viewCount = "1,180",
                likeCount = "78"
            )
        )
    }
}