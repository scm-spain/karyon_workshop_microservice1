# ms-campaign-manager
Microservice to manage campaigns info

To start the development environment using docker:

![Docker](http://cdn.meme.am/instances/61590355.jpg)

##Using MAC:

```bash
$ boot2docker up
$ eval "$(boot2docker shellinit)"
$ docker-compose up
```

##Using Linux:

```bash
$ docker-compose up
```

##Using Windows:

```bash
boot2docker up
set DOCKER_HOST=tcp://192.168.59.103:2376
set DOCKER_CERT_PATH=C:\Users\daniel.ricart\.boot2docker\certs\boot2docker-vm
set DOCKER_TLS_VERIFY=1
docker run -p 8080:8080 -v /Users/Daniel.ricart/.gradle/:/root/.gradle/ IMAGE_DOCKER runApp
```

