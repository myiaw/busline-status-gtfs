#!/bin/bash

# Compile
javac -d out -cp src/main/java src/main/java/org/example/*.java

# Run the application with all arguments
java -cp out org.example.Main "$@"
