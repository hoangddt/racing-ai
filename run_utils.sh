#!/bin/bash

# With directoty hierarchy
# see dir_hier.txt file
echo "Compiling...."
javac -d bin/ -cp src src/RaceAI/AI/Main.java
echo "Compile Complete!"
echo "Running....."
# MainFrame contain entry point (main function)
java -cp bin RaceAI.AI.Main