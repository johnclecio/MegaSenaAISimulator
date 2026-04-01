# 🎯 Mega-Sena AI Simulator

Sistema de simulação, análise estatística e geração inteligente de apostas da Mega-Sena utilizando Java + Spring Boot.

---

## 🚀 Visão Geral

Este projeto simula milhões de jogos da Mega-Sena utilizando regras customizadas, analisa frequências, aprende com histórico e gera apostas otimizadas com base em:

- 📊 Probabilidade
- 🔥 Frequência (ranking)
- 📈 Tendência (subindo/caindo)
- 🤖 Algoritmo evolutivo (IA simples)

---

## ⚙️ Funcionalidades

### 🎲 Simulação
- Geração massiva de jogos (multithread)
- Uso de múltiplas threads (`Worker`)
- Regra de filtro:
  - números pares OU maiores que 30

---

### 📊 Análise Estatística
- Probabilidade (%) por número
- Ranking de frequência
- Números quentes 🔥 e frios ❄️

---

### 📈 Tendência
- Detecta números:
  - 📈 Subindo (HI)
  - 📉 Caindo (LOW)

---

### 🤖 Inteligência Artificial
- Algoritmo evolutivo (heurística)
- Geração de jogos inteligentes
- Seleção baseada em score

---

### 🏆 Score dos Jogos
- Avalia força de cada jogo
- Permite comparar apostas

---

### 💾 Histórico
- Salva jogos gerados
- Permite aprendizado contínuo

---

### 🌐 Exportação JSON
- Gera arquivo `dados.json`
- Usado para dashboard web

---

## 🌐 API REST

### ▶️ Como executar

```bash
mvn spring-boot:run 

# 🎯 Mega-Sena AI Simulator

Sistema de simulação, análise estatística e geração inteligente de apostas da Mega-Sena utilizando Java + Spring Boot.

---

## 🚀 Visão Geral

Este projeto simula milhões de jogos da Mega-Sena utilizando regras customizadas, analisa frequências, aprende com histórico e gera apostas otimizadas com base em:

- 📊 Probabilidade
- 🔥 Frequência (ranking)
- 📈 Tendência (subindo/caindo)
- 🤖 Algoritmo evolutivo (IA simples)

---

## ⚙️ Funcionalidades

### 🎲 Simulação
- Geração massiva de jogos (multithread)
- Uso de múltiplas threads (`Worker`)
- Regra de filtro:
  - números pares OU maiores que 30

---

### 📊 Análise Estatística
- Probabilidade (%) por número
- Ranking de frequência
- Números quentes 🔥 e frios ❄️

---

### 📈 Tendência
- Detecta números:
  - 📈 Subindo (HI)
  - 📉 Caindo (LOW)

---

### 🤖 Inteligência Artificial
- Algoritmo evolutivo (heurística)
- Geração de jogos inteligentes
- Seleção baseada em score

---

### 🏆 Score dos Jogos
- Avalia força de cada jogo
- Permite comparar apostas

---

### 💾 Histórico
- Salva jogos gerados
- Permite aprendizado contínuo

---

### 🌐 Exportação JSON
- Gera arquivo `dados.json`
- Usado para dashboard web

---

## 🌐 API REST

### ▶️ Como executar

```bash
mvn spring-boot:run


ou

./mvnw spring-boot:run

🌐 Abrir Swagger
http://localhost:8080/swagger-ui.html



📈 O que o dashboard mostra
Top 10 números
Probabilidade (%)
Tendência (HI / LOW)
Jogos gerados pela IA
📁 Estrutura do Projeto
        src/main/java/com/Mega_Sena/demo/

        ├── controller/
        │   └── MegaController.java
        │
        ├── service/
        │   ├── Simulador.java
        │   ├── Worker.java
        │   ├── RankingService.java
        │   ├── EstatisticaService.java
        │   ├── TendenciaService.java
        │   ├── IAService.java
        │   ├── HistoricoService.java
        │   └── AnaliseService.java
        │
        └── MegaApplication.java
🧠 Conceito do Sistema

O sistema funciona em etapas:

Simulação massiva (multithread)
Cálculo de frequência
Conversão em probabilidade
Análise de tendência
Geração de jogos inteligentes
⚠️ Observação Importante

Este sistema:

❌ NÃO prevê resultados reais
✔️ É baseado em simulação e heurísticas

A Mega-Sena é um sistema totalmente aleatório.

🎯 Objetivo do Projeto

Praticar:

Java
Estruturas de dados
Concorrência (multithreading)
Estatística aplicada
Arquitetura de sistemas
APIs REST
🚀 Possíveis Evoluções
🌐 Dashboard em React
🗄️ Banco de dados (PostgreSQL)
📡 Atualização em tempo real (WebSocket)
🤖 Machine Learning real
📱 App mobile


👨‍💻 Autor

John Lima