<div align="center">

# Minesweeper Game | Jogo do Campo Minado

<img width="auto" src="https://github.com/henriqueotogami/minesweeper/blob/master/img/minesweeper.png?raw=true">

<br>

<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/henriqueotogami/minesweeper">
<img src="https://img.shields.io/github/issues/henriqueotogami/minesweeper">
<img src="https://img.shields.io/github/forks/henriqueotogami/minesweeper">
<img src="https://img.shields.io/github/stars/henriqueotogami/minesweeper">
<img src="https://img.shields.io/github/license/henriqueotogami/minesweeper">

<br>

<a href="https://wakatime.com/badge/user/1e53636e-c916-4d50-9ce1-f3ac75a883e3/project/ec7309d4-59db-4349-8682-760dcba83ee5"><img src="https://wakatime.com/badge/user/1e53636e-c916-4d50-9ce1-f3ac75a883e3/project/ec7309d4-59db-4349-8682-760dcba83ee5.svg" alt="wakatime"></a>

</div>

<br>
<hr>

> Campo minado é um popular jogo de computador para um jogador. Foi inventado por Robert Donner em 1989 e tem como objetivo revelar um campo de minas sem que alguma seja detonada.

**Data:** 26/06/2022  
**Curso:** [Cod3r | Java 2022 Completo](https://www.udemy.com/course/fundamentos-de-programacao-com-java/)

---

## 📋 Sobre o Projeto

Este projeto é uma implementação do clássico **Campo Minado** em Java, desenvolvida como parte do curso de Java da Cod3r. O jogo está disponível em duas interfaces: **console** (via terminal/IDE) e **desktop** (Swing). A arquitetura utiliza o padrão **Observer** para comunicação entre modelo e visão, com tabuleiro configurável (linhas, colunas e quantidade de minas), abertura em cadeia de campos vazios e marcação de bandeiras.

---

## 📁 Estrutura do Projeto

### Modelo (`src/br/com/otogamidev/minesweeper/model/`)
- **GameBoard.java** — Tabuleiro do jogo: geração dos campos, vizinhança e sorteio das minas
- **BoardField.java** — Cada célula do tabuleiro: estado (aberto, minado, marcado) e vizinhos
- **BoardFieldObserver.java** — Interface de observador dos eventos do campo
- **BoardFieldEvents.java** — Enumeração dos eventos do campo
- **GameBoardEventsResult.java** — Resultado dos eventos do tabuleiro (vitória/explosão)

### Visão (`src/br/com/otogamidev/minesweeper/view/`)
- **GameBoardConsole.java** — Interface em modo texto (console)
- **GameBoardPanel.java** — Painel gráfico do tabuleiro (Swing)
- **GameBoardButton.java** — Botão que representa cada célula na interface gráfica
- **GameBoardObserver.java** — Interface de observador do tabuleiro
- **MainScreen.java** — Janela principal do aplicativo desktop (Swing)

### Controller (`src/br/com/otogamidev/minesweeper/controller/`)
- **ApplicationConsole.java** — Ponto de entrada para executar o jogo no console

### Exceções (`src/br/com/otogamidev/minesweeper/exception/`)
- **ExplosionException.java** — Lançada quando o jogador abre uma mina
- **ExitException.java** — Lançada para encerrar o jogo (ex.: sair pelo console)

### Testes (`test/br/com/otogamidev/minesweeper/`)
- **GameBoardTest.java** — Testes do tabuleiro
- **BoardFieldTest.java** — Testes do campo
- **GameBoardConsoleTest.java** — Testes da interface em console

---

## 📂 Estrutura do repositório

```
README.md
licence
minesweeper.iml
img/
  minesweeper.png
  Otogamidev-Minesweeper-Console.png
  Otogamidev-Minesweeper-Swing.png
src/br/com/otogamidev/minesweeper/
  controller/
    ApplicationConsole.java    # entrada do jogo no console
  exception/
    ExplosionException.java
    ExitException.java
  model/
    GameBoard.java             # tabuleiro e regras
    BoardField.java            # célula do tabuleiro
    BoardFieldObserver.java
    BoardFieldEvents.java
    GameBoardEventsResult.java
  view/
    GameBoardConsole.java      # interface console
    GameBoardPanel.java        # painel Swing
    GameBoardButton.java
    GameBoardObserver.java
    MainScreen.java            # janela desktop
    Temporary.java
test/br/com/otogamidev/minesweeper/
  model/
    GameBoardTest.java
    BoardFieldTest.java
  view/
    GameBoardConsoleTest.java
```

---

## 🛠️ Tecnologias Utilizadas

- **[Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)** — Linguagem e runtime
- **[JUnit 5.7.0](https://junit.org/junit5/docs/5.7.0/api/index.html)** — Testes unitários
- **Java Swing** — Interface gráfica desktop

> **Links úteis:** [Adicionando JUnit5 ao IntelliJ](https://stackoverflow.com/questions/42721368/including-junit-5-dependency-in-intellij-idea)

---

## 📝 Funcionalidades Principais

- **Dois modos de jogo:** console (terminal/IDE) e desktop (Swing)
- **Tabuleiro configurável:** linhas, colunas e número de minas
- **Abertura em cadeia:** ao abrir um campo sem minas vizinhas, os vizinhos seguros são abertos automaticamente
- **Marcação de bandeiras:** marcar células suspeitas de mina
- **Detecção de vitória/derrota:** fim de jogo ao abrir uma mina ou ao revelar todos os campos seguros
- **Padrão Observer:** modelo (tabuleiro/campo) notifica a visão sobre eventos

---

## 🚀 Como Compilar e Executar

### Pré-requisitos

- **JDK 11** instalado
- **IDE** (recomendado: IntelliJ IDEA) ou terminal com `javac`/`java` no PATH

### Executar via IDE (IntelliJ)

**Modo Console:**
- Classe principal: `br.com.otogamidev.minesweeper.controller.ApplicationConsole`
- Run/Debug dessa classe para jogar no console (tabuleiro 6x6 com 6 minas)

**Modo Desktop (Swing):**
- Classe principal: `br.com.otogamidev.minesweeper.view.MainScreen`
- Run/Debug dessa classe para abrir a janela do jogo (tabuleiro 16x30 com 50 minas)

### Executar via Terminal

```bash
# Compilar (a partir da raiz do projeto)
javac -d out src/br/com/otogamidev/minesweeper/**/*.java

# Modo Console
java -cp out br.com.otogamidev.minesweeper.controller.ApplicationConsole

# Modo Desktop
java -cp out br.com.otogamidev.minesweeper.view.MainScreen
```

### Executar testes

- No IntelliJ: clique com o botão direito na pasta `test` ou em uma classe de teste e escolha *Run Tests*
- Ou use a configuração de testes do JUnit 5 apontando para `test/` como test source root

---

## ⚙️ Como funciona

### Regras do jogo

1. O tabuleiro é uma grade de células; algumas contêm minas, outras não.
2. O jogador **abre** uma célula: se for mina, perde; se não for, aparece o número de minas nas 8 células vizinhas (ou nada se for 0).
3. Se o número for 0, o jogo abre automaticamente os vizinhos seguros (abertura em cadeia).
4. O jogador pode **marcar** células com bandeira para indicar suspeita de mina.
5. Vitória: todas as células sem mina foram abertas.

### Fluxo técnico (resumo)

- **GameBoard** cria os **BoardField**, define vizinhança e sorteia as minas.
- Cada **BoardField** notifica **BoardFieldObserver** (ex.: **GameBoard**) ao ser aberto ou marcado.
- **GameBoard** notifica **GameBoardObserver** (ex.: **GameBoardConsole** ou **GameBoardPanel**) com resultado (vitória, explosão, atualização).
- Console lê entrada do usuário (linha/coluna ou marcar) e envia comandos ao modelo; Swing reage a cliques nos **GameBoardButton** e atualiza o painel.

---

## Demonstração

### Printscreens

| Via Console IDE | Via Aplicativo Desktop |
| --------------- | ---------------------- |
| <img src="https://github.com/henriqueotogami/minesweeper/blob/master/img/Otogamidev-Minesweeper-Console.png?raw=true"> | <img src="https://github.com/henriqueotogami/minesweeper/blob/master/img/Otogamidev-Minesweeper-Swing.png?raw=true"> |

### GIFs / Vídeos

| Via Console IDE | Via Aplicativo Desktop |
| --------------- | ---------------------- |
| [![Watch the video](https://img.youtube.com/vi/sK4k7Olkqyg/maxresdefault.jpg)](https://youtu.be/sK4k7Olkqyg) | [![Watch the video](https://img.youtube.com/vi/lPeUcs8y0HM/maxresdefault.jpg)](https://youtu.be/lPeUcs8y0HM) |

---

## Ambiente de Desenvolvimento

- **Sistema operacional:** macOS Monterey — Versão 12.5
- **IDE:** IntelliJ IDEA Community Edition 2022.1

### Plugins sugeridos

- [Atom Material Icons](https://plugins.jetbrains.com/plugin/10044-atom-material-icons)
- [Codota AI Autocomplete for Java](https://plugins.jetbrains.com/plugin/7638-codota-ai-autocomplete-for-java-and-javascript)
- [GitToolBox](https://plugins.jetbrains.com/plugin/7499-gittoolbox)
- [Nyan Progress Bar](https://plugins.jetbrains.com/plugin/8575-nyan-progress-bar)
- [Rainbow Brackets](https://plugins.jetbrains.com/plugin/10080-rainbow-brackets)
- [Wakatime](https://wakatime.com)
- [Xcode-Dark Theme](https://plugins.jetbrains.com/plugin/13106-xcode-dark-theme)

---

## 📚 Conteúdos Abordados

- ✅ Orientação a objetos em Java (classes, encapsulamento, herança)
- ✅ Padrão Observer (observadores e notificação de eventos)
- ✅ Interface gráfica com Java Swing (JFrame, JPanel, botões)
- ✅ Entrada e saída em modo texto (Scanner, System.out)
- ✅ Tratamento de exceções (ExplosionException, ExitException)
- ✅ Testes unitários com JUnit 5
- ✅ Estruturas de dados (listas, vizinhança no tabuleiro)
- ✅ Lógica de jogo (tabuleiro, minas, abertura em cadeia, vitória/derrota)

---

## 📄 Licença

Este projeto está sob a licença indicada no arquivo [licence](licence) deste repositório.

---

## 📖 Referências

- [Cod3r | Java 2022 Completo](https://www.udemy.com/course/fundamentos-de-programacao-com-java/) — Curso em que o projeto foi desenvolvido
- Código-fonte em `src/br/com/otogamidev/minesweeper/` — Implementação do jogo e padrão Observer
- Testes em `test/br/com/otogamidev/minesweeper/` — Exemplos de testes com JUnit 5

---

## Contribuições

Qualquer ajuda para melhorar este repositório é bem-vinda.

1. Faça um **fork** do repositório: [https://github.com/henriqueotogami/minesweeper/fork](https://github.com/henriqueotogami/minesweeper/fork)
2. Crie um **branch** para sua alteração: `git checkout -b meu-novo-recurso`
3. Faça **commit**: `git commit -am 'Adicionando um novo recurso ...'`
4. Envie um **push**: `git push origin meu-novo-recurso`
5. Abra uma **Pull Request** neste repositório

Depois que sua PR for aceita e merged no branch principal, você pode excluir sua branch.

---

## 📝 Leia meus artigos

- [Artigos no Medium](https://medium.com/@henriqueotogami)
- [Artigos no Dev.to](https://dev.to/henriqueotogami)

## 💼 Conecte-se comigo

- [Perfil no LinkedIn](https://www.linkedin.com/in/henrique-matheus-alves-pereira)

## 🙏🏻 Apoie meu conteúdo

- [Compre-me um cafézinho | Buy me a coffee](https://ko-fi.com/henriqueotogami) ☕

---

<div align="center">

**Desenvolvido por HMAP | Henrique Matheus Alves Pereira** 🦁

*Muito obrigado, e que a força esteja com você.*

</div>

---

### Hashtags
#Java #Minesweeper #CampoMinado #Swing #ObserverPattern #JUnit #OpenSource #GitHub #Cod3r #GameDevelopment #DesktopApp #ConsoleApp

### Meta Keywords
```
Java, Campo Minado, Minesweeper, Swing, padrão Observer, JUnit 5, testes unitários,
interface gráfica, console, Cod3r, jogo, desenvolvimento de jogos, código aberto,
orientação a objetos, exceções, HMAP
```
