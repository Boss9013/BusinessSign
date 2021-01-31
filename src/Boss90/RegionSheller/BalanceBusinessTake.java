package Boss90.RegionSheller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class BalanceBusinessTake implements CommandExecutor, Listener {
private GLClass plugin;

public BalanceBusinessTake(GLClass plugin) {
this.plugin = plugin;
}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		 Player player = (Player) sender;
   		if(this.plugin.getConfig().getString("Info.owner").contains(player.getName())) {
			String Failed = plugin.getConfig().getString("Messages.InsufficientBusinessFailedMessage");
			Failed = Failed.replace("&", "\u00a7");
			
			String Sucess = plugin.getConfig().getString("Messages.InsufficientBusinessSucessMessage");
			Sucess = Sucess.replace("&", "\u00a7");
			
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
			Prefix = Prefix.replace("&", "\u00a7");
		 int money = this.plugin.getConfig().getInt("Info.money");
		 this.plugin.getConfig().set("Info.money", 0);
		 GLClass.getInsance().saveConfig();
		 if(money == 0) {
			 sender.sendMessage(Prefix + " " + Failed);
			 return true;
		 }
		 EconomyManager.giveMoney(player, money);
		 updateScoreboard(player);
   		 sender.sendMessage(Prefix + " " + Sucess + " " + money);
   		 return true;
   		} else {
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
			Prefix = Prefix.replace("&", "\u00a7");
		
			String Error = plugin.getConfig().getString("Messages.Error");
			Error = Error.replace("&", "\u00a7");
			
   			player.sendMessage(Prefix + " " + Error);
   			return true;
   		}
	}
	private void updateScoreboard(Player player) {
		String LoreScoreBoard1 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard");
		LoreScoreBoard1 = LoreScoreBoard1.replace("&", "\u00a7");
		Scoreboard s = player.getScoreboard();
        Objective o = s.getObjective("stats"); {
        	if(o == null) {
        		return;
        	}
        o.getScore(LoreScoreBoard1).setScore(plugin.getConfig().getInt("Info.money"));
			String LoreScoreBoard2 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2");
			LoreScoreBoard2 = LoreScoreBoard2.replace("&", "\u00a7");
			o.getScore(LoreScoreBoard2).setScore(plugin.getConfig().getInt("Info.material"));
        }
	}
}