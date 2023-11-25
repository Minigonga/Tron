## LDTS_709 - TRON

Vamos fazer o trabalho sobre o [Tron](https://en.wikipedia.org/wiki/Tron_(video_game)), um jogo em que dois jogadores controlam uma moto e deixam 1 rastro pela área de jogo. Se alguém tocar no rastro (incluindo o seu), perde.

Projeto desenvolvido por André Moreira Teixeira (up202108882@up.pt), Gonçalo Pinto (up202204943@fe.up.pt), Manuel Mo (up202205000@fe.up.pt) para LDTS 2023/2024.

### IMPLEMENTED FEATURES

- **Screen** - Abrir o terminal onde vai decorrer o jogo.
- **Display** - Dar display ao quadro onde que vai ter as duas motos e os seus rastros e as paredes sempre atualizados.
- **Movimento** - Os dois jogadores vão se mover na direção e sentido da última tecla que pressionaram para se movimentar.
- **Rastro** - As motos vão deixar 1 rastro para trás enquanto se movem.
- **Colisão** - Um jogador que toque em algum dos dois rastros ou na parede vai morrer e assim acabar por perder o jogo.
- **Boost** - Um jogador pode andar numa velocidade mais rápida durante um curto período de tempo.

### PLANNED FEATURES

- **Salto** - Um jogador pode saltar evitando assim um rastro à sua frente.
- **Score** - Mostra as partidas ganhas por cada jogador por exemplo (P1 2-3 P2).
- **Menu** - Quando inciar o programa aparece o menu que vai ter como opções (Start game, instructions e Exit game).
- **Timer** - Durante o jogo aparece há quanto tempo o jogo está a decorrer.

### UML CLASS DIAGRAM

![uml-tron.png](Images%2Fuml-tron.png)

### DESIGN


#### ELEMENT

**Problem in Context**

Temos várias classes que têm variáveis e funções iguais (Wall, Player, Trail).

**The Pattern**

Criamos uma classe abstrata "Element" que engloba essas três classes.

**Implementation**

A seguinte imagem mostra como está criada a classe "Element".

![element.png](Images%2Felement.png)

As proximas imagens mostram como ficaram as subclasses.

![wall.png](Images%2Fwall.png)
![player.png](Images%2Fplayer.png)
![trail.png](Images%2Ftrail.png)

**Consequences**

Mais fácil para alguém que não escreveu o código de entendê-lo, uma vez que fica mais simples com a classe abstrata.

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