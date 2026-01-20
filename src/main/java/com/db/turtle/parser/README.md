# Arquitetura do Parser SQL

Este documento descreve a arquitetura do parser SQL adotado no projeto. A proposta segue princípios de **separação de responsabilidades**, **baixo acoplamento** e **alta coesão**, alinhados com práticas utilizadas em engines de banco de dados e compiladores modernos. O objetivo é garantir clareza conceitual, facilidade de evolução e previsibilidade técnica.

---

## Visão Geral

O parser é estruturado em **três camadas bem definidas**, cada uma com um papel claro dentro do pipeline de processamento de uma query SQL:

1. **ANTLR (Lexer + Parser)** — Camada sintática
2. **AST (Abstract Syntax Tree / Modelo Semântico)** — Camada conceitual
3. **AST Builder (Visitor)** — Camada de transformação

Essa divisão evita que regras de negócio vazem para a gramática e impede que o restante do sistema dependa diretamente do ANTLR.

---

## 1. ANTLR (Lexer + Parser)

### Responsabilidade

Esta camada é responsável **exclusivamente por compreender a gramática do SQL**. Ela transforma texto bruto em uma **Parse Tree**, sem qualquer interpretação semântica ou lógica de execução.

Em termos corporativos: o ANTLR atua como o **contrato sintático** do sistema.

### Componentes

- **Lexer**  
  Converte o texto da query em tokens (palavras-chave, identificadores, literais, operadores etc).

- **Parser**  
  Organiza os tokens de acordo com as regras da gramática, gerando a **Parse Tree**.

### O que NÃO deve existir aqui

- Validações semânticas
- Regras de negócio
- Conhecimento sobre tabelas, colunas ou tipos
- Qualquer lógica de execução ou planejamento

### Output

- `ParseTree` (estrutura específica do ANTLR)

---

## 2. AST (Abstract Syntax Tree / Modelo Semântico)

### Responsabilidade

A AST representa o **significado real da query**, independentemente da sintaxe utilizada para escrevê-la.  
Aqui o sistema começa a “entender” a query, não apenas lê-la.

Essa camada funciona como o **modelo de domínio da linguagem SQL**.

### Características

- Implementada como **classes Java puras**
- Totalmente desacoplada do ANTLR
- Estrutura estável e orientada ao domínio

### Exemplos de nós da AST

- `SelectStatement`
- `FromClause`
- `WhereClause`
- `Join`
- `Expression`
- `ColumnReference`
- `LiteralValue`

### Benefícios estratégicos

- Facilita testes unitários
- Permite múltiplas sintaxes mapeando para o mesmo modelo
- Serve como contrato entre o parser e o planejador de queries
- Reduz impacto de mudanças na gramática

---

## 3. AST Builder (Visitor)

### Responsabilidade

Esta camada faz a **ponte entre o mundo sintático (ANTLR)** e o **mundo semântico (AST)**.

Ela percorre a Parse Tree gerada pelo ANTLR e constrói, passo a passo, a AST correspondente.

Em termos arquiteturais, este componente atua como um **tradutor estruturado**.

### Implementação

- Baseada no **Visitor Pattern**
- Normalmente estende `BaseVisitor<T>` do ANTLR
- Um método por regra relevante da gramática

### Exemplo conceitual

- Regra `selectStatement` → cria um `SelectStatement`
- Regra `whereClause` → cria um `WhereClause`
- Regra `expression` → cria uma hierarquia de `Expression`

### O que pertence a esta camada

- Mapeamento Parse Tree → AST
- Normalização estrutural da query
- Conversão de tokens em tipos semânticos

### O que NÃO pertence aqui

- Otimizações
- Planejamento de execução
- Acesso a catálogo ou metadados

---

## Fluxo Completo do Parser

```text
SQL (String)
   ↓
ANTLR Lexer
   ↓
ANTLR Parser
   ↓
Parse Tree
   ↓
AST Builder (Visitor)
   ↓
AST (Modelo Semântico)
