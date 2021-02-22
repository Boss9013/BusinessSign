package Boss90.RegionSheller.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Boss90.RegionSheller.GLClass;
import Boss90.RegionSheller.Util.Methods;

public class VoteStart implements CommandExecutor, Listener {
	private GLClass plugin;

	public VoteStart(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		   	 if(!sender.hasPermission("Business.startvote")) {
		   		 sender.sendMessage("§cError");
		   		 return true;			 
		   	 }
   		 Player p = (Player) sender;
   		 String Prefix = plugin.getConfig().getString("Messages.Prefix");
 		 Prefix = Prefix.replace("&", "\u00a7");
   		 if(args.length <= 2) {
   			 p.sendMessage(Prefix + " Enter candidate!");
   			 return true;
   		 }
   		 String Start = plugin.getConfig().getString("Vote.BroadcastMessageStartVote");
 		 Start = Start.replace("&", "\u00a7");
 		 Start = Start.replace("%arg1%", args[0]);
 		 Start = Start.replace("%arg2%", args[1]);
 		 Start = Start.replace("%arg3%", args[2]);
   		 if(plugin.getConfig().getString("Vote.start") == "true") {
   			 p.sendMessage(Prefix + " Voting has already been start");
   			 return true;
   		 }
   		 plugin.getConfig().set("Vote.start", "true");
   		 plugin.getConfig().set("Vote.Nick1", args[0]);
   		 plugin.getConfig().set("Vote.Nick2", args[1]);
   		 plugin.getConfig().set("Vote.Nick3", args[2]);
   		 p.sendMessage(Prefix + " You sucess start vote.");
   		 plugin.saveConfig();
   		 Bukkit.broadcastMessage(Start);
   		 Methods.Log(p.getName(), " started voting, condidate: " + args[0] + ", " + args[1] + ", " + args[2]);
		return true;
   	 }
}