#!/bin/bash

# GitHub Push Script for Igbo Gospel Message Android App
# This script helps you push your project to GitHub

echo "🚀 Pushing Igbo Gospel Message Android App to GitHub..."
echo "======================================================"

# Check if git is initialized
if [ ! -d ".git" ]; then
    echo "❌ Git repository not initialized!"
    echo "Please run: git init"
    exit 1
fi

# Check if remote origin is set
if ! git remote get-url origin >/dev/null 2>&1; then
    echo "❌ No remote origin found!"
    echo ""
    echo "Please set your GitHub repository URL:"
    echo "git remote add origin https://github.com/YOUR_USERNAME/igbo-gospel-message-app.git"
    echo ""
    echo "Replace YOUR_USERNAME with your actual GitHub username"
    exit 1
fi

# Show current remote
echo "📍 Current remote origin:"
git remote get-url origin
echo ""

# Check git status
echo "📊 Git status:"
git status --short
echo ""

# Ask user to confirm
read -p "Do you want to continue with push? (y/n): " confirm

if [ "$confirm" != "y" ] && [ "$confirm" != "Y" ]; then
    echo "👋 Push cancelled."
    exit 0
fi

# Add all files
echo "📁 Adding all files..."
git add .

# Commit changes
echo "💾 Committing changes..."
git commit -m "Update Igbo Gospel Message Android App

- Professional mobile-optimized interface
- Featured video section with latest content
- Complete video playlist
- Friday notifications for new uploads
- Modern Material Design 3 interface
- GitHub Actions workflow for automatic builds"

# Push to GitHub
echo "🚀 Pushing to GitHub..."
git push origin main

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Successfully pushed to GitHub!"
    echo ""
    echo "🎉 What happens next:"
    echo "1. GitHub Actions will automatically build your APK"
    echo "2. Check the 'Actions' tab in your repository"
    echo "3. Download the built APK from build artifacts"
    echo "4. Create a release with tag 'v1.0.0' for distribution"
    echo ""
    echo "📱 To create a release:"
    echo "1. Go to your repository on GitHub"
    echo "2. Click 'Releases' → 'Create a new release'"
    echo "3. Tag: v1.0.0"
    echo "4. GitHub Actions will build and attach the APK automatically!"
    echo ""
    echo "📚 For detailed instructions, see: GITHUB_SETUP.md"
else
    echo ""
    echo "❌ Push failed!"
    echo "Please check your git configuration and try again."
    echo ""
    echo "Common issues:"
    echo "- Authentication: Check your GitHub credentials"
    echo "- Branch name: Ensure you're on 'main' branch"
    echo "- Permissions: Verify you have write access to the repository"
fi