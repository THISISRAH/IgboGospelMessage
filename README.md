# Igbo Gospel Message - Android TV App

A modern, professional Android TV application exclusively designed for the YouTube channel **@igbogospelmessage**. This app provides an immersive viewing experience for gospel content in the Igbo language, optimized for television screens.

## Features

### 🎯 **Core Functionality**
- **Featured Video**: Most recent video automatically displayed as the default
- **Video Playlist**: Organized collection of older videos for easy browsing
- **Smart Notifications**: Friday-only notifications for new video uploads
- **Modern UI**: Beautiful, TV-optimized interface using Android Leanback

### 📱 **User Experience**
- **TV-Optimized Navigation**: Smooth navigation using TV remote control
- **High-Quality Video Playback**: Powered by ExoPlayer for optimal performance
- **Responsive Design**: Adapts to different TV screen sizes and resolutions
- **Intuitive Interface**: Easy-to-use layout designed for living room viewing

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
- **Device Type**: Android TV devices only
- **Architecture**: ARM64, x86_64

### **Dependencies**
- **UI Framework**: Android Leanback for TV optimization
- **Video Player**: ExoPlayer for high-quality video playback
- **Image Loading**: Glide for efficient image management
- **Architecture**: MVVM pattern with LiveData
- **Background Tasks**: WorkManager for notification scheduling

### **Permissions**
- Internet access for video streaming
- Network state monitoring
- Wake lock for video playback
- Boot completion for notification persistence

## Installation

### **For End Users**
1. Download the APK file from the provided link
2. Enable "Unknown Sources" in Android TV settings
3. Install the APK using a file manager
4. Launch the app from the TV app launcher

### **For Developers**
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle dependencies
4. Build and run on Android TV device/emulator

## Usage Guide

### **Navigation**
- Use **D-pad** or **arrow keys** to navigate
- **Enter/OK** to select videos
- **Back** to return to previous screen
- **Home** to return to main menu

### **Video Playback**
- **Play/Pause**: OK button
- **Seek**: Left/Right arrows
- **Volume**: Volume buttons on remote
- **Fullscreen**: Automatic in video player

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
- **Banner**: Replace `app_banner.xml` with channel banner image
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

The APK file is automatically uploaded to a cloud service for easy download. Users can install it directly on their Android TV devices.

## Support & Contact

For technical support or feature requests, please contact the development team.

## License

This application is developed exclusively for the **@igbogospelmessage** YouTube channel. All rights reserved.

---

**Built with ❤️ for spreading the Gospel in Igbo language**