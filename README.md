# api-support

Api para gerenciamento de inciddentes

## Pré-requisitos

1. [Git](https://git-scm.com/)

2. [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

3. [Maven](https://maven.apache.org/)

4. [Docker](https://docs.docker.com/engine/installation/)


Baixe o projeto do repositório
```
git clone https://github.com/renatodotlira/api-support.git
```

Execute o seguinte comando para acessar o diretório do projeto

```
cd api-support/
```

Execute o seguinte comando maven para buildar o projeto

```
mvn clean install
```

Execute o seguinte comando para criar a imagem docker

```
docker build -t api-support-image .
```
