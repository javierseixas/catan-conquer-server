# Catan Conquer Server

API with Stark Framework.

## Installation

### Clone the repository

Clone repository as usual.

### Compile

```bash
$ ./gradlew installApp
```

### Dockerize it!

```bash
$ docker run -it -v /your/path/to/catan-conquer-server:/code -p 4566:4567 --name="spark" netflixoss/java:8 "/code/build/install/catan-conquer-server/bin/catan-conquer-server"
```