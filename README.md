# Seminário DevSecOps

Aplicação para apresentação do Trabalho Final da Disciplina DevSecOps

## Pré-requisitos

Certifique-se de ter os seguintes requisitos instalados em sua máquina:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Como Iniciar

1. **Clone o Repositório:**

   ```bash
   git clone https://github.com/Peixoto258/seminarioTeste.git
   cd seminarioTeste
   ```

2. **Build da Aplicação:**

   ```bash
   ./mvnw clean install
   ```
3. **Construa a Imagem Docker:**

   ```bash
   docker-compose build
   ```
4. **Inicie os Contêineres:**

   ```bash
   docker-compose up -d
   ```
   #### O aplicativo estará disponível em http://localhost:8080

5. **Parar e Remover os Contêineres:**

   ```bash
   docker-compose down
   ```

