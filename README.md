# Livraria de Filmes



Este repositório contem uma API RestFull desenvolvida como projeto de finalização do curso Web Development with Java Spring Framework. O projeto consiste em serviço de dados para uma locadora de filmes digitais, em uma versão simplificada, tendo em vista que o projeto foi realizado para finalizar o curso de java citado acima.    



## Diagrama das Entidades de Domínio



![alt text](/home/felipeamorim/Imagens/movie_library.png)



Apartir desse esquema de classes podemos entender como utilizar os endpoints da API para servir o frontend da aplicação. Os parâmetros ImageUrl e Url apontam para urls para acessar a imagem da capa e arquivo de vídeo, respectivamente, contudo, a fim de simplificar, foi direcionado para endereços fictícios, sobre tudo para o arquivo de vídeo. 



## Tecnologias utilizadas



A seguir, está discriminado as tecnologias que foram utilizadas nesse projeto:

* Java 11 com Spring Boot 2.5.7
* Lombok
* Spring Data Jpa
* Validação com Hibernate Validator
* Banco de dados H2 para testes
* Banco de dados PostgreSQL para produção
* Flyway
* Maven
* Postman - Para teste de endpoint
* PgAdmin 4 - Para gerenciar o banco de dados PostgreSQL



## Endpoints da API Rest



A seguir está descrito como utilizar a os dados do serviço atraves dos endpoints da camada de controle:

| Verbos Http                  | Descrição                                                    |
| ---------------------------- | ------------------------------------------------------------ |
| GET    /genres               | Acessa todos os gêneros de filmes                            |
| GET    /genres/{id}          | Acessa um gênero de filme por id                             |
| GET    /movies               | Acessa todos os filmes de forma paginada                     |
| GET    /movies/views         | Acessa todos os filmes com dados apenas para exibição em uma grade com vários filmes. |
| GET   /movies/{id}           | Recupera dados do filme através do seu id                    |
| POST   /movies/new           | Cadastra um novo filme ao catalogo                           |
| PUT   /movies//update/{id}   | Atualiza os dados sobre um filme apartir do seu id           |
| DELETE   /movies/delete/{id} | Deleta o filme correspondente ao id do catalogo.             |

**Obs:** Foi adotado o padrão DTO para transferência de dados e persistência no projeto. Assim, verificar na classe DTO correspondente quais os parâmetros são obrigatórios para realizar a persistência no banco de dados.



## Instalação 



Primeiramente, acesse o arquivo application-dev.properties para modificar o usuário e senha do banco de dados PostgreSQL. As informações contidas sobre esses campos são referentes ao meu usuário de teste local, desse modo, deve-se modificar esses campos e também no arquivo pom.xml nas tags de configuração do plugin flyway, responsável por realizar a migração dos dados para o banco na inicialização da aplicação. 

Após a configuração do banco de dados, podemos executar o comando, a seguir, para criar o arquivo executável da aplicação (.jar) a partir da pasta raiz do projeto pelo terminal:

```bash
mvn clean package
```

Após finalizar o processo de build, o arquivo .jar da aplicação estará na pasta target. Com esse arquivo basta executar o comando.

```bash
Java -jar [nome_do_arquivo.jar]
```

que a aplicação será inicializada em seu computador.

Outra forma de testar a aplicação é fazendo o importe do projeto para sua IDE favorita, modificando as configuração do banco de dados ditas anteriormente e inicializar a aplicação.

