#!/bin/sh

find_maven() {
  MAVEN_PATH=$(which mvn 2>/dev/null)
  if [ -x "$MAVEN_PATH" ]; then
    echo "$MAVEN_PATH"
    return
  fi

  COMMON_PATHS=(
    "/usr/bin/mvn"
    "/usr/local/bin/mvn"
    "$HOME/.m2/wrapper/maven-wrapper"
    "$HOME/apache-maven/bin/mvn"
    "/opt/maven/bin/mvn"
    "/opt/homebrew/bin/mvn"
  )

  for path in "${COMMON_PATHS[@]}"; do
    if [ -x "$path" ]; then
      echo "$path"
      return
    fi
  done

  echo ""
}

if [ -z "$1" ]; then
  echo "Error: No file name provided."
  echo "Usage: $0 <FILE_NAME>"
  exit 1
fi

FILE_NAME=$1

MAVEN_BIN=$(find_maven)

if [ -z "$MAVEN_BIN" ]; then
  echo "Error: Maven not found. Please ensure Maven is installed and available in your PATH."
  exit 1
fi

echo "Using Maven binary: $MAVEN_BIN"

if $MAVEN_BIN clean package; then
  echo "Compilation successful."
else
  echo "Compilation failed."
  exit 1
fi

if $MAVEN_BIN exec:java -Dexec.args="src/main/resources/$FILE_NAME.videoml"; then
  echo "Code generation successful."
else
  echo "Code generation failed."
  exit 1
fi

cd src/main/resources || exit

PYTHON_BIN=$(which python3)

if [ -z "$PYTHON_BIN" ]; then
  echo "Error: Python3 not found. Please ensure Python3 is installed and available in your PATH."
  exit 1
fi

echo "Using Python binary: $PYTHON_BIN"


if ! $PYTHON_BIN -c "import moviepy" 2>/dev/null; then
  echo "Error: The 'moviepy' package is not installed in the Python environment used by this script."

  echo "Trying to install 'moviepy' package..."
  $PYTHON_BIN -m pip install moviepy
  if [ $? -eq 0 ]; then
    echo "Installation successful."
  else
    echo "Installation failed."
    echo "Try installing it using: $PYTHON_BIN -m pip install moviepy"
    exit 1
  fi
fi

if $PYTHON_BIN "$FILE_NAME.py"; then
  echo "Execution successful."
else
  echo "Execution failed."
  exit 1
fi

exit 0