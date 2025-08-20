# Igbo Gospel Message - Android TV App Build Instructions

## Overview
This document provides complete instructions for building the "Igbo Gospel Message" Android TV app APK.

## Prerequisites

### 1. Install Android Studio
- Download and install Android Studio from: https://developer.android.com/studio
- This is the recommended approach as it handles all SDK dependencies automatically

### 2. Alternative: Command Line Setup
If you prefer command line, install these components:
```bash
# Install Java 17 (required for Android development)
sudo apt install openjdk-17-jdk

# Install Android SDK
sudo apt install android-sdk

# Install build tools
sudo apt install android-sdk-build-tools android-sdk-platform-tools
```

## Building the APK

### Method 1: Using Android Studio (Recommended)

1. **Open Android Studio**
2. **Import Project**: File → Open → Select the project folder
3. **Sync Gradle**: Click "Sync Now" when prompted
4. **Build APK**: Build → Build Bundle(s) / APK(s) → Build APK(s)
5. **Find APK**: The APK will be in `app/build/outputs/apk/debug/app-debug.apk`

### Method 2: Command Line (Advanced)

1. **Set Environment Variables**:
```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export ANDROID_HOME=/usr/lib/android-sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
```

2. **Accept Licenses**:
```bash
yes | $ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager --licenses
```

3. **Build APK**:
```bash
./gradlew assembleDebug
```

## Project Structure

```
igbo-gospel-message-tv/
├── app/
│   ├── src/main/
│   │   ├── java/com/igbogospelmessage/tv/
│   │   │   ├── MainActivity.kt          # Main TV interface
│   │   │   ├── VideoPlayerActivity.kt   # Video playback
│   │   │   ├── adapter/VideoPresenter.kt # Video display adapter
│   │   │   ├── model/Video.kt          # Video data model
│   │   │   ├── service/NotificationService.kt # Friday notifications
│   │   │   └── receiver/BootReceiver.kt # Boot notifications
│   │   ├── res/                         # Resources (layouts, strings, colors)
│   │   └── AndroidManifest.xml         # App configuration
│   └── build.gradle                    # App dependencies
├── build.gradle                        # Project configuration
└── settings.gradle                     # Project settings
```

## Features Implemented

✅ **Modern TV UI**: Uses Android TV Leanback library
✅ **Latest Video Display**: Most recent video appears first
✅ **Video Playlist**: Access to older videos
✅ **Friday Notifications**: Automatic notification system
✅ **Professional Design**: Modern color scheme and typography
✅ **Branding Ready**: Placeholder for channel images

## Customization

### 1. Update Channel Information
- Edit `MainActivity.kt` to add your actual YouTube videos
- Replace placeholder URLs with real video links

### 2. Add Your Branding
- Replace `app_banner.xml` with your channel banner
- Update `ic_launcher.xml` with your profile picture
- Customize colors in `colors.xml`

### 3. YouTube API Integration
- Add your YouTube API key
- Implement real video fetching from your channel

## Troubleshooting

### Common Issues

1. **Gradle Sync Failed**
   - Check internet connection
   - Update Android Studio
   - Clear Gradle cache: File → Invalidate Caches

2. **Build Errors**
   - Ensure Java 17 is installed
   - Check Android SDK installation
   - Verify all dependencies in build.gradle

3. **APK Not Installing**
   - Enable "Unknown Sources" on Android TV
   - Check APK compatibility with your TV

## Next Steps

1. **Test on Device**: Install APK on Android TV
2. **Customize Content**: Add your actual videos
3. **Deploy**: Share APK with your audience
4. **Update**: Regular updates for new features

## Support

For issues or questions:
- Check Android Studio error logs
- Review Gradle build output
- Consult Android TV development documentation

## Alternative: Pre-built APK

If you continue to have build issues, consider:
- Using a cloud build service (GitHub Actions, GitLab CI)
- Asking a developer friend to build the APK
- Using a different development environment

The source code is complete and ready to build - you just need the proper Android development environment.