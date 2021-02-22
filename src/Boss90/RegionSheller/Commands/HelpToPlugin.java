package Boss90.RegionSheller.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import Boss90.RegionSheller.GLClass;

public class HelpToPlugin implements CommandExecutor, Listener {
private GLClass plugin;

public HelpToPlugin(GLClass plugin) {
this.plugin = plugin;
}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.help")) {
   		 sender.sendMessage("§cError");
   		 return true;			 
   	 }
   		 String prefixsign = plugin.getConfig().getString("Sign.Prefix");
   		 sender.sendMessage("§dHelp:");
   		 sender.sendMessage("To create a business, you need to enter: §3" + prefixsign +  "§f, in the first line of the table, then the region and the cost of the business.");
   		 sender.sendMessage("The §edata.yml §ffile will store the coordinates of all the placemarks where §3"  + prefixsign + "§f, is specified, when the buy business coordinates disappear.");
   		 sender.sendMessage("§6Commands:");
   		 sender.sendMessage("§a/sbalance§f - find out the business balance.");
   		 sender.sendMessage("§a/stakebalance §f- withdraw money from the business.");
   		 sender.sendMessage("§a/shopGUI §f- GUI shop from business.");
   		 sender.sendMessage("§a/sremoveowner §f- remove owner from business.");
   		 sender.sendMessage("§a/swipebusiness §f- wipe from business.");
   		 sender.sendMessage("§4WARNING:");
   		 sender.sendMessage("§cOnly 1 business can be put up for sale. 2 or more businesses can lead to a bug.");
   		 return true;
	}
}