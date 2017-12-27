$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("api_flickr_validation.feature");
formatter.feature({
  "line": 2,
  "name": "Validar o Status Code da API Flickr",
  "description": "",
  "id": "validar-o-status-code-da-api-flickr",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "Configuracao do Endpoint",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Eu tenho o endpoint ativado",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 8,
  "name": "Verificar se o status retornado do HTTP eh 200",
  "description": "",
  "id": "validar-o-status-code-da-api-flickr;verificar-se-o-status-retornado-do-http-eh-200",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@run"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Eu acesso o servico /",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Eu devo recerber o status Code 200 como retorno",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});