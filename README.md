# Selenium Automation Framework

Framework profissional de automação com **Selenium** utilizando:

- Java 17  
- Selenium WebDriver  
- Gradle  
- JUnit 5  
- WebDriverManager  
- Page Object Model  

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

## Principais Conceitos

### DriverFactory
Responsável por criar instâncias do **WebDriver**.

### BaseTest
Classe base para todos os testes.

### Page Object Model
As páginas encapsulam as interações com a interface (UI interactions).

### ConfigReader
Carrega configurações do projeto, como o tipo de **browser** utilizado.

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

## Execução Paralela

A execução paralela de testes está habilitada via configuração do **JUnit 5** no arquivo `build.gradle`.

## Autor

Natália Gomes Carnelós
