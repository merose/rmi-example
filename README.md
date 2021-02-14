# rmi-example
A simple Java RMI example that uses the Maven build system

## Using in Eclipse

Use _File_ > _Import..._ and then _Existing Maven Projects_ to import the project into Eclipse.

## Building with Maven

    mvn package

## Running

The server Java application is in the class `TaskServer`. The client is in the class `TaskClient`.
To start the server, either use _Run As_ and _Java Application_ within Eclipse, or build with Maven
and use this command line:

    java -cp target/rmi-example-1.0.0-SNAPSHOT.jar me.markrose.example.server.TaskServer

You can also start the client within Eclipse, or use this command line:

    java -cp target/rmi-example-1.0.0-SNAPSHOT.jar me.markrose.example.client.TaskClient

You can stop the server using control-C.