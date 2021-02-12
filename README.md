# rmi-example
A simple Java RMI example that uses the Maven build system

## Using in Eclipse

Use _File_ > _Import..._ and then _Existing Maven Projects_ to import the project into Eclipse.

## Running

To start the server, either use _Run As_ and _Java Application_ within Eclipse, or use this
command line.

    java -cp target/classes me.markrose.example.TaskServer

Starting the client

    java -cp target/classes me.markrose.example.TaskClient
