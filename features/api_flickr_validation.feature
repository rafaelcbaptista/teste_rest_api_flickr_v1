#Author: Rafael Costa Baptista
Feature: Validacao de chamadas da API - FLICKR

  Background: Configuracao do Endpoint 
    Given O Endpoint ja esta configurado

  @run
  Scenario: Entre com uma URI valida
    When Eu entro com uma URI valida "https://api.flickr.com/services/rest/?method=flickr.test.login&api_key=647c45c3407c255fcb5e418211b19bc5&format=json&nojsoncallback=1&auth_token=72157689941352871-fd6b0449e0431e00&api_sig=47811ff00201d598b539eb9e3d4e338f"
    Then Eu devo ter o status code "200"
    And O tipo do conteudo deve estar no formato "JSON"
    And O conteudo do body response deve ser igual a
      | key              | value                       |
      | stat             |                          ok |


  @run
  Scenario: Entre com uma URI invalida
    When Eu entro com uma URI invalida "https://api.flickr.com/services1"
    Then Eu devo ter o status code "404"
