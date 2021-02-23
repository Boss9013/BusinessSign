package Commands;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import GLClass.GLClass;

public class VoteStop implements CommandExecutor, Listener {
	private GLClass plugin;

	public VoteStop(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	   	 if(!sender.hasPermission("Business.stopvote")) {
	   		 sender.sendMessage("§cError");
	   		 return true;			 
	   	 }
   		 Player p = (Player) sender;
   		 String Prefix = plugin.getConfig().getString("Messages.Prefix");
   		 if(plugin.getConfig().getString("Vote.start") == "false") {
   			 p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " Voting has already been stopped"));
   			 return true;
   		 }
   		 plugin.getConfig().set("Vote.start", "false");
   		 plugin.getConfig().set("Vote.Nick1", "");
   		 plugin.getConfig().set("Vote.Nick2", "");
   		 plugin.getConfig().set("Vote.Nick3", "");
   		 p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " You sucess stop vote."));
   		 plugin.saveConfig();
   		 String Broadcast = plugin.getConfig().getString("Vote.BroadcastMessageStopVote");
   		 Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',Broadcast));
         List<String> list = GLClass.getLog().getStringList("logs");
         list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + p.getName() + " stopped voting.");
         GLClass.getLog().set("logs", list);
         GLClass.saveLog();
		return true;
   	 }
}