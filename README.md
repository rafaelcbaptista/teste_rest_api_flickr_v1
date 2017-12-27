# Estrutura do Projeto
- Linguagem de Programa��o: JAVA
- IDE: Eclipse
- Projeto Maven para rodar o programa
- Adicionadas as depend�cias no pom.xml 
- Utilizado Cucumber para gerenciar BDD e Rest-assured para chamar o web-service REST
- Adicionado json-schema-validator para validar o formato da resposta JSON
- Criados os cen�rios de testes no arquivo TestesAPI_Junit.java para serem excutados pelo Junit

## BDD (Feature file / Step definition)
- Criados os cen�rios no feature file api_flickr_validation.feature 
- Criados os passos a serem executados no arquivo  FlickrValidationSteps.java
- Criada a classe de execu��o do Cucumber no arquivo RunnerCucumber.java

## REST API 
- Utilizado REST Assured library para testar REST API
- Utilizado o plugin do browser chrome REST Console
- Testes executados na API do FLICKR https://www.flickr.com/services/api/

## Verifica��o do Json
Teste da resposta contendo os dados do JSON.

- Request Url: https://api.flickr.com/services/rest/?method=flickr.test.login&api_key=1a6c20cf1910df63f885f4a0a88d1a92&format=json&nojsoncallback=1&auth_token=72157691541022555-d465e67bd0ecc0fd&api_sig=c7eb835125438c62ba01447f1a06cb12
- Request Method: GET
- Request Accept: */*
- Request Connection: keep-alive
- Request Content-Type: application/xml
- Resposta Status Code: 200
- Response Body:
{
    "user": {
        "id": "158345347@N08",
        "username": {
            "_content": "valida_api"
        },
        "path_alias": null
    },
    "stat": "ok"
}
- Status Code: 200 OK

## Resquet not found 
- Request URL: https://api.flickr.com/services1
- Request Method: GET
- Response Body:
 P�gina n�o encontrada

- Status Code: 404 Not Found

## Valida��o do JSON schema
- Verificado que o formato do JSON e o seu conte�do est�o corretos. Criado um arquivo json (json-schema.json) em src//test/resources.


