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

### Writing a video montage

Create a `.videoml` file in the `src/main/resources` folder. Add all the sources (videos, images, sounds...) to the same folder.

You can find examples in the `src/main/resources` folder or you can read the [documentation](DOCUMENTATION.md) to learn how to write a video montage using VideoML.

### Using the script

Run it with the scenario (an existing `.videoml` file in the `src/main/resources` folder) you want to test:

```bash
./run.sh fragmovie --build
```

The first time you run the script, you need to build the project with the `--build` flag. This will compile the ANTLR grammar and build the project.
After that, you can run the script without the `--build` flag.


### By hand

Compile the ANTLR grammar :
```bash
mvn clean package
```

Run the compiler using the `exec` plugin:
```bash
mvn exec:java -Dexec.args="src/main/resources/fragmovie.videoml"
```

Run the python script to generate the video:
```bash
cd src/main/resources
python3 fragmovie.py
```

