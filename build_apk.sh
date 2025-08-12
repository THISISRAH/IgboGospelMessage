#!/bin/bash

# Igbo Gospel Message TV App - Build Script
# This script helps build the Android TV app APK

echo "🎬 Igbo Gospel Message TV App - Build Script"
echo "=============================================="

# Check if we're in the right directory
if [ ! -f "build.gradle" ]; then
    echo "❌ Error: Please run this script from the project root directory"
    exit 1
fi

# Check Java version
echo "🔍 Checking Java version..."
java_version=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$java_version" -ge "17" ]; then
    echo "✅ Java $java_version found (compatible)"
else
    echo "❌ Java 17 or higher required. Found: $java_version"
    echo "💡 Install Java 17: sudo apt install openjdk-17-jdk"
    exit 1
fi

# Check if Gradle wrapper exists
if [ ! -f "gradlew" ]; then
    echo "❌ Error: Gradle wrapper not found"
    exit 1
fi

# Make gradlew executable
chmod +x gradlew

# Check Android SDK
echo "🔍 Checking Android SDK..."
if [ -z "$ANDROID_HOME" ]; then
    echo "⚠️  ANDROID_HOME not set. Trying to find Android SDK..."
    if [ -d "/usr/lib/android-sdk" ]; then
        export ANDROID_HOME="/usr/lib/android-sdk"
        echo "✅ Found Android SDK at: $ANDROID_HOME"
    else
        echo "❌ Android SDK not found. Please install it first."
        echo "💡 Install: sudo apt install android-sdk"
        exit 1
    fi
else
    echo "✅ Android SDK found at: $ANDROID_HOME"
fi

# Try to build
echo "🚀 Starting build process..."
echo "📱 Building debug APK..."

if ./gradlew assembleDebug; then
    echo ""
    echo "🎉 Build successful!"
    echo "📦 APK location: app/build/outputs/apk/debug/app-debug.apk"
    echo ""
    echo "📋 Next steps:"
    echo "1. Install the APK on your Android TV"
    echo "2. Enable 'Unknown Sources' in TV settings"
    echo "3. Customize with your channel content"
    echo ""
    echo "🔧 If you had build issues, see BUILD_INSTRUCTIONS.md"
else
    echo ""
    echo "❌ Build failed!"
    echo ""
    echo "🔧 Troubleshooting options:"
    echo "1. Use Android Studio (recommended):"
    echo "   - Download from: https://developer.android.com/studio"
    echo "   - Open project and build from GUI"
    echo ""
    echo "2. Check BUILD_INSTRUCTIONS.md for detailed help"
    echo ""
    echo "3. Common issues:"
    echo "   - Android SDK licenses not accepted"
    echo "   - Missing build tools"
    echo "   - Java version incompatibility"
fi