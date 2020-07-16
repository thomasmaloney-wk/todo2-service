# Todo2 Backend Java Service
A Java service inspired by the [todo-example-service](https://github.com/Workiva/todo-example-service)
from the LINK 2015 workshop.

## Running Locally
First you need to have Java set up.
The following lines should be added to your `.bashrc` or `.zshrc` profile:

```bash
# You can probably get away with using a different version of Java
# so long as it's within 1.8 <= version < 1.12 

$ export DEFAULT_JDK_VERSION=11.0.7
$ export JAVA_HOME=$(/usr/libexec/java_home -F -v "$DEFAULT_JDK_VERSION")
```

You'll also want to install Maven, which if you're on Mac you can just run:
```bash
$ brew install maven
```

One other thing you'll want if you don't have it already is `gnatsd` 
which you can install by running the following in your terminal:
```bash
$ brew install gnatsd
```

Then to start the service, just run the following in your terminal:
```bash
# from anywhere:
$ gnatsd

# in another terminal in the todo2-service directory:
$ make serve
```

Note that you'll need to have the `messaging-frontend` running
in order to actually send messages to and from this service.