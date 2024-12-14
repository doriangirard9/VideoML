# VideoML

## Requirements

- Java 17
- Maven
- Python 3
- ffmpeg

## Usage 

### Install dependencies

```bash
pip3 install -r requirements.txt
```

### By hand

Compile the ANTLR grammar :
```bash
mvn clean package
```

Run the compiler using the `exec` plugin:
```bash
mvn exec:java -Dexec.args="src/main/resources/test.videoml"
```

Run the python script to generate the video: (sources must be in the same directory as the script)
```bash
cd src/main/resources
python3 test.py
```

### Using the script

```bash
./run.sh test
```
