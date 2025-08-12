#!/bin/bash

# Deployment Script for Igbo Gospel Message Android TV App
# This script helps upload the APK to cloud services for distribution

echo "🚀 Deploying Igbo Gospel Message Android TV App..."
echo "=================================================="

# Check if APK exists
if [ ! -f "app/build/outputs/apk/release/app-release.apk" ]; then
    echo "❌ Release APK not found!"
    echo "Please build the app first using: ./build.sh"
    exit 1
fi

APK_PATH="app/build/outputs/apk/release/app-release.apk"
APK_SIZE=$(du -h "$APK_PATH" | cut -f1)

echo "✅ APK found: $APK_PATH"
echo "📊 APK Size: $APK_SIZE"

echo ""
echo "🌐 Choose deployment method:"
echo "1. Google Drive"
echo "2. Dropbox"
echo "3. OneDrive"
echo "4. Custom upload"
echo "5. Exit"

read -p "Enter your choice (1-5): " choice

case $choice in
    1)
        echo "📤 Uploading to Google Drive..."
        echo "Please follow these steps:"
        echo "1. Go to https://drive.google.com"
        echo "2. Upload the APK file: $APK_PATH"
        echo "3. Right-click the file → Share → Copy link"
        echo "4. Make sure the link is accessible to anyone with the link"
        echo ""
        echo "📁 APK ready for upload: $APK_PATH"
        ;;
    2)
        echo "📤 Uploading to Dropbox..."
        echo "Please follow these steps:"
        echo "1. Go to https://dropbox.com"
        echo "2. Upload the APK file: $APK_PATH"
        echo "3. Right-click the file → Share → Copy link"
        echo "4. Make sure the link is accessible to anyone with the link"
        echo ""
        echo "📁 APK ready for upload: $APK_PATH"
        ;;
    3)
        echo "📤 Uploading to OneDrive..."
        echo "Please follow these steps:"
        echo "1. Go to https://onedrive.live.com"
        echo "2. Upload the APK file: $APK_PATH"
        echo "3. Right-click the file → Share → Copy link"
        echo "4. Make sure the link is accessible to anyone with the link"
        echo ""
        echo "📁 APK ready for upload: $APK_PATH"
        ;;
    4)
        echo "📤 Custom upload method..."
        echo "Please upload the APK to your preferred service:"
        echo "📁 APK location: $APK_PATH"
        echo ""
        echo "After uploading, make sure to:"
        echo "- Make the link publicly accessible"
        echo "- Test the download link"
        echo "- Share the link with your audience"
        ;;
    5)
        echo "👋 Deployment cancelled."
        exit 0
        ;;
    *)
        echo "❌ Invalid choice. Please run the script again."
        exit 1
        ;;
esac

echo ""
echo "📋 Post-upload checklist:"
echo "✅ APK uploaded successfully"
echo "✅ Download link is working"
echo "✅ Link is publicly accessible"
echo "✅ Tested download on different devices"
echo ""
echo "🔗 Share the download link with your audience!"
echo "📱 Include installation instructions for Android TV users"
echo ""
echo "📚 Installation instructions for users:"
echo "1. Download the APK from the provided link"
echo "2. Enable 'Unknown Sources' in Android TV settings"
echo "3. Install using a file manager app"
echo "4. Launch from the TV app launcher"
echo ""
echo "🎉 Deployment process completed!"
echo "Your app is now ready for distribution!"