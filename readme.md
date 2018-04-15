Encontrei alguns pontos que acredito estarem errados na especificação e nos testes:

Na parte do "Find distance between two towns" o correto seria :
{
  "distance" : 8,
  "path" : [ "A", "B", "C" ]
}
e não 
{
  "distance" : 3,
  "path" : ["A", "B", "C"]
}

Já que A->B = 6
B->C = 2.

No quarto caso de teste (Distance of route AEBCD: 22) o correto seria retornar -1 pois
na especificação está escrito "This endpoint should receive a directed graph and a ORDERED list", 
se a lista não está ordenada, como neste caso, não há caminho válido. 

No teste 6, "Routes starting at C and ending at C with a maximum of 3 stops": 
O 0 como distancia também é valido já que permanecer no nó original é um caminho válido já que:

"This endpoint should compute ALL available routes from ANY given pair of towns".

Por último, para o teste 7, mesmo o gráfo sendo direto, outros caminhos são possíveis, veja que por exemplo:
No caso do ABCDC, CDC é um caminho válido.

Segue o resultado:
{
  "routes" : [ {
    "route" : "ABC",
    "stops" : 2,
    "distancia" : 9.0
  }, {
    "route" : "ABCDC",
    "stops" : 4,
    "distancia" : 25.0
  }, {
    "route" : "ADC",
    "stops" : 2,
    "distancia" : 13.0
  }, {
    "route" : "ADEBC",
    "stops" : 4,
    "distancia" : 18.0
  }, {
    "route" : "ADCDC",
    "stops" : 4,
    "distancia" : 29.0
  }, {
    "route" : "AEBC",
    "stops" : 3,
    "distancia" : 14.0
  } ]
}