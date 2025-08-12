# Build Instructions for Igbo Gospel Message Android App

## Prerequisites

Before building the APK, ensure you have the following installed:

1. **Android Studio** (latest version)
2. **Android SDK** (API 21-34)
3. **Java Development Kit (JDK)** 8 or higher
4. **Gradle** (will be downloaded automatically)

## Environment Setup

### 1. Install Android Studio
- Download from: https://developer.android.com/studio
- Install and launch Android Studio
- Complete the initial setup wizard

### 2. Install Android SDK
- Open Android Studio
- Go to Tools → SDK Manager
- Install the following:
  - Android SDK Platform 21 (Android 5.0)
  - Android SDK Platform 34 (Android 14)
  - Android SDK Build-Tools (latest)
  - Android SDK Platform-Tools

### 3. Set Environment Variables
```bash
# Linux/macOS
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools

# Windows
set ANDROID_HOME=C:\Users\YourUsername\AppData\Local\Android\Sdk
set PATH=%PATH%;%ANDROID_HOME%\tools;%ANDROID_HOME%\platform-tools
```

## Building the APK

### Method 1: Using Android Studio (Recommended)

1. **Open the Project**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the project folder and select it
   - Wait for Gradle sync to complete

2. **Build the APK**
   - Go to Build → Build Bundle(s) / APK(s) → Build APK(s)
   - Wait for the build to complete
   - The APK will be located in: `app/build/outputs/apk/debug/app-debug.apk`

3. **Build Release APK**
   - Go to Build → Generate Signed Bundle / APK
   - Select APK
   - Create a new keystore or use existing one
   - Choose release build variant
   - The APK will be in: `app/build/outputs/apk/release/app-release.apk`

### Method 2: Using Command Line

1. **Navigate to Project Directory**
   ```bash
   cd /path/to/igbo-gospel-message-app
   ```

2. **Build Debug APK**
   ```bash
   ./gradlew assembleDebug
   ```

3. **Build Release APK**
   ```bash
   ./gradlew assembleRelease
   ```

4. **Clean Build**
   ```bash
   ./gradlew clean assembleRelease
   ```

## APK Location

After successful build, the APK files will be located at:

- **Debug APK**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release APK**: `app/build/outputs/apk/release/app-release.apk`

## Troubleshooting

### Common Issues

1. **SDK Location Not Found**
   - Ensure ANDROID_HOME is set correctly
   - Check that Android SDK is installed
   - Verify local.properties file has correct sdk.dir path

2. **Gradle Sync Failed**
   - Check internet connection
   - Clear Gradle cache: `./gradlew clean`
   - Invalidate caches in Android Studio: File → Invalidate Caches

3. **Build Errors**
   - Check that all dependencies are available
   - Ensure minimum SDK version is supported
   - Verify that all required files are present

4. **Permission Denied on gradlew**
   - Make gradlew executable: `chmod +x gradlew`

### Build Verification

After building, verify the APK:

1. **Check APK Size**: Should be reasonable (typically 10-50 MB)
2. **Verify Contents**: Use APK analyzer in Android Studio
3. **Test Installation**: Install on Android phone or emulator

## Testing the APK

### On Android Phone

1. **Enable Unknown Sources**
   - Go to Settings → Security → Unknown sources
   - Enable for your browser or file manager

2. **Install APK**
   - Copy APK to device (USB, network, or cloud)
   - Use file manager or browser to install
   - Follow installation prompts

3. **Launch App**
   - Find app in phone app launcher
   - Launch and test functionality

### On Emulator

1. **Create Phone Emulator**
   - In Android Studio: Tools → AVD Manager
   - Create new virtual device
   - Select Phone category
   - Choose appropriate API level

2. **Install and Test**
   - Drag APK onto emulator
   - Or use: `adb install app-debug.apk`
   - Launch and test all features

## Distribution

### For End Users

1. **Upload to Cloud Service**
   - Google Drive, Dropbox, or similar
   - Make link publicly accessible
   - Provide clear installation instructions

2. **Alternative Distribution**
   - USB drive installation
   - Network file sharing
   - Direct download from website

### For Developers

1. **Version Control**
   - Tag releases with version numbers
   - Document changes in CHANGELOG
   - Maintain separate branches for features

2. **Continuous Integration**
   - Set up automated builds
   - Run tests before release
   - Generate signed APKs automatically

## Security Considerations

1. **APK Signing**
   - Always sign release APKs
   - Keep keystore secure
   - Use strong passwords

2. **Permissions**
   - Review requested permissions
   - Only request necessary permissions
   - Document permission usage

## Performance Optimization

1. **APK Size**
   - Enable ProGuard for release builds
   - Use vector drawables where possible
   - Optimize image resources

2. **Build Speed**
   - Enable Gradle daemon
   - Use parallel builds
   - Configure appropriate memory settings

---

**Note**: This app is specifically designed for Android phones and tablets and requires the standard Android SDK for proper functionality.