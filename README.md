## Problema
Um time de robôs devem ser colocados pela NASA para explorar um terreno em Marte.
Esse terreno, que é retangular, precisa ser navegado pelos robôs de tal forma que suas câmeras acopladas possam obter uma visão completa da região, enviando essas imagens novamente para a Terra.

A posição de cada robô é representada pela combinação de coordenadas cartesianas `(x, y)` e por uma letra, que pode representar uma das quatro orientações: `NORTH`, `SOUTH`, `EAST` e `WEST`. Para simplificar a navegação, a região “marciana” a ser explorada foi subdividia em sub-regiões retangulares.
Uma posição válida de um robô, seria `(0, 0, N)`, que significa que o robô está posicionado no canto esquerdo inferior do terreno, voltado para o Norte.
Para controlar cada robô, a NASA envia uma string simples, que pode conter as letras `L`, `R` e `M`. As letras `L` e `R` fazem o robô rotacionar em seu próprio eixo 90 graus para esquerda ou para direita, respectivamente, sem se mover da sua posição atual. A letra `M` faz o robô deslocar-se uma posição para frente.
Assuma que um robô se movimenta para o NORTE em relação ao eixo y. Ou seja, um passo para o NORTE da posição `(x,y)`, é a posição `(x, y+1)`
Exemplo: Se o robô está na posição `(0,0,N)`, o comando `MML` fará ele chegar na posição `(0,2,W)`.

### Requisitos do desafio

* O terreno deverá ser iniciado com `5x5` posições.
* O robô inicia na coordenada `(0,0,N)`.
* Deverá ser possível enviar um comando para o Robô que me retorne a posição final dele.
* O Robô não pode se movimentar para fora da área especificada.
* Não deve guardar estado do robô para consulta posterior.

## Executando

Primeiro vamos precisar executar o comanndo para que o maven baixe as dependencias necessárias para o projeto e faça o build da aplicação. Acesse a raiz do projeto e execute:

```sh
#/mars-robot/
$ mvn clean install
```
após finalizar acesse a pasta target e execute o **jar** gerado com o seguinte comando

```sh
#/mars-robot/target/
$  java -jar mars-robot-0.0.1-SNAPSHOT.jar