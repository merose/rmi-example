# rmi-example
A simple Java RMI example that uses the Maven build system

## Using in Eclipse

Use _File_ > _Import..._ and then _Existing Maven Projects_ to import the project into Eclipse.

## Building with Maven

    mvn package

## Running

To start the server, either use _Run As_ and _Java Application_ within Eclipse. Or build with Maven
and use this command line.

    java -cp target/rmi-example-1.0.0-SNAPSHOT.jar me.markrose.example.TaskServer

To start the client

    java -cp target/rmi-example-1.0.0-SNAPSHOT.jar me.markrose.example.TaskClient

You can stop the server using control-C.