# 🎯 Mega-Sena AI Simulator

Sistema de simulação, análise estatística e geração inteligente de apostas da Mega-Sena utilizando Java.

---

## 🚀 Visão Geral

Este projeto simula milhões de jogos da Mega-Sena utilizando regras customizadas, analisa frequências, aprende com histórico e gera apostas otimizadas com base em:

- 📊 Probabilidade
- 🔥 Frequência (ranking)
- 📈 Tendência (subindo/caindo)
- 🤖 Algoritmo evolutivo (IA simples)

---

## 🧠 Arquitetura

Simulação → Ranking → Histórico → Análise → IA → Exportação (JSON)ls


---

## ⚙️ Funcionalidades

### 🎲 Simulação
- Geração massiva de jogos (multithread)
- Regra de filtro: números pares ou > 30

---

### 📊 Análise Estatística
- Probabilidade (%) por número
- Ranking de frequência
- Números quentes 🔥 e frios ❄️

---

### 📈 Tendência
- Detecta números:
  - 📈 Subindo
  - 📉 Caindo

---

### 🤖 Inteligência Artificial
- Algoritmo evolutivo (tipo genético)
- Seleciona os melhores jogos com base em score

---

### 🏆 Score dos Jogos
- Avaliação baseada na força dos números
- Permite comparar qualidade entre apostas

---

### 💾 Histórico
- Salva jogos gerados
- Permite aprendizado contínuo

---

### 🌐 Exportação JSON
- Gera arquivo `dados.json`
- Integração com dashboard (Chart.js)

---

## 📁 Estrutura do Projeto

    src/
    ├── index.html
    ├── Main.java
    ├── Simulador.java
    ├── Worker.java
    ├── RankingService.java
    ├── EstatisticaService.java
    ├── AnaliseService.java
    ├── TendenciaService.java
    ├── IAService.java
    ├── HistoricoService.java
    ├── ExportService.java


    ---

## ▶️ Como Executar

### Compilar

```bash
javac *.java

---

## ▶️ Como Executar

### Compilar

```bash
javac *.java

📊 Exemplo de Saída
🚀 RODADA 1

🔥 TOP 10 REAL: [8, 35, 48, 50, 57, 59, ...]

🎯 APOSTA PRINCIPAL:
[8, 35, 48, 50, 57, 59]

📈 SUBINDO:
[44, 32, 50, ...]

📉 CAINDO:
[1, 3, 5, ...]

🏆 SCORE DOS JOGOS:
[8, 35, 48, 50, 57, 59] → Score: 720000

🤖 MELHORES JOGOS (IA):
[10, 32, 44, 50, 57, 60]

📊 Dashboard (Opcional)

Use o arquivo dados.json com um frontend simples em HTML + Chart.js:

fetch('dados.json')
⚠️ Observação Importante

Este sistema:

❌ NÃO prevê resultados reais
✔️ É baseado em simulação e heurísticas

A Mega-Sena real é um sistema totalmente aleatório.

🎯 Objetivo do Projeto
        Praticar:
        Java
        Estruturas de dados
        Concorrência (multithreading)
        Estatística aplicada
        Arquitetura de sistemas
🚀 Possíveis Evoluções
🌐 API REST (Spring Boot)
🗄️ Banco de dados (PostgreSQL)
📈 Dashboard em tempo real
🤖 Machine Learning real
📱 App mobile
👨‍💻 Autor

John Lima

⭐ Se curtir o projeto

Deixa uma estrela ⭐ no repositório!