# Conversor de Moedas

Este projeto é um conversor de moedas simples em Java que utiliza a API pública do ExchangeRate-API para obter a taxa de câmbio em tempo real. O usuário interage via linha de comando, escolhendo o tipo de conversão e inserindo o valor desejado.

---

## Funcionalidades

* Conversão entre pares de moedas predefinidos:

    * USD (Dólar) ↔ ARS (Peso Argentino)
    * USD (Dólar) ↔ BRL (Real Brasileiro)
    * USD (Dólar) ↔ COP (Peso Colombiano)
* Interface de linha de comando interativa
* Exibição clara do resultado e data da última atualização

---

## Pré-requisitos

* Java 11 ou superior
* Maven (ou outro gerenciador de dependências) para baixar o GSON
* Conexão com a Internet para acessar a API de câmbio

---

## Configuração

1. Clone este repositório:

   ```bash
   git clone https://github.com/CarlosLonghi/ONE-Challenge-Conversor-de-Moedas.git
   ```
2. Acesse o diretório do projeto:

   ```bash
   cd ONE-Challenge-Conversor-de-Moedas
   ```
3. No arquivo `ConsultaMoeda.java`, substitua **`apiKey`** pelo seu token obtido em [ExchangeRate-API](https://www.exchangerate-api.com).

---

## Como executar

1. Compile o projeto:

   ```bash
   mvn compile
   ```
2. Execute a classe principal:

   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```
3. Siga as instruções no console para escolher a conversão e inserir o valor.

---

## Estrutura de arquivos

```
src/
├── main/
│   └── java/
│       └── org/
│           └── example/
│               ├── Main.java          # Classe principal e menu interativo
│               ├── ConsultaMoeda.java # Lógica de requisição HTTP e parsing
│               └── Moeda.java         # Model de resposta JSON
└── pom.xml                            # Configurações do Maven
```

---

## Tecnologias

* Java 11+
* ExchangeRate-API
* Gson (para deserialização JSON)
* HTTP Client (Java 11)