# CaseTecnicoTarget
## Linguagem utilizada: Java ☕

### Respostas / Observações sobre cada questão: 
#### 1) Valor encontrado: 91
#### 2) Utilizei de recursividade para resolver a questão, aproveitei para aplicar o conceito em cima do Fibonacci.
#### 3)<br>- A Questão 3 pra mim foi a mais difícil, pois precesei trabalhar com JSON;<br>- Criei um arquivo do tipo JSON com ajuda de IA, presente na pasta util/arquivo.json<br> - Utilizei algumas dependências que adicionei manualmente ao projeto conforme a necessidade<br>- Foi necessário criar uma classe que comportasse a estrutura do arquivo JSON, mapear e configurar o mapper para trabalhar com estruturas do tipo date (encontrei um erro ao trocar a estrutura antes mapeada em String para LocalDate)<br><br>Observação: Na descrição da atividade o aviso destacado como IMPORTANTE: Podem existir dias sem faturamento, como nos finais de semana e feriado. Estes dias devem ser ignorados no calculo da média;
_Seguindo o raciocínio acima, os dias de faturamento que apresentam valor R$0.00 não foram levados em consideração ou seja contando finais de semanas e feriados do mês um por exemplo, restaram 22 dias de faturameto diferente de zero a conta se dá  **valorTotalMes/diasFaturamentoDiferenteZero**._
#### 4) Resposta:<br>SP :> 37,5%<br>RJ :> 20,3%<br>MG :> 16,2%<br>ES :> 15,0%<br>OUTROS :> 11,0%
#### 5)<br>- Inverti a String percorrendo as posições e concatenando de maneira manual utilizando de Character.toString(palavra.charAt(i)) e devolvendo o valor resultando a String original<br>- Em C essa inversão de String ficaria mais interessante por mecher com vetor

### Imagem do OutPut
![alt text](image.png)
🌵