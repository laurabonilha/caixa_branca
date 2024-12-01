# Login Java com MySQL

Este repositório contém um exemplo de código Java para realizar login em um banco de dados MySQL.

## Problemas Encontrados e Soluções

### 1. **Erro nos Imports**
**Descrição**: As classes como `Connection`, `DriverManager`, e `Statement` não foram reconhecidas pela IDE.

**Causa**: O arquivo JAR do **MySQL Connector/J** não estava configurado corretamente no classpath.

**Solução**:
- Baixar o **MySQL Connector/J** do site oficial da Oracle.
- Adicionar o arquivo JAR ao classpath do projeto na IDE (Eclipse/IntelliJ).
- Atualizar os imports para incluir as classes `java.sql`.

### 2. **Erro de Conexão ao Banco**
**Descrição**: O código apresentou falha ao tentar conectar ao banco de dados.

**Causa**: Problemas na string de conexão (`JDBC URL`).

**Solução**:
- Certificar-se de que o banco está rodando localmente na porta correta.
- Ajustar a string de conexão para:
  ```java
  String url = "jdbc:mysql://127.0.0.1:3306/test?user=lopes&password=123";

# Plano de Teste

## Grafo de Fluxo

O grafo de fluxo do código foi criado com base nos pontos de execução do método `verificarUsuario` da classe `User`. Os pontos foram numerados e interligados conforme os fluxos possíveis de execução.

![Grafo de Fluxo](images/grafo_fluxo.png)



  
