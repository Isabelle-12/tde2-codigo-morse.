<div align="center">

# 📡 Código Morse com Árvore Binária de Busca

### TDE 2 · Listas Não-Lineares: Código Morse

![Java](https://img.shields.io/badge/Java-24-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-21-1F6FEB?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

![Entrega](https://img.shields.io/badge/📅_Entrega-06%2F11%2F2026-DC2626?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-em_desenvolvimento-F59E0B?style=for-the-badge)
![PUCPR](https://img.shields.io/badge/PUCPR-Engenharia_de_Software-8B1A3A?style=for-the-badge)

</div>

---

> [!IMPORTANT]
> 📅 **Data de entrega: 06/11/2026 (sexta-feira)**
> Entrega pelo link do repositório no GitHub (público) ou pelo projeto compactado no Canvas.

---

## 📑 Índice

- [📋 Ficha do projeto](#-ficha-do-projeto)
- [💡 Sobre o projeto](#-sobre-o-projeto)
- [👥 Integrantes](#-integrantes)
- [🎯 O que o trabalho precisa entregar](#-o-que-o-trabalho-precisa-entregar)
- [🚀 Como rodar na sua máquina](#-como-rodar-na-sua-máquina)
- [🗂️ Estrutura do projeto](#️-estrutura-do-projeto)
- [📍 Onde cada um modifica](#-onde-cada-um-modifica)
- [🧩 Divisão de tarefas](#-divisão-de-tarefas)
- [🔀 Fluxo de trabalho com Git](#-fluxo-de-trabalho-com-git-pelo-intellij)
- [✍️ Padrão de código](#️-padrão-de-código)
- [✅ Checklist de entrega](#-checklist-de-entrega)
- [🏷️ Tags](#️-tags)
- [🙌 Créditos](#-créditos)

---

## 📋 Ficha do projeto

| | |
|---|---|
| 🏫 **Instituição** | PUCPR – Grupo Marista |
| 🎓 **Curso** | Bacharelado em Engenharia de Software |
| 📚 **Disciplina** | Resolução de Problemas Estruturados em Computação |
| 👩‍🏫 **Professora** | Lisiane Reips |
| 👥 **Grupo** | 4 integrantes (confirmado com a professora) |
| 📅 **Entrega** | **06/11/2026** |
| 🛠️ **Tecnologias** | Java 24 · JavaFX · Maven · JUnit 5 |

---

## 💡 Sobre o projeto

O programa armazena o alfabeto Morse em uma **árvore binária de busca**:

> **ponto (`.`) vai para a esquerda** · **traço (`-`) vai para a direita**

A partir dela, o programa:

- 🔤 **codifica** texto em Morse
- 🔡 **decodifica** Morse em texto
- 🌳 **desenha** a árvore na tela
- 🔊 **toca o som** dos sinais (ponto extra)

### Exemplo: os primeiros níveis da árvore

```
                 (raiz)
          . /               \ -
           E                 T
       . /   \ -         . /   \ -
        I     A           N     M
```

Em cada linha, `. /` é o caminho para a **esquerda** e `\ -` o caminho para a **direita**.  
Para chegar ao **A** (`.-`): raiz → esquerda (`.`) até o **E** → direita (`-`) até o **A**.

---

## 👥 Integrantes

| # | Nome | Usuário no GitHub | Parte |
|---|------|-------------------|-------|
| 1 | Gabriela | gabiistp | 🌱 Núcleo da árvore |
| 2 | Isabelle | Isabelle-12 | 🔁 Codificar e decodificar |
| 3 | Pedro | pedrobrecher | 🖥️ Interface JavaFX |
| 4 | Laura | lauraneris | 🔊 Som e testes |

---

## 🎯 O que o trabalho precisa entregar

| Requisito | Pontos |
|-----------|:------:|
| Inserção dos caracteres conforme a heurística do Morse (ponto à esquerda, traço à direita) | **3** |
| Decodificar uma sequência fornecida pelo usuário e mostrar o resultado | **2** |
| Codificar/decodificar (o item aparece repetido no PDF; implementamos os dois sentidos) | **2** |
| Imprimir a árvore de forma clara (código base já fornecido) | **1,5** |
| Código modularizado em classes e funções, nomes claros, camelCase | **1,5** |
| ⭐ **Extra:** som | **+1** |

---

## 🚀 Como rodar na sua máquina

### 📦 O que instalar

- ☕ **JDK 24** (a versão está no `pom.xml`, na propriedade `maven.compiler.release`)
- 💻 **IntelliJ IDEA** (a Community serve)
- 🔧 **Git**
- 🐙 Conta no **GitHub**, com o convite de colaborador aceito

> [!NOTE]
> Não precisa instalar o JavaFX: o Maven baixa sozinho.

### 🪜 Passo a passo (IntelliJ)

1. Abra o IntelliJ e vá em **File → New → Project from Version Control** (ou **Get from VCS**, na tela inicial).
2. Escolha **Git**, cole a URL do repositório e clique em **Clone**.
3. Se perguntar, clique em **Trust Project**.
4. Espere o Maven importar as dependências (barra de progresso no canto inferior). Se aparecer o ícone do **"m" com setinha** no editor, clique nele.
5. Vá em **File → Project Structure → Project** e confira se o **SDK** e o **Language level** estão em **24**.
6. Abra `src/main/java/br/pucpr/codigomorse/TreeVisualizer.java`, clique com o botão direito e escolha **Run 'TreeVisualizer.main()'**.
7. Deve abrir uma janela com a árvore. Se abriu, está tudo certo! 🎉

### ⌨️ Alternativa pelo terminal

Na pasta do projeto:

```
mvnw.cmd javafx:run      (Windows)
./mvnw javafx:run        (Linux/macOS)
```

### 🛠️ Problemas comuns

| Mensagem | Causa e solução |
|----------|-----------------|
| `modules are not supported in -source 8` | O `pom.xml` está compilando em Java 8. Confira se **não existe** `<source>8</source>`/`<target>8</target>` no `maven-compiler-plugin` e se `maven.compiler.release` está em 24. Depois recarregue o Maven. |
| `cannot find symbol` / pacote `javafx` não encontrado | O Maven ainda não importou. Clique no "m" com setinha ou *botão direito no `pom.xml` → Maven → Reload project*. |
| `JavaFX runtime components are missing` | Rode pelo IntelliJ (Run) ou por `mvnw javafx:run`, não pelo `java` direto. Confira se o `module-info.java` existe. |
| SDK diferente do `pom.xml` | Ajuste em **File → Project Structure → Project → SDK**. |
| Push recusado | Verifique se aceitou o convite de colaborador e se está empurrando **para a sua branch**, não para a `main`. |

---

## 🗂️ Estrutura do projeto

```
src/main/java/br/pucpr/codigomorse/
├── Node.java              # nó da árvore (pronto no esqueleto)
├── MorseAlphabet.java     # [Gabriela] tabela letra → código Morse
├── MorseBST.java          # [Gabriela] insert · [Isabelle] encode/decode
├── TreeDrawer.java        # [Pedro, opcional] desenho da árvore no Canvas
├── MorseSoundPlayer.java  # [Laura] bipes curtos e longos
└── TreeVisualizer.java    # [Pedro] janela JavaFX (interface) e main
src/main/java/module-info.java       # requires javafx.controls, java.desktop
src/test/java/br/pucpr/codigomorse/  # [Laura] testes JUnit
```

O código base da professora trazia `Node` e `MorseBST` dentro do `TreeVisualizer`. A **Etapa 0** (abaixo) separa tudo em arquivos para cada pessoa trabalhar sem conflito.

### 🔣 Convenção de entrada e saída

- Letras do Morse separadas por **espaço**; palavras separadas por **`/`**.
  Exemplos: `... --- ...` ou `.... . .-.. .-.. --- / .-- --- .-. .-.. -..`
- A raiz da árvore não tem letra (usamos `' '`).
- Letras maiúsculas; ignorar ou avisar sobre caracteres sem código.

### 📜 Contratos entre as partes

Todos programam contra estas assinaturas, para trabalhar em paralelo.

**`MorseBST`** (Gabriela e Isabelle):

```java
public MorseBST()
public Node getRoot()
public void insert(char letter, String morseCode)
public char decodeLetter(String morseCode)     // ".-"  -> 'A'
public String encodeLetter(char letter)        // 'A'   -> ".-"
public String decodeMessage(String morse)      // ".- -..." -> "AB"
public String encodeMessage(String text)       // "AB"  -> ".- -..."
public int getHeight()
```

**`MorseSoundPlayer`** (Laura):

```java
public void playMorse(String morseCode)        // ".- -... / .-.." -> toca o som
```

---

## 📍 Onde cada um modifica

Cada arquivo tem um **responsável**, e os pontos exatos de trabalho estão marcados no código com comentários `TODO (Nome)`.
No IntelliJ, abra a aba **TODO** (barra inferior ou **View → Tool Windows → TODO**) para ver todos eles.

| Arquivo | Quem mexe | O que fazer lá |
|---------|-----------|----------------|
| `MorseAlphabet.java` | 🌱 **Gabriela** | Preencher o mapa de `getAlphabet()` com A–Z (e números) e seus códigos Morse |
| `MorseBST.java` → `insert` | 🌱 **Gabriela** | Inserir cada letra: `.` para a esquerda e `-` para a direita |
| `MorseBST.java` → `decodeLetter`, `encodeLetter`, `decodeMessage`, `encodeMessage` | 🔁 **Isabelle** | Codificar e decodificar letras e mensagens, tratando entradas inválidas |
| `TreeVisualizer.java` → `start()` | 🖥️ **Pedro** | Campo de texto, botões, área de resultado e `ScrollPane` com o canvas |
| `TreeDrawer.java` | 🖥️ **Pedro** (opcional) | Só se quiser melhorar o desenho (cores, tamanho, espaçamento) |
| `MorseSoundPlayer.java` → `playMorse` | 🔊 **Laura** | Gerar e tocar os bipes em thread separada |
| `src/test/java/br/pucpr/codigomorse/` | 🔊 **Laura** | Testes JUnit (por exemplo, `MorseBSTTest.java`) |
| `Node.java` | — | Pronto no esqueleto. Só altere avisando o grupo |
| `pom.xml`, `module-info.java` | — | Não mexer sem avisar o grupo |

> [!WARNING]
> `MorseBST.java` é o **único arquivo dividido por duas pessoas** (Gabriela e Isabelle). Para evitar conflito:
> - Cada uma mexe **só nos seus métodos**, sem reorganizar nem renomear o resto do arquivo.
> - A Gabriela entra primeiro na `main`. Antes de abrir o Pull Request, a Isabelle traz a `main` para a sua branch (no menu de branches, clique em `origin/main` → **Merge into Current**).
> - Se aparecer conflito, resolvam juntas na janela de merge do IntelliJ.

---

## 🧩 Divisão de tarefas

### 🏁 Etapa 0 – Esqueleto (Isabelle, antes de todos)

- [X] Criar os arquivos da estrutura acima (`Node`, `MorseAlphabet`, `MorseBST`, `TreeDrawer`, `MorseSoundPlayer`), mover o desenho para `TreeDrawer` e enxugar o `TreeVisualizer`
- [X] Declarar os métodos dos contratos (podem retornar valores provisórios)
- [X] Marcar em cada arquivo, com comentários `TODO (Nome)`, o ponto onde cada pessoa vai trabalhar
- [X] Conferir que o projeto compila e roda, e dar push na `main`
- [X] Avisar o grupo. **Só depois disso os outros começam.**

### 🌱 Gabriela – Núcleo da árvore (3 pontos)

📁 **Onde mexer:** `MorseAlphabet.java` e o método `insert` de `MorseBST.java`  
🌿 **Branch sugerida:** `feature/insert`

- [X] `MorseAlphabet.getAlphabet()`: preencher o mapa com A–Z (e números, se quiserem)
- [X] `MorseBST.insert`: percorrer o código; `.` vai para a esquerda e `-` para a direita; criar os nós intermediários vazios; colocar a letra no último nó
- [X] Conferir se a árvore desenhada bate com a tabela Morse (o `fillTree` do `TreeVisualizer` já lê o `MorseAlphabet` e chama o `insert`, então não precisa mexer lá)
- [X] Se o `Node` precisar de algum ajuste, avisar o grupo antes

### 🔁 Isabelle – Codificar e decodificar (2 + 2 pontos)

📁 **Onde mexer:** métodos `decodeLetter`, `encodeLetter`, `decodeMessage` e `encodeMessage` de `MorseBST.java`  
🌿 **Branch sugerida:** `feature/encode-decode`

- [X] `decodeLetter`: seguir o caminho da raiz até o nó
- [X] `decodeMessage`: separar letras por espaço e palavras por `/`
- [X] `encodeLetter`: buscar a letra na árvore e montar o caminho (`.`/`-`)
- [X] `encodeMessage`
- [X] Tratar entrada inválida (símbolo desconhecido, caractere sem código, texto vazio)

### 🖥️ Pedro – Interface JavaFX (1,5 ponto)

📁 **Onde mexer:** `TreeVisualizer.java` (método `start()`); `TreeDrawer.java` só se quiser melhorar o desenho  
🌿 **Branch sugerida:** `feature/interface`

- [ ] Campo de texto para o usuário digitar
- [ ] Botões **Codificar**, **Decodificar** e **Tocar som** (ligado à parte da Laura)
- [ ] Área de resultado na tela
- [ ] Canvas da árvore dentro de um `ScrollPane` (a árvore fica larga)
- [ ] Mensagens de erro amigáveis

### 🔊 Laura – Som e testes (+1 ponto e 1,5 ponto)

📁 **Onde mexer:** `MorseSoundPlayer.java` (método `playMorse`) e a pasta `src/test/java/br/pucpr/codigomorse/`  
🌿 **Branch sugerida:** `feature/som`

- [ ] `MorseSoundPlayer` com `javax.sound.sampled`: tom de ~600 Hz, ponto curto, traço longo, pausas entre letras e palavras
- [ ] Tocar em **thread separada**, para a janela não travar
- [ ] Testes JUnit (já estão no `pom.xml`) para `insert`, `decode` e `encode`
- [ ] Revisar nomes e camelCase em todo o código

### 🔗 Ordem e dependências

```
Etapa 0 (Isabelle) ──► Gabriela (insert) ──► Isabelle (decode/encode)
        │                                              │
        ├──────────► Pedro (interface) ◄───────────────┤
        └──────────► Laura (som, testes) ◄─────────────┘
```

Enquanto o `insert` não estiver pronto, Isabelle, Pedro e Laura programam contra o contrato e testam com a árvore montada à mão.

---

## 🔀 Fluxo de trabalho com Git (pelo IntelliJ)

> [!IMPORTANT]
> **Regra de ouro:** ninguém dá push direto na `main`. Cada pessoa trabalha na sua branch e entra na `main` por Pull Request.

1. **Atualizar antes de começar:** **Git → Update Project** (ou `Ctrl+T`).
2. **Criar sua branch:** clique no nome da branch (barra de cima) → **New Branch...**. Nomes sugeridos: `feature/insert`, `feature/encode-decode`, `feature/interface`, `feature/som`.
3. **Commits pequenos e frequentes:** janela **Commit** (`Ctrl+K`), mensagem curta dizendo o que mudou.
4. **Enviar:** **Git → Push** (`Ctrl+Shift+K`).
5. **Abrir o Pull Request** no GitHub (aparece o botão *Compare & pull request*).
6. **Revisão cruzada:** outra pessoa do grupo lê e aprova antes do merge.
   Sugestão: Gabriela revisa Isabelle → Isabelle revisa Pedro → Pedro revisa Laura → Laura revisa Gabriela.
7. Depois do merge, todos fazem **Update Project** na `main` e atualizam suas branches.

> [!TIP]
> Para evitar conflitos, cada pessoa mexe só nos **arquivos da sua parte** (veja [Onde cada um modifica](#-onde-cada-um-modifica)). Se precisar alterar um arquivo de outra pessoa, avise o grupo antes.

---

## ✍️ Padrão de código

- Nomes de métodos e variáveis em **camelCase** e que expliquem o que fazem (`decodeMessage`, não `dm`)
- Classes em **PascalCase** (`MorseBST`)
- Um arquivo por classe
- Métodos curtos, com uma responsabilidade cada
- Comentários só onde ajudarem a entender o porquê

---

## ✅ Checklist de entrega

- [ ] Projeto compila e roda em todas as máquinas do grupo
- [ ] Inserção funcionando e árvore desenhada corretamente
- [ ] Decodificar e codificar funcionando, com entrada inválida tratada
- [ ] Som funcionando
- [ ] Código modularizado, com camelCase
- [ ] README completo, com os nomes dos integrantes
- [ ] Repositório **público**
- [ ] Link entregue no Canvas até **06/11/2026**

---

## 🏷️ Tags

`java` `javafx` `maven` `intellij-idea` `junit5` `binary-search-tree` `arvore-binaria-de-busca` `morse-code` `codigo-morse` `data-structures` `estruturas-de-dados` `listas-nao-lineares` `pucpr` `engenharia-de-software` `trabalho-academico`

---

## 🙌 Créditos

### 👥 Equipe

| | Integrante | Contribuição |
|:-:|------------|--------------|
| 🌱 | **Gabriela** | Núcleo da árvore: `Node`, alfabeto e inserção |
| 🔁 | **Isabelle** | Esqueleto do projeto, codificação e decodificação |
| 🖥️ | **Pedro** | Interface JavaFX |
| 🔊 | **Laura** | Som e testes |

### 🏫 Contexto acadêmico

- **Professora:** Lisiane Reips
- **Disciplina:** Resolução de Problemas Estruturados em Computação
- **Curso:** Bacharelado em Engenharia de Software · PUCPR – Grupo Marista

### 📚 Referências

- Código base do desenho da árvore (`TreeVisualizer.java`) fornecido pela professora Lisiane Reips
- [Documentação do JavaFX](https://openjfx.io/openjfx-docs/)

<div align="center">

Feito com ☕ e 💙 pelos alunos de Engenharia de Software da PUCPR · 2026

</div>
