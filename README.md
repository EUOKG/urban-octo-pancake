 * Copyright (c) OkayyG and contributors
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

<h1>💻 OkayG - Desenvolvedor de Plugins Minecraft</h1>

<img src="https://komarev.com/ghpvc/?username=OkayG&color=blueviolet" alt="Profile Views">
<img src="https://img.shields.io/github/followers/OkayG?label=Follow&style=social" alt="GitHub followers">

<p><strong>Olá! Sou OkayG, um desenvolvedor apaixonado por criar plugins personalizados para redes de servidores Minecraft.</strong></p>

<h2>🛠️ Habilidades Técnicas</h2>

<ul>
  <li><strong>Linguagens:</strong> <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java"> <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black" alt="JavaScript"> <img src="https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white" alt="Python"></li>
  <li><strong>Desenvolvimento de Plugins:</strong> Spigot, Bukkit</li>
  <li><strong>Ferramentas e Tecnologias:</strong> <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white" alt="Git"> <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" alt="Maven"> <img src="https://img.shields.io/badge/IntelliJIDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white" alt="IntelliJ IDEA"> <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" alt="GitHub"></li>
  <li><strong>Áreas de Interesse:</strong> Gameplay Enhancement, Economia Virtual, Mini-Games, Automação de Servidores, Relações com GTA, Interesses na Área de Programação</li>
</ul>

<h2>🚀 Projetos Destacados</h2>

<ul>
  <li><strong>EconomiaPlugin:</strong> Um sistema de economia virtual para Minecraft com suporte a transações e lojas.</li>
  <li><strong>MiniGamesPlugin:</strong> Conjunto de mini-jogos personalizados para servidores Minecraft.</li>
  <li><strong>AdminToolsPlugin:</strong> Ferramentas avançadas para administração de servidores, incluindo gerenciamento de permissões e monitoramento de jogadores.</li>
  <li><strong>QuestPlugin:</strong> Sistema inovador de quests personalizadas, permitindo aos administradores criar e gerenciar missões únicas para os jogadores.</li>
</ul>

<h2>🎮 QuestPlugin - Sistema Inovador de Quests Personalizadas</h2>

<h3>📥 Instalação</h3>

<ol>
  <li><strong>Baixe o Plugin:</strong>
    <ul>
      <li>Baixe a versão mais recente do plugin na página de <a href="https://github.com/OkayG/QuestPlugin/releases">Releases</a>.</li>
    </ul>
  </li>
  <li><strong>Coloque na Pasta de Plugins:</strong>
    <ul>
      <li>Coloque o arquivo <code>.jar</code> baixado na pasta <code>plugins</code> do diretório do seu servidor Minecraft.</li>
    </ul>
  </li>
  <li><strong>Inicie o Servidor:</strong>
    <ul>
      <li>Inicie ou reinicie seu servidor Minecraft para carregar o plugin.</li>
    </ul>
  </li>
  <li><strong>Configuração:</strong>
    <ul>
      <li>Edite o arquivo <code>config.yml</code> localizado no diretório do plugin para personalizar as configurações de acordo com suas necessidades.</li>
    </ul>
  </li>
</ol>

<h3>📚 Uso</h3>

<h4>Comandos</h4>

<ul>
  <li><code>/quest criar <nome></code> - Cria uma nova quest.</li>
  <li><code>/quest adicionarObjetivo <quest> <objetivo></code> - Adiciona um objetivo a uma quest.</li>
  <li><code>/quest listar</code> - Lista todas as quests.</li>
  <li><code>/quest iniciar <nome></code> - Inicia uma quest.</li>
  <li><code>/quest progresso</code> - Verifica o progresso da quest atual.</li>
</ul>

<h4>Permissões</h4>

<ul>
  <li><code>quest.admin</code> - Acesso a comandos administrativos.</li>
  <li><code>quest.usar</code> - Acesso às funcionalidades gerais do plugin.</li>
</ul>

<h3>🛠 Exemplos de Código</h3>

<h4>Comando Personalizado</h4>

<pre><code>
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

           
