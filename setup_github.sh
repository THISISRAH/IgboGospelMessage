#!/bin/bash

# GitHub Setup Script for Igbo Gospel Message Android App
# This script helps you set up your GitHub repository

echo "🚀 Setting up GitHub Repository for Igbo Gospel Message Android App"
echo "=================================================================="

# Check if git is installed
if ! command -v git &> /dev/null; then
    echo "❌ Git is not installed!"
    echo "Please install Git first:"
    echo "  - Windows: https://git-scm.com/download/win"
    echo "  - macOS: brew install git"
    echo "  - Linux: sudo apt-get install git"
    exit 1
fi

echo "✅ Git is installed"

# Check if git is initialized
if [ ! -d ".git" ]; then
    echo "📁 Initializing Git repository..."
    git init
    echo "✅ Git repository initialized"
else
    echo "✅ Git repository already exists"
fi

# Check if remote origin is set
if ! git remote get-url origin >/dev/null 2>&1; then
    echo ""
    echo "🌐 Setting up GitHub remote..."
    echo "Please enter your GitHub username:"
    read -p "GitHub Username: " github_username
    
    if [ -z "$github_username" ]; then
        echo "❌ Username cannot be empty!"
        exit 1
    fi
    
    echo "Please enter your repository name (or press Enter for 'igbo-gospel-message-app'):"
    read -p "Repository Name: " repo_name
    
    if [ -z "$repo_name" ]; then
        repo_name="igbo-gospel-message-app"
    fi
    
    remote_url="https://github.com/$github_username/$repo_name.git"
    
    echo "Adding remote origin: $remote_url"
    git remote add origin "$remote_url"
    
    echo "✅ Remote origin set to: $remote_url"
else
    echo "✅ Remote origin already set:"
    git remote get-url origin
fi

# Check current branch
current_branch=$(git branch --show-current)
echo "📍 Current branch: $current_branch"

# If not on main branch, create and switch to it
if [ "$current_branch" != "main" ]; then
    echo "🔄 Creating and switching to main branch..."
    git checkout -b main
    echo "✅ Now on main branch"
fi

# Show git status
echo ""
echo "📊 Current Git status:"
git status --short

# Ask user what to do next
echo ""
echo "🎯 What would you like to do next?"
echo "1. Add all files and commit"
echo "2. Push to GitHub (if already committed)"
echo "3. Just show status"
echo "4. Exit"

read -p "Enter your choice (1-4): " choice

case $choice in
    1)
        echo ""
        echo "📁 Adding all files..."
        git add .
        
        echo "💾 Committing changes..."
        git commit -m "Initial commit: Igbo Gospel Message Android App

- Professional mobile-optimized interface
- Featured video section with latest content
- Complete video playlist
- Friday notifications for new uploads
- Modern Material Design 3 interface
- GitHub Actions workflow for automatic builds"
        
        echo "✅ Files committed successfully!"
        echo ""
        echo "🚀 Ready to push to GitHub!"
        echo "Run: ./github_push.sh"
        ;;
    2)
        echo ""
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
        else
            echo ""
            echo "❌ Push failed!"
            echo "Please check your git configuration and try again."
        fi
        ;;
    3)
        echo ""
        echo "📊 Git status:"
        git status
        ;;
    4)
        echo "👋 Goodbye!"
        exit 0
        ;;
    *)
        echo "❌ Invalid choice. Please run the script again."
        exit 1
        ;;
esac

echo ""
echo "📚 Next steps:"
echo "1. Check the 'Actions' tab in your GitHub repository"
echo "2. Wait for the build to complete"
echo "3. Download the APK from build artifacts"
echo "4. Create a release with tag 'v1.0.0'"
echo ""
echo "📖 For detailed instructions, see: GITHUB_SETUP.md"
echo "🚀 To push changes later, run: ./github_push.sh"