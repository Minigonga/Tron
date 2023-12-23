## LDTS_709 - TRON

Vamos fazer o trabalho sobre o [Tron](https://en.wikipedia.org/wiki/Tron_(video_game)), um jogo em que dois jogadores controlam uma moto e deixam 1 rastro pela área de jogo. Se alguém tocar no rastro (incluindo o seu), perde.

Projeto desenvolvido por André Moreira Teixeira (up202108882@up.pt), Gonçalo Pinto (up202204943@fe.up.pt), Manuel Mo (up202205000@fe.up.pt) para LDTS 2023/2024. 

Ao colocar o projeto no repositório de submissão, as branches desapareceram. No entanto, estas estão visíveis no repositório onde o projeto foi desenvolvido.
[Repositório onde o projeto foi criado com as branches](https://github.com/Minigonga/Tron).

### IMPLEMENTED FEATURES

- **Screen** - Abrir o terminal onde vai decorrer o jogo.
- **Display** - Dar display ao quadro onde que vai ter as duas motos e os seus rastros e as paredes sempre atualizados.
- **Movimento** - Os dois jogadores vão se mover na direção e sentido da última tecla que pressionaram para se movimentar.
- **Rastro** - As motos vão deixar 1 rastro para trás enquanto se movem.
- **Colisão** - Um jogador que toque em algum dos dois rastros ou na parede vai morrer e assim acabar por perder o jogo.
- **Salto** - Um jogador pode saltar evitando assim um rastro à sua frente.
- **Menu** - Quando inciar o programa aparece o menu que vai ter como opções (Start, instructions e Exit).
- **Score** - Mostra as partidas ganhas por cada jogador por exemplo (P1 2-3 P2).
- **ScoreBoard** - Retângulo ao lado da arena para pode ver os jogos ganhos e os boosts restantes dos jogadores.
- **Boost** - Um jogador pode andar numa velocidade mais rápida durante um curto período de tempo.
- **RandomSpawner** - Os jogadores nascem em posições aleatórias, mas simétricas ao mesmo tempo para ninguém ter vantagem.
- **Instructions** - Menu que explica como se joga o jogo e diz quais são os controlos para o conseguir jogar.

### UML CLASS DIAGRAM

A aplicação onde estavamos a criar o diagrama em UML não tinha setas como as "uni-directional" e, por isso, usamos triângulos para essas ligações (dá para perceber por ter um número ou * ao lado do mesmo).

![uml-tron.png](Images%2Fuml-tron.png)

UML criado pelo IDE.

![uml-intellij.png](images%2Fuml-intellij.png)

### MOCKUPS

Menu:

![menu.png](images%2Fmenu.png)

Instructions menu:

![instructions-menu.png](images%2Finstructions-menu.png)

Tela do jogo:

![game1.png](images%2Fgame1.png)

Salto da moto:

![game2.png](images%2Fgame2.png)

Boost da moto:

![game3.png](images%2Fgame3.png)

### DESIGN PATTERNS

### ORGANIZAÇÃO DO CÓDIGO

**Problem in Context**

Quando estávamos a organizar o trabalho, percebemos que o código podia se tornar muito confuso sem uma boa estrutura.

**The Pattern**

Para resolver este problema nós usamos o MVC pattern. Este pattern separa o display do jogo e a sua forma de raciocinar.

**Implementation**

![mvc-pattern.png](images%2Fmvc-pattern.png)

- [Controller](https://github.com/FEUP-LDTS-2023/project-l07gr09/tree/master/src/main/java/org/l07g09/controller)
- [Model](https://github.com/FEUP-LDTS-2023/project-l07gr09/tree/master/src/main/java/org/l07g09/model)
- [View](https://github.com/FEUP-LDTS-2023/project-l07gr09/tree/master/src/main/java/org/l07g09/viewer)

**Consequences**

- Torna o código simples de ler, ajudando-nos a descobrir erros, ao logo do desenvolvimento do jogo, bem como corrigi-los.
- Mais fácil de ajustar o código, se quisermos mudar um novo controlo, podemos facilmente atualizar o Controller.
- Se quisermos adicionar uma feature, isso será mais fácil, uma vez que o código vai estar bem organizado. Se for adicionar, por exemplo, um controlo é só criar um novo Controller.

### INPUTS

**Problem in Context**

Nós precisavamos de avisar os objetos de que se leu um input, para poderem agir.

**The Pattern**

Para resolver este problema nós usamos o Observer pattern, pattern este que avisa vários objetos sobre algo que tenha ocorrido.

**Implementation**

![observer-pattern.png](images%2Fobserver-pattern.png)

- [KeyListener(GUI)](https://github.com/FEUP-LDTS-2023/project-l07gr09/tree/master/src/main/java/org/l07g09/gui)
- [PlayersController](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/game/PlayersController.java)
- [GameController](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/game/GameController.java)
- [ArenaController](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/game/ArenaController.java)
- [InstructionsController](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/menu/InstructionsController.java)
- [MenuController](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/menu/MenuController.java)

**Consequences**

- Podemos fazer relações entre objetos enquanto o programa está a correr.

### CRIAÇÃO DE OBJETOS

Acabamos por não usar o pattern. Em vez disso criamos o ArenaBuilder que cria todos os elementos contidos no jogo.

**Consequences**

- Podemos adicionar algo ao código sem ter de mudar o que já temos/tínhamos.
- Os objetos são criados numa classe específica e são separadamente atualizados.
- Faz com que o código seja mais fácil de atualizar.

### ESTADOS DO PROGRAMA

**Problem in Context**

Ao desenvolver o nosso jogo, percebemos que iria haver uma grande quantidade de estados em que o nosso programa poderia encontrar e, por isso, estávamos com algumas dificuldades em mudar o estado do nosso programa.

**The Pattern**

Para resolver este problema nós usamos o State pattern. Com ele conseguimos separar todos os estados em classes individuais, implementando mais facilmente os seus métodos.

**Implementation**

![state-pattern.png](images%2Fstate-pattern.png)

- [State](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/states/State.java)
- [Controller](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/Controller.java)
- [GameController](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/game/GameController.java)
- [PlayersController](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/game/PlayersController.java)
- [ArenaController](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/game/ArenaController.java)
- [InstructionsController](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/menu/InstructionsController.java)
- [MenuController](https://github.com/FEUP-LDTS-2023/project-l07gr09/blob/master/src/main/java/org/l07g09/controller/menu/MenuController.java)

Acabamos por não agrupar o MenuController e o InstructionsController como tinhamos planeado inicialmente.

**Consequences**

- Organiza o código de vários estados por classes.
- Torna mais fácil adicionar novos estados, não tendo a necessidade de mudar qualquer tipo de código.
- 
#### KNOWN CODE SMELLS

Possuímos a classe Instructions.java (em org.l07g09.model.menu.Instructions) sem nenhum conteúdo.
![instructions_model.png](images%2Finstructions_model.png)

### TESTING

Test coverage report:

![coverage.png](images%2Fcoverage.png)

Pitest

### SELF-EVALUATION

O trabalho foi realizado de forma equilibrada, no sentido de distribuição por colegas de trabalho. A maior parte do projeto foi feito por chamada, via online. Um ficava encarregue na parte de colocar os códigos e na sua organização, enquanto outros dois desenvolviam programas para mandar a esse colega. Sendo assim, este possui mais _commits_ realizados, contudo, não foi tudo feito por si.
Havia alguns momentos em que não daria para fazer chamada por divergência de horários disponíveis. Neste caso, os colegas que estavam livres avançavam no projeto e deixavam algumas tarefas para os que não estavam disponíves no momento.

Andre Teixeira: 33.33%
Gonçalo Pinto: 33.33%
Manuel Mo: 33.33%