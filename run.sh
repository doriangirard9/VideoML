#!/bin/sh

# Get the file to generate
if [ -z "$1" ]; then
  echo "Error: No file name provided."
  echo "Usage: $0 <FILE_NAME>"
  exit 1
fi

FILE_NAME=$1

# Compile ANTLR4 grammar
mvn clean package

# Execute the code with the given arguments
mvn exec:java -Dexec.args="src/main/resources/$FILE_NAME.videoml"

# Execute the generated code
cd src/main/resources
python $FILE_NAME.py