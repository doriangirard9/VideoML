#!/bin/sh

# Check if the file name is provided
if [ -z "$1" ]; then
  echo "Error: No file name provided."
  echo "Usage: $0 <FILE_NAME>"
  exit 1
fi

FILE_NAME=$1

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


# Compile ANTLR4 grammar
if mvn clean package ; then
  echo "Compilation successful."
else
  echo "Compilation failed."
  exit 1
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
if python3 $FILE_NAME.py ; then
  echo "Execution successful."
else
  echo "Execution failed."
  exit 1
fi