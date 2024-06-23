HashMap Project

This project implements a HashMap data structure in Java and provides a simple command-line interface to interact with it. The instructions below will guide you through setting up and running the project.
Setup and Installation

    Download the Project Files
        Download the HashMap.zip file from the provided source.

    Extract the Files
        Extract the HashMap.zip file to a directory of your choice.

    Open the Command Line
        On Linux, you can open the terminal using Ctrl+Alt+T.

    Navigate to the Project Directory
        Use the cd command to navigate to the directory where you extracted the files.
                        
            cd path/to/extracted/files

Build the Project

    Run the following Maven command to clean and package the project. This command is a combination of two Maven commands:

                   mvn clean package

Navigate to the Target Directory

    After the build is complete, navigate to the newly created target directory:

                 cd target

Run the Program

    Run the program using the following command:


        java -jar HashMap-Hash.jar

    Start the Program
        Once the program is running, you can start interacting with it by typing the path to the .txt file you want to process and pressing Enter.

Tips for Running the Program

    Absolute Path for Multiple Root Directories
        If your system has multiple root directories (common in Windows), make sure to type the absolute path of the file. On Linux, there is only one root directory (/).

    File Format
        The application can only read .txt files. Ensure the file you are trying to process is in .txt format.

    Performance Improvement
        Typing the absolute path of the file can significantly improve the speed of the program.

    File Extension
        Remember to manually include the .txt extension after the file name. For example, if the file name is tryhard.txt, you should enter:

        name -> tryhard
        extension -> .txt

HashMap Overview

A HashMap is a data structure that implements an associative array abstract data type, a structure that can map keys to values. It is part of the Java Collections Framework and provides the following features:

    Key-Value Pair Storage: Stores data in key-value pairs, allowing efficient retrieval of values based on their associated keys.
    Constant-Time Performance: Provides average constant-time performance for the basic operations (get and put), assuming the hash function disperses the elements properly among the buckets.
    Null Keys and Values: Allows one null key and multiple null values.
    Non-Synchronized: The HashMap class is not synchronized. If multiple threads access a hash map concurrently, and at least one of the threads modifies the map structurally, it must be synchronized externally.

Key Methods in HashMap

    put(K key, V value): Associates the specified value with the specified key in the map.
    get(Object key): Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
    remove(Object key): Removes the mapping for a key from this map if it is present.
    containsKey(Object key): Returns true if this map contains a mapping for the specified key.
    size(): Returns the number of key-value mappings in the map.

The HashMap implemented in this project provides these basic functionalities and can be tested using the provided command-line interface.
Conclusion

This project demonstrates the implementation and usage of a HashMap data structure in Java. Follow the setup instructions to build and run the project, and use the provided tips for optimal performance. Feel free to explore and modify the code to enhance its functionality or adapt it to your needs. Happy coding
