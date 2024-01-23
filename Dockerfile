# Usar uma imagem base do OpenJDK 17
FROM ubuntu:latest

# Instalar OpenJDK 17
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk wget  && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Definir a variável JAVA_HOME
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64

# Definir variável de ambiente para armazenar a porta padrão da aplicação
ENV PORT 8080

ENV ENV_JAVA_OPTS "-Xmx512m -Xms256m"

# Expor a porta que a aplicação usará
EXPOSE $PORT

# Definir diretório de trabalho no container
WORKDIR /app

RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'


# Copiar o artefato de construção (jar) para o diretório de trabalho no container
# Substitua 'sua-aplicacao.jar' pelo nome do seu arquivo jar
COPY ./target/*.jar /app/app.jar

# Definir comando de execução usando ENTRYPOINT
# Substitua 'sua-aplicacao.jar' pelo nome do seu arquivo jar
ENTRYPOINT exec java ${ENV_JAVA_OPTS} -Ddatadog.slf4j.simpleLogger.logFile=System.out -Ddatadog.slf4j.simpleLogger.dateTimeFormat=yyyy-MM-dd'T'HH:mm:ss.SSS -XX:FlightRecorderOptions=stackdepth=256 -javaagent:./dd-java-agent.jar -jar app.jar