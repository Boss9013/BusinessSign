package Boss90.RegionSheller.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Boss90.RegionSheller.GLClass;
import Boss90.RegionSheller.Util.EconomyManager;
import Boss90.RegionSheller.Util.Methods;

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
			 }	GLClass.getInsance().saveConfig();
		 EconomyManager.giveMoney(player, money);
		 Methods.Log(player.getName(), " take money: " + money);
	        Methods.updateScoreboard(player, plugin.getConfig().getString("ScoreBoard.LoreScoreBoard"), plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2"), plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
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
}