#!/bin/bash

# Build Script for Igbo Gospel Message Android TV App
# This script builds the APK when the proper Android development environment is available

echo "🚀 Building Igbo Gospel Message Android TV App..."
echo "=================================================="

# Check if ANDROID_HOME is set
if [ -z "$ANDROID_HOME" ]; then
    echo "❌ Error: ANDROID_HOME environment variable is not set"
    echo "Please set ANDROID_HOME to your Android SDK location"
    echo "Example: export ANDROID_HOME=\$HOME/Android/Sdk"
    exit 1
fi

# Check if Android SDK exists
if [ ! -d "$ANDROID_HOME" ]; then
    echo "❌ Error: Android SDK not found at $ANDROID_HOME"
    echo "Please install Android SDK or set correct ANDROID_HOME path"
    exit 1
fi

echo "✅ Android SDK found at: $ANDROID_HOME"

# Make gradlew executable
chmod +x gradlew

# Clean previous builds
echo "🧹 Cleaning previous builds..."
./gradlew clean

# Build debug APK
echo "🔨 Building debug APK..."
./gradlew assembleDebug

if [ $? -eq 0 ]; then
    echo "✅ Debug APK built successfully!"
    echo "📱 Location: app/build/outputs/apk/debug/app-debug.apk"
    
    # Show APK info
    if [ -f "app/build/outputs/apk/debug/app-debug.apk" ]; then
        APK_SIZE=$(du -h "app/build/outputs/apk/debug/app-debug.apk" | cut -f1)
        echo "📊 APK Size: $APK_SIZE"
    fi
else
    echo "❌ Debug build failed!"
    exit 1
fi

# Build release APK
echo "🔨 Building release APK..."
./gradlew assembleRelease

if [ $? -eq 0 ]; then
    echo "✅ Release APK built successfully!"
    echo "📱 Location: app/build/outputs/apk/release/app-release.apk"
    
    # Show APK info
    if [ -f "app/build/outputs/apk/release/app-release.apk" ]; then
        APK_SIZE=$(du -h "app/build/outputs/apk/release/app-release.apk" | cut -f1)
        echo "📊 APK Size: $APK_SIZE"
    fi
else
    echo "❌ Release build failed!"
    echo "Note: Release builds may fail if signing is not configured"
fi

echo ""
echo "🎉 Build process completed!"
echo ""
echo "📋 Next steps:"
echo "1. Test the APK on an Android TV device or emulator"
echo "2. Upload the APK to a cloud service for distribution"
echo "3. Share the download link with your audience"
echo ""
echo "📚 For detailed instructions, see: build_instructions.md"
echo "📖 For project information, see: README.md"