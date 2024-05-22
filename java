public class QuestListener implements Listener {

    private final QuestManager questManager;

    public QuestListener(QuestManager questManager) {
        this.questManager = questManager;
    }

    @EventHandler
    public void onPlayerCompleteObjective(PlayerCompleteObjectiveEvent event) {
        Player player = event.getPlayer();
        PlayerQuestProgress progress = questManager.getPlayerProgress(player);

        if (progress != null) {
            progress.advanceObjective();
            player.sendMessage("Objetivo completado! Progresso: " + progress.getProgress() + "%");

            if (progress.getProgress() == 100) {
                player.sendMessage("Parabéns! Você completou a quest '" + progress.getQuest().getName() + "'!");
                questManager.rewardPlayer(player, progress.getQuest());
            }
        }
    }
}
