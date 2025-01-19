#!/bin/sh

# Check if the file name is provided
if [ -z "$1" ]; then
  echo "Error: No file name provided."
  echo "Usage: $0 <FILE_NAME> [build]"
  exit 1
fi

FILE_NAME=$1
BUILD=${2:-}

# Check if the file exists in the resources directory
if [ ! -f "src/main/resources/$FILE_NAME.videoml" ]; then
  echo "Error: File not found."
  exit 1
fi

# Check if tools are installed (Maven, Python3)
if ! command -v mvn &> /dev/null ; then
  echo "Error: Maven is not installed."
  exit 1
fi

if ! command -v python3 &> /dev/null ; then
  echo "Error: Python3 is not installed."
  exit 1
fi

# Run mvn clean package if '--build' argument is provided
if [ "$BUILD" = "--build" ]; then
  echo "Building the project..."
  if mvn clean package ; then
    echo "Build successful."
  else
    echo "Build failed."
    exit 1
  fi
else
  echo "Skipping build step. Use '--build' argument to trigger the build."
fi

# Execute the code with the given arguments
if mvn exec:java -Dexec.args="src/main/resources/$FILE_NAME.videoml" ; then
  echo "Code generation successful."
else
  echo "Code generation failed."
  exit 1
fi

# Execute the generated code
cd src/main/resources
if python3 "$FILE_NAME.py" ; then
  echo "Execution successful."
else
  echo "Execution failed."
  exit 1
fi
