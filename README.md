# Aplicativo de Previsão do Tempo
Sistema que faz a previsão do tempo por cidade. Essa aplicação permite buscar cidades pelo nome e código do país. 

Com isso a mesma irá fazer uma c


### Arquitetura back-end

O back-end da aplicação é um MVC clássico, porém possúi suas camadas modularizadas. Essa modularização entre as camadas permite que seja possível uma melhor divisão das dependências entre as camadas e uma coesão maior entre os recursos que estarão disponíveis em cada uma das camadas da aplicação. Outro ponto a se destacar é que dessa forma pode-se reaproveitar a camada de serviço para outros projetos com mais facilidade. 

Os modulos da Aplicação são:

* Controller - Camada responsável por gerenciar as requisições para o back-end
* Service - Camada de regras de negócio
* Repository - Camada reponsavém pela leitura e gravação dos dados
* Model - Camada dos objetos da aplicação


No back-end estão se usando as tecnologias:

* Spring Boot
* PostgresSQL
* Docker
* Flyway
* Swagger


### Arquitetura front-end

O front-end da aplicação é uma aplicação angular, onde se utiliza o Material para simplificação dos componentes.

### Execução back-end

Para executar o back-end deve-se seguir o fluxo abaixo:

### 1º) banco de dados

As configurações do application.yml referentes ao banco de dados solicitam:

 - Um servidor de banco de dados PostgresSQL rodando na porta `5432`
 - Um bamco de dados com o nome `previsao`
 - Um usuário com o nome `postgres` e senha `postgres`
 
 Caso não tenha um servidor PostgresSQL com essa configuração pode modificar o application.yml da aplicação.
 
 Porém no projeto também há um `docker-compose` que ao ser executado irá criar um servidor postgres com as informações destacas acima. 
 
 Para executar o docker-compose:
 
 baixe a imagem do posgres:
 
 > docker pull postgres
 
Entre na pasta `docker` que encontra-se dentro do projeto:

> cd docker

Execute o docker-compose:

> docker-compose up -d


### 2º) Build e execução da aplicação

Para buildar e executar o jar da aplicação execute os comando abaixo:

No pom principal da aplicação execute:

> mvn clean install

Entre na pasta de geração do jar da aplicação, ele fica em:

> cd controller/target/

Execute o jar principal da aplicação:

> java -jar controller-1.0-SNAPSHOT.jar 

Feito isso será executado o jar da aplicação e a mesma estará em plena execução.

OBS: Se atentar em ter o maven instalado e também do controle de permissões.


### Excucao front-end

Para executar o front-end da aplicação basta entrar na pasta `web` da aplicação, esta pasta contem a aplicação front-end em agular.

Entre em: 

>  cd web/previsao-web/

Execute:

> npm install

Execute: 

> npm start

Obs: é necesário do node instalado.
