## LDTS_709 - TRON

Vamos fazer o trabalho sobre o [Tron](https://en.wikipedia.org/wiki/Tron_(video_game)), um jogo em que dois jogadores controlam uma moto e deixam 1 rastro pela área de jogo. Se alguém tocar no rastro (incluindo o seu), perde.

Projeto desenvolvido por André Moreira Teixeira (up202108882@up.pt), Gonçalo Pinto (up202204943@fe.up.pt), Manuel Mo (up202205000@fe.up.pt) para LDTS 2023/2024.

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

### PLANNED FEATURES
- **Instructions** - Menu que explica como se joga o jogo e diz quais são os controlos para o conseguir jogar.

### UML CLASS DIAGRAM

A aplicação onde estavamos a criar o diagrama em UML não tinha setas como as "uni-directional" e, por isso, usamos triângulos para essas ligações (dá para perceber por ter um número ou * ao lado do mesmo).

![uml-tron.png](Images%2Fuml-tron.png)

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

### DESIGN

### ORGANIZAÇÃO DO CÓDIGO

**Problem in Context**

Quando estávamos a organizar o trabalho, percebemos que o código podia se tornar muito confuso sem uma boa estrutura.

**The Pattern**

Para resolver este problema nós usamos o MVC pattern. Este pattern separa o display do jogo e a sua forma de raciocinar.

**Implementation**

![mvc-pattern.png](images%2Fmvc-pattern.png)

(O código ainda não foi implementado).

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

(O código ainda não foi implementado).

**Consequences**

- Podemos fazer relações entre objetos enquanto o programa está a correr.

### CRIAÇÃO DE OBJETOS

**Problem in Context**

Quando queremos atualizar algum elemento, temos de usar funções de terceiros o que torna o código mais pesado e mais díficil de perceber. Além disso, é mais complexo criar testes unitários.

**The Pattern**

Para resolver este problema nós usamos o Factory pattern. Neste pattern definimos uma interface para criar objetos, deixando as subclasses decidir que classes são para serem inicializadas.

**Implementation**

![factory-pattern.png](images%2Ffactory-pattern.png)

(O código ainda não foi implementado).

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

(O código ainda não foi implementado).

**Consequences**

- Organiza o código de vários estados por classes.
- Torna mais fácil adicionar novos estados, não tendo a necessidade de mudar qualquer tipo de código.

#### KNOWN CODE SMELLS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%