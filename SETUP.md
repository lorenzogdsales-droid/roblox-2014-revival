# 🚀 Guia de Setup - Roblox 2014 Revival

## Pré-requisitos

- Node.js 14+
- Android SDK
- Gradle
- Git

## Instalação do Servidor

```bash
# Clonar repositório
git clone https://github.com/lorenzogdsales-droid/roblox-2014-revival.git
cd roblox-2014-revival

# Instalar dependências do servidor
cd server
npm install

# Iniciar servidor
npm start
```

O servidor estará disponível em `http://localhost:8080`

## Instalação do App Android

### Opção 1: Usar APK Pré-compilado
1. Baixe `android/app.apk`
2. Instale em seu dispositivo Android
3. Configure o endereço do servidor em Configurações

### Opção 2: Compilar do Zero
```bash
cd android
gradlew build
gradlew installDebug
```

## Configuração

Edite `server/config.json`:
```json
{
  "server": {
    "port": 8080,
    "host": "0.0.0.0"
  }
}
```

## Teste

1. Inicie o servidor: `npm start`
2. Instale o APK
3. Abra o app
4. Crie uma conta
5. Teste as funcionalidades

## Troubleshooting

### Erro: "Não conseguiu conectar ao servidor"
- Verifique se o servidor está rodando
- Confira o IP e porta em Configurações
- Verifique firewall

### Erro: "WebSocket connection failed"
- Verifique se porta 8080 está aberta
- Reinicie o servidor

## Próximos Passos

- [ ] Implementar banco de dados persistente
- [ ] Adicionar sistema de monetização
- [ ] Melhorar gráficos do cliente
- [ ] Adicionar mais tipos de games
- [ ] Sistema de moderação
