# GameOS - Desktop APK para Android 🎮

GameOS é um aplicativo Android inovador que oferece um desktop completo em formato APK, com suporte integrado para **Linux**, **Windows** e **Android**, permitindo dois modos de operação distintos.

## 🎯 Características Principais

### 🧪 Modo Teste (Sandbox)
- **Ambiente Isolado**: Completamente isolado do sistema operacional principal
- **Sem Modificações**: Seu sistema NÃO será afetado
- **Progresso Persistente**: Salva automaticamente seu progresso
- **Seguro e Rápido**: Teste sem riscos

### 🔧 Modo Instalação
- **Instalação Real**: Permite instalar sistemas operacionais reais
- **Modificações Persistentes**: Altera o sistema conforme necessário
- **Histórico Completo**: Rastreia todas as instalações
- **Configuração Salva**: Mantém suas configurações

## 📋 Estrutura do Projeto

```
gameos/
├── src/
│   ├── main/
│   │   ├── AndroidManifest.xml       # Configuração Android
│   │   ├── java/com/gameos/desktop/
│   │   │   ├── MainActivity.kt           # Tela principal
│   │   │   ├── ui/
│   │   │   │   ├── TestModeActivity.kt
│   │   │   │   └── InstallationModeActivity.kt
│   │   │   └── core/
│   │   │       ├── TestModeManager.kt
│   │   │       └── InstallationManager.kt
│   │   └── res/
│   │       ├── layout/                # Layouts XML
│   │       ├── values/                # Recursos
│   │       └── drawable/              # Imagens
│   └── test/
└── build.gradle                       # Configuração Gradle

.github/
└── workflows/
    └── build-apk.yml                  # GitHub Actions CI/CD
```

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Kotlin + Java
- **SDK**: Android SDK 34
- **Min SDK**: 24 (Android 7.0)
- **Build System**: Gradle
- **Database**: Room Database
- **Async**: Coroutines

## 📦 Instalação e Compilação

### Pré-requisitos
- Android Studio 4.2+
- JDK 11+
- Gradle 8.0+

### Build Local
```bash
cd gameos
./gradlew assembleDebug      # Build de debug
./gradlew assembleRelease    # Build de release
```

### APK Resultante
O APK compilado estará em:
```
gameos/build/outputs/apk/release/gameos-release.apk
gameos/build/outputs/apk/debug/gameos-debug.apk
```

## 🚀 GitHub Actions CI/CD

O projeto inclui um workflow automático que:
1. ✅ Compila o APK automaticamente a cada push
2. 📦 Realiza upload como artifact do GitHub
3. 🔖 Cria releases com as versões

### Download do APK

Os APKs compilados estão disponíveis em:
- **[Releases](../../releases)** - Versões de release
- **[Actions](../../actions)** - Artifacts de cada build

## 📱 Como Usar

### Modo Teste
1. Abra o aplicativo
2. Clique em "Modo Teste (Sandbox)"
3. Escolha o OS para testar (Linux, Windows, Android)
4. Seu progresso é salvo automaticamente

### Modo Instalação
1. Abra o aplicativo
2. Clique em "Modo Instalação"
3. ⚠️ **Cuidado**: Isto modificará seu sistema
4. Escolha o OS para instalar
5. Suas configurações são salvas

## 📊 Estado do Projeto

- [x] Estrutura base do projeto
- [x] Interface de tela principal
- [x] Modo Teste (framework)
- [x] Modo Instalação (framework)
- [x] Gerenciamento de progresso
- [x] CI/CD com GitHub Actions
- [ ] Emulação Linux completa
- [ ] Emulação Windows completa
- [ ] Emulação Android completa
- [ ] Instalação real do SO
- [ ] Interface gráfica avançada
- [ ] Documentação completa

## 🔒 Segurança

- **Modo Teste**: Usa cache do app, completamente isolado
- **Modo Instalação**: Salva em arquivos externos, com avisos
- **Permissões**: Apenas as necessárias são solicitadas

## 📝 Licença

Este projeto é parte do repositório roblox-2014-revival.

## 🤝 Contribuindo

Contribuições são bem-vindas! Por favor:
1. Faça fork do projeto
2. Crie uma branch de feature
3. Commit suas mudanças
4. Push para a branch
5. Abra um Pull Request

## 📞 Suporte

Para dúvidas ou problemas, abra uma [Issue](../../issues) no GitHub.

---

**GameOS** - Transformando seu Android em um Desktop Completo 🚀
