# Catan Conquer Server

API with Stark Framework.

## Compile

```bash
gradle installApp
```

## Dockerize it!

```bash
docker run -it -v /your/path/to/catan-conquer-server:/code -p 4566:4567 --name="spark" netflixoss/java:8 "/code/build/install/catan-conquer-server/bin/catan-conquer-server"
```