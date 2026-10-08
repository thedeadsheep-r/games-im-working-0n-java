#!/bin/bash

# ==========================================
# CONFIGURATION
# You can change these variables as needed!
# ==========================================

# Default commit message if you don't provide one
DEFAULT_COMMIT_MESSAGE="Updated code"

# The name of your primary branch (usually 'main')
BRANCH_NAME="main"

# ==========================================

# If you run the script with a message like: ./github_update.sh "Fixed bug"
# it will use your message. Otherwise, it uses the DEFAULT_COMMIT_MESSAGE.
COMMIT_MESSAGE=${1:-$DEFAULT_COMMIT_MESSAGE}

echo "🔍 Checking for changed files..."
git status -s

echo "📦 Staging all changed files..."
git add .

echo "💾 Committing changes with message: '$COMMIT_MESSAGE'..."
git commit -m "$COMMIT_MESSAGE"

echo "⬆️ Pushing changes to GitHub branch '$BRANCH_NAME'..."
git push origin "$BRANCH_NAME"

echo "✅ Done! Your updates have been pushed to GitHub."
