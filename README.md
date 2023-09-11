# SSI-SDK JNA Java Bindings

This repo creates a Client.java that can use code from the SSI-SDK

## Getting Started


### Generating C Bindings from Go

To create the C bindings from the Go code, use the following command:

```bash
go build -o ssi.so -buildmode=c-shared main.go
```

This command compiles the Go code in main.go into a shared object file named ssi.so, which can be used as C bindings.

### Compiling the Java Client
To compile the Client.java code with the jna.jar dependency, use:
```bash
javac -cp jna.jar Client.java
```

This command compiles the Java code in Client.java using the Java Native Access (JNA) library provided in jna.jar.

### Running the Java Client
To run the compiled Java client, which loads the Go C bindings with the help of the JNA library, use:
```bash
java -cp .:jna.jar Client
```

This command runs the Client class, ensuring that both the current directory (for ssi.so) and the jna.jar are in the classpath.