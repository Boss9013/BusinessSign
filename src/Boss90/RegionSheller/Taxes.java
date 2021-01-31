package Boss90.RegionSheller;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Taxes implements Listener {
	private GLClass plugin;

	public Taxes(GLClass plugin) {
	this.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return true;
	}
	{
		     Bukkit.getScheduler().runTaskTimer(GLClass.getInsance(), () -> {
		         Player p = (Player) Bukkit.getPlayer(plugin.getConfig().getString("Info.owner"));
		 		if (!plugin.getConfig().getBoolean("Taxes.Taxes"))
					return;
		 		int money = plugin.getConfig().getInt("Info.money");
		 		if(money <= 0) {
		 			plugin.getConfig().set("Info.money", 0);
					 updateScoreboard(p);
		 			plugin.getConfig().set("Info.owner", "Null");
					 plugin.saveConfig();
		 			return;
		 		}
				int price2 = plugin.getConfig().getInt("Taxes.money");
				int price = money -= price2;
			 plugin.getConfig().set("Info.money", price);
			 plugin.saveConfig();
      		 String message = plugin.getConfig().getString("Taxes.message");
    	     message = message.replace("&", "\u00a7");
			 Bukkit.broadcastMessage(message);
			 updateScoreboard(p);
			 return;
		     }, 75000L, 75000L);
}
	private void updateScoreboard(Player player) {
		String LoreScoreBoard1 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard");
		LoreScoreBoard1 = LoreScoreBoard1.replace("&", "\u00a7");
		if(player == null) {
			return;
		}
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