
# Desafio Infuse Tecnologia

Projeto para resolução do teste técnico para vaga Desenvolvedor Full Stack Java da empresa Infuse Tecnologia.

As intruções para a implementação do Projeto:

- [Documentação Teste](https://docs.google.com/document/d/1gQUPZIgcua4qDxEAVek2e_VPV8jO6_qceP9xEb90wd0/edit?tab=t.0)

## 🛠️ Stack utilizada

- **Front-end:** Angular 17, Scss

- **Back-end:** Java 17, Spring Boot 3+, PostgresSQL

- **Testes:** JUnit, Mockito

- **Conteinerização:** Docker, Docker Compose



## 🔧 Instalação

Clone o repositório na maquina local:

```bash
git clone https://github.com/nfdeveloper/DesafioInfuseTecnologia.git
```

Após a clonagem da aplicação a duas formas de roda-lá na maquina local:

- ### [Docker](#docker) 

- ### <a name=“docker”><a/> Utilizando Docker e Docker Compose

    Acesse a pasta da Aplicação:

    ```bash
    cd ./DesafioInfuseTecnologia/
    ```

    Execute o comando:

    ```bash
    docker compose up
    ```

    A aplicação será acessada através da URL:

    ```bash
    http://localhost:4200
    ```
    

- ### Sem Utilizar Docker

- #### Front End

    Acesse a pasta da aplicação Front End:

    ```bash
    cd ./DesafioInfuseTecnologia/consuta-creditos-ui/
    ```

    Execute o comando para instalar as dependências do Node:

    ```bash
    npm install
    ```

    Após esses passos o projeto front end poderá ser executado com o seguinte comando:

    ```bash
    ng s
    ```

    A aplicação será acessada através da URL:

    ```bash
    http://localhost:4200
    ```
    
- #### Back End

    Acesse a pasta da aplicação Front End:

    ```bash
    cd ./DesafioInfuseTecnologia/consulta-creditos-api/
    ```

    Execute o comando para instalar as dependências do Maven:

    ```bash
    mvn install
    ```

    - **OBS:** Para a instalação do projeto na máquina local, é necessário que o banco de dados Postgres v13+ esteja previamente instalado, e que dentro do mesmo haja um banco de dados com o nome postgres. Pois a aplicação usa o Flyway como ferramente para gerenciamento de migrações. Sendo assim, na primeira execução da aplicação a mesma criará dentro deste banco a tabela necessário assim como irá inserir alguns dados.

    Após esses passos basta executar o comando: 

    ```bash
    mvn spring-boot:run
    ```
