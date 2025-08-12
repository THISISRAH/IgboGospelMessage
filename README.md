# Igbo Gospel Message - Android App

A modern, professional Android application exclusively designed for the YouTube channel **@igbogospelmessage**. This app provides an immersive viewing experience for gospel content in the Igbo language, optimized for mobile phones and tablets.

## Features

### 🎯 **Core Functionality**
- **Featured Video**: Most recent video automatically displayed as the default
- **Video Playlist**: Organized collection of older videos for easy browsing
- **Smart Notifications**: Friday-only notifications for new video uploads
- **Modern UI**: Beautiful, mobile-optimized interface using Material Design 3

### 📱 **User Experience**
- **Mobile-Optimized Navigation**: Smooth navigation using touch gestures
- **High-Quality Video Playback**: Powered by ExoPlayer for optimal performance
- **Responsive Design**: Adapts to different phone screen sizes and orientations
- **Intuitive Interface**: Easy-to-use layout designed for mobile viewing

### 🔔 **Notification System**
- **Friday Alerts**: Automatic notifications every Friday for new content
- **Smart Scheduling**: Intelligent notification management
- **Boot Persistence**: Notifications continue working after device restart

### 🎨 **Design & Branding**
- **Professional Appearance**: Modern, clean design aesthetic
- **Brand Integration**: Uses channel banner and profile picture for branding
- **Color Scheme**: Gospel-inspired color palette with gold accents
- **Custom Icons**: App icon featuring cross symbol representing the gospel message

## Technical Specifications

### **Platform Requirements**
- **Minimum SDK**: Android 5.0 (API 21)
- **Target SDK**: Android 14 (API 34)
- **Device Type**: Android phones and tablets
- **Architecture**: ARM64, x86_64

### **Dependencies**
- **UI Framework**: Material Design 3 components
- **Video Player**: ExoPlayer for high-quality video playback
- **Image Loading**: Glide for efficient image management
- **Architecture**: MVVM pattern with LiveData
- **Background Tasks**: WorkManager for notification scheduling

### **Permissions**
- Internet access for video streaming
- Network state monitoring
- Wake lock for video playback
- Boot completion for notification persistence
- Post notifications (Android 13+)

## Installation

### **For End Users**
1. Download the APK file from the provided link
2. Enable "Unknown Sources" in Android settings (if needed)
3. Install the APK using the file manager
4. Launch the app from the app launcher

### **For Developers**
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle dependencies
4. Build and run on Android device/emulator

## Usage Guide

### **Navigation**
- **Touch**: Tap to select videos and navigate
- **Swipe**: Swipe down to refresh content
- **Back**: Use back button or navigation arrow
- **Home**: Return to main screen

### **Video Playback**
- **Play/Pause**: Tap the video player
- **Seek**: Use the video progress bar
- **Volume**: Use device volume buttons
- **Fullscreen**: Rotate device or use fullscreen button

### **Content Organization**
- **Featured Section**: Latest video prominently displayed
- **Recent Videos**: Latest 5 videos for quick access
- **Playlist**: Complete collection of older content

## Content Schedule

- **New Videos**: Every Friday
- **Notification Timing**: Automatic Friday alerts
- **Content Type**: Gospel messages in Igbo language
- **Video Duration**: 12-18 minutes per episode

## Customization

### **Branding Elements**
- **App Icon**: Replace `app_icon_foreground.xml` with channel profile picture
- **Colors**: Modify `colors.xml` for custom color schemes
- **Strings**: Update `strings.xml` for different languages

### **Content Management**
- **Video Data**: Update `VideoData.kt` with actual channel videos
- **YouTube Integration**: Replace sample URLs with real YouTube video links
- **Thumbnails**: Use actual video thumbnails from your channel

## Building the APK

### **Release Build**
```bash
./gradlew assembleRelease
```

### **Debug Build**
```bash
./gradlew assembleDebug
```

### **APK Location**
```
app/build/outputs/apk/release/app-release.apk
```

## Deployment

The APK file is automatically uploaded to a cloud service for easy download. Users can install it directly on their Android phones and tablets.

## Support & Contact

For technical support or feature requests, please contact the development team.

## License

This application is developed exclusively for the **@igbogospelmessage** YouTube channel. All rights reserved.

---

**Built with ❤️ for spreading the Gospel in Igbo language**