#!/bin/bash

# Compile
javac -d out -cp src/main/java src/main/java/org/example/*.java

# Running the application
java -cp out org.example.Main "$@"
