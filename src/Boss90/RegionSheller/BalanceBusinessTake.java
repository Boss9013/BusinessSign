package Boss90.RegionSheller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.bukkit.ChatColor;
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
	 		if(this.plugin.getConfig().getString("Info.owner").contains(player.getName()) || this.plugin.getConfig().getStringList("Staff").contains(player.getName())) {
			String Failed = plugin.getConfig().getString("Messages.InsufficientBusinessFailedMessage");
			
			String Sucess = plugin.getConfig().getString("Messages.InsufficientBusinessSucessMessage");
			
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
			 int money = this.plugin.getConfig().getInt("Info.money");
			 if(money == 0) {
				 sender.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + Failed));
				 return true;
			 }
		 GLClass.getInsance().saveConfig();
		 EconomyManager.giveMoney(player, money);
	        List<String> list = GLClass.getLog().getStringList("logs");
	        list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + player.getName() + " take money: " + money);
	        GLClass.getLog().set("logs", list);
	        GLClass.saveLog();
		 updateScoreboard(player);
   		 sender.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + Sucess + " " + money));
		 this.plugin.getConfig().set("Info.money", 0);
   		 return true;
   		} else {
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
		
			String Error = plugin.getConfig().getString("Messages.Error");
			
   			player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + Error));
   			return true;
   		}
	}
	private void updateScoreboard(Player player) {
		String LoreScoreBoard1 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard");
		Scoreboard s = player.getScoreboard();
        Objective o = s.getObjective("stats"); {
        	if(o == null) {
        		return;
        	}
        o.getScore(ChatColor.translateAlternateColorCodes('&',LoreScoreBoard1)).setScore(plugin.getConfig().getInt("Info.money"));
			String LoreScoreBoard2 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2");
			o.getScore(ChatColor.translateAlternateColorCodes('&',LoreScoreBoard2)).setScore(plugin.getConfig().getInt("Info.material"));
        }
	}
}