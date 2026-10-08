#!/bin/bash

# ==========================================
# CONFIGURATION
# You can change these variables as needed!
# ==========================================

# Replace this with your actual GitHub repository URL
REPO_URL="https://github.com/thedeadsheep-r/games-im-working-0n-java"

# The name of your primary branch (usually 'main')
BRANCH_NAME="main"

# ==========================================

if [ "$REPO_URL" = "https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git" ]; then
    echo "⚠️ ERROR: Please open this script and change REPO_URL to your actual GitHub link first!"
    exit 1
fi

echo "📝 Creating standard project files if they don't exist..."

if [ ! -f "README.md" ]; then
    echo "# My Project" > README.md
    echo "Created README.md"
fi

if [ ! -f "requirements.txt" ]; then
    touch requirements.txt
    echo "Created requirements.txt"
fi

if [ ! -f "LICENSE" ]; then
    cat << 'EOF' > LICENSE
MIT License

Copyright (c) $(date +%Y)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
EOF
    echo "Created MIT LICENSE"
fi

echo "🚀 Initializing new Git repository..."
git init

echo "📦 Staging all files..."
git add .

echo "💾 Committing files..."
git commit -m "Initial commit"

echo "🌿 Setting branch to '$BRANCH_NAME'..."
git branch -M "$BRANCH_NAME"

echo "🔗 Linking to GitHub repository..."
git remote add origin "$REPO_URL"

echo "⬆️ Pushing code to GitHub..."
git push -u origin "$BRANCH_NAME"

echo "✅ Done! Your project is now on GitHub."
