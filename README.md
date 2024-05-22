# 💻 OkayG - Desenvolvedor de Plugins Java Minecraft

![Profile Views](https://komarev.com/ghpvc/?username=OkayG&color=blueviolet)
![GitHub followers](https://img.shields.io/github/followers/OkayG?label=Follow&style=social)

**Olá! Sou OkayG, um desenvolvedor apaixonado por criar plugins personalizados para redes de servidores Minecraft.**

## 🛠️ Habilidades Técnicas

- **Linguagens:** ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)
- **Desenvolvimento de Plugins:** Spigot, Bukkit
- **Ferramentas e Tecnologias:** ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white) ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white) ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white) ![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
- **Áreas de Interesse:** Gameplay Enhancement, Economia Virtual, Mini-Games, Automação de Servidores

## 🚀 Projetos Destacados

- **EconomiaPlugin:** Um sistema de economia virtual para Minecraft com suporte a transações e lojas.
- **MiniGamesPlugin:** Conjunto de mini-jogos personalizados para servidores Minecraft.
- **AdminToolsPlugin:** Ferramentas avançadas para administração de servidores, incluindo gerenciamento de permissões e monitoramento de jogadores.
- **QuestPlugin:** Sistema inovador de quests personalizadas, permitindo aos administradores criar e gerenciar missões únicas para os jogadores.

## 🎮 QuestPlugin - Sistema Inovador de Quests Personalizadas

### 📥 Instalação

1. **Baixe o Plugin:**
   - Baixe a versão mais recente do plugin na página de [Releases](https://github.com/OkayG/QuestPlugin/releases).

2. **Coloque na Pasta de Plugins:**
   - Coloque o arquivo `.jar` baixado na pasta `plugins` do diretório do seu servidor Minecraft.

3. **Inicie o Servidor:**
   - Inicie ou reinicie seu servidor Minecraft para carregar o plugin.

4. **Configuração:**
   - Edite o arquivo `config.yml` localizado no diretório do plugin para personalizar as configurações de acordo com suas necessidades.

### 📚 Uso

#### Comandos

- `/quest criar <nome>` - Cria uma nova quest.
- `/quest adicionarObjetivo <quest> <objetivo>` - Adiciona um objetivo a uma quest.
- `/quest listar` - Lista todas as quests.
- `/quest iniciar <nome>` - Inicia uma quest.
- `/quest progresso` - Verifica o progresso da quest atual.

#### Permissões

- `quest.admin` - Acesso a comandos administrativos.
- `quest.usar` - Acesso às funcionalidades gerais do plugin.

### 🛠 Exemplos de Código

#### Comando Personalizado

```java
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("quest")) {
        if (args.length < 1) {
            sender.sendMessage("Uso: /quest <subcomando>");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "criar":
                if (args.length < 2) {
                    sender.sendMessage("Uso: /quest criar <nome>");
                    return true;
                }
                String questName = args[1];
                questManager.createQuest(questName);
                sender.sendMessage("Quest '" + questName + "' criada!");
                break;

            case "adicionarObjetivo":
                if (args.length < 3) {
                    sender.sendMessage("Uso: /quest adicionarObjetivo <quest> <objetivo>");
                    return true;
                }
                String quest = args[1];
                String objective = args[2];
                questManager.addObjective(quest, objective);
                sender.sendMessage("Objetivo adicionado à quest '" + quest + "'");
                break;

            case "listar":
                questManager.listQuests(sender);
                break;

            case "iniciar":
                if (args.length < 2) {
                    sender.sendMessage("Uso: /quest iniciar <nome>");
                    return true;
                }
                String questToStart = args[1];
                questManager.startQuest((Player) sender, questToStart);
                break;

            case "progresso":
                questManager.checkProgress((Player) sender);
                break;

            default:
                sender.sendMessage("Comando desconhecido. Use /quest <criar|adicionarObjetivo|listar|iniciar|progresso>");
                break;
        }
        return true;
    }
    return false;
}
