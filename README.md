# Spring RH - Redis Database

<br />

<div align="center">
    <img src="https://i.imgur.com/w8tTOuT.png" title="source: imgur.com" /> 
    <br /><b>com</b><br />
    <img src="https://i.imgur.com/4Iidn3S.png" title="source: imgur.com" width="45%"/> 
</div>


<br />

## Diagrama de Classes

```mermaid
classDiagram
class Colaborador {
  - id : Integer
  - nome : String
  - salario : Double
  + Integer getId()
  + String getNome()
  + Double getSalario()
  + void setId(Integer id)
  + void setNome(String nome)
  + void setSalario(Double salario)
}
```

<br />

## Instalação do Redis Database no Windows

1. Instalar ou habilitar o **WSL2**
2. Instalar o **Ubuntu** dentro do WSL2
3. Instalar o **Redis**:

```bash
curl -fsSL https://packages.redis.io/gpg | sudo gpg --dearmor -o /usr/share/keyrings/redis-archive-keyring.gpg

echo "deb [signed-by=/usr/share/keyrings/redis-archive-keyring.gpg] https://packages.redis.io/deb $(lsb_release -cs) main" | sudo tee /etc/apt/sources.list.d/redis.list

sudo apt-get update
sudo apt-get install redis
```

4. Iniciar o **Redis**:

```bash
sudo service redis-server start
```

5. Conectar com o **Redis**:

```bash
redis-cli 
127.0.0.1:6379> ping
PONG
```

6. Instalar a IDE **RedisInsight**: https://github.com/RedisInsight/RedisInsight

<div align="center"><img src="https://i.imgur.com/alfD6Zi.png" title="source: imgur.com" /></div>

<br />

## Dependências do Spring



- [x] Spring WEB
- [x] Spring Boot Dev Tools
- [x] Spring Data Redis
