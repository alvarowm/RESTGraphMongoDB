# Exemplo de servidor REST que provê funções sobre dados de grafos em JSON.

Utilizando Spring Boot como base, esse teste disponibiliza endpoints REST para se trabalhar com grafos que sistematizam o problema do caixeiro viajante:

https://pt.wikipedia.org/wiki/Problema_do_caixeiro-viajante

O grafo além de vértices e arestas possue pesos nas arestas, ligações entre os vértices ou nós.

Endpoints disponibilizados:

```
/graph
```

Salva um grafo no formato JSON em uma base MongoDB.

https://www.mongodb.com/

Exemplos de entrada:

```javascript
{
  "data":[
    { 
      "source": "X", "target": "Y", "distance":3
    },
    { 
      "source": "Y", "target": "Z", "distance":7
    ...
  ]
}
```

```
/graph/{id}
Recupera as informações de um gráfico pelo seu identificador.
```

```
/routes/from/{town1}/to/{town2}
Exibe as rotas entre dois pontos, possíveis conjuntos de arestas entre dois vértices.
```

```
/routes/{id}/from/{town1}/to/{town2}
Exibe as rotas entre dois pontos levando em consideração um número máximo de paradas.
```

```
/distance
Exibe a distância de um caminho.
```

```
/distance/{id}
Retorna a distância de listas de pontos ou vértices.
```

Exemplo de payload:
```javascript
{
  "path":["X", "Y"]
}
```

```
/distance/from/{town1}/to/{town2}
Distância entre dois pontos específicos.
```

```
/distance/{id}/from/{town1}/to/{town2}
Menor distância entre dois pontos específicos de um grafo já salvo.
```


Para a lógica dos gráficos são usadas as funções da biblioteca https://jgrapht.org/.

Elas são chamadas na classe GraphHelper:

https://github.com/alvarowm/RESTGraphMongoDB/blob/master/src/main/java/com/avenuecode/graphhelper/GraphHelper.java



