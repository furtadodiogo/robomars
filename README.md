# Mars Robot Project
[![Release Version](https://img.shields.io/github/release/diegosilva13/mars-robot.svg)](https://github.com/diegosilva13/mars-robot/tree/v2.2)
[![Build Status](https://travis-ci.org/diegosilva13/mars-robot.svg?branch=master)](https://travis-ci.org/diegosilva13/mars-robot)
[![codecov](https://codecov.io/gh/diegosilva13/mars-robot/branch/master/graph/badge.svg)](https://codecov.io/gh/diegosilva13/mars-robot)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a909853e988e408abde3faef88049776)](https://www.codacy.com/app/diegosilva13/mars-robot?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=diegosilva13/mars-robot&amp;utm_campaign=Badge_Grade)

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

## Aplicação
### Tecnologias

Para o desenvolvimento da aplicação foram utilizadas a seguinte stack:

* Java 8
* Maven

## Executando

### Via JAR

Primeiro vamos precisar executar o comanndo para que o maven baixe as dependencias necessárias para o projeto e faça o build da aplicação. Acesse a raiz do projeto e execute:

```sh
#/mars-robot/
$ mvn clean install
```
após finalizar acesse a pasta target e execute o **jar** gerado com o seguinte comando

```sh
#/mars-robot/target/
$  java -jar mars-robot-0.0.1-SNAPSHOT.jar
```

## Api Rest

O Foi disponibilizado o seguinte endpoint rest para possibilitar controlar o Robô:
```sh
$ POST http://localhost:8080/api/mars-robot/moveto/{command}
#Exemplo: http://localhost:8080/api/mars-robot/moveto/MML
```

#### Parâmetros
| Nome | Valor |
| ---- | ----- |
| `command` | Uma string simples, que pode conter as letras L, R e M. Exemplo: `MML` |

#### Respostas

| Código | Quando ocorre | Resposta |
| ---- | ----- | ----- |
| `200` | Quano o robô é movimentado com sucesso, sua posição é retornada | `(0,2,W)` |
| `400` | Quando passado um comando inválido | Um ou mais comandos informado estão inválido. |
| `400` | Quando o robô excede os limites da área configurada. | O robô excedeu os limites da área configurada. |
| `500` | Quando ocorre um erro inesperado no servidor | Ocorreu um erro inesperado, por favor entre em contato com o suporte técnico. |

