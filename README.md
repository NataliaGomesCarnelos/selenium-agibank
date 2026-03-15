# Selenium Automation Framework

Framework de automação de testes **Selenium** desenvolvido em **Java** utilizando boas práticas de automação como **Page Object Model**, execução paralela e integração com **CI (GitHub Actions)**.

Este projeto demonstra um fluxo automatizado de busca no blog do Agibank.

## Tecnologias Utilizadas

- Java 17
- Selenium WebDriver
- Gradle
- JUnit 5
- WebDriverManager
- Page Object Model
- GitHub Actions (CI)

## Estrutura do Projeto

```
src
 ├── main
 │   └── java
 │       └── framework
 │           ├── config
 │           │   └── ConfigReader.java
 │           ├── driver
 │           │   └── DriverFactory.java
 │           └── utils
 │               └── ScreenshotUtil.java
 │
 └── test
     └── java
         ├── base
         │   └── BaseTest.java
         ├── pages
         │   └── BlogAgibankPageObject.java
         └── tests
             └── BlogAgibankTest.java
```

## Cenários Automatizados

Os seguintes cenários foram implementados:

- Buscar artigo existente no blog
- Buscar termo inexistente e validar mensagem de erro

## Principais Conceitos

### DriverFactory
Responsável por criar e gerenciar instâncias do **WebDriver**.

### BaseTest
Classe base para os testes, responsável pela inicialização e finalização do driver.

### Page Object Model
As páginas encapsulam as interações com a interface, tornando os testes mais organizados e reutilizáveis.

### ConfigReader
Carrega configurações do projeto, como o **browser** utilizado.

## Executando os Testes

Execute os testes utilizando **Gradle**:

```
./gradlew test
```

ou

```
gradle test
```

## Configuração do Browser

Edite o arquivo:

```
src/test/resources/config.properties
```

Exemplo:

```
browser=chrome
```

Browsers suportados:

- chrome
- firefox
- edge

## Execução em CI

Os testes são executados automaticamente através do **GitHub Actions** a cada push no repositório.

## Execução Paralela

A execução paralela está habilitada utilizando configuração do **JUnit 5** no `build.gradle`.

## Autor

Natália Gomes Carnelós
