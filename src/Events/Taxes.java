package Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import GLClass.GLClass;
import Util.Methods;

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
		         if(p == null) {
		        	 return;
		         }
		 		if (!plugin.getConfig().getBoolean("Taxes.Taxes"))
					return;
		 		int money = plugin.getConfig().getInt("Info.money");
		 		if(money <= 0) {
		 			plugin.getConfig().set("Info.money", 0);
		 			Methods.updateScoreboard(p, plugin.getConfig().getString("ScoreBoard.LoreScoreBoard"), plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2"), plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
		 			plugin.getConfig().set("Info.owner", "Null");
					 plugin.saveConfig();
		 			return;
		 	  } int price2 = plugin.getConfig().getInt("Taxes.money");
				int price = money -= price2;
			 plugin.getConfig().set("Info.money", price);
			 plugin.saveConfig();
      		 String message = plugin.getConfig().getString("Taxes.message");
			 Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',message));
			 Methods.updateScoreboard(p, plugin.getConfig().getString("ScoreBoard.LoreScoreBoard"), plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2"), plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
			 Methods.Log(p.getName(), " pay Taxes: " + price2 + " total money: " + money);
			 return;
		     }, 75000L, 75000L);
}
	{
	     Bukkit.getScheduler().runTaskTimer(GLClass.getInsance(), () -> {
			 GLClass.getData().set("Info.24", 0);
				GLClass.saveData();
	     }, 1728000L, 1728000L);
	}
}