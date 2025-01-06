#!/bin/sh

# Get the file to generate
if [ -z "$1" ]; then
  echo "Error: No file name provided."
  echo "Usage: $0 <FILE_NAME>"
  exit 1
fi

FILE_NAME=$1

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