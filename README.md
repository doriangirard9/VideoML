# VideoML

## Usage 

Compile the ANTLR grammar :
```bash
mvn clean package
```

Run the compiler using the `exec` plugin:
```bash
mvn exec:java -Dexec.args="src/main/resources/test.videoml"
```